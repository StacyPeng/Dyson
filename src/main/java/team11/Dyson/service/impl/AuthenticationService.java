package team11.Dyson.service.impl;
//Auther：Hengqian Mao
//c3008838
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Course;
import team11.Dyson.domian.Student;
import team11.Dyson.dto.StudentDTO;
import team11.Dyson.repository.StudentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private StudentRepository studentRepository; // Suppose there is a repository for student actions

    public StudentDTO getCurrentStudent(HttpSession session) {

        String studentEmail = getSessionStudentEmail(session);

        // Use student email address to search for students
        if (studentEmail != null) {
            Optional<Student> studentOptional = studentRepository.findByStudentEmailAddress(studentEmail);
            if (studentOptional.isPresent()) {
                return convertToStudentDTO(studentOptional.get());
            }
        }
        return null; // If the student associated with the session cannot be found, null is returned
    }

    public String getCurrentStudentEmail(HttpSession session) {
        // Get the email address of the currently logged in student

        return getSessionStudentEmail(session);
    }

    public List<Course> findCoursesByStudentEmail(String studentEmail) {
        // Retrieve courses from database according to student email address

        if (studentEmail != null) {
            Optional<Student> studentOptional = studentRepository.findByStudentEmailAddress(studentEmail);
            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                return student.getCourses(); // Suppose your Student class has a getCourses() method to get a list of courses associated with the student
            }
        }
        return Collections.emptyList(); // If the student cannot be found or the student does not have any courses, an empty list is returned
    }

    // Helper method to retrieve student email from session
    private String getSessionStudentEmail(HttpSession session) {
        // Get the student email from the HTTP session
        return (String) session.getAttribute("studentEmail");
    }


    // Convert Student entity to DTO
    private StudentDTO convertToStudentDTO(Student student) {
        // Implement the conversion logic from Student entity to StudentDTO
        // This is just a placeholder, you need to implement this conversion according to your application's requirements
        return new StudentDTO();
    }
}
