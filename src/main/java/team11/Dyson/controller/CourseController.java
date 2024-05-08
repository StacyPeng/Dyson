package team11.Dyson.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Course;
import team11.Dyson.domian.Staff;
import team11.Dyson.dto.CourseDTO;
import team11.Dyson.dto.StaffDTO;
import team11.Dyson.service.impl.Authentication2Service;
import team11.Dyson.service.impl.AuthenticationService;
import team11.Dyson.service.impl.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private AuthenticationService authenticationService;
    private Authentication2Service authentication2Service;

    @GetMapping("/student")
    public ResponseEntity<?> getStudentCourses(HttpSession session) {
        // 从身份验证服务中获取当前登录学生的邮箱地址
        String currentStudentEmail = authenticationService.getCurrentStudentEmail(session);

        // 如果当前学生邮箱为空，可能表示用户未登录或未授权
        if (currentStudentEmail == null) {
            // 返回适当的错误响应，例如 401 未授权
            return ResponseEntity.status(401).body("Unauthorized access.");
        }

        // 根据学生邮箱检索与该学生相关的课程
        List<Course> studentCourses = courseService.findCoursesByStudentEmail(currentStudentEmail);

        // 将课程转换为 DTO 并返回
        List<CourseDTO> courseDTOs = studentCourses.stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(courseDTOs);
    }

    // CourseController.java

    @GetMapping("/staff/courses")
    public ResponseEntity<?> getStaffCourses(HttpSession session) {
        String staffEmail = (String) session.getAttribute("staffEmail");
        if (staffEmail == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        List<Course> staffCourses = courseService.findCoursesByTeacherEmail(staffEmail);
        List<CourseDTO> courseDTOs = staffCourses.stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(courseDTOs);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody CourseDTO courseDTO) {
        Course existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
        }
        // 更新课程逻辑
        Course updatedCourse = courseService.updateCourse(existingCourse, courseDTO);
        return ResponseEntity.ok(convertToCourseDTO(updatedCourse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            return ResponseEntity.ok().body("Course deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
        }
    }


    @PostMapping
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO, HttpSession session) {
        // 从会话中获取当前登录教职员工的邮箱地址
        String staffEmail = (String) session.getAttribute("staffEmail");
        if (staffEmail == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // 创建课程实体，并从DTO中设置必要的信息
        Course course = convertToCourseEntity(courseDTO);

        // 设置教职工信息
        Staff teacher = new Staff();
        teacher.setStaffEmailAddress(staffEmail);  // 确保有一个构造器或者setter来设置邮箱地址
        course.setTeacher(teacher);

        // 将课程保存到数据库
        Course savedCourse = courseService.addCourse(course);
        if (savedCourse == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        // 将保存的课程转换回DTO
        CourseDTO savedCourseDTO = convertToCourseDTO(savedCourse);
        return ResponseEntity.ok(savedCourseDTO);
    }



    @GetMapping("/studentEmail")
    public ResponseEntity<?> storeEmailInSession(HttpSession session, @RequestParam String email) {
        if (email == null || email.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email parameter is missing or empty.");
        }
        session.setAttribute("studentEmail", email);
        return ResponseEntity.ok("Email stored in session successfully.");
    }

    @GetMapping("/staffEmail")
    public ResponseEntity<?> storeStaffEmailInSession(HttpSession session, @RequestParam String email) {
        if (email == null || email.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email parameter is missing or empty.");
        }
        session.setAttribute("staffEmail", email);
        return ResponseEntity.ok("Staff email stored in session successfully.");
    }




    private Course convertToCourseEntity(CourseDTO courseDTO) {
        if (courseDTO.getEndTime() == null) {
            System.out.println("Received null endTime for course: " + courseDTO.getTitle());
        }

        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setStartTime(courseDTO.getStartTime());
        course.setEndTime(courseDTO.getEndTime());
        System.out.println("Converted endTime: " + course.getEndTime());
        return course;
    }





    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());


        // 如果 Course 中的 teacher 不为 null，转换为 StaffDTO
        if (course.getTeacher() != null) {
            StaffDTO teacherDTO = new StaffDTO();
            teacherDTO.setEmail(course.getTeacher().getStaffEmailAddress());
            // 设置 Staff 的其他属性
            dto.setTeacher(teacherDTO);
        }

        return dto;
    }

}
