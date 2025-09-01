package com.bash.agricdeckmvp.service;

import com.bash.agricdeckmvp.exceptions.UserNotFoundException;
import com.bash.agricdeckmvp.model.User;
import com.bash.agricdeckmvp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository UserRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = UserRepo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Cannot find user with the email: "+email));
        return new UserPrincipal(user);
    }
}
