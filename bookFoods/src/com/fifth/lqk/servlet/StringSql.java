package com.fifth.lqk.servlet;

public class StringSql {
	public String appendstring(String rsname,String location){
		StringBuffer sbsql = new StringBuffer("select * from restaurants");
		System.out.println(rsname+"=="+location);
		if(!"Resturant Name".equals(rsname) && !"null".equals(location)){
			sbsql.append(" where rname like '%"+rsname+"%'"+" and rlocation like '%"+location+"%'");	
		}
		else if(!"Resturant Name".equals(rsname) && "null".equals(location)){
			sbsql.append(" where rname like '%"+rsname+"%'");	
		}
		else if("Resturant Name".equals(rsname) && !"null".equals(location)){
			sbsql.append(" where rlocation like '%"+location+"%'");	
		}else{
			sbsql.append(";");
		}
			
		return sbsql.toString();
	}
}
