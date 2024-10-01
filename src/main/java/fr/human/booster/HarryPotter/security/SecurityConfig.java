package fr.human.booster.HarryPotter.security;

import fr.human.booster.HarryPotter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


@Component
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private JwtTokenFilter jwtTokenFilter;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/api/**")
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/api/**").permitAll()
//                                .requestMatchers("/api/login", "/api/register").permitAll()
//                                .requestMatchers(
//                                        AntPathRequestMatcher.antMatcher(HttpMethod.GET,"/api/listing")).permitAll()
//                                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET,"/api/**")).authenticated()
//                                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.DELETE,"/api/login")).hasAuthority("ADMIN")
                );
        return http.build();
    }

    public AuthenticationProvider authenticationProvider
}
