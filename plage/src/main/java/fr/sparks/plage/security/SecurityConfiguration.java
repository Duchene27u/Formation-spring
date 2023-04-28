package fr.sparks.plage.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    private UserDetailsService userService;
    private PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authenticationManager(new CustomAuthenticationManager(userService, passwordEncoder))
                .formLogin()
                // On fait référence à une URL
                .loginPage("/index")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/clients")
                .failureForwardUrl("/index?notification=Email ou mot de passe incorrect")
                        .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index?notification=Au revoir")
                        .and()
                        .authorizeRequests()
                        .antMatchers("/h2-console").permitAll()
                        .antMatchers("/clients").authenticated()
                        // Pour la console H2 (à ne pas utiliser en prod)
                        .and()
                        .headers().frameOptions().disable();

        return http.build();
    }

}
