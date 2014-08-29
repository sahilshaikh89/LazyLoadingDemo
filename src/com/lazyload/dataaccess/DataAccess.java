package com.lazyload.dataaccess;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.fluttercode.datafactory.impl.DataFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.lazyload.model.Person;
import com.lazyloading.tag.form.Template;

public class DataAccess {
	public static String filterName;
	public List<Person> getPersonList(Long begin, Long end, String filterName) throws Exception{
		
		try {
			DataAccess.filterName = filterName;
			ArrayList<Person> personList = new ArrayList<Person>();
			
			//GET DATA FROM JSON FILE
			InputStream in = getClass().getClassLoader().getResourceAsStream("com/lazyload/util/Person.json");
			InputStreamReader ir = new InputStreamReader(in);
		
			//Custom filter to seach string inside personName. This will demonstrate the requestAttr of lazyloading
			Filter myFilter = new Filter.FilterAdapter<Map<String, Object>>(){
                @Override
                public boolean accept(Map<String, Object> map) {
                	String name = map.get("personName").toString();
                	if(DataAccess.filterName == null || name.contains(DataAccess.filterName)) 
                	      return true; 
                	
                	return false;
                }
            };
			
			List<Object> objects = JsonPath.read(in, "$.person[?]", myFilter);
			
			Long count = begin;
			while(count < end && count < objects.size()){
				Person person = new Person();				
				Gson gson = new GsonBuilder().create();				
				person = gson.fromJson(objects.get(count.intValue()).toString(), Person.class);
				
				ArrayList<String> hobbies = new ArrayList<String>();
				
				hobbies.add("Hobby 1");
				hobbies.add("Hobby 2");
				hobbies.add("Hobby 3");
				
				person.setHobbies(hobbies);
				personList.add(person);

				count++;
			}
			
			return personList;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}
	
public Long getPersonCount(String filterName) throws Exception{
		
		try {
			
			DataAccess.filterName = filterName;
			ArrayList<Person> personList = new ArrayList<Person>();
			
			//GET DATA FROM JSON FILE
			InputStream in = getClass().getClassLoader().getResourceAsStream("com/lazyload/util/Person.json");
			InputStreamReader ir = new InputStreamReader(in);
		
			//Custom filter to seach string inside personName. This will demonstrate the requestAttr of lazyloading
			Filter myFilter = new Filter.FilterAdapter<Map<String, Object>>(){
                @Override
                public boolean accept(Map<String, Object> map) {
                	String name = map.get("personName").toString();
                	if(DataAccess.filterName == null || name.contains(DataAccess.filterName)) 
                	      return true; 
                	
                	return false;
                }
            };
			
			List<Object> objects = JsonPath.read(in, "$.person[?]", myFilter);
			
			return new Long(objects.size());
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}
//public static void main(String[] args) throws Exception {
//	DataAccess da = new DataAccess();
//	
//	da.getPersonList(0L, 10L, "N");
//}
	
}
