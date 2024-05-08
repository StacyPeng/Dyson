//Auther：Hengqian Mao
//c3008838
package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Course;
import team11.Dyson.domian.Student;
import team11.Dyson.dto.CourseDTO;
import team11.Dyson.mapper.ClassesMapper;
import team11.Dyson.repository.CourseRepository;
import team11.Dyson.repository.StudentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public boolean checkForConflicts(Course newCourse) {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().anyMatch(course -> {
            boolean hasTimeConflict =
                    course.getEndTime().isAfter(newCourse.getStartTime()) &&
                            course.getStartTime().isBefore(newCourse.getEndTime());
            if (course.getTeacher() != null && newCourse.getTeacher() != null) {
                // Check if both courses have a teacher and if their emails match
                return course.getTeacher().getStaffEmailAddress().equals(newCourse.getTeacher().getStaffEmailAddress()) &&
                        hasTimeConflict;
            }
            // If one of the courses doesn't have a teacher, just check the time conflict
            return hasTimeConflict;
        });
    }

    public Course addCourse(Course course) {
        if (!checkForConflicts(course)) {
            return courseRepository.save(course);
        } else {
            // Log or handle the conflict case, for example:
            System.out.println("This course has a scheduling conflict and cannot be added.");
        }
        return null; // or you can throw a custom exception if preferred
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findCoursesByStudentEmail(String studentEmail) {

        Optional<Student> studentOptional = studentRepository.findByStudentEmailAddress(studentEmail);
        Student student = studentOptional.orElse(null);
        if (student != null) {

            return student.getCourses();
        } else {

            return Collections.emptyList();
        }
    }

    // CourseService.java

    public List<Course> findCoursesByTeacherEmail(String email) {
        // Get the course associated with the teacher email from the database
        return courseRepository.findByTeacher_StaffEmailAddress(email);
    }


    public Course updateCourse(Course existingCourse, CourseDTO courseDTO) {
        existingCourse.setTitle(courseDTO.getTitle());
        existingCourse.setStartTime(courseDTO.getStartTime());
        existingCourse.setEndTime(courseDTO.getEndTime());

        return courseRepository.save(existingCourse);
    }

    public boolean deleteCourse(Integer id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean addCourseForStudent(Integer courseId, String email) {
        // First make sure the students and course exist
        if (studentRepository.existsByStudentEmailAddress(email) && courseRepository.existsById(courseId)) {
            Student student = studentRepository.findByStudentEmailAddress(email).orElse(null);
            Course course = courseRepository.findById(courseId).orElse(null);
            if (course != null && student != null) {
                course.getStudents().add(student); // Add students to the course association
                courseRepository.save(course); // Save the changes
                return true;
            }
        }
        return false;
    }

    public boolean removeCourseForStudent(Integer courseId, String email) {
        // Confirm that students and courses exist
        if (studentRepository.existsByStudentEmailAddress(email) && courseRepository.existsById(courseId)) {
            Student student = studentRepository.findByStudentEmailAddress(email).orElse(null);
            Course course = courseRepository.findById(courseId).orElse(null);
            if (course != null && student != null && course.getStudents().contains(student)) {
                course.getStudents().remove(student); // Remove students from the course
                courseRepository.save(course); // Save the changes
                return true;
            }
        }
        return false;
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
}
