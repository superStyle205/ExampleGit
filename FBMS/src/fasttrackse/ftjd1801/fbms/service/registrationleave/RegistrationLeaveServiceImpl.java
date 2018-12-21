package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.RegistrationLeaveDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

@Service
public class RegistrationLeaveServiceImpl implements RegistrationLeaveService {

	@Autowired
	private RegistrationLeaveDao registrationLeaveDao;
	
	@Override
	public List<RegistrationLeave> getEmployees() {
		
		return registrationLeaveDao.getEmployees();
	}


	@Override
	public void addNew(RegistrationLeave rl) {
		registrationLeaveDao.addNew(rl);
	}

}
