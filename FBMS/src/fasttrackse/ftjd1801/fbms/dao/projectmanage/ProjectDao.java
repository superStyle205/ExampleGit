package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Project;

public interface ProjectDao {
	Project findById(int id);

	void addNew(Project project);

	void update(Project project);

	void delete(int id);

	List<Project> listAll();

	List<Project> findProject(int fromIndex, int toIndex, String search);

}
