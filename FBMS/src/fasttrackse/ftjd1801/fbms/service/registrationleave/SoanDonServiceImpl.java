package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.SoanDonDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.LaborContract;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;


@Service
public class SoanDonServiceImpl implements SoanDonService {

	@Autowired
	private SoanDonDao soanDonDao;
	
	
	@Override
	public List<RegistrationLeave> findAll() {
		return soanDonDao.findAll();
	}

	@Override
	public void addNew(RegistrationLeave rl, int dayOfRest, int idContract) {
		soanDonDao.addNew(rl);
		dayOfRest = dayOfRest - rl.getTotalDay();
		LaborContract lb = new LaborContract();
		lb.setIdContract(idContract);
		lb.setDayOfRest(dayOfRest);
		soanDonDao.updateDayOfRest(lb);		
	
		
		
	}

	@Override
	public void update(RegistrationLeave rl) {
		soanDonDao.update(rl);
	}

	@Override
	public void delete(int maVangNghi) {
		soanDonDao.delete(maVangNghi);
	}

	@Override
	public RegistrationLeave findByMaVangNghi(int maVangNghi) {
		return soanDonDao.findByMaVangNghi(maVangNghi);
	}

	
	  @Override 
	  public List<RegistrationLeave> listDrafts(String draft) { 
		  return soanDonDao.listDrafts(draft);
	 
	  }
	 

	@Override
	public List<RegistrationLeave> listDraftsPage(int id, String draft, int currentPage, int perPage) {
		// TODO Auto-generated method stub
		currentPage = (currentPage -1)*perPage;
		return soanDonDao.listDraftsPage(id, draft, currentPage,perPage);
	}


	@Override
	public List<RegistrationLeave> findById(int id,String draft) {
		return soanDonDao.findById(id,draft);
	}

	@Override
	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		return soanDonDao.listDraftsPage(draft, currentPage,perPage);
	}

	@Override
	public LaborContract dayOfRest(int idEmployee) {
		return soanDonDao.dayOfRest(idEmployee);
	}

	@Override
	public List<RegistrationLeave> findListDraftById(int idEmployee) {
		String status = "Nháp";
		return soanDonDao.findByIdEmployee(idEmployee, status);
	}

	@Override
	public List<RegistrationLeave> findListById(int idEmployee) {
		List<RegistrationLeave> list = new ArrayList<RegistrationLeave>();
	
		list.addAll(soanDonDao.findByIdEmployee(idEmployee, "Chờ Duyệt"));
		list.addAll(soanDonDao.findByIdEmployee(idEmployee, "Phê Duyệt"));
		list.addAll(soanDonDao.findByIdEmployee(idEmployee, "Từ Chối"));	
		return list;
	}

	@Override
	public List<RegistrationLeave> findByIdAbsent(int search, int idEmployee, String status) {
		List<RegistrationLeave> list = new ArrayList<RegistrationLeave>();
		
		list.addAll(soanDonDao.findByIdAbsent(search, idEmployee, "Chờ Duyệt"));
		list.addAll(soanDonDao.findByIdAbsent(search, idEmployee, "Phê Duyệt"));
		list.addAll(soanDonDao.findByIdAbsent(search, idEmployee, "Từ Chối"));	
		return list;
	}

	@Override
	public List<RegistrationLeave> listPage(String status,int idEmployee, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		
		return soanDonDao.listPageByIdEmployee(status,idEmployee, currentPage,perPage);
	}

	@Override
	public List<RegistrationLeave> listPage(int search, String status,int idEmployee, int currentPage, int perPage) {
		currentPage = (currentPage -1)*perPage;
		List<RegistrationLeave> list = new ArrayList<RegistrationLeave>();
		list.addAll(soanDonDao.listPageByIdAbsent(search, "Chờ Duyệt",idEmployee, currentPage, perPage));
		list.addAll(soanDonDao.listPageByIdAbsent(search, "Phê Duyệt",idEmployee, currentPage, perPage));
		list.addAll(soanDonDao.listPageByIdAbsent(search, "Từ Chối",idEmployee, currentPage, perPage));
		return list;
	}

	

	

	

	

	



}
