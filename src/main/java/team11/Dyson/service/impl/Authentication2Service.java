package team11.Dyson.service.impl;
//Auther：Hengqian Mao
//c3008838
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Staff;
import team11.Dyson.dto.StaffDTO;
import team11.Dyson.repository.StaffRepository;

import java.util.Optional;

@Service
public class Authentication2Service {

    @Autowired
    private StaffRepository staffRepository;

    public StaffDTO getCurrentStaff(HttpSession session) {
        // Implement the logic to get the currently logged in employee information, which may involve extracting information from the session
        String staffEmail = getSessionStaffEmail(session);

        // Use employee email to query employees
        if (staffEmail != null) {
            Optional<Staff> staffOptional = staffRepository.findByStaffEmailAddress(staffEmail);
            if (staffOptional.isPresent()) {
                return convertToStaffDTO(staffOptional.get());
            }
        }
        return null; // If the employee associated with the session cannot be found, null is returned
    }

    public String getCurrentStaffEmail(HttpSession session) {
        // Get the email address of the currently logged employee from the session
        return getSessionStaffEmail(session);
    }

    // Helper method to retrieve staff email from session
    private String getSessionStaffEmail(HttpSession session) {
        // Get the employee email from the HTTP session
        return (String) session.getAttribute("staffEmail");
    }

    // Convert Staff entity to DTO
    private StaffDTO convertToStaffDTO(Staff staff) {
        // Transform logic from Staff entity to StaffDTO
        StaffDTO dto = new StaffDTO();
        dto.setName(staff.getStaName());
        dto.setEmail(staff.getStaffEmailAddress());

        return dto;
    }
}
