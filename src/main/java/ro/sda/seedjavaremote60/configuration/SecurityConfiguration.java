package ro.sda.seedjavaremote60.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Component
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/");
        http.authorizeHttpRequests((req) ->{

            req.requestMatchers(mvcMatcherBuilder.pattern("/api/**")).permitAll()
                    .requestMatchers(mvcMatcherBuilder.pattern("/h2**")).permitAll()
                    .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                    .requestMatchers(mvcMatcherBuilder.pattern("/logout")).permitAll()
                    .anyRequest().authenticated();

        });
        http.formLogin((loginForm)->loginForm.permitAll().defaultSuccessUrl("/author/list").successForwardUrl("/author/list"));
        http.logout((logout)->logout.permitAll().clearAuthentication(true).invalidateHttpSession(true));
        http.csrf(AbstractHttpConfigurer::disable); //disable csrf (.csrf((csrf) -> csrf.disable()))
        http.cors(AbstractHttpConfigurer::disable); //disable cors (.cors((cors) -> cors.disable()))

        return http.build();
    }
}
