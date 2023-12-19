package com.hexaware.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.sql.Date;

import com.hexaware.entity.Artwork;

class VagServiceTest {
	private Artwork artwork;
	private VagService vagService = new VagService();
	private Date creationDate = null;

	@Test
	public void addArtworkTest() {
		creationDate = new Date(System.currentTimeMillis());
		artwork = new Artwork(15, "Hello", "this is test",creationDate, "usfcu", "nchusc");
		boolean result = vagService.addArtwork(artwork);
		assertEquals(result,true);
		
	}
	@Test
	public void getArtworkByIdTest()
	{
		artwork = vagService.getArtwork(30);
		assertEquals(artwork.getTitle(),"mountain");
	}
	@Test
	public void updateArtworkTest()
	{
		creationDate = new Date(System.currentTimeMillis());
		Artwork newArtwork = new Artwork(15, "Welcome", "updated test",creationDate, "usfcu", "ggsc");
		boolean result = vagService.updateArtwork(newArtwork);
		assertEquals(result,true);
	}
	
	@Test 
	public void deleteArtworkTest()
	{
		boolean result = vagService.deleteArtwork(15);
		assertEquals(result,true);
	}
	
	
	
}
