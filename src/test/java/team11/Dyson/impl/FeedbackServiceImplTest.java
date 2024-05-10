package team11.Dyson.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.Feedback;
import team11.Dyson.mapper.FeedbackMapper;
import team11.Dyson.service.impl.FeedbackServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceImplTest {

    @Mock
    private FeedbackMapper mockFeedbackMapper;

    @InjectMocks
    private FeedbackServiceImpl feedbackServiceImplUnderTest;

    @Test
    void testUpload() {
        // Setup
        final Feedback feedback = new Feedback("student_email_address", "content");
        when(mockFeedbackMapper.upload(any(Feedback.class))).thenReturn(false);

        // Run the test
        final boolean result = feedbackServiceImplUnderTest.upload(feedback);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testUpload_FeedbackMapperReturnsTrue() {
        // Setup
        final Feedback feedback = new Feedback("student_email_address", "content");
        when(mockFeedbackMapper.upload(any(Feedback.class))).thenReturn(true);

        // Run the test
        final boolean result = feedbackServiceImplUnderTest.upload(feedback);

        // Verify the results
        assertThat(result).isTrue();
    }
}
