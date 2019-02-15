package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.PheDuyetDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Service
public class PheDuyetServiceImpl implements PheDuyetService {

	@Autowired
	private PheDuyetDao pheDuyetDao;
	
	  @Override 
	  public List<RegistrationLeave> listApproved(String approved) { 
		  return pheDuyetDao.listApproved(approved);
	 
	  }
	 

	

	@Override
	public List<RegistrationLeave> listApprovedPage(int id, String approved, int currentPage, int perPage) {
		// TODO Auto-generated method stub
		currentPage = (currentPage -1)*perPage;
		return pheDuyetDao.listApprovedPage(id, approved, currentPage,perPage);
	}

	

	@Override
	public List<RegistrationLeave> findById(int id,String approved) {
		return pheDuyetDao.findById(id,approved);
	}

	@Override
	public List<RegistrationLeave> listApprovedPage(String approved, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		return pheDuyetDao.listApprovedPage(approved, currentPage,perPage);
	}

	

	

	



}
