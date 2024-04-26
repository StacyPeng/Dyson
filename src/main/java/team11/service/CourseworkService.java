package team11.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.domian.Coursework;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
@Transactional
public interface CourseworkService {
    public Coursework getById(int classId);

    public List<Coursework> getAll();
}
