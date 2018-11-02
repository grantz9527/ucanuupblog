package ucanuup.cc.common.web.query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseQueryModel implements BaseQuery{
	
	private Integer pageNo;
	
	private Integer pageSize;
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public Integer getPageNo() {
		return pageNo == null ? DEFAULT_PAGE_NO : pageNo;
	}

	@Override
	public Integer getPageSize() {
		return pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
	}

	/**
	 * @Title:  BaseQueryModel.java   
	 * @Package ucanuup.cc.common.web.query   
	 * @Description:   对象转回为map集合  
	 * @author: WenBin     
	 * @date:   2018年10月22日 上午11:15:50   
	 * @version V1.0 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @Copyright: 2018
	 */
	@Override
	@JsonIgnore
	public Map<String, Object> castMapObjects() throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		List<Field> fields = new ArrayList<>();
		Class<?> tempClass = this.getClass();
		while (tempClass != null && !tempClass.getName().toLowerCase().equals("java.lang.object")) {
			//当父类为null的时候说明到达了最上层的父类(Object类).
			fields.addAll(Arrays.asList(tempClass .getDeclaredFields()));
		    tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
		}
		for(Field f : fields){
			f.setAccessible(true);
			String name = f.getName();
			params.put(name, f.get(this));
		}
		return params ;
	}

	/**
	 * 
	 * @Title:  BaseQueryModel.java   
	 * @Package ucanuup.cc.common.web.query   
	 * @Description:    对象转换为指定的对象
	 * @author: WenBin     
	 * @date:   2018年10月22日 上午11:14:48   
	 * @version V1.0 
	 * @Copyright: 2018
	 */
	@Override
	@JsonIgnore
	public <T> T cast2Object(Class<T> t)  throws Exception{
		T rt = t.newInstance();
		BeanUtils.copyProperties(this, rt);
		return rt;
	}

}
