package edu.estu.petmates.configuration;

import edu.estu.petmates.user.User;
import edu.estu.petmates.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = userRepository.findByUsername(username); // db den  kullanıcıları getirir.
        if(inDB == null){
            throw new UsernameNotFoundException("User not found"); // user ın olup olmadığının kontrolü.
        }
        return inDB;
    }
}