package com.bean;

public class CustomerBean {
	//properties
	private String custId;
    private String custName;
	//cons setter getter toString
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBean(String custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@Override
	public String toString() {
		return "CustomerBean [custId=" + custId + ", custName=" + custName + "]";
	}
	

}
