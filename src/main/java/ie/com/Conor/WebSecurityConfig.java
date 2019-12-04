
package ie.com.Conor;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure (HttpSecurity http) throws Exception {
			
			
			http.authorizeRequests()
			.antMatchers("/css/**", "/", "/login/*","/registration", "/jobs/*","/h2/*").permitAll()
			.antMatchers("/jobs").hasRole("USER")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.defaultSuccessUrl("/")
			.usernameParameter("email")
			.and().csrf().disable()
			.headers().frameOptions().disable();
				
		}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		String encodedPassword = passwordEncoder.encode("password");
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email, password, userEnabled from user_Details where user_Details.email=?")
		.authoritiesByUsernameQuery("select userEmail, roleDescription from role where role.userEmail = ?");
			
		
	}	
}
