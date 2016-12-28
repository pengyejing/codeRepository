package common;

/**
 * java链接SAP的参数
 * @author HCC
 *
 */
public class JCO_Parameters {

	/**
	 * 服务器IP
	 */
	public static final String JCO_ASHOST = "10.226.64.13";
	
	/**
	 * 系统编号
	 */
	public static final String  JCO_SYSNR = "00";
	
	/**
	 * SAP集团
	 */
	public static final String JCO_CLIENT = "180";
	
	/**
	 * SAP用户名
	 */
	public static final String JCO_USER = "EAI_LDPV";
	
	/**
	 * SAP密码
	 */
	public static final String JCO_PASSWD = "ldpv5050";
	
	/**
	 * 登录语言
	 */
	public static final String JCO_LANG = "zh";
	
	/**
	 * 最大链接数
	 */
	public static final String JCO_POOL_CAPACITY = "3";
	
	/**
	 * 最大链接线程
	 */
	public static final String JCO_PEAK_LIMIT = "10";
	
}
