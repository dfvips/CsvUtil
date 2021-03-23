package entity;

public class tableBrush {
	private String orderNum;
	private String personName;
	private String personPhone;
	
	public tableBrush() {
		
	}
	
	public  tableBrush(String orderNum,String personName,String personPhone) {
		this.orderNum = orderNum;
		this.personName = personName;
		this.personPhone = personPhone;
	}
	

	@Override
	public String toString() {
		return "tablebrush [orderNum=" + orderNum + ", personName=" + personName + ", personPhone=" + personPhone + "]";
	}

	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
} 
