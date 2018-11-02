package ucanuup.cc.common.web.rt;

import java.util.HashMap;
import java.util.Map;

public enum RtType {
	OK("200"),
	VALID("-1"),
	QQERROR("-2"),
	PROCESS("-3"),
	SYSTEM_ERROR("500");
	
	RtType(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	private static final Map<String,String> map = new HashMap<String,String>();
	
	static {
		map.put("200", "成功");
		map.put("50", "校验数据异常！");
		map.put("500", "系统程序运行错误");
	}
	
	@Override
	public String toString() {
		return "["+value+"]"+map.get(value);
	}
}
