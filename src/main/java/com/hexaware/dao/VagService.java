
/**
 * The VagService class provides methods to perform database operations related to artworks
 * in the Virtual Art Gallery. It implements the IVirtualArtGallery interface.
 */
package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.entity.Artwork;
import com.hexaware.util.*;

/**
 * The VagService class implements the IVirtualArtGallery interface and provides methods
 * for adding, retrieving, updating, and deleting artworks in the Virtual Art Gallery database.
 */
public class VagService implements IVirtualArtGallery
{
	private Connection connection;
	private DBConnUtil dbConnection = new DBConnUtil();
	
	
	  /**
     * Adds a new artwork to the Virtual Art Gallery database.
     *
     * @param artwork The Artwork object to be added.
     * @return true if the artwork is added successfully, false otherwise.
     */
	public boolean addArtwork(Artwork artwork)
	{
		connection = dbConnection.getDBConnection();
		String sql = "insert into Artwork (artworkId, title, description, creationDate, medium, imageURL) VALUES (?, ?, ?, ?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql))	{
			ps.setInt(1, artwork.getArtworkId());
			ps.setString(2, artwork.getTitle());
			ps.setString(3, artwork.getDescription());
			ps.setDate(4, artwork.getCreationDate());
			ps.setString(5, artwork.getMedium());
			ps.setString(6, artwork.getImageURL());
			int norows = ps.executeUpdate();
			return norows >0;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	 /**
     * Retrieves artwork details from the Virtual Art Gallery database based on the provided artwork ID.
     *
     * @param artworkId The ID of the artwork to be retrieved.
     * @return An Artwork object containing the retrieved artwork details, or null if not found.
     */
	public Artwork getArtwork(int artworkId)
	{
		try  {
        	connection = dbConnection.getDBConnection();
            String sql = "select * from Artwork where artworkId = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, artworkId);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (resultSet.next()) {
                        return new Artwork(
                                resultSet.getInt("artworkId"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getDate("creationDate"), 
                                resultSet.getString("medium"),
                                resultSet.getString("imageURL") 
                        );
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
		
	}
	
	
	 /**
     * Updates the details of an existing artwork in the Virtual Art Gallery database.
     *
     * @param artwork The updated Artwork object.
     * @return true if the artwork is updated successfully, false otherwise.
     */
	 public boolean updateArtwork(Artwork artwork) {
	        try {
	        	connection = dbConnection.getDBConnection();
	            String sql = "update Artwork SET title = ?, description = ?, creationDate = ?, medium = ?, imageURL = ? WHERE artworkId = ?";
	            try (PreparedStatement ps = connection.prepareStatement(sql)) {
	                ps.setInt(6, artwork.getArtworkId());
	                ps.setString(1, artwork.getTitle());
	                ps.setString(2, artwork.getDescription());
	                ps.setDate(3, artwork.getCreationDate());
	                ps.setString(4, artwork.getMedium());
	                ps.setString(5, artwork.getImageURL());

	                int rowsUpdated = ps.executeUpdate();
	                return rowsUpdated > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
	   /**
	     * Deletes an artwork from the Virtual Art Gallery database based on the provided artwork ID.
	     *
	     * @param artworkId The ID of the artwork to be deleted.
	     * @return true if the artwork is deleted successfully, false otherwise.
	     */
	 public boolean deleteArtwork(int artworkId) {
	        try {
	        	connection = dbConnection.getDBConnection();
	            String sql = "delete from Artwork WHERE artworkId = ?";
	            try (PreparedStatement ps = connection.prepareStatement(sql)) {
	                ps.setInt(1, artworkId);

	                int rowsDeleted = ps.executeUpdate();
	                return rowsDeleted > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}

