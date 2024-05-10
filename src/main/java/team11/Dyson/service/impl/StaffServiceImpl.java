package team11.Dyson.service.impl;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domain.Staff;
import team11.Dyson.mapper.StaffMapper;
import team11.Dyson.service.StaffService;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class StaffServiceImpl implements StaffService {
    private static final Logger log = (Logger) LoggerFactory.getLogger(StaffServiceImpl.class);

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Staff login(String email, String password) {
        Staff staff = staffMapper.login(email, password);
        if (staff != null) {
            if (password.equals(staff.getPassword())) {
                log.info("Login successful for user: {}", email);
                return staff;
            } else {
                log.warn("Incorrect password for user: {}", email);
                return null;
            }
        }
        log.warn("User not found: {}", email);
        return null;
    }

    @Override
    public String register(Staff staff) {
        if ("".equals(staff.getPassword())) {
            return "please input password";
        } else if ("".equals(staff.getStaffEmailAddress())) {
            return "please input email address";
        } else {
            staffMapper.register(staff);
            return "SUCCESS";
        }
    }

    @Override
    public boolean modifyPassword(String password, String email) {
        boolean modifyPassword = staffMapper.modifyPassword(password, email);
        return modifyPassword;
    }
}
