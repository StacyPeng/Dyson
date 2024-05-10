package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.*;
import team11.Dyson.mapper.StudentMapper;
import team11.Dyson.service.impl.StudentServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentMapper mockStudentMapper;

    @InjectMocks
    private StudentServiceImpl studentServiceImplUnderTest;

    @Test
    void testLogin() {
        // Setup
        // Configure StudentMapper.login(...).
        final Student student = new Student("studentEmailAddress", "stuName", "password", "gender",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStudentMapper.login("studentEmailAddress", "password")).thenReturn(student);

        // Run the test
        final Student result = studentServiceImplUnderTest.login("studentEmailAddress", "password");

        // Verify the results
    }

    @Test
    void testLogin_StudentMapperReturnsNull() {
        // Setup
        when(mockStudentMapper.login("studentEmailAddress", "password")).thenReturn(null);

        // Run the test
        final Student result = studentServiceImplUnderTest.login("studentEmailAddress", "password");

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testRegister() {
        // Setup
        final Student student = new Student("studentEmailAddress", "stuName", "password", "gender",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final String result = studentServiceImplUnderTest.register(student);

        // Verify the results
        verify(mockStudentMapper).register(any(Student.class));
    }

    @Test
    void testModifyPassword() {
        // Setup
        when(mockStudentMapper.modifyPassword("password", "studentEmailAddress")).thenReturn(false);

        // Run the test
        final boolean result = studentServiceImplUnderTest.modifyPassword("password", "studentEmailAddress");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testModifyPassword_StudentMapperReturnsTrue() {
        // Setup
        when(mockStudentMapper.modifyPassword("password", "studentEmailAddress")).thenReturn(true);

        // Run the test
        final boolean result = studentServiceImplUnderTest.modifyPassword("password", "studentEmailAddress");

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    void testGetByEmail() {
        // Setup
        // Configure StudentMapper.getByEmail(...).
        final Student student = new Student("studentEmailAddress", "stuName", "password", "gender",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStudentMapper.getByEmail("studentEmailAddress")).thenReturn(student);

        // Run the test
        final Student result = studentServiceImplUnderTest.getByEmail("studentEmailAddress");

        // Verify the results
    }

    @Test
    void testGetAll() {
        // Setup
        // Configure StudentMapper.getAll(...).
        final List<Student> students = List.of(new Student("studentEmailAddress", "stuName", "password", "gender",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()));
        when(mockStudentMapper.getAll()).thenReturn(students);

        // Run the test
        final List<Student> result = studentServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_StudentMapperReturnsNoItems() {
        // Setup
        when(mockStudentMapper.getAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Student> result = studentServiceImplUnderTest.getAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetClassesInfo() {
        // Setup
        final Classes classes = new Classes();
        classes.setClassId(0L);
        classes.setClassName("className");
        classes.setClassTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        classes.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        classes.setRoom("room");
        final List<Classes> expectedResult = List.of(classes);

        // Configure StudentMapper.getClassesInfo(...).
        final Classes classes2 = new Classes();
        classes2.setClassId(0L);
        classes2.setClassName("className");
        classes2.setClassTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        classes2.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        classes2.setRoom("room");
        final List<Classes> classes1 = List.of(classes2);
        when(mockStudentMapper.getClassesInfo("student_email_address")).thenReturn(classes1);

        // Run the test
        final List<Classes> result = studentServiceImplUnderTest.getClassesInfo("student_email_address");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetClassesInfo_StudentMapperReturnsNoItems() {
        // Setup
        when(mockStudentMapper.getClassesInfo("student_email_address")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Classes> result = studentServiceImplUnderTest.getClassesInfo("student_email_address");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetModulesInfo() {
        // Setup
        // Configure StudentMapper.getModulesInfo(...).
        final Modules modules = new Modules(0, "modName", 0, 0, "description");
        when(mockStudentMapper.getModulesInfo("modId")).thenReturn(modules);

        // Run the test
        final Modules result = studentServiceImplUnderTest.getModulesInfo("modId");

        // Verify the results
    }

    @Test
    void testGetExamInfo() {
        // Setup
        // Configure StudentMapper.getExamInfo(...).
        final Exam exam = new Exam();
        exam.setAchievement("achievement");
        exam.setExamId(0);
        exam.setExamName("examName");
        exam.setExamTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        exam.setPlace("place");
        when(mockStudentMapper.getExamInfo("modId")).thenReturn(exam);

        // Run the test
        final Exam result = studentServiceImplUnderTest.getExamInfo("modId");

        // Verify the results
    }

    @Test
    void testGetRegisteredmodulesInfo() {
        // Setup
        final Registeredmodules registeredmodules = new Registeredmodules();
        registeredmodules.setStudentEmailAddress("studentEmailAddress");
        registeredmodules.setModId("modId");
        registeredmodules.setModName("modName");
        final List<Registeredmodules> expectedResult = List.of(registeredmodules);

        // Configure StudentMapper.getRegisteredmodulesInfo(...).
        final Registeredmodules registeredmodules2 = new Registeredmodules();
        registeredmodules2.setStudentEmailAddress("studentEmailAddress");
        registeredmodules2.setModId("modId");
        registeredmodules2.setModName("modName");
        final List<Registeredmodules> registeredmodules1 = List.of(registeredmodules2);
        when(mockStudentMapper.getRegisteredmodulesInfo("student_email_address")).thenReturn(registeredmodules1);

        // Run the test
        final List<Registeredmodules> result = studentServiceImplUnderTest.getRegisteredmodulesInfo(
                "student_email_address");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetRegisteredmodulesInfo_StudentMapperReturnsNoItems() {
        // Setup
        when(mockStudentMapper.getRegisteredmodulesInfo("student_email_address")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Registeredmodules> result = studentServiceImplUnderTest.getRegisteredmodulesInfo(
                "student_email_address");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
