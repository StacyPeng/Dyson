package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domian.Staff;
import team11.Dyson.mapper.StaffMapper;
import team11.Dyson.service.impl.StaffServiceImpl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StaffServiceImplTest {

    @Mock
    private StaffMapper mockStaffMapper;

    @InjectMocks
    private StaffServiceImpl staffServiceImplUnderTest;

    @Test
    void testLogin() {
        // Setup
        // Configure StaffMapper.login(...).
        final Staff staff = new Staff();
        staff.setStaffEmailAddress("staffEmailAddress");
        staff.setStaName("staName");
        staff.setPassword("password");
        staff.setGender("gender");
        staff.setBirthday(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        when(mockStaffMapper.login("email", "password")).thenReturn(staff);

        // Run the test
        final Staff result = staffServiceImplUnderTest.login("email", "password");

        // Verify the results
    }

    @Test
    void testLogin_StaffMapperReturnsNull() {
        // Setup
        when(mockStaffMapper.login("email", "password")).thenReturn(null);

        // Run the test
        final Staff result = staffServiceImplUnderTest.login("email", "password");

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testRegister() {
        // Setup
        final Staff staff = new Staff();
        staff.setStaffEmailAddress("staffEmailAddress");
        staff.setStaName("staName");
        staff.setPassword("password");
        staff.setGender("gender");
        staff.setBirthday(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final String result = staffServiceImplUnderTest.register(staff);

        // Verify the results
        verify(mockStaffMapper).register(any(Staff.class));
    }

    @Test
    void testModifyPassword() {
        // Setup
        when(mockStaffMapper.modifyPassword("password", "email")).thenReturn(false);

        // Run the test
        final boolean result = staffServiceImplUnderTest.modifyPassword("password", "email");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testModifyPassword_StaffMapperReturnsTrue() {
        // Setup
        when(mockStaffMapper.modifyPassword("password", "email")).thenReturn(true);

        // Run the test
        final boolean result = staffServiceImplUnderTest.modifyPassword("password", "email");

        // Verify the results
        assertThat(result).isTrue();
    }
}
