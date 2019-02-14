package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.FrameworkDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Framework;

@Service
public class FrameworkServiceImpl implements FrameworkService {
	@Autowired
	FrameworkDao dao;

	@Override
	public void addNew(Framework fm) {
		dao.addNew(fm);
	}

	@Override
	public void update(Framework fm) {
		dao.update(fm);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public Framework findById(int id) {
		return dao.findByIdFramework(id);
	}

	@Override
	public List<Framework> findAll(String search) {
		return dao.findAll(search);
	}

	@Override
	public List<Framework> findFramework(int from, int to, String search) {
		return dao.findFramework(from, to, search);
	}

}
