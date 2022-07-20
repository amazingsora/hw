package idv.xeno.homeWork.security.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DemoUserDetailsService implements UserDetailsService {
	private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils
			.createAuthorityList("admin", "auth");
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		if(org.junit.platform.commons.util.StringUtils.isBlank(username)) {
	        throw new UsernameNotFoundException("請填入帳號");
		}
		System.out.println("登入權限設置");
//		UserDetails userDetails = User.withUsername("admin").password(new BCryptPasswordEncoder().encode("admin")).authorities("admin").build();
		 return new User("admin", new BCryptPasswordEncoder().encode("admin"), ADMIN_ROLES); 
//		return userDetails;
	}

}