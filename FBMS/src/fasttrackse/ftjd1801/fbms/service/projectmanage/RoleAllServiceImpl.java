package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.RoleAllDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.RoleAll;

@Service
public class RoleAllServiceImpl implements RoleAllService {
	@Autowired
	RoleAllDao dao;

	@Override
	public RoleAll findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void addNew(RoleAll role) {
		dao.addNew(role);
	}

	@Override
	public void update(RoleAll role) {
		dao.update(role);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<RoleAll> findAll() {
		return dao.listAll();
	}

	@Override
	public List<RoleAll> findRole(int fromIndex, int toIndex, String search) {
		return dao.listForPagination(fromIndex, toIndex, search);
	}

}
