
/**
 * The UserService class provides methods to perform database operations related to users
 * and their favorite artworks in the Virtual Art Gallery. It implements the IUserService interface.
 */
package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.User;
import com.hexaware.util.DBConnUtil;
public class UserService implements IUserService
{
	private Connection connection;
	private DBConnUtil dbConnection = new DBConnUtil();
	
	
	 /**
     * Checks whether an artwork with the given ID exists in the Artwork table.
     *
     * @param artworkId The ID of the artwork to check.
     * @return true if the artwork exists, false otherwise.
     */
	public boolean isArtworkExists(int artworkId) {
	    System.out.println(artworkId);
	    connection = dbConnection.getDBConnection();
	    boolean check = false;
	    String findQuery = "SELECT * FROM Artwork where artworkId=?";
	    try (PreparedStatement ps = connection.prepareStatement(findQuery)) {
	        ps.setInt(1, artworkId);
	        try (ResultSet resultSet = ps.executeQuery()) {
	            while (resultSet.next()) {
	                check = true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return check;
	}

	  /**
     * Adds a new user to the Virtual Art Gallery database.
     *
     * @param user The User object to be added.
     * @return true if the user is added successfully, false otherwise.
     */
	public boolean addUser(User user) {
		connection = dbConnection.getDBConnection();
		boolean artworkExists = isArtworkExists(user.getFavoriteArtwork());
		if(artworkExists) {
			String sql = "insert into User (userId, userName,artworkId ) VALUES (?, ?, ?)";
			try(PreparedStatement ps = connection.prepareStatement(sql))	{
				ps.setInt(1, user.getUserId());
				ps.setString(2, user.getUsername());
				ps.setInt(3, user.getFavoriteArtwork());
				int norows = ps.executeUpdate();
				return norows >0;
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	
	 /**
     * Removes an artwork from a user's list of favorite artworks in the Virtual Art Gallery database.
     *
     * @param userId    The ID of the user.
     * @param artworkId The ID of the artwork to be removed from favorites.
     * @return true if the artwork is removed successfully, false otherwise.
     */
	public boolean removeFavouriteArtwork(int userId, int artworkId) {
		try {
        	connection = dbConnection.getDBConnection();
            String sql = "delete from User WHERE userId=? and artworkId = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userId);
                ps.setInt(2, artworkId);
                
                int rowsDeleted = ps.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	/**
     * Retrieves the list of favorite artworks for a given user from the Virtual Art Gallery database.
     *
     * @param userId The ID of the user.
     * @return A List of Integer representing the artwork IDs in the user's favorites.
     */
	public List<Integer> getUserFavouriteArtwork(int userId) {
		List<Integer> artWorks = new ArrayList();
		try  {
        	connection = dbConnection.getDBConnection();
            String sql = "SELECT artworkId FROM User where userId=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
            	ps.setInt(1,userId);
                try (ResultSet resultSet = ps.executeQuery()) {
                    while (resultSet.next()) {
                    	artWorks.add(resultSet.getInt("artworkId"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artWorks;
		
	}
}

