package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.ProgramingLanguage;

public interface ProgramingLanguageDao {
	ProgramingLanguage findById(int id);

	void addNew(ProgramingLanguage pl);

	void update(ProgramingLanguage pl);

	void delete(int id);

	List<ProgramingLanguage> listAll(String search);

	List<ProgramingLanguage> listForPagination(int fromIndex, int toIndex, String search);
}
