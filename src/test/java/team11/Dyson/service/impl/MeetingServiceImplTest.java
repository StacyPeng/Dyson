package team11.Dyson.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.Meeting;
import team11.Dyson.mapper.MeetingMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Dechun Meng
 */
@ExtendWith(MockitoExtension.class)
class MeetingServiceImplTest {

    @Mock
    private MeetingMapper mockMeetingMapper;

    @InjectMocks
    private MeetingServiceImpl meetingServiceImplUnderTest;

    @Test
    void testBookMeeting() {
        // Setup
        final Meeting meeting = new Meeting();

        when(mockMeetingMapper.book(any(Meeting.class))).thenReturn(false);

        // Run the test
        final String result = meetingServiceImplUnderTest.bookMeeting(meeting);

        // Verify the results
        assertThat(result).isEqualTo("Fail to book a meeting,please try again");
    }
}
