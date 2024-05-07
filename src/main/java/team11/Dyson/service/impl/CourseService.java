//Auther：Hengqian Mao
package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Course;
import team11.Dyson.domian.Student;
import team11.Dyson.dto.CourseDTO;
import team11.Dyson.repository.CourseRepository;
import team11.Dyson.repository.StudentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository; // 注入 StudentRepository

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository; // 初始化 StudentRepository
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
        // 在此方法中实现根据学生邮箱检索与该学生相关的课程的逻辑
        // 以下是一个示例，您需要根据实际需求进行调整

        // 使用 StudentRepository 根据学生邮箱查找学生
        Optional<Student> studentOptional = studentRepository.findByStudentEmailAddress(studentEmail);
        Student student = studentOptional.orElse(null); // 获取 Student 对象或者返回 null
        if (student != null) {
            // 返回学生的课程列表
            return student.getCourses();
        } else {
            // 如果找不到学生，则返回一个空列表或者抛出异常，取决于您的需求
            return Collections.emptyList(); // 返回空列表表示找不到相关课程
        }
    }

    public Course updateCourse(Course existingCourse, CourseDTO courseDTO) {
        existingCourse.setTitle(courseDTO.getTitle());
        existingCourse.setStartTime(courseDTO.getStartTime());
        existingCourse.setEndTime(courseDTO.getEndTime());
        // 根据需要更新其他字段
        return courseRepository.save(existingCourse);
    }

    public boolean deleteCourse(Integer id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
}
