package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.personnel.ExperienceDao;
import fasttrackse.ftjd1801.fbms.entity.personnel.Experience;

@Transactional
@Service("ExperienceService")
public class ExperienceServiceImpl implements ExperienceService {
	@Autowired
	private ExperienceDao dao;

	@Override
	public Experience findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveExperience(Experience Experience) {
		dao.saveExperience(Experience);
	}

	@Override
	public void updateExperience(Experience Experience) {
		Experience entity = dao.findById(Experience.getIdEmployee());
		if (entity != null) {
			entity.setTimeLine(Experience.getTimeLine());
			entity.setWorkPlace(Experience.getWorkPlace());
			entity.setDescribes(Experience.getDescribes());
			entity.setIdEmployee(Experience.getIdEmployee());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteExperienceById(id);
	}

	@Override
	public List<Experience> findAllExperiences() {
		return dao.findAllExperiences();
	}

	@Override
	public List<Experience> findAllExperiences(String search) {
		return dao.findAllExperiences(search);
	}

	@Override
	public List<Experience> getExperiences(int currentPage, int perPage) {
		return dao.getExperiences(currentPage, perPage);
	}

	@Override
	public List<Experience> getExperiences(int currentPage, int perPage, String search) {
		return dao.getExperiences(currentPage, perPage, search);
	}

	@Override
	public boolean isExperienceIdUnique(Integer id) {
		Experience Experience = findById(id);
		return (Experience == null || (id != null));
	}
}
