package sample09;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallService {

	// 사용자 정보를 제공하는 저장소 객체
	private UserRepository userRepo = new UserRepository();
	// 상품 정보를 제공하는 저장소 객체
	private ProductRepository productRepo = new ProductRepository();
	// 주문 정보를 제공하는 저장소 객체
	private OrderRepository orderRepo = new OrderRepository();
	
	/*
	 * 모든 상품정보 목록을 반환한다.
	 * 	반환타입 : List<Product>
	 * 	메소드명 : getAllProducts
	 *  매개변수 : 없음
	 */
	
	public List<Product> getAllProducts() {
		return productRepo.getProduts();
	}
	
	/*
	 *  아이디, 비밀번호를 전달받아서 사용자를 인증하고, 인증된 사용자정보를 반환한다.
	 *  반환타입 : User
	 *  메소드명 : login
	 *  매개변수 : String id, String password
	 *  예외 : RuntimeException, 사용자정보가 없거나 비밀번호가 일치하지 않는 경우
	 */
	public User login(String id, String password) {
		// 인증절차
		User user = userRepo.getUserById(id);
		if (user == null) {
			throw new RuntimeException("["+id+"] 사용자정보가 존재하지 않습니다.");
		}
		
		if (!user.getPassword().equals(password)) { // 패스워드가 일치하지않으면
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		
		return user;
	}
	
	/*
	 * 상품번호, 구매수량, 사용자아이디를 전달받아서 주문정보를 저장하기 (주문하기)
	 *  반환타입 : void
	 *  메소드명 : order
	 *  매개변수 : int productNo, int quantity, String userId
	 *  예외 : RuntimeException, 상품정보가 없거나 재고수량이 부족한 경우
	 */
	public void order(int productNo, int quantity, String userId) {
		// 1. 상품번호에 해당하는 상품정보를 조회한다
		Product product = productRepo.getProductByNo(productNo);
		// 2. 상품정보가 존재하지 않으면 예외를 던진다.
		if (product == null) {
			throw new RuntimeException("["+productNo+"] 상품정보가 존재하지 않습니다.");
		}
		// 3. 구매수량보다 재고수량이 적으면 예외를 던진다.
		if (product.getStock() < quantity) {
			throw new RuntimeException("재고수량이 부족합니다.");
		}
		
		// 4. 상품의 가격을 조회한다.
		int productPrice = product.getPrice();
		// 5. 총구매금액을 계산한다.
		int orderPrice = productPrice*quantity;
		// 6. 적립포인트를 계산한다.
		int depositPoint = (int) (orderPrice*0.01);
		// 7. 재고수량을 변경한다.
		product.setStock(product.getStock() - quantity);
		
		// 8. 사용자정보를 조회한다.
		User user = userRepo.getUserById(userId);
		// 9. 적립포인트만큼 사용자의 포인트를 증가시킨다.
		user.setPoint(user.getPoint() + depositPoint);
		
		// 10. 주문번호 생성
		int orderNo = orderRepo.getOrderNo();
		// 11. 주문날짜 생성
		Date orderDate = new Date();
		// 12. 주문정보를 저장하는 Order객체를 생성해서 
		//	   주문번호, 주문날짜, 사용자아이디, 상품번호, 총구매금액, 적립포인트를 대입한다.
		Order order = new Order();
		order.setNo(orderNo);
		order.setDate(orderDate);
		order.setUserId(userId);
		order.setProductNo(productNo);
		order.setQuantity(quantity);
		order.setOrderPrice(orderPrice);
		order.setDepositPoint(depositPoint);
		// 13. 주문정보를 저장시킨다.
		orderRepo.insertOrder(order);
	}
	
	// 주문내역
	public List<Map<String, Object>> getMyOrders(String userId){
		List<Map<String, Object>> result = new ArrayList<>();
		
		// 지정된 사용자 아이디로 등록된 모든 주문정보를 조회한다.
		List<Order> orders = orderRepo.getOrdersByUserId(userId);
		for (Order order : orders) {
			// 주문정보와 주문상품정보를 저장하는 Map객체를 생성한다.
			Map<String, Object> item = new HashMap<>();
			// Map객체에 주문정보(주문번호,주문날짜,주문수량,주문가격,적립포인트)를 저장한다.
			item.put("orderNo", order.getNo());
			item.put("orderDate", order.getDate());
			item.put("orderQuantity", order.getQuantity());
			item.put("orderPrice", order.getOrderPrice());
			item.put("depositPoint", order.getDepositPoint());
			// Map객체에서 주문상품정보(상품이름, 상품가격)를 저장한다.
			// 주문정보의 상품번호(order.getProductNo())로 상품정보를 조회한다.
			Product product = productRepo.getProductByNo(order.getProductNo());
			item.put("productName", product.getName());
			item.put("productPrice", product.getPrice());
			
			result.add(item);
		}
		return result;
	}
	
	// 종료 후 저장
	public void save() {
		userRepo.save();
		productRepo.save();
		orderRepo.save();
	}
}










