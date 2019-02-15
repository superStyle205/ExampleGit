package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.UserAccountProject;

public interface UserAccountProjectDao {
	public UserAccountProject loadUserByUsername(final String username);
}