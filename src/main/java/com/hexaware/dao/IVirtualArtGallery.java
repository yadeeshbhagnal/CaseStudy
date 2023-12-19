
/**
 * The IVirtualArtGallery interface defines the contract for performing basic
 * CRUD (Create, Read, Update, Delete) operations on artworks in the Virtual Art Gallery.
 */
package com.hexaware.dao;

import com.hexaware.entity.Artwork;

public interface IVirtualArtGallery {
	

    /**
     * Adds a new artwork to the Virtual Art Gallery database.
     *
     * @param artwork The Artwork object to be added.
     * @return true if the artwork is added successfully, false otherwise.
     */
	boolean addArtwork(Artwork artwork);
	
	/**
     * Retrieves artwork details from the Virtual Art Gallery database based on the provided artwork ID.
     *
     * @param artworkId The ID of the artwork to be retrieved.
     * @return An Artwork object containing the retrieved artwork details, or null if not found.
     */
	Artwork getArtwork(int artworkId);
	
	 /**
     * Updates the details of an existing artwork in the Virtual Art Gallery database.
     *
     * @param artwork The updated Artwork object.
     * @return true if the artwork is updated successfully, false otherwise.
     */
	boolean updateArtwork(Artwork artwork);
	
	/**
     * Deletes an artwork from the Virtual Art Gallery database based on the provided artwork ID.
     *
     * @param artworkId The ID of the artwork to be deleted.
     * @return true if the artwork is deleted successfully, false otherwise.
     */
	boolean deleteArtwork(int artworkId);
}
