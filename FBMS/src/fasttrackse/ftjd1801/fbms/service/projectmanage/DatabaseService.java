package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;

public interface DatabaseService {
	void addNew(Database db);

	void update(Database db);

	void delete(int id);

	Database findById(int id);

	List<Database> findAll();

	List<Database> findDatabase(int from, int to, String search);
}
