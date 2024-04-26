package team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.domian.Feedback;
import team11.service.FeedbackService;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public String uplodeFeedback(@RequestBody Feedback feedback) {
        boolean upload = feedbackService.upload(feedback);
        if (upload){
            return "Success to upload feedback";
        }else {
            return "Something went wrong, please try again";
        }
    }
}
