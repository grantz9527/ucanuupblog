package ucanuup.cc.common.utils;

/**
 *
 */
public final class StringUtil {

	/**
	 * @Title:  StringUtil.java   
	 * @Package ucanuup.cc.string   
	 * @Description:    是否不为空, true 是  false 否
	 * @author: WenBin     
	 * @date:   2018年10月22日 下午12:26:52   
	 * @version V1.0 
	 * @Copyright: 2018
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	/**
	 * @Title:  StringUtil.java   
	 * @Package ucanuup.cc.string   
	 * @Description:    是否为空  true 是  false 否
	 * @author: WenBin     
	 * @date:   2018年10月22日 下午12:26:32   
	 * @version V1.0 
	 * @Copyright: 2018
	 */
	public static boolean isEmpty(String str){
		
		if(str==null){
			return true;
		}
		if(str.equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * @Title:  StringUtil.java   
	 * @Package ucanuup.cc.string   
	 * @Description:   转换为like查询字段  
	 * @author: WenBin     
	 * @date:   2018年10月22日 下午12:28:38   
	 * @version V1.0 
	 * @Copyright: 2018
	 */
	public static String addSqlLike(String str) {
		if(isEmpty(str)) {
			return "%";
		}else {
			return "%"+str+"%";
		}
	}
}
