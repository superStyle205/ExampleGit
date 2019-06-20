package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

public interface DonNhapDao {
	
	
	public void update(RegistrationLeave rl);

	public void delete(int maVangNghi);

	public RegistrationLeave findByMaVangNghi(int maVangNghi);

	public List<RegistrationLeave> listDrafts(String draft);

	public List<RegistrationLeave> listDraftsPage(int id, String draft, int currentPage, int perPage);

	public List<RegistrationLeave> findById(int id, String draft);

	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage);

	




	
	

}
