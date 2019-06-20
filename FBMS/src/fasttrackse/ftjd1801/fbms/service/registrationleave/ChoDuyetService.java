package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

public interface ChoDuyetService {

	public List<RegistrationLeave> findAll();
	
	public void update(RegistrationLeave rl);

	public void delete(String maVangNghi);

	public RegistrationLeave findByMaVangNghi(int maVangNghi);

	public List<RegistrationLeave> listPending(String pending);

	public List<RegistrationLeave> listPendingPage( int search, String pending, int currentPage, int perPage);

	List<RegistrationLeave> findById(int search, String pending);

	public List<RegistrationLeave> listPendingPage(String pending, int currentPage, int perPage);
	

}
