package fasttrackse.ftjd1801.fbms.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.security.UserAccountDao;
import fasttrackse.ftjd1801.fbms.entity.security.UserAccount;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	@Transactional
	public UserAccount loadUserByUsername(String username) {

		return this.userAccountDao.loadUserByUsername(username);
	}

}
