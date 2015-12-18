package com.continent.web.utils;


import java.util.List;

import org.dozer.DozerBeanMapper;


public class MapperUtils {
//	static String counts[] = { "dozer_mapping.xml" };
//	static DozerBeanMapper mapper = new DozerBeanMapper(Arrays.asList(counts));
	public static <T, U> void map(DozerBeanMapper mapper,List<T> source, List<U> dest,Class<U> destType) {

		for (T element : source) {
		dest.add(mapper.map(element, destType));
		}
		}
	
	public static <T,U> U map(DozerBeanMapper mapper,T source,Class<U> destype){

		return  mapper.map(source,destype);
		
	}

}
