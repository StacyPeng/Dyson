package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Programme;
import team11.Dyson.mapper.ProgrammeMapper;
import team11.Dyson.service.ProgrammeService;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 14:05
 * @student ID:230045675
 */
@Service
public class ProgrammeServiceImpl implements ProgrammeService {

    @Autowired
    private ProgrammeMapper programmeMapper;

    @Override
    public Programme getProgrammeById(int id) {
        return programmeMapper.getProgrammeById(id);
    }

    @Override
    public Programme getProgrammeByName(String name) {
        return programmeMapper.getProgrammeByName(name);
    }

    @Override
    public List<Programme> findAll() {
        return programmeMapper.getAllProgramme();
    }

    @Override
    public boolean modifyStudent(String studentEmailAddress, int programmeId) {
        return programmeMapper.modifyStudent(studentEmailAddress, programmeId);
    }

    @Override
    public boolean addProgramme(Programme programme) {
        return programmeMapper.addProgramme(programme);
    }
}
