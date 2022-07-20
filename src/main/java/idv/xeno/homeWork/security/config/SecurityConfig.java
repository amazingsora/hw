package idv.xeno.homeWork.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Autowired
	DemoUserDetailsService demoUserDetailsService;
	// 密碼加密
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager imudm = new InMemoryUserDetailsManager(
//				User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("auth").build(),
//				User.withUsername("amazingSora").password(passwordEncoder().encode("admin")).authorities("all", "auth")
//						.build(),
//				User.withUsername("test").password(passwordEncoder().encode("test")).authorities("test").build());
//		return imudm;
//	}

	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	// 授權控制
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 設定放行名單
				.antMatchers("/sc/**").hasAuthority("admin").antMatchers("/login").permitAll()
				// 其餘路徑皆須進行驗證
				.anyRequest().authenticated().and().formLogin().loginPage("/login").usernameParameter("hwUser")
				.passwordParameter("hwPW").defaultSuccessUrl("/").failureUrl("/failPage").permitAll().and().logout()
				.logoutUrl("/logout").and().csrf().disable();

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// 僅僅作為演示
		return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**");
	}

}