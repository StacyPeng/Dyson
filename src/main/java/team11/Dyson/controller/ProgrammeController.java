package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Programme;
import team11.Dyson.domian.Result;
import team11.Dyson.service.ProgrammeService;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 14:09
 * @student ID:230045675
 */
@RestController
@RequestMapping("/programmes")
@CrossOrigin(origins = "*")
public class ProgrammeController {

    @Autowired
    private ProgrammeService programmeService;

    @GetMapping("/{id}")
    public Result getProgrammeById(@PathVariable int id) {
        Programme programme =programmeService.getProgrammeById(id);
        Integer code = programme !=null?Code.GET_OK:Code.GET_ERR;
        String massage = programme !=null?"successful to search":"fail to search, please input again";
        return new Result(code, programme,massage);
    }

    @GetMapping("/name/{programmeName}")
    public Result getProgrammeByName(@PathVariable String programmeName) {
        Programme programme =programmeService.getProgrammeByName(programmeName);
        Integer code = programme !=null?Code.GET_OK:Code.GET_ERR;
        String massage = programme !=null?"successful to search":"fail to search, please input again";
        return new Result(code, programme,massage);
    }

    @GetMapping
    public Result findAll() {
        List<Programme> programmes = programmeService.findAll();
        Integer code = programmes !=null?Code.GET_OK:Code.GET_ERR;
        String massage = programmes !=null?"successful to search":"fail to search";
        return new Result(code, programmes,massage);
    }

    @PutMapping
    public Result modifyStudent(@RequestParam String studentEmailAddress, @RequestParam int programmeId) {
        boolean flag = programmeService.modifyStudent(studentEmailAddress,programmeId);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @PostMapping
    public Result addProgramme(@RequestBody Programme programme) {
        Boolean flag = programmeService.addProgramme(programme);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
}
