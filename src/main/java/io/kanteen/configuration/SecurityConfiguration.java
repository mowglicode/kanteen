package io.kanteen.configuration;

import java.util.ArrayList;
import java.util.List;

import io.kanteen.dto.AccountDto;
import io.kanteen.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Configuration // bean spring : comportement particulier
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAccountService accountService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication auth) throws AuthenticationException {


                final String userName = auth.getName();
                final String password = auth.getCredentials().toString();

                AccountDto u = accountService.getAccountByEmail(userName);

                if (u != null) {
                    if (password.equals(u.getPassword())) {
                        List<GrantedAuthority> grantedAuths = new ArrayList<>();
                        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
                        return new UsernamePasswordAuthenticationToken(u, "", grantedAuths);

                    }
                }

                return null;
            }

            @Override
            public boolean supports(Class<?> arg0) {
                return true;
            }
        });
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/oauth/**")
                .antMatchers("/api/public/**"); //ignore les requetes /public/*

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();
//    }

}
