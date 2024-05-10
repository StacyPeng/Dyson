package team11.Dyson.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.StuClass;
import team11.Dyson.mapper.StuClassMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Dechun Meng
 */
@ExtendWith(MockitoExtension.class)
class StuClassServiceImplTest {

    @Mock
    private StuClassMapper mockStuClassMapper;

    @InjectMocks
    private StuClassServiceImpl stuClassServiceImplUnderTest;

    @Test
    void testExtension() {
        // Setup
        final StuClass stuClass = new StuClass();

        when(mockStuClassMapper.extensionInsert(any(StuClass.class))).thenReturn(false);

        // Run the test
        final boolean result = stuClassServiceImplUnderTest.extension(stuClass);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testExtension_StuClassMapperReturnsTrue() {
        // Setup
        final StuClass stuClass = new StuClass();

        when(mockStuClassMapper.extensionInsert(any(StuClass.class))).thenReturn(true);

        // Run the test
        final boolean result = stuClassServiceImplUnderTest.extension(stuClass);

        // Verify the results
        assertThat(result).isTrue();
    }
}
