package com.pronajdiusluga.app.security;

import com.pronajdiusluga.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailService{

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // hasRole("ADMIN") => бара ROLE_ADMIN
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + u.getRole().name()))
        );
    }
}
