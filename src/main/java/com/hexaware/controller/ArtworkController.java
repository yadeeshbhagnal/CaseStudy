/**
 * The ArtworkController class handles user interactions related to artworks in the Virtual Art Gallery.
 * It provides methods to add, retrieve, update, and remove artworks, as well as manage user favorites.
 */

package com.hexaware.controller;

import java.sql.Date;
import java.util.*;

import com.hexaware.dao.UserService;
import com.hexaware.dao.VagService;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.User;

public class ArtworkController {
	Scanner scanner = new Scanner(System.in);
	private VagService vagService = new VagService(); // Service for managing artworks
	private UserService userService = new UserService();  // Service for managing users
	private  Date createDate=null;
	
	/**
     * Adds a new artwork to the Virtual Art Gallery.
     * Reads user input for artwork details and creates an Artwork object.
     * Calls the VagService to add the artwork to the gallery.
     */
	public void addArtwork()
	{
		System.out.println("Enter Artwork ID: ");
        int artworkId = scanner.nextInt();
        
        scanner.nextLine();
               
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.println("Enter Description:");
        String description = scanner.nextLine();
        
        System.out.println("Enter creation date:");
        String creationDate = scanner.nextLine();
        createDate = Date.valueOf(creationDate);
        
        System.out.println("Enter Medium:");
        String medium = scanner.nextLine();
        
        System.out.println("Enter imageURL:");
        String imageURL = scanner.nextLine();
        
        Artwork artwork = new Artwork(artworkId,title,description,createDate,medium,imageURL);
        
        boolean success = vagService.addArtwork(artwork);

        if (success) {
            System.out.println("Artwork added successfully.");
        } else {
            System.out.println("Failed to add artwork.");
        }
	}

    /**
     * Retrieves artwork details based on the provided artwork ID.
     * Calls the VagService to get the artwork information and prints it to the console.
     *
     * @return true if artwork is retrieved successfully, false otherwise.
     */
	public boolean getArtwork()
	{
		System.out.println("Enter artwork ID to retreive: ");
		int artworkId = scanner.nextInt();
		Artwork artwork = vagService.getArtwork(artworkId);
		if(artwork!=null) {
			System.out.println("Retreived artwork: ");
			System.out.println("Artwork ID: " + artwork.getArtworkId());
			System.out.println("title: " + artwork.getTitle());
			System.out.println("Description: " + artwork.getDescription());
			System.out.println("Creation Date: " + artwork.getCreationDate());
			System.out.println("Medium: " + artwork.getMedium());
			System.out.println("ImageURL: " + artwork.getImageURL());
			return true;
		}
		else return false;
		
	}
	
	/**
     * Updates the details of an existing artwork based on the provided artwork ID.
     * Reads user input for updated artwork details and calls the VagService to perform the update.
     *
     * @return true if the artwork is updated successfully, false otherwise.
     */
	public boolean updateArtwork()
	{
		System.out.println("Enter artwork ID to update: ");
		int artworkId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter artwork title:");
		String updatedArtworkTitle = scanner.nextLine();
		
		System.out.println("Enter artwork description:");
		String updatedArtworkDescription = scanner.nextLine();
		
		System.out.println("Enter artwork creation date:");
		String updatedArtworkCreationDate = scanner.nextLine();
	    createDate = Date.valueOf(updatedArtworkCreationDate);
		
		System.out.println("Enter artwork medium:");
		String updatedArtworkMedium = scanner.nextLine();
		
		System.out.println("Enter artwork imageURL:");
		String updatedArtworkUrl = scanner.nextLine();
		
		Artwork updatedArtwork = new Artwork(artworkId, updatedArtworkTitle, updatedArtworkDescription, createDate, updatedArtworkMedium, updatedArtworkUrl);
			boolean success = vagService.updateArtwork(updatedArtwork);
			return success;	
	}
	
	/**
     * Removes an artwork from the Virtual Art Gallery based on the provided artwork ID.
     * Calls the VagService to delete the artwork from the gallery.
     *
     * @return true if the artwork is removed successfully, false otherwise.
     */
	public boolean removeArtwork()
	{
		System.out.println("Enter Artwork ID to delete:");
        int artworkId = scanner.nextInt();

        
        boolean success = vagService.deleteArtwork(artworkId);
        return success;
	}
	
	/**
     * Adds an artwork to a user's list of favorite artworks.
     * Reads user input for user ID, artwork ID, and username.
     * Creates a User object and calls the UserService to add the artwork to the user's favorites.
     *
     * @return true if the artwork is added to favorites successfully, false otherwise.
     */
	public boolean addFavourite(){
		System.out.println("Enter userId: ");
		int userId = scanner.nextInt();
		System.out.println("Enter artworkId to added in favourite: ");
		int artworkId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		User user = new User(userId,username,artworkId);
		boolean success = userService.addUser(user);
		return success;
	}
	
	   /**
     * Removes an artwork from a user's list of favorite artworks.
     * Reads user input for user ID and artwork ID.
     * Calls the UserService to remove the artwork from the user's favorites.
     *
     * @return true if the artwork is removed from favorites successfully, false otherwise.
     */
	public boolean removeFavourite() {
		System.out.println("Enter userId: ");
		int userId = scanner.nextInt();
		System.out.println("Enter artworkId to remove from favourite: ");
		int artworkId = scanner.nextInt();
	boolean success = userService.removeFavouriteArtwork(userId, artworkId);
	return success;
		
	}
	
	/**
     * Retrieves the list of favorite artworks for a given user.
     * Reads user input for user ID and calls the UserService to get the user's favorite artworks.
     *
     * @return true if user's favorite artworks are retrieved successfully, false otherwise.
     */
	public boolean getFavourite() {
		System.out.println("Enter userId: ");
		int userId = scanner.nextInt();
		List<Integer> artworks = userService.getUserFavouriteArtwork(userId);
		if(artworks.isEmpty()) {
			return false;
		}
        System.out.println("All artworks of user:");
        for(Object artworkId:artworks) {
        	Artwork artwork = vagService.getArtwork((int) artworkId);
    		if(artwork!=null) {
    			System.out.println("Retreived artwork: ");
    			System.out.println("Artwork ID: " + artwork.getArtworkId());
    			System.out.println("title: " + artwork.getTitle());
    			System.out.println("Description: " + artwork.getDescription());
    			System.out.println("Creation Date: " + artwork.getCreationDate());
    			System.out.println("Medium: " + artwork.getMedium());
    			System.out.println("ImageURL: " + artwork.getImageURL());
    			System.out.println();
    		}
           }
        return true;
	}
}
