package team11.chengyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.domian.Modules;
import team11.chengyu.mapper.ModulesMapper;
import team11.chengyu.service.ModulesService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class ModulesServiceImpl implements ModulesService {

    @Autowired
    private ModulesMapper modulesMapper;

    @Override
    public Modules getById(int modId) {
        return modulesMapper.getById(modId);
    }

    @Override
    public List<Modules> getAll() {
        return modulesMapper.getAll();
    }
}
