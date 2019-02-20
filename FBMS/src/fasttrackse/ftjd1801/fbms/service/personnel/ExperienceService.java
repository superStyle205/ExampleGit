package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.Experience;

public interface ExperienceService {
	Experience findById(int id);

	void saveExperience(Experience Experience);

	void updateExperience(Experience Experience);

	void deleteById(int id);

	List<Experience> findAllExperiences();

	List<Experience> findAllExperiences(String search);

	boolean isExperienceIdUnique(Integer id);

	List<Experience> getExperiences(int fromIndex, int toIndex);

	List<Experience> getExperiences(int fromIndex, int toIndex, String search);
}