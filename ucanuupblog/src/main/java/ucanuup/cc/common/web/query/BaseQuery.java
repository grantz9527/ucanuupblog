package ucanuup.cc.common.web.query;

import java.util.Map;

public interface BaseQuery {
	
	public static final Integer DEFAULT_PAGE_NO = 0;
	
	public static final Integer DEFAULT_PAGE_SIZE = 10;

	Integer getPageNo();
	
	Integer getPageSize();
	
	Map<String,Object>  castMapObjects() throws Exception;
	
	<T extends Object> T  cast2Object(Class<T> t)  throws Exception;
}
