package com.yash.ytdms.dao;

import java.util.List;
import java.util.Map;

import com.yash.ytdms.domain.Section;

/**
 * 
 * @author vijay.solanki
 *
 */
public interface SectionDAO {

	/**
	 * This method will save the section in Database
	 */
	void save(Section section);
	/**
	 * This method will show all the section from Database
	 * return null if no section found in the Database
	 * @param user
	 */
	
	List<String> listCategories();
	/**
	 * This method will display the fix number of section
	 * @param numberOfSections to be displayed
	 * @return
	 */
	  Map<Section, String> listSection(int numberOfSections) ;
	/**
	 * This method will return all sections with corresponding category name from the section table of database
	 * @return section from the database 
	 */
	  Map<Section, String> listSection();
	/**
	 * This method will return all the sections 
	 * @param pageName
	 * @param page
	 * @return
	 */
	Map<Section, String> getSections(String pageName,int page);
	/**
	 * This updateForm method give the section info from the  sections table.
	 * @param id take the id as parameter which is int
	 * @return it return the section object.
	 */
	Section updateForm(int id);
	/**
	 * This update method update the sections table  according to id. 
	 * @param id it take the id of section
	 * @param name it take the name of section
	 * @param description it take the description of section
	 * @param category 
	 */
	void update(int id, String name, String description, String category);
	/**
	 * This update method update the sections table  according to id. 
	 * @param id it take the id of section
	 * @param name it take the name of section
	 * @param description it take the description of section
	 * @param category 
	 */
	void delete(int id);
	/**
	 * This method will return the section list with their corresponding name from the database
	 * @param searchItem is the name of section or search item
	 * @return the map of Section object and Category name
	 */
	Map<Section, String> search(String searchItem);
	void changeRecordDisplayOrder(int id);
	void changeRecordDisplayOrderDown(int id);
	
}
