package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Feedback;
import team11.Dyson.mapper.FeedbackMapper;
import team11.Dyson.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public boolean upload(Feedback feedback) {
        return feedbackMapper.upload(feedback);
    }
}
