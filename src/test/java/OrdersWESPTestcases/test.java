package OrdersWESPTestcases;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String orderID="#1234";
		  orderID=orderID.replaceAll("[-+.^:,#a-zA-Z]", "");
		  System.out.println(orderID);
	}

}
