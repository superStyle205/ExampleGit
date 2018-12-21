package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;


public interface DatabaseDao {
	Database findByIdDatabase(int id);

	void saveDatabase(Database db);

	void delete(int id);

	List<Database> findAll();

	List<Database> findDatabase(int fromIndex, int toIndex, String search);
}
