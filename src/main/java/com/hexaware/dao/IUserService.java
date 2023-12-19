/**
 * The IUserService interface defines the contract for performing operations related to users
 * and their favorite artworks in the Virtual Art Gallery.
 */
package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.User;
public interface IUserService
{

    /**
     * Checks whether an artwork with the given ID exists in the Artwork table.
     *
     * @param artworkId The ID of the artwork to check.
     * @return true if the artwork exists, false otherwise.
     */
	 boolean isArtworkExists(int artworkId);
	 
	 /**
	     * Adds a new user to the Virtual Art Gallery database.
	     *
	     * @param user The User object to be added.
	     * @return true if the user is added successfully, false otherwise.
	     */
	 boolean addUser(User user);
	 
	 /**
	     * Removes an artwork from a user's list of favorite artworks in the Virtual Art Gallery database.
	     *
	     * @param userId    The ID of the user.
	     * @param artworkId The ID of the artwork to be removed from favorites.
	     * @return true if the artwork is removed successfully, false otherwise.
	     */
	 boolean removeFavouriteArtwork(int userId, int artworkId);
	 
	 /**
	     * Retrieves the list of favorite artworks for a given user from the Virtual Art Gallery database.
	     *
	     * @param userId The ID of the user.
	     * @return A List of Integer representing the artwork IDs in the user's favorites.
	     */
	 List<Integer> getUserFavouriteArtwork(int userId);
}

