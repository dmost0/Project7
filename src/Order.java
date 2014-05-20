/**
 * Order represents a customer order of a bouquet
 *
 */
public class Order implements Comparable {
	//Fields
	private String date;
	private int numericDate;
	private String toLn;
	private String toFn;
	private String toStr;
	private String toC;
	private String toSt;
	int toZ;
	private String fromLn;
	private String fromFn;
	private String fromStr;
	private String fromC;
	private String fromSt;
	private int fromZ;
	private boolean beforeN;
	private int ship;
	private int bSize;
	private String msg;
	
	/**
	 * Default constructor
	 */
	public Order()
	{
		beforeN = false;
		numericDate = 0;
	}
	
		
	
	/**
	 * Specialized constructor
	 * @param toLn
	 * @param toFn
	 * @param toStr
	 * @param toC
	 * @param toSt
	 * @param toZ
	 * @param fromLn
	 * @param fromFn
	 * @param fromStr
	 * @param fromC
	 * @param fromSt
	 * @param fromZ
	 * @param beforeN
	 * @param date
	 * @param ship
	 * @param bSize
	 * @param msg
	 */
	public Order(String toLn, String toFn, String toStr, String toC,
			String toSt, int toZ, String fromLn, String fromFn,
			String fromStr, String fromC, String fromSt, int fromZ,
			boolean beforeN, String date, int ship, int bSize, String msg) {
		// TODO Auto-generated constructor stub
		setNumericDate(date);
		this.date = date;
		this.numericDate = getNumericDate();
		this.toLn = toLn;
		this.toFn = toFn;
		this.toStr = toStr;
		this.toC = toC;
		this.toSt = toSt;
		this.toZ = toZ;
		this.fromLn = fromLn;
		this.fromFn = fromFn;
		this.fromStr = fromStr;
		this.fromC = fromC;
		this.fromSt = fromSt;
		this.fromZ = fromZ;
		this.beforeN = beforeN;
		this.ship = ship;
		this.bSize = bSize;
		this.msg = msg;
	}








	public String getToLn() {
		return toLn;
	}




	public void setToLn(String toLn) {
		this.toLn = toLn;
	}




	public String getToFn() {
		return toFn;
	}




	public void setToFn(String toFn) {
		this.toFn = toFn;
	}




	public String getToStr() {
		return toStr;
	}




	public void setToStr(String toStr) {
		this.toStr = toStr;
	}




	public String getToC() {
		return toC;
	}




	public void setToC(String toC) {
		this.toC = toC;
	}




	public String getToSt() {
		return toSt;
	}




	public void setToSt(String toSt) {
		this.toSt = toSt;
	}




	public int getToZ() {
		return toZ;
	}




	public void setToZ(int toZ) {
		this.toZ = toZ;
	}




	public String getFromLn() {
		return fromLn;
	}




	public void setFromLn(String fromLn) {
		this.fromLn = fromLn;
	}




	public String getFromFn() {
		return fromFn;
	}




	public void setFromFn(String fromFn) {
		this.fromFn = fromFn;
	}




	public String getFromStr() {
		return fromStr;
	}




	public void setFromStr(String fromStr) {
		this.fromStr = fromStr;
	}




	public String getFromC() {
		return fromC;
	}




	public void setFromC(String fromC) {
		this.fromC = fromC;
	}




	public String getFromSt() {
		return fromSt;
	}




	public void setFromSt(String fromSt) {
		this.fromSt = fromSt;
	}




	public int getFromZ() {
		return fromZ;
	}




	public void setFromZ(int fromZ) {
		this.fromZ = fromZ;
	}




	public boolean isBeforeN() {
		return beforeN;
	}




	public void setBeforeN(boolean beforeN) {
		this.beforeN = beforeN;
	}







	/**
	 * Get shipping
	 * @return 1 standard 2 holiday
	 */
	public int getShip() {
		return ship;
	}




	/**
	 * Set shipping 
	 * @param ship 1 standard 2 holiday
	 */
	public void setShip(int ship) {
		this.ship = ship;
	}




	/**
	 *  get bouquet size
	 * @return 1 small 2 medium 3 big
	 */
	public int getbSize() {
		return bSize;
	}




	/**
	 * set bouquet size
	 * @param bSize 1 small 2 medium 3 big
	 */
	public void setbSize(int bSize) {
		this.bSize = bSize;
	}




	public String getMsg() {
		return msg;
	}




	public void setMsg(String msg) {
		this.msg = msg;
	}




	/**
	 * Gets the day of the month of this order
	 * @return the day this order is for
	 */
	public int getNumericDate() {
		return numericDate;
	}



	/**
	 * The numeric date represents the day of the month of this order.
	 * @param numericDate 
	 */
	public void setNumericDate(int numericDate) {
		this.numericDate = numericDate;
	}

	/**
	 * Sets the numeric date by extracting the day from a String of date
	 * @param date String representation of date of this order
	 */
	public void setNumericDate(String date)
	{
		String[] a = date.split(" ");
		numericDate = Integer.parseInt(a[1]);
	}

	/**
	 * Gets the date of this order in a String format
	 * @return the date of this order
 	 */
	public String getDate() {
		return date;
	}



	/**
	 * Set the date of this order
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}







	/**
	 * Set the state of this order
	 * @param beforeNoon true if before noon, false otherwise.
	 */
	public void setBeforeNoon(boolean beforeNoon) {
		this.beforeN = beforeNoon;
	}

	/**
	 * Compares two orders by their date
	 * @param o order to compare this order to
	 * @return -1 if this order comes before target day, 0 if same day, 1 if after target day.
	 */
	@Override
	public int compareTo(Object o) {
		Order order = (Order) o;
		if(numericDate < order.getNumericDate()){
			return -1;
		}
		else if(getNumericDate() == order.getNumericDate()){
			if(isBeforeN()== true && order.isBeforeN() == true)
				return 0;
			else if(isBeforeN() == true && order.isBeforeN() == false)
				return -1;
			else if(isBeforeN() == false && order.isBeforeN() == false)
				return 0;
			else
				return 1;
		}
		return 1;
	}
	
	/**
	 * Returns a string representation of this order.
	 */
	public String toString()
	{
		return "A order";
	}
	
	public String getDeliveryInfo()
	{
		if(isBeforeN() == true)
			return "*" + getToStr() + ", " +  getToSt() + " - " + getToLn() + ", " + getToFn();
		else
			return getToStr() + ", " +  getToSt() + " - " + getToLn() + ", " + getToFn();
	}
	
		
}
