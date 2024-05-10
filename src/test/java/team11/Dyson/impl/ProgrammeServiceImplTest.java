package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.Programme;
import team11.Dyson.mapper.ProgrammeMapper;
import team11.Dyson.service.impl.ProgrammeServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProgrammeServiceImplTest {

    @Mock
    private ProgrammeMapper mockProgrammeMapper;

    @InjectMocks
    private ProgrammeServiceImpl programmeServiceImplUnderTest;

    @Test
    void testGetProgrammeById() {
        // Setup
        // Configure ProgrammeMapper.getProgrammeById(...).
        final Programme programme = new Programme(0, "proName", "Description", "student_email_address");
        when(mockProgrammeMapper.getProgrammeById(0)).thenReturn(programme);

        // Run the test
        final Programme result = programmeServiceImplUnderTest.getProgrammeById(0);

        // Verify the results
    }

    @Test
    void testGetProgrammeByName() {
        // Setup
        // Configure ProgrammeMapper.getProgrammeByName(...).
        final Programme programme = new Programme(0, "proName", "Description", "student_email_address");
        when(mockProgrammeMapper.getProgrammeByName("name")).thenReturn(programme);

        // Run the test
        final Programme result = programmeServiceImplUnderTest.getProgrammeByName("name");

        // Verify the results
    }

    @Test
    void testFindAll() {
        // Setup
        // Configure ProgrammeMapper.getAllProgramme(...).
        final List<Programme> programmes = List.of(new Programme(0, "proName", "Description", "student_email_address"));
        when(mockProgrammeMapper.getAllProgramme()).thenReturn(programmes);

        // Run the test
        final List<Programme> result = programmeServiceImplUnderTest.findAll();

        // Verify the results
    }

    @Test
    void testFindAll_ProgrammeMapperReturnsNoItems() {
        // Setup
        when(mockProgrammeMapper.getAllProgramme()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Programme> result = programmeServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testModifyStudent() {
        // Setup
        when(mockProgrammeMapper.modifyStudent("studentEmailAddress", 0)).thenReturn(false);

        // Run the test
        final boolean result = programmeServiceImplUnderTest.modifyStudent("studentEmailAddress", 0);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testModifyStudent_ProgrammeMapperReturnsTrue() {
        // Setup
        when(mockProgrammeMapper.modifyStudent("studentEmailAddress", 0)).thenReturn(true);

        // Run the test
        final boolean result = programmeServiceImplUnderTest.modifyStudent("studentEmailAddress", 0);

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    void testAddProgramme() {
        // Setup
        final Programme programme = new Programme(0, "proName", "Description", "student_email_address");
        when(mockProgrammeMapper.addProgramme(any(Programme.class))).thenReturn(false);

        // Run the test
        final boolean result = programmeServiceImplUnderTest.addProgramme(programme);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testAddProgramme_ProgrammeMapperReturnsTrue() {
        // Setup
        final Programme programme = new Programme(0, "proName", "Description", "student_email_address");
        when(mockProgrammeMapper.addProgramme(any(Programme.class))).thenReturn(true);

        // Run the test
        final boolean result = programmeServiceImplUnderTest.addProgramme(programme);

        // Verify the results
        assertThat(result).isTrue();
    }
}
