package ie.com.Conor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration
 */
/*public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/*
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
	*/
	
