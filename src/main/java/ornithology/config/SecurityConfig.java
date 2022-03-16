package ornithology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/userView/**").hasAnyAuthority("ADMIN")
                .antMatchers("/birdClassView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/birdFoundView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/birdRegionView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/classificationView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/countryView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/familyView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/genusView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/nutritionView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .antMatchers("/specieView/**").hasAnyAuthority("ADMIN", "SCIENTIST", "TEACHER", "STUDENT")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}