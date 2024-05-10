package team11.Dyson.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.StaffStudent;
import team11.Dyson.mapper.StaffStudentMapper;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author llh
 * @student ID:
 */
@ExtendWith(MockitoExtension.class)
class StaffStudentServiceImplTest {

    @Mock
    private StaffStudentMapper mockStaffStudentMapper;

    private StaffStudentServiceImpl staffStudentServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        staffStudentServiceImplUnderTest = new StaffStudentServiceImpl();
        staffStudentServiceImplUnderTest.staffStudentMapper = mockStaffStudentMapper;
    }

    @Test
    void testInsert() {
        // Setup
        when(mockStaffStudentMapper.insert("staffEmailAddress", "studentEmailAddress")).thenReturn(0);

        // Run the test
        final int result = staffStudentServiceImplUnderTest.insert("staffEmailAddress", "studentEmailAddress");

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testGetStudentByStaff() {
        // Setup
        // Configure StaffStudentMapper.getByStaffEmail(...).
        final StaffStudent staffStudent = new StaffStudent();
        final List<StaffStudent> staffStudents = List.of(staffStudent);
        when(mockStaffStudentMapper.getByStaffEmail("staffEmailAddress")).thenReturn(staffStudents);

        // Run the test
        final List<StaffStudent> result = staffStudentServiceImplUnderTest.getStudentByStaff("staffEmailAddress");

        // Verify the results
    }

    @Test
    void testGetStudentByStaff_StaffStudentMapperReturnsNoItems() {
        // Setup
        when(mockStaffStudentMapper.getByStaffEmail("staffEmailAddress")).thenReturn(Collections.emptyList());

        // Run the test
        final List<StaffStudent> result = staffStudentServiceImplUnderTest.getStudentByStaff("staffEmailAddress");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetStaffByStudent() {
        // Setup
        // Configure StaffStudentMapper.getByStudentEmail(...).
        final StaffStudent staffStudent = new StaffStudent();
        final List<StaffStudent> staffStudents = List.of(staffStudent);
        when(mockStaffStudentMapper.getByStudentEmail("studentEmailAddress")).thenReturn(staffStudents);

        // Run the test
        final List<StaffStudent> result = staffStudentServiceImplUnderTest.getStaffByStudent("studentEmailAddress");

        // Verify the results
    }

    @Test
    void testGetStaffByStudent_StaffStudentMapperReturnsNoItems() {
        // Setup
        when(mockStaffStudentMapper.getByStudentEmail("studentEmailAddress")).thenReturn(Collections.emptyList());

        // Run the test
        final List<StaffStudent> result = staffStudentServiceImplUnderTest.getStaffByStudent("studentEmailAddress");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testDelete() {
        // Setup
        when(mockStaffStudentMapper.delete("staffEmailAddress", "studentEmailAddress")).thenReturn(0);

        // Run the test
        final int result = staffStudentServiceImplUnderTest.delete("staffEmailAddress", "studentEmailAddress");

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
