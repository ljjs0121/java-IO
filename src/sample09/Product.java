package sample09;

import java.text.MessageFormat;

public class Product {

	private int no;
	private String name;
	private String maker;
	private int price;
	private int stock;
	
	public Product() {}
	
	public Product(int no, String name, String maker, int price, int stock) {
		super();
		this.no = no;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.stock = stock;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static Product createProduct(String text) {
		// text = "100,맥북프로,애플,2000000,5"
		// values = {"100", "맥북프로", "애플", "2000000", "5"}
		String[] values = text.split(",");
		int no = Integer.parseInt(values[0]);
		String name = values[1];
		String maker = values[2];
		int price = Integer.parseInt(values[3]);
		int stock = Integer.parseInt(values[4]);
		
		return new Product(no, name, maker, price, stock);
	}
	
	public String generateText() {
	      return MessageFormat.format("{0},{1},{2},{3},{4}", 
	            String.valueOf(no), 
	            name, 
	            maker, 
	            String.valueOf(price), 
	            String.valueOf(stock));
	   }
}








