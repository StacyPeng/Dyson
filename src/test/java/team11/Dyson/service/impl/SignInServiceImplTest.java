package team11.Dyson.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team11.Dyson.domain.SignIn;
import team11.Dyson.mapper.SignInMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Dechun Meng
 */
@ExtendWith(MockitoExtension.class)
class SignInServiceImplTest {

    @Mock
    private SignInMapper mockSignInMapper;

    @InjectMocks
    private SignInServiceImpl signInServiceImplUnderTest;

    @Test
    void testSignin() {
        // Setup
        final SignIn signIn = new SignIn(0L, "studentEmailAddress", 0);
        when(mockSignInMapper.signin(any(SignIn.class))).thenReturn(false);

        // Run the test
        final boolean result = signInServiceImplUnderTest.signin(signIn);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSignin_SignInMapperReturnsTrue() {
        // Setup
        final SignIn signIn = new SignIn(0L, "studentEmailAddress", 0);
        when(mockSignInMapper.signin(any(SignIn.class))).thenReturn(true);

        // Run the test
        final boolean result = signInServiceImplUnderTest.signin(signIn);

        // Verify the results
        assertThat(result).isTrue();
    }
}
