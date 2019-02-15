package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface TuChoiService {


	public List<RegistrationLeave> listRefused(String refused);

	public List<RegistrationLeave> listRefusedPage( int search, String refused, int currentPage, int perPage);

	List<RegistrationLeave> findById(int search, String refused);

	public List<RegistrationLeave> listRefusedPage(String refused, int currentPage, int perPage);

}
