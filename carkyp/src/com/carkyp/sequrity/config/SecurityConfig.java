package com.carkyp.sequrity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.carkyp.UseRoleStatus;
import com.carkyp.service.LocalAuthenticationProvider;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private LocalAuthenticationProvider local;


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	
    	//http.httpBasic();
        http.authorizeRequests()
        .antMatchers("/rest/regitrationConfirm**").permitAll();
        
        http.authorizeRequests()
        .antMatchers("/rest/register/serviceprovider").permitAll();
          
        http
		.authorizeRequests()
		.anyRequest().authenticated();
 
    	    //    .httpBasic().disable();
    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic();
         http.csrf().disable();
       //  http.httpBasic().disable();
    }        
	
         @Override
         protected void configure(AuthenticationManagerBuilder auth) throws Exception {
             auth.authenticationProvider(local);
         }
	
}
