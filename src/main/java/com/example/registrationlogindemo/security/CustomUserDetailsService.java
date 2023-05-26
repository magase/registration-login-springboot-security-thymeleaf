package com.example.registrationlogindemo.security;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }



    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }

     */
/*
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsCustom userDetailsCustom = getUserDetailsCustom(username);

        if(ObjectUtils.isEmpty(userDetailsCustom)){
            throw new UsernameNotFoundException("User not found");
        }
        return userDetailsCustom;
    }

    private UserDetailsCustom getUserDetailsCustom(String email){
        User user = userRepository.findByEmail(email);

        if(ObjectUtils.isEmpty(user)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "User not found");
        }

        return new UserDetailsCustom(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toList())
        );
    }

 */

    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(usernameOrEmail);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail()
                    , user.getPassword(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}

