package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.ProgramingLanguageProject;

public interface ProgramingLanguageProjectDao {
	void addNew(ProgramingLanguageProject pl);

	void update(ProgramingLanguageProject pl);

	void delete(int id);

	ProgramingLanguageProject findById(int id);
}
