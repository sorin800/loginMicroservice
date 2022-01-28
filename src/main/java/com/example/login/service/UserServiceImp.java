package com.example.login.service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.login.model.Role;
import com.example.login.model.User;
import com.example.login.repository.RoleRepository;
import com.example.login.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {	
		List<User> users = userRepository.findAll();
		for(int i=0;i<users.size();i++)
		{
			User tmpUser = users.get(i);
			if(tmpUser.getEmail().equals(user.getEmail()))
				return true;
		}
			return false;
	}
}
