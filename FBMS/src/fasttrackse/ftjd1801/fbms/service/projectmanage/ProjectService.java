package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Project;

public interface ProjectService {
	Project findById(int id);

	void addNew(Project project);

	void update(Project project);

	void delete(int id);

	List<Project> listAll();

	List<Project> findProject(int fromIndex, int toIndex, String search);
}
