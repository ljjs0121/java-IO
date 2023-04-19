package sample09;

import java.text.MessageFormat;
import java.util.Date;

import util.DateUtils;

public class Order {

	private int no;
	private Date date;
	private String userId;
	private int productNo;
	private int quantity;
	private int orderPrice;
	private int depositPoint;
	
	public Order() {}
	
	public Order(int no, Date date, String userId, int productNo, int quantity, int orderPrice, int depositPoint) {
		super();
		this.no = no;
		this.date = date;
		this.userId = userId;
		this.productNo = productNo;
		this.quantity = quantity;
		this.orderPrice = orderPrice;
		this.depositPoint = depositPoint;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getDepositPoint() {
		return depositPoint;
	}
	public void setDepositPoint(int depositPoint) {
		this.depositPoint = depositPoint;
	}
	
	public static Order createOrder(String text) {
		// text -> "10000,2023-04-11,kim,100,1,200000,200"
		// values -> {"10000", 2023-04-11", "kim", "100", "1", "200000", "200"}
		String[] values = text.split(",");
		int no = Integer.parseInt(values[0]);
		Date date = DateUtils.toDate(values[1]);
		String name = values[2];
		int productNo = Integer.parseInt(values[3]);
		int quantity = Integer.parseInt(values[4]);
		int orderPrice = Integer.parseInt(values[5]);
		int depositPoint = Integer.parseInt(values[6]);
		
		return new Order(no, date, name, productNo, quantity, orderPrice, depositPoint);
	}
	
	public String generateText() {
	      return MessageFormat.format("{0},{1},{2},{3},{4},{5},{6}", 
	            String.valueOf(no), 
	            DateUtils.toText(date), 
	            userId, 
	            String.valueOf(productNo), 
	            String.valueOf(quantity), 
	            String.valueOf(orderPrice), 
	            String.valueOf(depositPoint));
	   }
}




