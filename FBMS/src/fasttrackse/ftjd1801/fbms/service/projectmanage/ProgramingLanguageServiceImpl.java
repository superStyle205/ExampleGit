package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.ProgramingLanguageDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.ProgramingLanguage;

@Service
public class ProgramingLanguageServiceImpl implements ProgramingLanguageService {
	
	@Autowired
	ProgramingLanguageDao dao;
	
	@Override
	public ProgramingLanguage findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void addNew(ProgramingLanguage pl) {
		dao.addNew(pl);
	}

	@Override
	public void update(ProgramingLanguage pl) {
		dao.update(pl);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<ProgramingLanguage> findAll() {
		return dao.findAll();
	}

	@Override
	public List<ProgramingLanguage> findProgramingLanguage(int fromIndex, int toIndex, String search) {
		return dao.findProgramingLanguage(fromIndex, toIndex, search);
	}
	
}
