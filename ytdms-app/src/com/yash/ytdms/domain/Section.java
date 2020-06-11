package com.yash.ytdms.domain;

/**
 * This is the component for travel the information from db layer to sevice
 * layer
 * 
 * @author vijay.solanki
 *
 */
public class Section {
	/**
	 * This is the pk of sections
	 * 
	 */
	private int id;
	/**
	 * This is the name of the section
	 */
	private String name;
	/**
	 * it conatin descripition of the section
	 */

	private String description;
	/**
	 * it is the display number of the sections.
	 */
	private int displayOrderNumber;

	/**
	 * It is the foreign key category id contain the
	 */
	private int categoryId;
	/**
	 * it define the status of document 1: it means section contains document 0: it
	 * means section do not contain document
	 */
	private int documentStatus;

	// Getters and settrs of the secton attributes.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + ", description=" + description + ", displayNumber="
				+ displayOrderNumber + ", categoryId=" + categoryId + "]";
	}

	public int getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(int documentStatus) {
		this.documentStatus = documentStatus;
	}

	public int getDisplayOrderNumber() {
		return displayOrderNumber;
	}

	public void setDisplayOrderNumber(int displayOrderNumber) {
		this.displayOrderNumber = displayOrderNumber;
	}

}
