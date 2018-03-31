package io.java.sprinbootquickstart.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception  {
		auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()).withUser("user1").password("secrect1")
		.roles("USER");
		//.and().withUser("admin").password("secrect2").roles("USER", "ADMIN");
	}

	//Authorisation
	@Override
	protected void configure(HttpSecurity security) throws Exception{
		security.httpBasic().and().authorizeRequests().antMatchers("/topic").hasRole("USER").and().csrf().disable().headers().frameOptions().disable();
	}
	
}
