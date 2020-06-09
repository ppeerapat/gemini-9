package com.estcium.gemini9.configuration;

import com.estcium.gemini9.api.jwt.JwtAuthenticationEntryPoint;
import com.estcium.gemini9.configuration.filter.CorsFilter;
import com.estcium.gemini9.configuration.filter.JwtRequestFilter;
import com.estcium.gemini9.service.UserService;
import com.estcium.gemini9.util.PasswordEncoderProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    //private LoginSuccessHandler loginSuccessHandler = new LoginSuccessHandler();

    //private RestAuthenticationEntryPoint restAuthenticationEntryPoint = new RestAuthenticationEntryPoint();
    private JwtAuthenticationEntryPoint authenticationEntryPoint = new JwtAuthenticationEntryPoint();
    private PasswordEncoderProvider passwordEncoder = new PasswordEncoderProvider();

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(corsFilter(), SessionManagementFilter.class)

                .csrf().disable()
                .authorizeRequests().antMatchers("/api/**").authenticated()
                .and()
                .httpBasic()
                //.and()
//                .exceptionHandling()
//                    .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder.passwordEncoder());
        return auth;
    }
}
