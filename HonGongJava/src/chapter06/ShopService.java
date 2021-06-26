package chapter06;

/*
 * 싱글톤
 */
public class ShopService {

	private static ShopService singleton = new ShopService();
	
	private ShopService() {}
	
	static ShopService getInstance() {
		return singleton;
	}
}
