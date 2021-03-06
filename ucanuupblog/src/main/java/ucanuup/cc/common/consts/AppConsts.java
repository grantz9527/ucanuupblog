package ucanuup.cc.common.consts;

public final class AppConsts {
	/*==========================================================================
	 *==========================================================================
	 *==========================================================================
	 *========================= 【数据库字段常量  】  =============================
	 *==========================================================================
	 *==========================================================================
	 *==========================================================================*/
	/**
	 * 不存在，已经删除 【DELETED 字段-所有表】
	 */
	public static final int DELETED_REMOVE = 1;

	/**
	 *  存在，未删除【DELETED 字段-所有表】
	 */
	public static final int DELETED_EXIST = 0;

	/**
	 * 激活【STATUS 字段-所有表】
	 */
	public static final int STATUS_ACTIVE = 1;
	/**
	 * 失效【STATUS 字段-所有表】
	 */
	public static final int STATUS_UNACTIVE = 0;

	/*==========================================================================
	 *==========================================================================
	 *==========================================================================
	 *=========================   【日志信息常量  】  =============================
	 *==========================================================================
	 *==========================================================================
	 *==========================================================================*/
	/**错误 日志表的  超时记录标记*/
	public static final long LOG_METHOD_LOG_FLAG = 3000L;
	/**错误 日志表的  高耗时类型*/
	public static final String LOG_CODE_HIGH_WASTE = "HIGHWASTE";
	/**错误 日志表的  控制层执行错误信息*/
	public static final String LOG_CODE_ERROR = "ERROR";

	/*==========================================================================
	 *==========================================================================
	 *==========================================================================
	 *=========================   【HTTP 请求常量  】  =============================
	 *==========================================================================
	 *==========================================================================
	 *==========================================================================*/
	/**httpclient socket 超时*/
	public static final int HTTPCLIENT_SOCKET_TIME_OUT = 30000;
	/**httpclient 连接超时*/
	public static final int HTTPCLIENT_CONNECT_TIME_OUT = 30000;
	
	public static final String ACT_COMPANY_DEFAULT = "default";
}
