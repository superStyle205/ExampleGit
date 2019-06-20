package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.DatabaseDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;

@Service
public class DatabaseServiceImpl implements DatabaseService {
	
	@Autowired
	DatabaseDao dao;
	
	@Override
	public void addNew(Database db) {
		dao.addNew(db);
	}

	@Override
	public void update(Database db) {
		dao.update(db);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public Database findById(int id) {
		return dao.findByIdDatabase(id);
	}

	@Override
	public List<Database> findAll(String search) {
		return dao.listAll(search);
	}

	@Override
	public List<Database> findDatabase(int from, int to, String search) {
		return dao.listForPagination(from, to, search);
	}

}
