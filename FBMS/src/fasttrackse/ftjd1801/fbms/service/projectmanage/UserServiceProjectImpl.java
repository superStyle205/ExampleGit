package fasttrackse.ftjd1801.fbms.service.projectmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.UserAccountProjectDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.UserAccountProject;


@Service
public class UserServiceProjectImpl implements UserServiceProject {
	@Autowired
	private UserAccountProjectDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		UserAccountProject user = userDao.loadUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("No user found with id:" + username);
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new User(username, user.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,user.getAuthorities());
	}

}
