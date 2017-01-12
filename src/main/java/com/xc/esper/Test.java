package com.xc.esper;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/** 
* @ClassName: Test 
* @Description: TODO
* @author xuechen
* @date 2017年1月12日 下午3:42:21
*  
*/
public class Test {
	
	private static EPRuntime runtime;
	
	static {	
		EPServiceProvider ePService = EPServiceProviderManager.getDefaultProvider();
		
		EPAdministrator admin = ePService.getEPAdministrator();
		
		String product = Apple.class.getName();
		String epl = "select avg(price) as avgPrice from " + product + " .win:length_batch(3)";
		
		EPStatement state = admin.createEPL(epl);
		state.addListener(new AppleListener());
		
		runtime = ePService.getEPRuntime();
	}

	public static void main(String[] args) {
		Apple apple1 = new Apple();
		apple1.setId(1);
		apple1.setPrice(5.7);
		runtime.sendEvent(apple1);
		
		Apple apple2 = new Apple();  
        apple2.setId(2);  
        apple2.setPrice(2.3);  
        runtime.sendEvent(apple2);  
  
        Apple apple3 = new Apple();  
        apple3.setId(3);  
        apple3.setPrice(5.1);  
        runtime.sendEvent(apple3);
		
	}
}
