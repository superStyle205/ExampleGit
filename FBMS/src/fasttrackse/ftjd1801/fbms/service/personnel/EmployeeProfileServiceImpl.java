package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.personnel.EmployeeProfileDao;
import fasttrackse.ftjd1801.fbms.entity.personnel.EmployeeProfile;

@Transactional
@Service("EmployeeProfileService")
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
	@Autowired
	private EmployeeProfileDao dao;

	@Override
	public EmployeeProfile findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveEmployeeProfile(EmployeeProfile EmployeeProfile) {
		dao.saveEmployeeProfile(EmployeeProfile);
	}

	@Override
	public void updateEmployeeProfile(EmployeeProfile EmployeeProfile) {
		EmployeeProfile entity = dao.findById(EmployeeProfile.getIdEmployee());
		if (entity != null) {
			entity.setName(EmployeeProfile.getName());
			entity.setSex(EmployeeProfile.getSex());
			entity.setDayOfBirth(EmployeeProfile.getDayOfBirth());
			entity.setAddress(EmployeeProfile.getAddress());
			entity.setContact(EmployeeProfile.getContact());
			entity.setEmail(EmployeeProfile.getEmail());
			entity.setIntroduction(EmployeeProfile.getIntroduction());
			entity.setIdRights(EmployeeProfile.getIdRights());
			entity.setNote(EmployeeProfile.getNote());
			entity.setIdDepartment(EmployeeProfile.getIdDepartment());
			entity.setDayOfRest(EmployeeProfile.getDayOfRest());
			entity.setAvatar(EmployeeProfile.getAvatar());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteEmployeeProfileById(id);
	}

	@Override
	public List<EmployeeProfile> findAllEmployeeProfiles() {
		return dao.findAllEmployeeProfiles();
	}

	@Override
	public List<EmployeeProfile> findAllEmployeeProfiles(String search) {
		return dao.findAllEmployeeProfiles(search);
	}

	@Override
	public List<EmployeeProfile> getEmployeeProfiles(int currentPage, int perPage) {
		return dao.getEmployeeProfiles(currentPage, perPage);
	}

	@Override
	public List<EmployeeProfile> getEmployeeProfiles(int currentPage, int perPage, String search) {
		return dao.getEmployeeProfiles(currentPage, perPage, search);
	}

	@Override
	public boolean isEmployeeProfileIdUnique(Integer id) {
		EmployeeProfile EmployeeProfile = findById(id);
		return (EmployeeProfile == null || (id != null));
	}
}