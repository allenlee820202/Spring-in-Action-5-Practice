package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/design", "/orders").access("hasRole('ROLE_USER')")
                .antMatchers("/**").access("permitAll")
                .and()
                    .formLogin()
                        .loginPage("/login")
                        // .loginProcessingUrl("/authenticate")
                        // .usernameParameter("user")
                        // .passwordParameter("pwd")
                        .defaultSuccessUrl("/design", true)
                .and()
                    .logout()
                        .logoutSuccessUrl("/login");
        /*
         * To access h2-console, disable csrf() and frameOptions().
         * And don't forget to remove csrf input lines in .html pages.
         */
        // http.csrf().disable();
        // http.headers().frameOptions().disable();
    }

    /*
    @Autowired
    DataSource dataSource;

    // Jdbc user store
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from Users " +
                        "where username=?")
                .authoritiesByUsernameQuery("select username, authority from UserAuthorities " + "where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    */

    // Defining users in an in-memory user store
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("buzz")
                .password("infinity")
                .authorities("ROLE_USER")
                .and()
                .withUser("woody")
                .password("bullseye")
                .authorities("ROLE_USER");

    }
    */
}
