package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface PheDuyetService {


	public List<RegistrationLeave> listApproved(String approved);

	public List<RegistrationLeave> listApprovedPage( int search, String approved, int currentPage, int perPage);

	List<RegistrationLeave> findById(int search, String approved);

	public List<RegistrationLeave> listApprovedPage(String approved, int currentPage, int perPage);

}
