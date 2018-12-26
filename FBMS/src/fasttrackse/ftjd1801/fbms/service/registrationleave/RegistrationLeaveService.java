package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;


public interface RegistrationLeaveService {
	
	public List<RegistrationLeave> getEmployees();


	public void addNew(RegistrationLeave rl);


	

	
}
