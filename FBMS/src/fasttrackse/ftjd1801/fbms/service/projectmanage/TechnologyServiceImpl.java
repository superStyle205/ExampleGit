package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.TechnologyDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Technology;

@Service
public class TechnologyServiceImpl implements TechnologyService {
	@Autowired
	TechnologyDao dao;
	@Override
	public Technology findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void addNew(Technology tech) {
		dao.addNew(tech);
	}

	@Override
	public void update(Technology tech) {
		dao.update(tech);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<Technology> listAll(String search) {
		return dao.listAll(search);
	}

	@Override
	public List<Technology> listForPagination(int fromIndex, int toIndex, String search) {
		return dao.listForPagination(fromIndex, toIndex, search);
	}

}
