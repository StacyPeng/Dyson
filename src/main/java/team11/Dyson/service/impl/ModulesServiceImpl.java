package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domain.Modules;
import team11.Dyson.mapper.ModulesMapper;
import team11.Dyson.service.ModulesService;

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
    public Modules getByName(String modName) {
        return modulesMapper.getByName(modName);
    }

    @Override
    public List<Modules> getAll() {
        return modulesMapper.getAll();
    }
}
