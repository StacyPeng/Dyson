
//Auther：Hengqian Mao
package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Course;
import team11.Dyson.dto.CourseDTO;
import team11.Dyson.dto.StaffDTO;
import team11.Dyson.service.impl.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course savedCourse = courseService.addCourse(course);
        if (savedCourse == null) {
            return ResponseEntity.status(409).body("Time conflict detected.");
        }
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseService.findAllCourses();
        return courses.stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());
    }

    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());
        // ... 设置其他属性

        // 如果 Course 中的 teacher 不为 null，转换为 StaffDTO
        if (course.getTeacher() != null) {
            StaffDTO teacherDTO = new StaffDTO();
            teacherDTO.setEmail(course.getTeacher().getEmail());
            // ... 设置 Staff 的其他属性
            dto.setTeacher(teacherDTO);
        }

        return dto;
    }
}

