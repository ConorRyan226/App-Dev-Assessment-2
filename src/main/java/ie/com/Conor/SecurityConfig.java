package ie.com.Conor;

//@Configuration
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

	/*@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
				.antMatchers("/console/**").permitAll()
				..antMatchers("/list/**").permitAll();
		httpSecurity.headers().frameOptions().disable();
	}*/
	
	/*
	 @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll() 
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()                                    
                .permitAll();
    }
	 */
}
