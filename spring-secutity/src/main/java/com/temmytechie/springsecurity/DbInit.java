package com.temmytechie.springsecurity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.temmytechie.springsecurity.entity.User;
import com.temmytechie.springsecurity.repository.UserRepository;

@Component
public class DbInit implements CommandLineRunner{
	
	@Autowired
	 UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<User> users = Stream.of(
				new User( "temmytechie", "password", "zdfdf@yahoo.com"),
				new User( "fff", "zfevfvd", "tvfdv@yahoo.com"),
				new User("dfsvd", "fdvfdv", "receeyahoo.com"),
				new User( "wwre", "5gtggr", "44xferr@yahoo.com")
				).collect(Collectors.toList());
		
		
		userRepository.saveAll(users);
		
		
		
	}

}
