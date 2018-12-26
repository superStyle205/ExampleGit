package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

public interface VangNghiDao {
	public void addNew(RegistrationLeave rl);

	public List<RegistrationLeave> findAll();
	
	public void update(RegistrationLeave rl);

	public void delete(String idAbsent);

	public RegistrationLeave findByMaVangNghi(String idAbsent);

	public List<RegistrationLeave> listDrafts(String draft);




	
	

}
