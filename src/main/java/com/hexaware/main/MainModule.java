package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.controller.*;
import com.hexaware.exception.ArtworkNotFoundException;
import com.hexaware.exception.UserIdNotFoundException;

/**
 * MainModule class contains the main method for Virtual Art Gallery application,
 * allows to perform various operations related to artworks in the gallery.
 */
public class MainModule {

	/**
	 * The main method creates an instance of ArtworkController and a Scanner for user input.
     * It then enters a loop to display a menu and process user choices until the user chooses to exit.
	 * @param args
	 */
	public static void main(String[] args) {
		 ArtworkController artworkCont = new ArtworkController();
		 Scanner sc = new Scanner(System.in);
		 

       // Main application loop
		 while(true) {
			 System.out.println("\n Welcome To Virtual Art Gallery");
             System.out.println("1. Add artwork ");
             System.out.println("2. Update artwork ");
             System.out.println("3. Remove artwork");
             System.out.println("4. Get artwork by ID ");
             System.out.println("5. Add artwork to favourites");
             System.out.println("6. Remove artwork from favourites");
             System.out.println("7. Get user favourite artwork");
             System.out.println("8. Exit ");
             System.out.print("Enter your choice: ");
             
          // Reading the user's choice
             int choice = sc.nextInt();
             // Switch statement to perform actions based on user choice
             switch (choice) {
                 case 1:
                	artworkCont.addArtwork();	 
                    break;
                    
                 case 2:
                	try {
                		 boolean success = artworkCont.updateArtwork();
                    	 if(success)
                    		 System.out.println("Artwork updated successfully.");
                    	 else
                    		 throw new ArtworkNotFoundException ("Artwork ID not found.");
                	}catch (ArtworkNotFoundException e) {
               		 System.out.println(e.getMessage());
                	}
                     break;
                     
                 case 3:
                	try {
                		 boolean success = artworkCont.removeArtwork();
                    	 if(success)
                    		 System.out.println("Artwork deleted successfully.");
                    	 else 
                    		 throw new ArtworkNotFoundException ("Artwork ID not found.");
                	}catch (ArtworkNotFoundException e) {
                  		 System.out.println(e.getMessage());
                   	}
                     break;
                     
                 case 4:
                	try {
                		 boolean success = artworkCont.getArtwork();
                    	 if(success)
                    		 System.out.println("Artwork retreived successfully.");
                    	 else 
                    		 throw new ArtworkNotFoundException ("Artwork ID not found.");
            	}catch (ArtworkNotFoundException e) {
              		 System.out.println(e.getMessage());
               	}
                     break;
                     
                 case 5:
                	 try {
                		 boolean success = artworkCont.addFavourite();
                		 if(success) {
                    		 System.out.println("Favourite artwork added successfully.");
                		 }else {
                    		 throw new ArtworkNotFoundException("Failed to add favourite artwork.");
                		 }
                	 }catch(ArtworkNotFoundException e) {
                		 System.out.println(e.getMessage());
                		 
                	 }
                     break;
                 
                 case 6: 
                	 try {
                		 boolean success = artworkCont.removeFavourite();;
                		 if(success) {
                			 System.out.println("Favourite artwork removed successfully.");                		
                			 }
                		 else {
                    		 throw new UserIdNotFoundException("userId not found.");
                		 }
                	 }catch(UserIdNotFoundException e) {
                		 System.out.println(e.getMessage());
                		 
                	 }
                	 break;
                	 
                 case 7:
                	 try {
                		 boolean success = artworkCont.getFavourite();
                		 if(!success) {
                    		 throw new UserIdNotFoundException("userId not found.");
                		 }
                	 }catch(UserIdNotFoundException e) {
                		 System.out.println(e.getMessage());
                		 
                	 }
                	 
                	 break;
                     
                 case 8:
                     System.out.println("Thanks for using our System");
                     System.exit(0); // Exiting the application
                     
                 default:
                     System.out.println("Invalid choice. Please enter a number between 1 to 8.");
             }
           }
		 }
	}

