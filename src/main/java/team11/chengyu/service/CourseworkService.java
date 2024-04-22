package team11.chengyu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSException;
import team11.chengyu.domian.Coursework;

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
