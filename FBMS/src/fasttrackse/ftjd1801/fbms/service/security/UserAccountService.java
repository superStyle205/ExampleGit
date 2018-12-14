package fasttrackse.ftjd1801.fbms.service.security;

import fasttrackse.ftjd1801.fbms.entity.security.UserAccount;

public interface UserAccountService {
	public UserAccount loadUserByUsername(final String username);
}
