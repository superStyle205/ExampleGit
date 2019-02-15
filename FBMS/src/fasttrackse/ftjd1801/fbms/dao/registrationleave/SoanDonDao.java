package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.Collection;
import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.LaborContract;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface SoanDonDao {
	public void addNew(RegistrationLeave rl);

	public List<RegistrationLeave> findAll();
	
	public void update(RegistrationLeave rl);

	public void delete(int maVangNghi);

	public RegistrationLeave findByMaVangNghi(int maVangNghi);

	public List<RegistrationLeave> listDrafts(String draft);

	public List<RegistrationLeave> listDraftsPage(int id, String draft, int currentPage, int perPage);

	public List<RegistrationLeave> findById(int id, String draft);

	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage);

	public LaborContract dayOfRest (int idEmployee);

	public void updateDayOfRest(LaborContract lb);

	public List<RegistrationLeave> findByIdEmployee(int idEmployee, String status);

	public List<RegistrationLeave> findByIdAbsent(int search, int idEmployee, String status);

	public List<RegistrationLeave> listPageByIdEmployee(String status, int idEmployee, int currentPage, int perPage);

	public List<RegistrationLeave> listPageByIdAbsent(int search, String status, int idEmployee, int currentPage,
			int perPage);



	




	
	

}
