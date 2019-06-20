package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;


public interface DatabaseDao {
	Database findByIdDatabase(int id);

	void addNew(Database db);
	
	void update(Database db);
	
	void delete(int id);

	List<Database> listAll(String search);

	List<Database> listForPagination(int fromIndex, int toIndex, String search);
}
