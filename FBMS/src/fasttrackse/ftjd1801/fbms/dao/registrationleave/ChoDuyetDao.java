package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

public interface ChoDuyetDao {

	public List<RegistrationLeave> findAll();
	
	public void update(RegistrationLeave rl);

	public void delete(String idAbsent);

	public RegistrationLeave findByMaVangNghi(int maVangNghi);

	public List<RegistrationLeave> listPending(String pending);

	public List<RegistrationLeave> listPendingPage(int id, String pending, int currentPage, int perPage);

	public List<RegistrationLeave> findById(int id, String pending);

	public List<RegistrationLeave> listPendingPage(String pending, int currentPage, int perPage);

	




	
	

}
