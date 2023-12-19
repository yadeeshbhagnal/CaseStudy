package com.hexaware.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hexaware.entity.User;

class UserServiceTest {
	private User user ;
	private UserService userService = new UserService();
	
	@Test
	public void addUserTest() {
		user = new User(10, "abcde", 11);
		boolean result = userService.addUser(user);
		assertEquals(result,true);
	}
	
	@Test
	public void getUserFavouriteArtworkTest() {
		List<Integer> artWorks = new ArrayList();
		artWorks = userService.getUserFavouriteArtwork(120);
		assertEquals(artWorks.get(0),11);
	}
	
	@Test
	public void removeFavouriteArtworkTest() {
		boolean result = userService.removeFavouriteArtwork(10,11);
		assertEquals(result,true);
	}

}
