package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.personnel.RelativeInformationDao;
import fasttrackse.ftjd1801.fbms.entity.personnel.RelativeInformation;

@Transactional
@Service("RelativeInformationService")
public class RelativeInformationServiceImpl implements RelativeInformationService {
	@Autowired
	private RelativeInformationDao dao;

	@Override
	public RelativeInformation findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveRelativeInformation(RelativeInformation RelativeInformation) {
		dao.saveRelativeInformation(RelativeInformation);
	}

	@Override
	public void updateRelativeInformation(RelativeInformation RelativeInformation) {
		RelativeInformation entity = dao.findById(RelativeInformation.getIdEmployee());
		if (entity != null) {
			entity.setRelationship(RelativeInformation.getRelationship());
			entity.setName(RelativeInformation.getName());
			entity.setDayOfBirth(RelativeInformation.getDayOfBirth());
			entity.setJob(RelativeInformation.getJob());
			entity.setAddress(RelativeInformation.getAddress());
			entity.setIdEmployee(RelativeInformation.getIdEmployee());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteRelativeInformationById(id);
	}

	@Override
	public List<RelativeInformation> findAllRelativeInformations() {
		return dao.findAllRelativeInformations();
	}

	@Override
	public List<RelativeInformation> findAllRelativeInformations(String search) {
		return dao.findAllRelativeInformations(search);
	}

	@Override
	public List<RelativeInformation> getRelativeInformations(int currentPage, int perPage) {
		return dao.getRelativeInformations(currentPage, perPage);
	}

	@Override
	public List<RelativeInformation> getRelativeInformations(int currentPage, int perPage, String search) {
		return dao.getRelativeInformations(currentPage, perPage, search);
	}

	@Override
	public boolean isRelativeInformationIdUnique(Integer id) {
		RelativeInformation RelativeInformation = findById(id);
		return (RelativeInformation == null || (id != null));
	}
}