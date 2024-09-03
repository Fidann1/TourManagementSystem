package az.springlesson.travel.demo5.services.impl;

import az.springlesson.travel.demo5.entities.UserEntity;
import az.springlesson.travel.demo5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class    UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Could not found user compatible with the email you provided..!");

        }
        return new CustomUserDetails(user);







    }
}
