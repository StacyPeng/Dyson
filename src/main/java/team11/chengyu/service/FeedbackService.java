package team11.chengyu.service;

import org.springframework.stereotype.Service;
import team11.chengyu.domian.Feedback;

@Service
public interface FeedbackService {

    public boolean upload(Feedback feedback);
}
