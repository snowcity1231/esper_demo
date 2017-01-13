package com.xc.esper.type.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.xc.esper.Apple;
import com.xc.esper.AppleListener;

/** 
* @ClassName: TestPojoEsper 
* @Description: TODO
* @author xuechen
* @date 2017年1月13日 上午9:13:19
*  
*/
public class TestPojoEsper {

	private static EPRuntime runtime;
	
	static {	
		EPServiceProvider ePService = EPServiceProviderManager.getDefaultProvider();
		
		EPAdministrator admin = ePService.getEPAdministrator();
		
		String person = Person.class.getName();
		//case1 - 得到姓名、孩子列表、地址bean(需要属性具有getter方法)
//		String epl = "select name,children,address from " + person;
		//case 2 - 得到第二个孩子、家里电话以及所在城市(需修改Person的get方法)
		String epl = "select children[1] as child, phones('home') as homephone, address.city as city from " + person;
		
		EPStatement state = admin.createEPL(epl);
		state.addListener(new UpdateListener() {
			
			@Override
			public void update(EventBean[] newArgs, EventBean[] orgArgs) {
				if(newArgs != null) {
					//begin print case1
//					String name = (String) newArgs[0].get("name");
//					List<Child> children = (List<Child>) newArgs[0].get("children");
//					Address address = (Address) newArgs[0].get("address");
//					System.out.println("name:" + name + "|children:" + children.size() + "|address:" + address.getProvince() + "省" + address.getCity() + "市");
					//begin print case2
					Child child = (Child) newArgs[0].get("child");
					int phone = (int) newArgs[0].get("homephone");
					String city = (String) newArgs[0].get("city");
					System.out.println(child.getName() + "-" + phone + "-" + city);
				}
				
			}
		});
		
		runtime = ePService.getEPRuntime();
	}
	
	public static void main(String[] args) {
		Child child1 = new Child("tom", 1);
		Child child2 = new Child("Lilith", 0);
		List<Child> list = new ArrayList<>();
		list.add(child1);
		list.add(child2);
		Address address = new Address("河南", "驻马店");
		Map<String, Integer> phones = new HashMap<>();
		phones.put("home", 12345);
		Person person = new Person("jack", list, phones, address);
		runtime.sendEvent(person);
		
		Child child3 = new Child("Raj", 1);
		Child child4 = new Child("Selina", 0);
		List<Child> list2 = new ArrayList<>();
		list2.add(child3);
		list2.add(child4);
		Address address2 = new Address("北京", "周口店");
		Map<String, Integer> phones2 = new HashMap<>();
		phones2.put("home", 22222);
		Person person2 = new Person("Dave", list2, phones2, address2);
		runtime.sendEvent(person2);
		
	}
}
