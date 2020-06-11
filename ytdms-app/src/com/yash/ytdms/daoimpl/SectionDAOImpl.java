package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.yash.ytdms.dao.SectionDAO;
import com.yash.ytdms.domain.Section;
import com.yash.ytdms.util.JNDIUtil;

public class SectionDAOImpl extends JNDIUtil implements SectionDAO {

	@Override
	public void save(Section section) {
		String sql = "insert into sections(name,description,categoryId,documentStatus,displayOrderNumber) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = preparedStatement(sql);
			pstmt.setString(1, section.getName());
			pstmt.setString(2, section.getDescription());
			pstmt.setInt(3, section.getCategoryId());
			pstmt.setInt(4, section.getDocumentStatus());
			pstmt.setInt(5, section.getDisplayOrderNumber());
			pstmt.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		closeConnection();

	}

	@Override
	public List<String> listCategories() {
		List<String> categories = new ArrayList<>();
		String sql = "  SELECT DISTINCT NAME FROM categories ";
		PreparedStatement psmt;
		try {
			PreparedStatement pstmt = preparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
             	categories.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return categories;

	}
@Override
	public Map<Section, String> listSection(int numberOfSections) {
		System.out.println(numberOfSections);
		LinkedHashMap<Section, String> sections = new LinkedHashMap<>();
		String categoryName;
		Section section = null;
		String sql = "SELECT s.id, s.`name` ,  s.`description`,c.`name` FROM sections s  INNER JOIN    categories  c WHERE s.`categoryId`=c.`id` order by s.id desc LIMIT ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = preparedStatement(sql);
			pstmt.setInt(1, numberOfSections);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				section = new Section();
				section.setId(rs.getInt(1));
				section.setName(rs.getString(2));
				section.setDescription(rs.getString(3));
      	      	categoryName = rs.getString(4);
				sections.put(section, categoryName);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return sections;

	}

	@Override
	public Map<Section, String> listSection() {
		LinkedHashMap<Section, String> sections = new LinkedHashMap<>();
		String categoryName;
		Section section = null;
		String sql = "SELECT s.id, s.`name` ,  s.`description`,c.`name` FROM sections s  INNER JOIN    categories  c WHERE s.`categoryId`=c.`id` order by displayOrderNumber";
		PreparedStatement pstmt = null;
		try {
			pstmt = preparedStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				section = new Section();
				section.setId(rs.getInt(1));
				section.setName(rs.getString(2));
				section.setDescription(rs.getString(3));
				categoryName = rs.getString(4);
				sections.put(section, categoryName);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return sections;
	}

	@Override
	public Map<Section, String> getSections(String pageName, int page) {
		LinkedHashMap<Section, String> sections = new LinkedHashMap<>();
		String categoryName;
		Section section = null;
		String sql = "SELECT s.id, s.`name` ,  s.`description`,c.`name` FROM sections s  INNER JOIN    categories  c WHERE s.`categoryId`=c.`id`";
		PreparedStatement pstmt = null;
		int countSection = 0;
		try {
			pstmt = preparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (page > countSection) {
					countSection++;
				} else {
					section = new Section();
					section.setId(rs.getInt(1));
					System.out.println(section);
					section.setName(rs.getString(2));
					section.setDescription(rs.getString(3));

					System.out.println(section);
					categoryName = rs.getString(4);
					sections.put(section, categoryName);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return sections;
	}

	/**
	 * this updateForm get the data from table and set it into the Section objetct.
	 * return the Section object.
	 */
	@Override

	public Section updateForm(int id) {
		Section section = null;
		String sql = "select * from sections where id=?";
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			preparedStatement.setInt(1, id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				section = new Section();
				section.setId(rs.getInt("id"));
				section.setName(rs.getString("name"));
				section.setDescription(rs.getString("description"));
				System.out.println(rs.getInt("id"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return section;

	}

	@Override
	public void update(int id, String name, String description, String category) {
		int catId = getId(category);
		String sql = "UPDATE sections SET name='" + name + "',description='" + description + "',categoryId='" + catId
				+ "' WHERE id=" + id;

		PreparedStatement preparedStatement = preparedStatement(sql);
		System.out.println(preparedStatement);
		try {
			preparedStatement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();

	}

	/**
	 * it is the helper method for update method
	 * 
	 * @param category it take the category name as paramete
	 * @return it return the category id.
	 */
	private int getId(String category) {
		String sql = "select id from categories where name=?";
		ResultSet rs = null;
		int catId = 0;
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			preparedStatement.setString(1, category);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		try {
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				try {
					catId = rs.getInt("id");
					System.out.println(catId + "===============");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			} else {

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return catId;
	}

	@Override
	public void delete(int id) {
		int docId = getDocId(id);
		if (docId == 0) {
			String sql = "delete from sections where id=?";
			PreparedStatement preparedStatement = preparedStatement(sql);
			try {
				preparedStatement.setInt(1, id);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			try {
				preparedStatement.execute();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		closeConnection();
	}

	/**
	 * This getDocId() is helper method for delete() method.
	 * 
	 * @param id it take id for get doc id from sections table
	 * @return it return the docId
	 */
	private int getDocId(int id) {

		String sql = "select documentStatus from sections where id=?";
		ResultSet rs = null;
		int docId = 0;
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			preparedStatement.setInt(1, id);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		try {
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				try {
					docId = rs.getInt("documentStatus");
					System.out.println(docId + "===============");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return docId;

	}

	@Override
	public Map<Section, String> search(String searchItem) {
		Map<Section, String> sections = new LinkedHashMap<>();
		Section section;
		String categoryName;
		String sql = "SELECT s.id,s.name,s.description,c.name AS categoryName FROM sections s INNER JOIN categories c ON s.categoryId=c.id WHERE s.NAME LIKE ?";
		PreparedStatement psmt = preparedStatement(sql);
		try {
			psmt.setString(1, "%"+searchItem+"%");
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				section=new Section();
				section.setId(rs.getInt("id"));
				section.setName(rs.getString("name"));
				section.setDescription(rs.getString("description"));
				categoryName=rs.getString("categoryName");
				sections.put(section, categoryName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return sections;
	}
	// VIJAY
	@Override
	public void changeRecordDisplayOrder(int id) {
		String sql = "SELECT  s1.id,s1.displayOrderNumber,s2.id AS replaceId, s2.displayOrderNumber AS replaceOrderNumber FROM sections s1 INNER JOIN sections s2 ON s1.displayOrderNumber>s2.displayOrderNumber AND s1.id=? limit 1"; 
		chnageDisplayOrder(id, sql);
	}

	@Override
	public void changeRecordDisplayOrderDown(int id) {
		String sql = "SELECT  s1.id,s1.displayOrderNumber,s2.id AS replaceId, s2.displayOrderNumber AS replaceOrderNumber FROM sections s1 INNER JOIN sections s2 ON s1.displayOrderNumber<s2.displayOrderNumber AND s1.id=? limit 1"; 
		chnageDisplayOrder(id, sql);
		
	}

	private void chnageDisplayOrder(int id, String sql) {
		try {
			PreparedStatement pstmt = preparedStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int replaceId = rs.getInt("replaceId");
				int displayOrderNumber = rs.getInt("displayOrderNumber");
				int replaceOrderNumber = rs.getInt("replaceOrderNumber");
				String updateSql = "update sections set displayOrderNumber=" + replaceOrderNumber + " where id=" + id;
				PreparedStatement pstmt1 = preparedStatement(updateSql);
				pstmt1.execute();

				String updateSql1 = "update sections set displayOrderNumber=" + displayOrderNumber + " where id="
						+ replaceId;
				PreparedStatement pstmt2 = preparedStatement(updateSql1);
				pstmt2.execute();
			}
			} catch (SQLException e) {
	    e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
}
