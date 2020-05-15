package com.ashwani.slambook.util;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class SlamUitls {

	public static final boolean isNullOrZero(final Long o) {
		if(o==null) {
			return true;
		}
		else if(o==0) {
			return true;
		}
		return false;
	}
	
	public static final boolean isNullOrEmpty(Object o) {
		if(o==null) {
			return true;
		}
		if(o instanceof String && ((String) o).length()==0) {
			return true;
		}
		else if(o instanceof Map &&((Map) o ).size()==0) {
			return true;
		}
		else if(o instanceof Collection && ((Collection) o).size() == 0) {
			return true;
		}
		else if( o instanceof Object[] && ((Object[]) o).length == 0) {
			return true;
		}
		return false;
	}
	
	public static final Date getCurentDate() {
		Date date = new Date();
		return date;
	}
	
	
}
