package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Framework;

public interface FrameworkDao {
	Framework findByIdFramework(int id);

	void addNew(Framework db);
	
	void update(Framework db);
	
	void delete(int id);

	List<Framework> findAll(String search);

	List<Framework> findFramework(int fromIndex, int toIndex, String search);

}
