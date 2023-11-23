package ro.sda.seedjavaremote60.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ro.sda.seedjavaremote60.entities.User;
import ro.sda.seedjavaremote60.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser= userRepository.findByUsernameIgnoreCase(username);
        if (optionalUser.isPresent()){
            User foundUser = optionalUser.get();
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return List.of(new SimpleGrantedAuthority("ROLE_"+foundUser.getRole()));
                }

                @Override
                public String getPassword() {
                    return foundUser.getPassword();
                }

                @Override
                public String getUsername() {
                    return foundUser.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        }else{
            throw new UsernameNotFoundException("Bad credentials");
        }
    }
}
