package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface RegistrationLeaveDao {
	
	public void addNew(RegistrationLeave rl);

	public List<RegistrationLeave> getEmployees();

	
}
