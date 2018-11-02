package ucanuup.cc.common.web.rt;

/**
 * 此处为返回的基础信息接口
 * @author N0042171
 */
public interface RtBaseInter {

	/**
	 * 获取状态数据
	 */
	boolean getStatus();
	/**
	 * @Title:  RtBaseInter.java   
	 * @Package ucanuup.cc.common.web.returninfo   
	 * @Description:    获取编码信息
	 * @author: WenBin     
	 * @date:   2018年10月18日 下午4:14:25   
	 * @version V1.0 
	 * @Copyright: 2018
	 */
	String getCode();
	/**
	 * @Title:  RtBaseInter.java   
	 * @Package ucanuup.cc.common.web.returninfo   
	 * @Description:    获取信息对象  
	 * @author: WenBin     
	 * @date:   2018年10月18日 下午4:14:39   
	 * @version V1.0 
	 * @Copyright: 2018
	 */
	Object getContent();
}
