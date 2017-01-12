package com.xc.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/** 
* @ClassName: AppleListener 
* @Description: TODO
* @author xuechen
* @date 2017年1月12日 下午3:40:10
*  
*/
public class AppleListener implements UpdateListener{

	/* (non-Javadoc)
	 * @see com.espertech.esper.client.UpdateListener#update(com.espertech.esper.client.EventBean[], com.espertech.esper.client.EventBean[])
	 */
	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if(newEvents != null) {
			Double avg = (Double) newEvents[0].get("avgPrice");
			System.out.println("Apple's average price is $" + avg);
		}
		
	}

}
