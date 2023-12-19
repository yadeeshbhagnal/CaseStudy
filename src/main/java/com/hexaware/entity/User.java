package com.hexaware.entity;

public class User {
	private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int artworkId;
    
    public User(int userId, String username, String password, String email, String firstName, String lastName, String dateOfBirth, String profilePicture, int artworkId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.artworkId = artworkId;
    }
    
    public User(int userId, String username, int artworkId ) {
    	this.userId = userId;
        this.username = username;
        this.artworkId = artworkId;
    }
	
	private int userId;
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getFavoriteArtwork() {
		return artworkId;
	}
	public void setFavoriteArtwork(int artworkId) {
		this.artworkId = artworkId;
	}
	
}

