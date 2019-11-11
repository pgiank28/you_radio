package com.pgiank.you_radio.conf;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.beans.factory.annotation.Autowired;

@EnableWebSecurity
@EnableOAuth2Sso
public class loginSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    oauth2Registration oath;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/oauth/authorize**", "/login**", "/error**","/activ**","/index**","/newRadio**","/**")
                .permitAll()
            .and()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository2())
                .authorizedClientService(authorizedClientService())
                .loginPage("/index");
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {

    return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository2());
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository2(){

    return oath.clientRegistrationRepository();
    }
}
