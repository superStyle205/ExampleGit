package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.ProgramingLanguage;

public interface ProgramingLanguageService {
	ProgramingLanguage findById(int id);

	void addNew(ProgramingLanguage pl);

	void update(ProgramingLanguage pl);

	void delete(int id);

	List<ProgramingLanguage> findAll(String search);

	List<ProgramingLanguage> findProgramingLanguage(int fromIndex, int toIndex, String search);
}
