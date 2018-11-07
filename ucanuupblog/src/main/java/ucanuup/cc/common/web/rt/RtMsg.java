package ucanuup.cc.common.web.rt;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class RtMsg<T> implements RtBaseInter{
	
	public RtMsg() {
		this.status = true;
		this.code = "200";
		this.msg = null;
	}
	
	public RtMsg(RtType rtType,T msg) {
		if(rtType.getValue().equals("200")) {
			this.status = true;
		}else {
			this.status = false;
		}
		this.code = rtType.getValue();
		this.msg = msg;
	}
	/**
	 * 系统状态， 真为成功  false为失败
	 */
	private Boolean status;
	/**
	 * 系统状态， 异常编码
	 */
	private String code;
	/**
	 * 系统异常信息，或者成功信息
	 */
	private T  msg;

	@Override
	public Boolean getStatus() {
		return status;
	}

	@Override
	public String getCode() {
		return code;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}

	public T getMsg() {
		return msg;
	}

	@JsonIgnore
	@Override
	public Object getContent() {
		return msg;
	}
}
