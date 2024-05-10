package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;
import team11.Dyson.mapper.StaffMapper;
import team11.Dyson.mapper.StudentMapper;
import team11.Dyson.service.impl.UserService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private StudentMapper mockStudentMapper;
    @Mock
    private StaffMapper mockStaffMapper;

    @InjectMocks
    private UserService userServiceUnderTest;

    @Test
    void testUserSort() {
        // Setup
        // Configure StudentMapper.getByEmail(...).
        final Student student = new Student("studentEmailAddress", "stuName", "password", "gender",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStudentMapper.getByEmail("email")).thenReturn(student);

        // Run the test
        final Optional<Object> result = userServiceUnderTest.userSort("email");

        // Verify the results
    }

    @Test
    void testUserSort_StudentMapperReturnsNull() {
        // Setup
        when(mockStudentMapper.getByEmail("email")).thenReturn(null);

        // Configure StaffMapper.getByEmail(...).
        final Staff staff = new Staff();
        staff.setStaffEmailAddress("staffEmailAddress");
        staff.setStaName("staName");
        staff.setPassword("password");
        staff.setGender("gender");
        staff.setBirthday(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStaffMapper.getByEmail("email")).thenReturn(staff);

        // Run the test
        final Optional<Object> result = userServiceUnderTest.userSort("email");

        // Verify the results
    }

    @Test
    void testUserSort_StaffMapperReturnsNull() {
        // Setup
        when(mockStudentMapper.getByEmail("email")).thenReturn(null);
        when(mockStaffMapper.getByEmail("email")).thenReturn(null);

        // Run the test
        final Optional<Object> result = userServiceUnderTest.userSort("email");

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testAuthenticateUser() {
        // Setup
        // Configure StudentMapper.getByEmail(...).
        final Student student = new Student("studentEmailAddress", "stuName", "password", "gender",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStudentMapper.getByEmail("email")).thenReturn(student);

        // Run the test
        final Optional<Object> result = userServiceUnderTest.authenticateUser("email", "password");

        // Verify the results
    }

    @Test
    void testAuthenticateUser_StudentMapperReturnsNull() {
        // Setup
        when(mockStudentMapper.getByEmail("email")).thenReturn(null);

        // Configure StaffMapper.getByEmail(...).
        final Staff staff = new Staff();
        staff.setStaffEmailAddress("staffEmailAddress");
        staff.setStaName("staName");
        staff.setPassword("password");
        staff.setGender("gender");
        staff.setBirthday(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStaffMapper.getByEmail("email")).thenReturn(staff);

        // Run the test
        final Optional<Object> result = userServiceUnderTest.authenticateUser("email", "password");

        // Verify the results
    }

    @Test
    void testAuthenticateUser_StaffMapperReturnsNull() {
        // Setup
        when(mockStudentMapper.getByEmail("email")).thenReturn(null);
        when(mockStaffMapper.getByEmail("email")).thenReturn(null);

        // Run the test
        final Optional<Object> result = userServiceUnderTest.authenticateUser("email", "password");

        // Verify the results
        assertThat(result).isEmpty();
    }
}
