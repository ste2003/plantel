package com.acuaa.plantel.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acuaa.plantel.models.User;
import com.acuaa.plantel.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		
		// final User user = userRepository.findByUsername(username);
        //if (user == null)
          //  throw new UsernameNotFoundException("username " + username
            //        + " not found");

        //System.out.println("---------------------> FOUND ------------->"
          //      + user.getEmail());

       // return user;
	
		return UserDetailsImpl.build(user);
	}

}
