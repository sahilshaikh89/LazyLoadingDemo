package com.lazyload.model;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lazyload.dataaccess.DataAccess;
import com.lazyloading.tag.util.ProviderUtil;

public class LazyPerson extends Person{

	@Override
	public List<?> lazyLoad(Long begin, Long end, HttpServletRequest request,
			HashMap<String, String> requestAttr) throws Exception {
		
		try {
			DataAccess dataAccess = new ProviderUtil().getBeanByType(DataAccess.class);
								
			return dataAccess.getPersonList(begin, end, requestAttr.get("personName"));
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}
	
	@Override
	public Long lazyLoadTotalCount(HttpServletRequest request,
			HashMap<String, String> requestAttr) throws Exception {
		try {
			DataAccess dataAccess = new ProviderUtil().getBeanByType(DataAccess.class);
								
			return dataAccess.getPersonCount(requestAttr.get("personName"));
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
}
