package ro.sda.seedjavaremote60.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.List;

@Component
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/");
        http.authorizeHttpRequests((req) ->{

            req.requestMatchers("/api/**").permitAll()
//                    .requestMatchers(("/h2**")).permitAll()
                    .requestMatchers("/login").permitAll()
                    .requestMatchers(("/logout")).permitAll()
                    .requestMatchers(("/author/edit**"),
                            ("/author/create"),
                            ("/author/edit")
                            ).hasAuthority("ROLE_author")
                    .requestMatchers(("/book/**")
                    ).hasRole("book")
                    .requestMatchers(("/author/list")).authenticated()
                    .anyRequest().authenticated()
            ;

        });
        http.formLogin().permitAll();
        http.logout((logout)->logout.permitAll().clearAuthentication(true).invalidateHttpSession(true));
        http.csrf(AbstractHttpConfigurer::disable); //disable csrf (.csrf((csrf) -> csrf.disable()))
        http.cors(AbstractHttpConfigurer::disable); //disable cors (.cors((cors) -> cors.disable()))

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("book")
                .build();
        UserDetails userAdmin = User.withDefaultPasswordEncoder().username("vlad").password("root").roles("author").build();
        return new InMemoryUserDetailsManager(List.of(user,userAdmin));
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
