package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Course;
import team11.Dyson.domian.Student;
import team11.Dyson.dto.StudentDTO;
import team11.Dyson.repository.StudentRepository;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private StudentRepository studentRepository;

    // 从会话中获取当前登录学生的邮箱，并返回学生DTO
    public StudentDTO getCurrentStudent(HttpSession session) {
        String studentEmail = getSessionStudentEmail(session);
        if (studentEmail != null) {
            Optional<Student> studentOptional = studentRepository.findByStudentEmailAddress(studentEmail);
            if (studentOptional.isPresent()) {
                return convertToStudentDTO(studentOptional.get());
            }
        }
        return null;
    }

    // 从会话中获取当前登录学生的邮箱
    public String getCurrentStudentEmail(HttpSession session) {
        return getSessionStudentEmail(session);
    }

    // 从数据库中检索与给定学生邮箱关联的课程列表
    public List<Course> findCoursesByStudentEmail(String studentEmail) {
        if (studentEmail != null) {
            Optional<Student> studentOptional = studentRepository.findByStudentEmailAddress(studentEmail);
            if (studentOptional.isPresent()) {
                return studentOptional.get().getCourses();
            }
        }
        return Collections.emptyList();
    }

    // Helper method to retrieve student email from session
    private String getSessionStudentEmail(HttpSession session) {
        return (String) session.getAttribute("userEmail"); // 使用会话中存储的用户邮箱
    }

    // Convert Student entity to DTO
    private StudentDTO convertToStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setStudentEmailAddress(student.getStudentEmailAddress());
        if (!student.getCourses().isEmpty()) {
            // 假设学生的第一个课程是主要课程
            dto.setCourseId(student.getCourses().get(0).getId());
        } else {
            dto.setCourseId(null); // 如果没有课程，设置为null
        }
        return dto;
    }
}
