package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.TuChoiDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Service
public class TuChoiServiceImpl implements TuChoiService {

	@Autowired
	private TuChoiDao tuChoiDao;
	
	  @Override 
	  public List<RegistrationLeave> listRefused(String refused) { 
		  return tuChoiDao.listRefused(refused);
	 
	  }
	 

	

	@Override
	public List<RegistrationLeave> listRefusedPage(int id, String refused, int currentPage, int perPage) {
		// TODO Auto-generated method stub
		currentPage = (currentPage -1)*perPage;
		return tuChoiDao.listRefusedPage(id, refused, currentPage,perPage);
	}

	

	@Override
	public List<RegistrationLeave> findById(int id,String refused) {
		return tuChoiDao.findById(id,refused);
	}

	@Override
	public List<RegistrationLeave> listRefusedPage(String refused, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		return tuChoiDao.listRefusedPage(refused, currentPage,perPage);
	}

	

	

	



}
