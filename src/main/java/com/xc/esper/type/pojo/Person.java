package com.xc.esper.type.pojo;

import java.util.List;
import java.util.Map;


/** 
* @ClassName: Person 
* @Description: 复杂数据类型
* @author xuechen
* @date 2017年1月12日 下午6:00:03
*  
*/
public class Person {

	String name;
	List<Child> children;
	Map<String, Integer> phones;
	Address address;
	/**
	 * @param name
	 * @param children
	 * @param phones
	 * @param address
	 */
	public Person(String name, List<Child> children, Map<String, Integer> phones, Address address) {
		this.name = name;
		this.children = children;
		this.phones = phones;
		this.address = address;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the children
	 */
	public List<Child> getChildren() {
		return children;
	}
	
	/**
	 * 获取指定第几个孩子
	 * @param index
	 * @return
	 */
	public Child getChild(int index) {
		return children.get(index);
	}
	
	/**
	 * @return the phones
	 */
	public Map<String, Integer> getPhones() {
		return phones;
	}
	
	/**
	 * 获取指定的电话
	 * @param name
	 * @return
	 */
	public int getPhones(String name) {
		return phones.get(name);
	}
	
	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Map<String, Integer> phones) {
		this.phones = phones;
	}
	public void setPhones(String name, Integer number){  
        phones.put(name, number);  
    }  
	
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	

}

class Child {
	String name;
	int gender;
	
	/**
	 * @param name
	 * @param gender
	 */
	public Child(String name, int gender) {
		this.name = name;
		this.gender = gender;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}
	
}

class Address {
	String province;
	String city;
	
	/**
	 * @param province
	 * @param city
	 */
	public Address(String province, String city) {
		this.province = province;
		this.city = city;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
}
