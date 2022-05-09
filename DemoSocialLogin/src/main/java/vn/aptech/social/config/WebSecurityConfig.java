/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.social.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import vn.aptech.social.model.CustomOAuth2User;
import vn.aptech.social.service.impl.CustomOAuth2UserServiceImpl;
import vn.aptech.social.service.impl.UserServiceImpl;

/**
 *
 * @author Thanh Sang
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Bean 
    public UserDetailsService userDetailsService(){
        return new UserServiceImpl();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Autowired
    private CustomOAuth2UserServiceImpl oauthUserService;
    
    @Autowired
    private UserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/login","/oauth/**").permitAll() // nhung route nay ko check
                .anyRequest().authenticated()  // nhung route khac bat buoc phai dang nhap
                .and()
                .formLogin().permitAll()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .and()
                .oauth2Login()    // thiet lap co che login cho sociall login
                .loginPage("/login")       // dung chung trang login
                .userInfoEndpoint()
                .userService(oauthUserService)
                .and()
                // xu ly cho login thanh cong
                .successHandler(new AuthenticationSuccessHandler(){
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        // nhan thong tin nguoi dung thong qua Priciple
                        CustomOAuth2User user = (CustomOAuth2User) authentication.getPrincipal();
                        userService.processOAuthPostLogin(user.getEmail());
                        response.sendRedirect("/home");
                    }
                })
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
