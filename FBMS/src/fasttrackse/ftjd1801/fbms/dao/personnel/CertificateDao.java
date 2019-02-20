package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.Certificate;

public interface CertificateDao {
	Certificate findById(int id);

	void saveCertificate(Certificate employee);

	void deleteCertificateById(int id);

	List<Certificate> findAllCertificates();

	List<Certificate> findAllCertificates(String search);

	List<Certificate> getCertificates(int fromIndex, int toIndex);

	List<Certificate> getCertificates(int fromIndex, int toIndex, String search);
}