package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface PheDuyetDao {


	public List<RegistrationLeave> listApproved(String approved);

	public List<RegistrationLeave> listApprovedPage(int id, String approved, int currentPage, int perPage);

	public List<RegistrationLeave> findById(int id, String approved);

	public List<RegistrationLeave> listApprovedPage(String approved, int currentPage, int perPage);
}
