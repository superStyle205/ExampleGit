package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.Certificate;

public interface CertificateService {
	Certificate findById(int id);

	void saveCertificate(Certificate Certificate);

	void updateCertificate(Certificate Certificate);

	void deleteById(int id);

	List<Certificate> findAllCertificates();

	List<Certificate> findAllCertificates(String search);

	boolean isCertificateIdUnique(Integer id);

	List<Certificate> getCertificates(int fromIndex, int toIndex);

	List<Certificate> getCertificates(int fromIndex, int toIndex, String search);
}