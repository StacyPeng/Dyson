//Auther：Hengqian Mao
package team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team11.domian.Course;
import team11.service.impl.CourseService;

import java.util.List;

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
    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }
}
