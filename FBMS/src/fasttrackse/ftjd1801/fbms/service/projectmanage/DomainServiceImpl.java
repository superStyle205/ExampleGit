package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.DomainDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Domain;
@Service
public class DomainServiceImpl implements DomainService {

	@Autowired
	private DomainDao domainDao;

	@Override
	public List<Domain> findAll() {
		return domainDao.findAll();
	}

	@Override
	public void addNew(Domain dm) {
		domainDao.addNew(dm);
		
	}

	@Override
	public void update(Domain dm) {
		domainDao.update(dm);		
	}

	@Override
	public void delete(int maDomain) {
		domainDao.delete(maDomain);		
	}

	@Override
	public Domain findByMaDomain(int maDomain) {
		return domainDao.findByMaDomain(maDomain);
	}

	@Override
	public List<Domain> findAll(int fromIndex, int toIndex, String search) {
		return domainDao.findAll(fromIndex, toIndex, search);
	}


}
