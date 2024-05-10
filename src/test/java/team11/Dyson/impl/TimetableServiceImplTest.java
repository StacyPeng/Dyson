package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.Timetable;
import team11.Dyson.mapper.TimetableMapper;
import team11.Dyson.service.impl.TimetableServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimetableServiceImplTest {

    @Mock
    private TimetableMapper mockTimetableMapper;

    @InjectMocks
    private TimetableServiceImpl timetableServiceImplUnderTest;

    @Test
    void testGetTimetables() {
        // Setup
        // Configure TimetableMapper.getAll(...).
        final Timetable timetable = new Timetable();
        timetable.setClass_id(0);
        timetable.setClass_name("class_name");
        timetable.setClass_time(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        timetable.setEnd_time(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        timetable.setRoom("room");
        final List<Timetable> timetables = List.of(timetable);
        when(mockTimetableMapper.getAll()).thenReturn(timetables);

        // Run the test
        final List<Timetable> result = timetableServiceImplUnderTest.getTimetables();

        // Verify the results
    }

    @Test
    void testGetTimetables_TimetableMapperReturnsNoItems() {
        // Setup
        when(mockTimetableMapper.getAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Timetable> result = timetableServiceImplUnderTest.getTimetables();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
