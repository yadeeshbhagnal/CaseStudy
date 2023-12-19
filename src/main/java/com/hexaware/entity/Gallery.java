package com.hexaware.entity;

public class Gallery {
	
	private int galleryId;
	private String name;
    private String description;
    private String location;
    private Artist curator;
    private String openingHours;
    
    public Gallery(int galleryId, String name, String description, String location, Artist curator, String openingHours) {
        this.galleryId = galleryId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.curator = curator;
        this.openingHours = openingHours;
    } 	
    
	    public int getGalleryId() {
			return galleryId;
		}
		public void setGalleryId(int galleryId) {
			this.galleryId = galleryId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Artist getCurator() {
			return curator;
		}
		public void setCurator(Artist curator) {
			this.curator = curator;
		}
		public String getOpeningHours() {
			return openingHours;
		}
		public void setOpeningHours(String openingHours) {
			this.openingHours = openingHours;
		}
		
}

