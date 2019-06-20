package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.EmployeeProfile;

public interface EmployeeProfileService {
	EmployeeProfile findById(int id);

	void saveEmployeeProfile(EmployeeProfile EmployeeProfile);

	void updateEmployeeProfile(EmployeeProfile EmployeeProfile);

	void deleteById(int id);

	List<EmployeeProfile> findAllEmployeeProfiles();

	List<EmployeeProfile> findAllEmployeeProfiles(String search);

	boolean isEmployeeProfileIdUnique(Integer id);

	List<EmployeeProfile> getEmployeeProfiles(int fromIndex, int toIndex);

	List<EmployeeProfile> getEmployeeProfiles(int fromIndex, int toIndex, String search);
}