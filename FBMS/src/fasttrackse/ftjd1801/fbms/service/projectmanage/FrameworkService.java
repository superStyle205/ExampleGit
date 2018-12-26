package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Framework;

public interface FrameworkService {
	void addNew(Framework fm);

	void update(Framework fm);

	void delete(int id);

	Framework findById(int id);

	List<Framework> findAll();

	List<Framework> findFramework(int from, int to, String search);
}
