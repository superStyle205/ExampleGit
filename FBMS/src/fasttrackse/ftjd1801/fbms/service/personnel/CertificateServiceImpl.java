package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.personnel.CertificateDao;
import fasttrackse.ftjd1801.fbms.entity.personnel.Certificate;

@Transactional
@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {
	@Autowired
	private CertificateDao dao;

	@Override
	public Certificate findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveCertificate(Certificate Certificate) {
		dao.saveCertificate(Certificate);
	}

	@Override
	public void updateCertificate(Certificate Certificate) {
		Certificate entity = dao.findById(Certificate.getIdEmployee());
		if (entity != null) {
			entity.setTypeOfCertificate(Certificate.getTypeOfCertificate());
			entity.setIssuedBy(Certificate.getIssuedBy());
			entity.setDuration(Certificate.getDuration());
			entity.setNote(Certificate.getNote());
			entity.setIdEmployee(Certificate.getIdEmployee());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteCertificateById(id);
	}

	@Override
	public List<Certificate> findAllCertificates() {
		return dao.findAllCertificates();
	}

	@Override
	public List<Certificate> findAllCertificates(String search) {
		return dao.findAllCertificates(search);
	}

	@Override
	public List<Certificate> getCertificates(int currentPage, int perPage) {
		return dao.getCertificates(currentPage, perPage);
	}

	@Override
	public List<Certificate> getCertificates(int currentPage, int perPage, String search) {
		return dao.getCertificates(currentPage, perPage, search);
	}

	@Override
	public boolean isCertificateIdUnique(Integer id) {
		Certificate Certificate = findById(id);
		return (Certificate == null || (id != null));
	}
}