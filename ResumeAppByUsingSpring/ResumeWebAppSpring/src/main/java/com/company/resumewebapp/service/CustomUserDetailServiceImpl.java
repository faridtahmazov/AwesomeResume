package com.company.resumewebapp.service;

import com.company.model.User;
import com.company.repository.repositoryInter.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class CustomUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    @Qualifier("userRepositoryCustomImpl")
    private UserRepositoryCustom userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        System.out.println("Username: " + user.getLoginUsers().getUsername());
        System.out.println("Password: " + user.getLoginUsers().getPassword());

        if (user!=null){
            UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);

            userBuilder.disabled(false);

            userBuilder.password(user.getLoginUsers().getPassword());

            String[] authoritiesArr =
                    new String[]{user.getAuthority().getAuthName(), "ROLE_" + user.getAuthority().getAuthName()}; // daxil olunan userin sadece user huququ var.
            userBuilder.authorities(authoritiesArr);

            return userBuilder.build();
        }else{
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
