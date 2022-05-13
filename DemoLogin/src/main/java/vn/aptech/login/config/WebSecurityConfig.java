/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.aptech.login.service.impl.AccountServiceImpl;

/**
 *
 * @author nhta1
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     @Autowired
    private AccountServiceImpl accountService;
    @Bean
    public PasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }
    
     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(accountService).passwordEncoder(encodePassword());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//            http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/account/login").permitAll().defaultSuccessUrl("/account").loginProcessingUrl("/j_spring_security_check");
            
//        super.configure(http); //To change body of generated methods, choose Tools | Templates.
        http.csrf().disable();

        http.authorizeHttpRequests()
                .antMatchers("/account/login","logout").permitAll();
        http.authorizeHttpRequests()
                .antMatchers("/account")
                .authenticated();
        
        // muon vao account/create or save thi phai la role admin
        http.authorizeHttpRequests().antMatchers("/account/create","/account/save").hasRole("ADMIN");
        //try cap route: /user =>y/c login
        http.authorizeHttpRequests()
                //                .antMatchers("/account/create","/account/save")
                //                .access("hasRole('ROLE_ADMIN')")
                .and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")//submit url
                .loginPage("/account/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/account",true)
                .failureUrl("/account/login?error=true")
                //cau hinh Logout Page
                .and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/account/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403");
       http.authorizeHttpRequests().and().rememberMe();
        //config remember
//                .tokenRepository("abc")
//                .tokenValiditySeconds(24*60*60); //1 ngay
    }
}
