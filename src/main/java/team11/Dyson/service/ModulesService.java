package team11.Dyson.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.Dyson.domain.Modules;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Transactional
@Service
public interface ModulesService {
    public Modules getByName(String modName);

    public List<Modules> getAll();
}
