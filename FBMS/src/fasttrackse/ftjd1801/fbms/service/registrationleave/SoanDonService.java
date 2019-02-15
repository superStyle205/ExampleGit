package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.LaborContract;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface SoanDonService {

	public List<RegistrationLeave> findAll();

	public void addNew(RegistrationLeave rl, int dayOfRest, int idContract);
	
	public void update(RegistrationLeave rl);

	
	public void delete(int maVangNghi);

	public RegistrationLeave findByMaVangNghi(int maVangNghi);

	public List<RegistrationLeave> listDrafts(String draft);


	public List<RegistrationLeave> listDraftsPage( int search, String draft, int currentPage, int perPage);

	List<RegistrationLeave> findById(int search, String draft);

	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage);
	
	public LaborContract dayOfRest (int idEmployee);

	public List<RegistrationLeave> findListDraftById(int idEmployee);

	public List<RegistrationLeave> findListById(int idEmployee);

	public List<RegistrationLeave> findByIdAbsent(int search, int idEmployee, String status);

	public List<RegistrationLeave> listPage(String status, int idEmployee, int currentPage, int perPage);

	public List<RegistrationLeave> listPage(int search, String status, int idEmployee, int currentPage,
			int perPage);

	

	
	
	

}
