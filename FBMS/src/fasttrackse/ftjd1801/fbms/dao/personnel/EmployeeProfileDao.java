package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.EmployeeProfile;

public interface EmployeeProfileDao {
	EmployeeProfile findById(int id);

	void saveEmployeeProfile(EmployeeProfile employee);

	void deleteEmployeeProfileById(int id);

	List<EmployeeProfile> findAllEmployeeProfiles();

	List<EmployeeProfile> findAllEmployeeProfiles(String search);

	List<EmployeeProfile> getEmployeeProfiles(int fromIndex, int toIndex);

	List<EmployeeProfile> getEmployeeProfiles(int fromIndex, int toIndex, String search);
}
