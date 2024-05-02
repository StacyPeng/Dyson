package team11.Dyson.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.Dyson.domian.Staff;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Transactional
@Service
public interface StaffService {

    public Staff login(String email, String password);

    public String register(Staff staff);

    public boolean modifyPassword(String password,String email);
}
