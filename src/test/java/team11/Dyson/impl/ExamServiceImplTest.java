package team11.Dyson.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.Exam;
import team11.Dyson.mapper.ExamMapper;
import team11.Dyson.service.impl.ExamServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {

    @Mock
    private ExamMapper mockExamMapper;

    private ExamServiceImpl examServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        examServiceImplUnderTest = new ExamServiceImpl();
        examServiceImplUnderTest.examMapper = mockExamMapper;
    }

    @Test
    void testGetByName() {
        // Setup
        // Configure ExamMapper.getByName(...).
        final Exam exam = new Exam();
        exam.setAchievement("achievement");
        exam.setExamId(0);
        exam.setExamName("examName");
        exam.setExamTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        exam.setPlace("place");
        when(mockExamMapper.getByName("examName")).thenReturn(exam);

        // Run the test
        final Exam result = examServiceImplUnderTest.getByName("examName");

        // Verify the results
    }

    @Test
    void testGetAll() {
        // Setup
        // Configure ExamMapper.getAll(...).
        final Exam exam = new Exam();
        exam.setAchievement("achievement");
        exam.setExamId(0);
        exam.setExamName("examName");
        exam.setExamTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        exam.setPlace("place");
        final List<Exam> exams = List.of(exam);
        when(mockExamMapper.getAll()).thenReturn(exams);

        // Run the test
        final List<Exam> result = examServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_ExamMapperReturnsNoItems() {
        // Setup
        when(mockExamMapper.getAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Exam> result = examServiceImplUnderTest.getAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
