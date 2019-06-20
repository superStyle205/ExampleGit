package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.RoleAll;

public interface RoleAllService {
	RoleAll findById(int id);

	void addNew(RoleAll role);

	void update(RoleAll role);

	void delete(int id);

	List<RoleAll> findAll();

	List<RoleAll> findRole(int fromIndex, int toIndex, String search);
}
