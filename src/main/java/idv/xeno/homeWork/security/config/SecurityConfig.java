package idv.xeno.homeWork.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
	// 密碼加密
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 調整至自訂畫面
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		// TODO Auto-generated method stub
////		WebMvcConfigurer.super.addViewControllers(registry);
//		registry.addViewController("/").setViewName("index");
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager imudm = new InMemoryUserDetailsManager(
				User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("auth").build(),
				User.withUsername("amazingSora").password(passwordEncoder().encode("admin")).authorities("all","auth").build(),
				User.withUsername("test").password(passwordEncoder().encode("test")).authorities("test").build()
				);
		return imudm;
	}

	// 授權控制
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//		// TODO Auto-generated method stub
//		http.authorizeRequests()
//				// 設定放行名單
//				.antMatchers("/login").permitAll()
//				.antMatchers("/sc/**").hasAuthority("admin")
//				// 其餘路徑皆須進行驗證
//				.anyRequest()
//				.authenticated();
////		.and().formLogin().loginPage("/login").usernameParameter("hwUser")
////				.passwordParameter("hwPW").defaultSuccessUrl("/main").failureUrl("/fail")
////				.and()
////				.logout().logoutUrl("/logout").and()
////				.csrf().disable();
//
//		return http.build();
//	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// 僅僅作為演示
		return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**");
	}

}