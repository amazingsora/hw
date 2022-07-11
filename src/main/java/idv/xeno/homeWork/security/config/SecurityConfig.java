package idv.xeno.homeWork.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// TODO Auto-generated method stub
		http.authorizeRequests()
				// 設定放行名單
				.antMatchers("/login").permitAll()
				// 其餘路徑皆須進行驗證
				.anyRequest().authenticated().and().formLogin().loginPage("/login").usernameParameter("hwUser")
				.passwordParameter("hwPW")
				.and().logout().logoutUrl("/logout").and()
				.csrf().disable();

		return http.build();
	}
	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        // 僅僅作為演示
	        return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**");
	    }

}