package team11.Dyson.service;

import org.springframework.stereotype.Service;
import team11.Dyson.domain.Feedback;

@Service
public interface FeedbackService {

    public boolean upload(Feedback feedback);
}
