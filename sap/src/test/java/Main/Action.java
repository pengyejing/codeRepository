package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import Servlet.GetMessage;

/**
 * 测试与SAP的链接状况
 * 
 * @author HCC
 *
 */
public class Action {

	@Test
	public void testConnectSAP() {
		String xml = "";
		Map<String, String> conditionMap = new HashMap<String, String>();
//		conditionMap.put("RFC_NAME", "ZWFDMM_VENDOR_EAIOUTPUT");
//		conditionMap.put("ZENDDATE", "9999-12-31");
//		conditionMap.put("ZENDTIME", "00:00:00");
//		conditionMap.put("ZSTARTDATE", "2014-03-28");
//		conditionMap.put("ZSTARTTIME", "11:12:05");
		conditionMap.put("RFC_NAME", "ZRFC_MD_PC_EAI");
		conditionMap.put("I_BDATE", "2015-12-11");
		conditionMap.put("I_BTIME", "00:00:00");
		conditionMap.put("I_EDATE", "");
		conditionMap.put("I_ETIME", "");
		conditionMap.put("I_WERKS", "8200");
		try {
			xml = GetMessage.LoadBorrowMoneyBalance(conditionMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>> " + xml);
	}

}
