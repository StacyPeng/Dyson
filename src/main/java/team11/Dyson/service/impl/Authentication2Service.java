package team11.Dyson.service.impl;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Staff;
import team11.Dyson.dto.StaffDTO;
import team11.Dyson.repository.StaffRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Authentication2Service {

    @Autowired
    private StaffRepository staffRepository; // 用于操作员工的 repository

    public StaffDTO getCurrentStaff(HttpSession session) {
        // 实现获取当前登录的员工信息的逻辑，可能涉及从会话中提取信息
        String staffEmail = getSessionStaffEmail(session);

        // 使用员工邮箱查询员工
        if (staffEmail != null) {
            Optional<Staff> staffOptional = staffRepository.findByStaffEmailAddress(staffEmail);
            if (staffOptional.isPresent()) {
                return convertToStaffDTO(staffOptional.get());
            }
        }
        return null; // 如果找不到与会话相关联的员工，则返回 null
    }

    public String getCurrentStaffEmail(HttpSession session) {
        // 从会话中获取当前登录员工的邮箱
        return getSessionStaffEmail(session);
    }

    // Helper method to retrieve staff email from session
    private String getSessionStaffEmail(HttpSession session) {
        // 从 HTTP 会话中获取员工电子邮件
        return (String) session.getAttribute("staffEmail");
    }

    // Convert Staff entity to DTO
    private StaffDTO convertToStaffDTO(Staff staff) {
        // 转换逻辑从 Staff 实体到 StaffDTO
        StaffDTO dto = new StaffDTO();
        dto.setName(staff.getStaName());
        dto.setEmail(staff.getStaffEmailAddress());
        // 添加更多属性转换
        return dto;
    }
}
