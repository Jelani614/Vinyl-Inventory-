package edu.cscc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Record{
	public Record() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	
	@NotEmpty(message="Please enter a title.")
	@Size(max=50, message="Please enter a title that is 1-50 characters in length.")
	public String title;
	
	@Size(max=40, message="Please enter a artist that is 1-40 characters in length.")
	@NotEmpty(message="Please enter a artist")
	public String artist;
	
	@Size(max=40, message="Please enter a label that is 1-40 characters in length.")
	@NotEmpty(message="Please enter a label.")
	public String label;
	
	@Min(value = 1930, message = "Please enter a year released that is on or after 1930")
	public int yearReleased;
	@Min(1)
	@Max(value = 20, message = "Please enter a number of tracks that is between 1 and 20.")
	public int numberofTracks;
	
	public int size;
	
	public boolean damaged;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public int getNumberofTracks() {
		return numberofTracks;
	}

	public void setNumberofTracks(int numberofTracks) {
		this.numberofTracks = numberofTracks;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isdamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}
	
}
