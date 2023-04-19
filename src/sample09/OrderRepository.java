package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
	
	private List<Order> orders = new ArrayList<>();
	
	public OrderRepository() {
		try {
			String path = "src/sample09/orders.txt";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) { // text 파일에 공백이 있으면 빠져나감
					break;
				}
				Order order = Order.createOrder(text);
				orders.add(order);
			}
		} catch (IOException ex) {
			throw new RuntimeException("orders.txt 읽기 오류", ex);
		}
	}
	
	// 마지막 주문번호 +1 하는 코드
	public int getOrderNo() { 
		// orders(List객체)의 맨 마지막번째(orders.size - 1) Order객체의 주문번호보다 1 큰 값
		return orders.get(orders.size() - 1).getNo() + 1;
	}
	
	// 주문정보 저장
	public void insertOrder(Order order) {
		orders.add(order);
	}
	
	// 주문내역
	public List<Order> getOrdersByUserId(String userId) {
		List<Order> result = new ArrayList<>();
		
		for (Order order : orders) {
			if (order.getUserId().equals(userId)) {
				result.add(order);
			}
		}
		return result;
	}
	
	// 종료 후 저장
	public void save() {
		try {
			String path = "src/sample09/orders.txt";
			PrintWriter out = new PrintWriter(path);
			
			for (Order order : orders) {
				String text = order.generateText();
				out.println(text);
			}
			out.close();
			
		} catch (IOException ex) {
			throw new RuntimeException("order.txt 읽기 쓰기 오류", ex);
		}
	}
	
}











