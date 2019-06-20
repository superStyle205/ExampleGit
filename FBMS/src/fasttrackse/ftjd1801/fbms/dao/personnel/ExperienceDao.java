package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.Experience;

public interface ExperienceDao {
	Experience findById(int id);

	void saveExperience(Experience employee);

	void deleteExperienceById(int id);

	List<Experience> findAllExperiences();

	List<Experience> findAllExperiences(String search);

	List<Experience> getExperiences(int fromIndex, int toIndex);

	List<Experience> getExperiences(int fromIndex, int toIndex, String search);
}