package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.Dyson.domain.Modules;
import team11.Dyson.domain.Result;
import team11.Dyson.service.ModulesService;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/modules")
public class ModulesController {
    @Autowired
    private ModulesService modulesService;

    @GetMapping("/{modName}")
    public Result getByName(@PathVariable String modName) {
        Modules modules = modulesService.getByName(modName);
        Integer code = modules !=null?Code.GET_OK:Code.GET_ERR;
        String massage = modules != null?"":"fail to search, please input again";
        return new Result(code,modules,massage);
    }

    @GetMapping
    public Result getAll() {
        List<Modules> modulesList = modulesService.getAll();
        Integer code = modulesList !=null?Code.GET_OK:Code.GET_ERR;
        String massage = modulesList != null?"":"fail to search, please input again";
        return new Result(code,modulesList,massage);
    }
}
