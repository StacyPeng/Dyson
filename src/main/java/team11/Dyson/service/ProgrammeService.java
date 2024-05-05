package team11.Dyson.service;

import org.springframework.stereotype.Service;
import team11.Dyson.domian.Programme;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 14:00
 * @student ID:230045675
 */
@Service
public interface ProgrammeService {

    public Programme getProgrammeById(int id);
    public Programme getProgrammeByName(String name);
    public List<Programme> findAll();
    public boolean modifyStudent(String studentEmailAddress, int programmeId);
    public boolean addProgramme(Programme programme);
}
