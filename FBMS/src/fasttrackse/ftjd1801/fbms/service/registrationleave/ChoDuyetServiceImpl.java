package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.ChoDuyetDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Service
public class ChoDuyetServiceImpl implements ChoDuyetService {

	@Autowired
	private ChoDuyetDao choDuyetDao;
	
	@Override
	public List<RegistrationLeave> findAll() {
		return choDuyetDao.findAll();
	}



	@Override
	public void update(RegistrationLeave rl) {
		choDuyetDao.update(rl);
	}

	@Override
	public void delete(String maVangNghi) {
		choDuyetDao.delete(maVangNghi);
	}

	@Override
	public RegistrationLeave findByMaVangNghi(int maVangNghi) {
		return choDuyetDao.findByMaVangNghi(maVangNghi);
	}

	
	  @Override 
	  public List<RegistrationLeave> listPending(String pending) { 
		  return choDuyetDao.listPending(pending);
	 
	  }
	 

	

	@Override
	public List<RegistrationLeave> listPendingPage(int id, String pending, int currentPage, int perPage) {
		// TODO Auto-generated method stub
		currentPage = (currentPage -1)*perPage;
		return choDuyetDao.listPendingPage(id, pending, currentPage,perPage);
	}

	

	@Override
	public List<RegistrationLeave> findById(int id,String pending) {
		return choDuyetDao.findById(id,pending);
	}

	@Override
	public List<RegistrationLeave> listPendingPage(String pending, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		return choDuyetDao.listPendingPage(pending, currentPage,perPage);
	}

	

	

	



}
