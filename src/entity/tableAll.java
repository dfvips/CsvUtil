package entity;

public class tableAll {
	private  String goodsName;
	private String orderNum;
	private String personName;
	private String personPhone;
	private String perPlace;
	private String goodId;
	private String time;
	
	public tableAll() {
		
	}
	
	public  tableAll(String goodsName,String orderNum,String personName,String personPhone,String perPlace,String goodId,String time) {
		this.goodsName = goodsName;
		this.orderNum = orderNum;
		this.personName = personName;
		this.personPhone = personPhone;
		this.perPlace = perPlace;
		this.goodId = goodId;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "tableAll [goodsName=" + goodsName + ", orderNum=" + orderNum + ", personName=" + personName
				+ ", personPhone=" + personPhone + ", perPlace=" + perPlace + ", goodId=" + goodId + ", time=" + time
				+ "]";
	}

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	public String getPerPlace() {
		return perPlace;
	}
	public void setPerPlace(String perPlace) {
		this.perPlace = perPlace;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
} 
