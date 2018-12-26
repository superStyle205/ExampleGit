package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.VangNghiDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

@Service
public class VangNghiServiceImpl implements VangNghiService {

	@Autowired
	private VangNghiDao vangNghiDao;
	
	@Override
	public List<RegistrationLeave> findAll() {
		return vangNghiDao.findAll();
	}

	@Override
	public void addNew(RegistrationLeave rl) {
		vangNghiDao.addNew(rl);
	}

	@Override
	public void update(RegistrationLeave rl) {
		vangNghiDao.update(rl);
	}

	@Override
	public void delete(String maVangNghi) {
		vangNghiDao.delete(maVangNghi);
	}

	@Override
	public RegistrationLeave findByMaVangNghi(String maVangNghi) {
		return vangNghiDao.findByMaVangNghi(maVangNghi);
	}

	@Override
	public List<RegistrationLeave> listDrafts(String draft) {
		return vangNghiDao.listDrafts(draft);
		
	}

	

	



}
