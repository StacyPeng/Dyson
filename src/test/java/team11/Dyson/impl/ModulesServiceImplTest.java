package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.Modules;
import team11.Dyson.mapper.ModulesMapper;
import team11.Dyson.service.impl.ModulesServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModulesServiceImplTest {

    @Mock
    private ModulesMapper mockModulesMapper;

    @InjectMocks
    private ModulesServiceImpl modulesServiceImplUnderTest;

    @Test
    void testGetByName() {
        // Setup
        // Configure ModulesMapper.getByName(...).
        final Modules modules = new Modules(0, "modName", 0, 0, "description");
        when(mockModulesMapper.getByName("modName")).thenReturn(modules);

        // Run the test
        final Modules result = modulesServiceImplUnderTest.getByName("modName");

        // Verify the results
    }

    @Test
    void testGetAll() {
        // Setup
        // Configure ModulesMapper.getAll(...).
        final List<Modules> modules = List.of(new Modules(0, "modName", 0, 0, "description"));
        when(mockModulesMapper.getAll()).thenReturn(modules);

        // Run the test
        final List<Modules> result = modulesServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_ModulesMapperReturnsNoItems() {
        // Setup
        when(mockModulesMapper.getAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Modules> result = modulesServiceImplUnderTest.getAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
