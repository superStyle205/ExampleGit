package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import org.hibernate.Criteria;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;

public class DatabaseImpl extends AbstractDao<Integer, Database> implements DatabaseDao {

	@Override
	public Database findByIdDatabase(int id) {
		return getByKey(id);
	}

	@Override
	public void saveDatabase(Database db) {
		persist(db);
	}

	@Override
	public void delete(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Database> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Database>) criteria.list();
	}

	@Override
	public List<Database> findDatabase(int fromIndex, int toIndex, String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
