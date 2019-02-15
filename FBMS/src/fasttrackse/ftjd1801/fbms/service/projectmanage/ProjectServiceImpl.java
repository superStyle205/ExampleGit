package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.ProjectDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Project;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	ProjectDao dao;
	
	@Override
	public Project findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void addNew(Project project) {
		dao.addNew(project);
	}

	@Override
	public void update(Project project) {
		dao.update(project);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<Project> listAll() {
		return dao.listAll();
	}

	@Override
	public List<Project> findProject(int fromIndex, int toIndex, String search) {
		return dao.listForPagination(fromIndex, toIndex, search);
	}

}
