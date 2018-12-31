package br.com.juniormiqueletti.socialbooks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication()
             .withUser("juniormiqueletti")
             .password("{noop}p4ssw0rd")
             .roles("USER");
     }

     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
             .authorizeRequests()
                 .antMatchers("/h2-console/**").permitAll()
                 .anyRequest().authenticated()
             .and()
                .httpBasic()
             .and()
                .csrf()
                .disable();
     }
}
