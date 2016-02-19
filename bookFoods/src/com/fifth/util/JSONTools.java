package com.fifth.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JSONTools {
	public static String getJson(Object object){
		return JSON.toJSONString(object);
	}
	
	/**
	 * 转换为JavaBean 对象
	 * @param jsonStr
	 * @return JavaBean
	 */
	public static <T> T getObject (String jsonStr, Class<T> cls){
		T t = null;
		t = JSON.parseObject(jsonStr, cls);
		return t;
	}
	
	public static <T> List<T> getList (String jsonStr, Class<T> cls){
		List<T> list = null;
		list = JSON.parseArray(jsonStr, cls);
		return list;
	}
	
	public static void  test(){
		JSON.parseObject("", new TypeReference<Map<String,List<String>>>(){});
	}
}
