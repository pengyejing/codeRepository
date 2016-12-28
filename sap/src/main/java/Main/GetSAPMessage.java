package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import Servlet.GetMessage;

/**
 * 与mule交互的类 
 * 接收mule传入的相关参数 返回结果集到mule上
 * @author HCC
 *
 */
public class GetSAPMessage extends AbstractMessageTransformer {

	private static Logger log = Logger.getLogger(GetSAPMessage.class);
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		String json = "";
		String xml = "";
		Map<String, String> conditionMap = new HashMap<String, String>();
		
		try {
			json = message.getPayloadAsString(); // 获取mule上传过来的json格式的字符串
		} catch (Exception e1) {
			log.error("GetSAPMessage.transformMessage: json = " + json);
			e1.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject(json);
		@SuppressWarnings("unchecked")
		Iterator<String> it = jsonObject.keys();
		while (it.hasNext()) {
			String key = it.next();
			String value = jsonObject.getString(key);
			conditionMap.put(key, value);
		}
		try {
			xml = GetMessage.LoadBorrowMoneyBalance(conditionMap);
		} catch (IOException e) {
			log.error("GetSAPMessage.transformMessage: xml = " + xml);
			e.printStackTrace();
		}
		return xml;
	}

}
