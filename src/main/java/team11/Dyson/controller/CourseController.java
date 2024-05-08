package team11.Dyson.controller;

//Auther：Hengqian Mao
//c3008838
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Course;
import team11.Dyson.domian.Staff;
import team11.Dyson.dto.CourseDTO;
import team11.Dyson.dto.StaffDTO;
import team11.Dyson.dto.SubscriptionRequest;
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
        // Get the email address of the currently logged in student from the authentication service
        String currentStudentEmail = authenticationService.getCurrentStudentEmail(session);

        // If the current student mailbox is empty, it may indicate that the user is not logged in or authorized
        if (currentStudentEmail == null) {
            // Return an appropriate error response, such as 401 not authorized
            return ResponseEntity.status(401).body("Unauthorized access.");
        }

        // Retrieve the courses related to the student according to the student's email address
        List<Course> studentCourses = courseService.findCoursesByStudentEmail(currentStudentEmail);

        // Convert the course to DTO and back
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
        // Update the course logic
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
        // Get the email address of the currently logged faculty member from the session
        String staffEmail = (String) session.getAttribute("staffEmail");
        if (staffEmail == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Create the course entity and set the necessary information from the DTO
        Course course = convertToCourseEntity(courseDTO);

        // Set the staff information
        Staff teacher = new Staff();
        teacher.setStaffEmailAddress(staffEmail);  // Make sure there is a constructor or setter to set the email address
        course.setTeacher(teacher);

        // Save the course to the database
        Course savedCourse = courseService.addCourse(course);
        if (savedCourse == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        // Convert saved courses back to DTO
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

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribeCourse(@RequestBody SubscriptionRequest request, HttpSession session) {
        String currentStudentEmail = request.getEmail(); // Get the email address from the request body

        if (currentStudentEmail == null || currentStudentEmail.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        Integer courseId = request.getCourseId(); // Get the course ID from the request body
        if (courseId == null) {
            return ResponseEntity.badRequest().body("Course ID is required.");
        }

        boolean success = courseService.addCourseForStudent(courseId, currentStudentEmail);
        if (success) {
            return ResponseEntity.ok("Subscribed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error subscribing to course.");
        }
    }


    @DeleteMapping("/unsubscribe/{courseId}")
    public ResponseEntity<?> unsubscribeCourse(@PathVariable Integer courseId, HttpSession session) {
        String currentStudentEmail = authenticationService.getCurrentStudentEmail(session);
        if (currentStudentEmail == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        boolean success = courseService.removeCourseForStudent(courseId, currentStudentEmail);
        if (success) {
            return ResponseEntity.ok("Unsubscribed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found or not subscribed.");
        }
    }



    private Course convertToCourseEntity(CourseDTO courseDTO) {
        if (courseDTO.getEndTime() == null) {
            System.out.println("Received null endTime for course: " + courseDTO.getTitle());
        }

        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setStartTime(courseDTO.getStartTime());
        course.setEndTime(courseDTO.getEndTime());
        course.setModId(courseDTO.getModId());

        return course;
    }

    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());
        dto.setModId(course.getModId());


        // If the teacher in the Course is not null, convert to StaffDTO
        if (course.getTeacher() != null) {
            StaffDTO teacherDTO = new StaffDTO();
            teacherDTO.setEmail(course.getTeacher().getStaffEmailAddress());
            // Set other properties of Staff
            dto.setTeacher(teacherDTO);
        }

        return dto;
    }

}
