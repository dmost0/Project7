//Imports
import java.util.ArrayList;

/**
 * 
 *
 */
public class OrderManager implements OrderManagerInterface{
	//Fields
	@SuppressWarnings("rawtypes")
	private ArrayList<Comparable> list;
	
	@SuppressWarnings("rawtypes")
	public OrderManager()
	{
		list = new ArrayList<Comparable>();
	}
	
	@Override
	public String printMessageCards() {
		// TODO Auto-generated method stub
		Sorting.insertionSort(list);
		String s = "";
		for(int i = 0; i < list.size(); i++){
			Order o = (Order) list.get(i);
			s += "Dear Mom\n" + o.getMsg() + "\nLove " + o.getFromFn() + "\n\n\n";
		}
		
		
		
		return s;
	}

	/**
	 * Adds an order to the ArrayList
	 */
	@Override
	public double addOrder(String toLn, String toFn, String toStr, String toC,
			String toSt, int toZ, String fromLn, String fromFn, String fromStr,
			String fromC, String fromSt, int fromZ, boolean beforeN,
			String date, int ship, int bSize, String msg) {
		
		Order o = new Order( toLn,  toFn,  toStr,  toC,
			 toSt,  toZ,  fromLn,  fromFn,  fromStr,
			 fromC,  fromSt,  fromZ, beforeN,
			 date,  ship,  bSize,  msg);
		list.add(o);
		
		
		
		return 0;
	}


	/**
	 * Sorts the arraylist by date, ascending
	 * A string representation of the delivery schedule of orders. * preceeded by orders
	 * placed before noon
	 */
	@Override
	public String deliverySchedule() {
		Sorting.insertionSort(list);
		String s = "Delivery Schedule\n";
		s += "\n";
		s += "\n";
		for(int i = 0; i < list.size(); i++){
			Order o = (Order)list.get(i);
			int a = o.getNumericDate();
			switch (a){
			case 8:
				if(i == 0){
					s += "May 8\n";
					s += o.getDeliveryInfo() +"\n\n\n";
				}
				else
					s += o.getDeliveryInfo() +"\n\n\n";
				break;
			
			case 9:
				if(i == 0){
					s += "May 9\n";
					s += o.getDeliveryInfo() +"\n\n\n";
				}
				else{
					if(((Order)list.get(i - 1)).getNumericDate() != 9){
						s += "May 9\n";
						s += o.getDeliveryInfo() +"\n\n\n";
					}
					else
						s += o.getDeliveryInfo() +"\n\n\n";
				}
				break;
			case 10:
				if(i == 0){
					s += "May 10\n";
					s += o.getDeliveryInfo() +"\n";
				}
				else{
					if(((Order)list.get(i - 1)).getNumericDate() != 10){
						s += "May 10\n";
						s += o.getDeliveryInfo() +"\n\n\n";
					}
					else
						s += o.getDeliveryInfo() +"\n\n\n";
				}
				break;
			case 11:
				if(i == 0){
					s += "May 11\n";
					s += o.getDeliveryInfo() +"\n\n\n";
				}
				else{
					if(((Order)list.get(i - 1)).getNumericDate() != 11){
						s += "May 11\n";
						s += o.getDeliveryInfo() +"\n\n\n";
					}
					else
						s += o.getDeliveryInfo() +"\n\n\n";
				}
				break;
				
			
			case 12:
				if(i == 0){
					s += "May 12\n";
					s += o.getDeliveryInfo() +"\n\n\n";
				}
				else{
					if(((Order)list.get(i - 1)).getNumericDate() != 12){
						s += "May 12\n";
						s += o.getDeliveryInfo() +"\n\n\n";
					}
					else
						s += o.getDeliveryInfo() +"\n\n\n";
				}
				break;
		}
		}
		
		return s;
		
	}




	/**
	 * Returns arrayList size
	 */
	@Override
	public int getNumOrders() {
		return list.size();
	}

}
