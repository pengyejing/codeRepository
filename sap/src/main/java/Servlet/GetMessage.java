package Servlet;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import Connection.SAPConn;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

import exception.NoRFC_NAME_Exception;

public class GetMessage {

	/**
	 * 链接SAP，通过参数获取相关数据
	 * @param conditionMap条件参数 Map类型（key:参数名， value:参数值）
	 * @return
	 * @throws IOException
	 */
	private static Logger log = Logger.getLogger(GetMessage.class);
	
	public static String LoadBorrowMoneyBalance(
			Map<String, String> conditionMap) throws IOException {

		String RFC_NAME = "";// ZWFDMM_VENDOR_EAIOUTPUT
		String xml = "";
		JCoFunction function = null;
		JCoParameterList tables = null;	
		
		JCoDestination destination = SAPConn.connect();// 获得SAP链接
		RFC_NAME = conditionMap.get("RFC_NAME");
		if (RFC_NAME == null || RFC_NAME == "") {
			try {
				log.error("GetMessage.LoadBorrowMoneyBalance: conditionMap = " + conditionMap);
				throw new NoRFC_NAME_Exception("缺少RFC名称：请输入RFC_NAME");
			} catch (NoRFC_NAME_Exception e) {
				e.printStackTrace();
			}
		}
		conditionMap.remove("RFC_NAME");
		try {
			// 调用RFC函数
			function = destination.getRepository().getFunction(RFC_NAME);
			// 将当前传入的值赋予各个参数
			for (Map.Entry<String, String> enty : conditionMap.entrySet()) {
				function.getImportParameterList().setValue(enty.getKey(),
						enty.getValue());
			}
			function.execute(destination);
			tables = function.getTableParameterList();
			xml = tables.toXML();
		} catch (JCoException e) {
			e.printStackTrace();
		}
		return xml;
	}
}
