package org.jpa.test;

import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.main.boot.model.User;
import com.main.boot.model.UserRepository;
import com.security.AppUserDetails;

@SpringBootTest
class JPAEntry {
	
	@Autowired
	UserRepository userRepository;

	@Test
	void test() {
		String userName = "Admin";
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		UserDetails userDetail = user.map(AppUserDetails::new).get();
		System.out.println(userDetail.getPassword());
	}

}
