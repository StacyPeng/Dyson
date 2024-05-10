package team11.Dyson.service;

import com.baomidou.mybatisplus.extension.service.IService;
import team11.Dyson.domain.StuClass;

/**
 * @author: Dechun Meng
 * @InterfaceName: ClassesService
 * @Description: Description of the interface file
 */
public interface StuClassService extends IService<StuClass> {

//    public boolean extension(Date courseworkDeadline, int classId, String studentEmailAddress);
    public boolean extension(StuClass stuClass);
}
