package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Domain;

public interface DomainDao {
	public List<Domain> findAll();

	public void addNew(Domain dm);

	public void update(Domain dm);

	public void delete(int maDomain);

	public Domain findByMaDomain(int maDomain);

	public List<Domain> findAll(int iDisplayStart, int iDisplayLength, String search);

}
