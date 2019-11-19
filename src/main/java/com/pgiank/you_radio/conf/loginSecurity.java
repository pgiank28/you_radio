package com.pgiank.you_radio.conf;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
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
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
@PropertySource("classpath:application.yml")
public class loginSecurity extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/**","/basic**","/retrieve**")
                .permitAll()
            .and()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .oauth2Login().loginPage("/index")
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(authorizedClientService());
    }


    public OAuth2AuthorizedClientService authorizedClientService() {

    return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
    }

    @Autowired
    private Environment env;

    String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";


    private static List<String> clients = Arrays.asList("google", "facebook");


      public ClientRegistrationRepository clientRegistrationRepository() {
          List<ClientRegistration> registrations = clients.stream()
            .map(c -> getRegistration(c))
            .filter(registration -> registration != null)
            .collect(Collectors.toList());

          return new InMemoryClientRegistrationRepository(registrations);
      }


      public ClientRegistration getRegistration(String client){

            String clientId = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-id");

                if (clientId == null) {
                  return null;
                }

            String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");

                if (client.equals("google")) {
                    return CommonOAuth2Provider.GOOGLE.getBuilder(client).clientId(clientId).clientSecret(clientSecret).build();
                }
                if (client.equals("facebook")) {
                    return CommonOAuth2Provider.FACEBOOK.getBuilder(client).clientId(clientId).clientSecret(clientSecret).build();
                }
            return null;
      }

}
