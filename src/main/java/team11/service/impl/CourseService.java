/*
//Auther：Hengqian Mao
package team11.chengyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.domian.Course;
import team11.chengyu.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public boolean checkForConflicts(Course newCourse) {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().anyMatch(course -> {
            boolean hasTimeConflict =
                    course.getEndTime().isAfter(newCourse.getStartTime()) &&
                            course.getStartTime().isBefore(newCourse.getEndTime());
            if (course.getTeacher() != null && newCourse.getTeacher() != null) {
                // Check if both courses have a teacher and if their emails match
                return course.getTeacher().getEmail().equals(newCourse.getTeacher().getEmail()) &&
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

    // Other service methods...

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    // Add any other service methods you need...

}
*/
