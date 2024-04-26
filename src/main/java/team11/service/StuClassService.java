package team11.service;

import com.baomidou.mybatisplus.extension.service.IService;
import team11.domian.StuClass;

import java.util.Date;

/**
 * @author: Dechun Meng
 * @InterfaceName: ClassesService
 * @Description: Description of the interface file
 */
public interface StuClassService extends IService<StuClass> {

    public boolean extension(Date courseworkDeadline, int classId, String studentEmailAddress);
}
