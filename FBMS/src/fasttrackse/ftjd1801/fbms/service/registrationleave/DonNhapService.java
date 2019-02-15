package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

public interface DonNhapService {

	
	public void update(RegistrationLeave rl);

	public void delete(int maVangNghi);

	public RegistrationLeave findByMaVangNghi(int maVangNghi);

	public List<RegistrationLeave> listDrafts(String draft);

	

	public List<RegistrationLeave> listDraftsPage( int search, String draft, int currentPage, int perPage);

	List<RegistrationLeave> findById(int search, String draft);

	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage);


	

	
	
	

}
