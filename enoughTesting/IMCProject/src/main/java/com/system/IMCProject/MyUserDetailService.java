package com.system.IMCProject;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.IMCProject.databaseObjects.User;
import com.system.IMCProject.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository UserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = UserRepository.findByUserName(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		return user.map(MyUserDetails::new).get();
	}

}
