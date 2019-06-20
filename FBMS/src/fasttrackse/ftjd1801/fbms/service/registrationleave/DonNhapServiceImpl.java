package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.DonNhapDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Service
public class DonNhapServiceImpl implements DonNhapService {

	@Autowired
	private DonNhapDao donNhapDao;


	@Override
	public void update(RegistrationLeave rl) {
		donNhapDao.update(rl);
	}

	@Override
	public void delete(int maVangNghi) {
		donNhapDao.delete(maVangNghi);
	}

	@Override
	public RegistrationLeave findByMaVangNghi(int maVangNghi) {
		return donNhapDao.findByMaVangNghi(maVangNghi);
	}

	
	  @Override 
	  public List<RegistrationLeave> listDrafts(String draft) { 
		  return donNhapDao.listDrafts(draft);
	 
	  }
	 

	

	@Override
	public List<RegistrationLeave> listDraftsPage(int id, String draft, int currentPage, int perPage) {
		// TODO Auto-generated method stub
		currentPage = (currentPage -1)*perPage;
		return donNhapDao.listDraftsPage(id, draft, currentPage,perPage);
	}

	

	@Override
	public List<RegistrationLeave> findById(int id,String draft) {
		return donNhapDao.findById(id,draft);
	}

	@Override
	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		return donNhapDao.listDraftsPage(draft, currentPage,perPage);
	}

	

	

	



}
