/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import vn.aptech.account.service.impl.AccountServiceImpl;

/**
 *
 * @author Thanh Sang
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private AccountServiceImpl accountService;
    
    @Bean
    public PasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }
    
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(accountService).passwordEncoder(encodePassword());
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        return new InMemoryTokenRepositoryImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); //To change body of generated methods, choose Tools | Templates.
        http.csrf().disable();
        
        // ko can login 
        http.authorizeHttpRequests().antMatchers("/account/login","/logout").permitAll();
        // truy cap route: /account => y/c login
        http.authorizeHttpRequests().antMatchers("/account","/account/**").authenticated();
        http.authorizeHttpRequests()
                // .antMatchers("/account/create","/account/save")
                // .access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check") // submit url
                .loginPage("/account/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/account")
                .failureUrl("/account/login?error=true")
                // cau hinh cho Logout Page
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/account/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403");
        // cau hinh cho viec nho thong tin dang nhap (remember)
        http.authorizeHttpRequests().and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(24*60*60); // 1 ngay
    }
    
    
}
