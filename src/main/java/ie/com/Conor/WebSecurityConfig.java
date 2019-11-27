package ie.com.Conor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/css/**", "/", "/login/**", "/registration/**").permitAll()
	.anyRequest().authenticated().and().formLogin();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	return new BCryptPasswordEncoder();
	}
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String encodedPassword = passwordEncoder.encode("password");
		
		auth.inMemoryAuthentication()
				.withUser("user").password(encodedPassword).roles("USER").and()
				.withUser("admin").password(encodedPassword).roles("USER", "ADMIN");
	}
	
	
	
}