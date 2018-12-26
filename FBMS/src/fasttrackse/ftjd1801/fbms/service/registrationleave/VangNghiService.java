package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

public interface VangNghiService {

	public List<RegistrationLeave> findAll();

	public void addNew(RegistrationLeave rl);
	
	public void update(RegistrationLeave rl);

	public void delete(String maVangNghi);

	public RegistrationLeave findByMaVangNghi(String maVangNghi);

	public List<RegistrationLeave> listDrafts(String draft);
	
	

}
