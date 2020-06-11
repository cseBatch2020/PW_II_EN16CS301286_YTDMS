package com.yash.ytdms.service;

import java.util.List;
import java.util.Map;

import com.yash.ytdms.domain.Section;
import com.yash.ytdms.exception.SectionException;

public interface SectionService {
	
	public static int DOCUMENT_STATUS=0;	
	
		/**
		 * This method will add section
		 * @param section to be added
		 * @throws SectionException 
		 */
		void addSection (Section section) throws SectionException;
		
		/**
		 * This method will return the category id 
		 * @param categoryName for which categoryId should be retrieve
		 * @return categoryId
		 */
		
		List<String> listCategories();
		
		Map<Section, String> listSection(int sections);

		Map<Section, String> listSection();

		Map<Section, String> getSections(String pageName, int page, int i);
        
		Section updateForm(int id);

		void update(int id, String name, String description, String category) throws SectionException;

		void delete(int id);

		int getCategoryId(String parameter);
		

		/**
		 * This method will display the list of matched sections with their category name
		 * @param searchItem is the name of section 
		 * @return Map of section object and category name
		 */
		Map<Section, String> searchSections(String searchItem);

		/**
		 * This method will display the list of section grouped by category name from the database
		 * @return map of section object and category name
		 */
		Map<Section, String> categorizeByCategoyName();

		void changeSectionDisplayOrder(int id);

		void changeDownSectionDisplayOrder(int id);

		/**
		 * This method will filter the sections category name wise
		 * @param categoryName for which filtering will be done
		 * @return return the map of section object and category name
		 */
		Map<Section, String> filterbyCategortyName(String categoryName);

		
	

}
