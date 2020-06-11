package com.yash.ytdms.factory;

import com.yash.ytdms.dao.SectionDAO;
import com.yash.ytdms.daoimpl.SectionDAOImpl;
import com.yash.ytdms.service.SectionService;
import com.yash.ytdms.serviceimpl.SectionServiceImpl;

/**
 * This object factory is used to get the Implementation object based on reference type
 * You need to copy paste the if block and change the Reference type as per your requirement. 
 * If condition is met successfully, return the implementation object. 
 * @author samay.jain
 *
 */
public class ObjectFactory {

	public static Object getObject(Class refClassName) {
		
		if(refClassName == SectionDAO.class) {
			return (Object) new SectionDAOImpl();
		}
		
		if(refClassName == SectionService.class) {
			return (Object) new SectionServiceImpl();
		}
		return null;
	}

}
