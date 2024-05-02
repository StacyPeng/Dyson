package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.Dyson.domian.Course;
import team11.Dyson.dto.CourseDTO;
import team11.Dyson.dto.StaffDTO;
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

    @GetMapping("/student")
    public ResponseEntity<?> getStudentCourses() {
        // 从身份验证服务中获取当前登录学生的邮箱地址
        String currentStudentEmail = authenticationService.getCurrentStudentEmail();

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

    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());
        // 设置其他属性...

        // 如果 Course 中的 teacher 不为 null，转换为 StaffDTO
        if (course.getTeacher() != null) {
            StaffDTO teacherDTO = new StaffDTO();
            teacherDTO.setEmail(course.getTeacher().getEmail());
            // 设置 Staff 的其他属性
            dto.setTeacher(teacherDTO);
        }

        return dto;
    }

}
