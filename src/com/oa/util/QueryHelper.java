package com.oa.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	private String from = "";
	private String where = "";
	private String orderBy = "";
	private List<Object> prment = new ArrayList<Object>();
	public QueryHelper(Class clazz,String s){
		from += "FROM "+clazz.getSimpleName()+" "+s;
	}
	public void setWhere(String st,Object ... objs){
		if(where.length()<1){
			where += " WHERE "+st;
		}else{
			where += " AND "+st;
		}
		if(objs!=null)
			for(Object obj :objs){
				prment.add(obj);
			}
	}
	public void setOrderBy(String st,boolean asc){
		if(orderBy.length()<1){
			orderBy += " ORDER BY "+st+" "+(asc?"ASC":"DESC");
		}else{
			orderBy += " , "+st+" "+(asc?"ASC":"DESC");
		}
	}
	
	public String getCountHql(){
		return "SELECT COUNT(*) "+from+where;
	}
	
	public String getHql(){
		return from+where+orderBy;
	}
	public List<Object> getPrment() {
		return prment;
	}
	
	
}
