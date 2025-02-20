package team11.Dyson.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.Dyson.domain.Coursework;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
@Transactional
public interface CourseworkService {
    public List<Coursework> getByName(String courseworkName);

    public List<Coursework> getAll();
}
