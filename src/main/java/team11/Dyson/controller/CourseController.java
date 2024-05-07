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
import team11.Dyson.service.impl.AuthenticationService;
import team11.Dyson.service.impl.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private AuthenticationService authenticationService;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody CourseDTO courseDTO) {
        Course existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
        }
        // 更新课程逻辑，假设已经在CourseService中实现了updateCourse方法
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
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
        Course course = convertToCourseEntity(courseDTO);
        Course savedCourse = courseService.addCourse(course);
        if (savedCourse == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 处理冲突，例如时间冲突
        }
        return ResponseEntity.ok(convertToCourseDTO(savedCourse));
    }

    @GetMapping("/studentEmail")
    public ResponseEntity<?> storeEmailInSession(HttpSession session, @RequestParam String email) {
        if (email == null || email.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email parameter is missing or empty.");
        }
        session.setAttribute("studentEmail", email);
        return ResponseEntity.ok("Email stored in session successfully.");
    }




    private Course convertToCourseEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setStartTime(courseDTO.getStartTime());
        course.setEndTime(courseDTO.getEndTime());
        // 根据需要设置其他字段，比如教师信息等
        if (courseDTO.getTeacher() != null) {
            Staff teacher = new Staff();
            teacher.setStaffEmailAddress(courseDTO.getTeacher().getEmail());
            // 可能还需要设置教师的其他信息
            course.setTeacher(teacher);
        }
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
