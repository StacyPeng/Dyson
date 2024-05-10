package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domian.Coursework;
import team11.Dyson.mapper.CourseworkMapper;
import team11.Dyson.service.impl.CourseworkServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseworkServiceImplTest {

    @Mock
    private CourseworkMapper mockCourseworkMapper;

    @InjectMocks
    private CourseworkServiceImpl courseworkServiceImplUnderTest;

    @Test
    void testGetByName() {
        // Setup
        // Configure CourseworkMapper.getByName(...).
        final List<Coursework> courseworks = List.of(
                new Coursework("courseworkName", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                        "coursework_description", 0));
        when(mockCourseworkMapper.getByName("courseworkName")).thenReturn(courseworks);

        // Run the test
        final List<Coursework> result = courseworkServiceImplUnderTest.getByName("courseworkName");

        // Verify the results
    }

    @Test
    void testGetByName_CourseworkMapperReturnsNoItems() {
        // Setup
        when(mockCourseworkMapper.getByName("courseworkName")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Coursework> result = courseworkServiceImplUnderTest.getByName("courseworkName");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetAll() {
        // Setup
        // Configure CourseworkMapper.getAll(...).
        final List<Coursework> courseworks = List.of(
                new Coursework("courseworkName", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                        "coursework_description", 0));
        when(mockCourseworkMapper.getAll()).thenReturn(courseworks);

        // Run the test
        final List<Coursework> result = courseworkServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_CourseworkMapperReturnsNoItems() {
        // Setup
        when(mockCourseworkMapper.getAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Coursework> result = courseworkServiceImplUnderTest.getAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
