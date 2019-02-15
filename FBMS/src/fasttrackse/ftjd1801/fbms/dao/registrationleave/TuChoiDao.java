package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface TuChoiDao {


	public List<RegistrationLeave> listRefused(String refused);

	public List<RegistrationLeave> listRefusedPage(int id, String refused, int currentPage, int perPage);

	public List<RegistrationLeave> findById(int id, String refused);

	public List<RegistrationLeave> listRefusedPage(String refused, int currentPage, int perPage);
}
