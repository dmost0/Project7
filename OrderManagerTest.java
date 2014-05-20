import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrderManagerTest {
	OrderManager orders1, order2;

	@Before
	public void setUp() throws Exception {
		orders1 = new OrderManager();
		orders1.addOrder("Brown", "Angela", "55321 Sycamore St.", "Gaithersburg", 
				"MD", 20879, "Smith", "Agnus", "344 Oak St.", "Pocatello", 
				"ID", 83205, true, "May 9", 1, 2, "Happy Mother's Day");
		orders1.addOrder("Miller", "Karen", "3399 Campus St.", "Rockville", 
				"MD", 20850, "Jones", "Peggy", "5633 Meadow Way", "Bloomington", 
				"IN", 47404, false, "May 8", 1, 1, "Love ya");
		orders1.addOrder("Hanson", "Beverly", "3356 Cypress Ln.", "North Potomac", 
				"MD", 20878, "Hanson", "Ken", "2985 Pointer Dr.", "Fountain Valley", 
				"CA", 83205, false, "May 11", 2, 3, "You're the greatest");
		orders1.addOrder("White", "Carolyn", "4488 Pinewood Ave.", "Olney", 
				"MD", 20859, "Green", "George", "492 Apple Way", "St. Louis", 
				"MO", 35587, false, "May 9", 1, 2, "All the Best!");
	}

	@After
	public void tearDown() throws Exception {
		orders1 = null;
	}

	@Test
	/**
	 * Message cards are printed in order by the delivery date.  Deliveries before noon come before
	 * other delivers on the same date.  Should be in this order:
	 * May 8 - from Peggy
	 * May 9 (before noon) - from Agnus
	 * May 9 - from George
	 * May 11 - from Ken
	 */
	public void testPrintMessageCards() {
		String result = orders1.printMessageCards();
		Scanner scan = new Scanner(result);
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("Love ya", scan.nextLine());
		assertEquals("Love Peggy", scan.nextLine());
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("Happy Mother's Day", scan.nextLine());
		assertEquals("Love Agnus", scan.nextLine());
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("All the Best!", scan.nextLine());
		assertEquals("Love George", scan.nextLine());
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("You're the greatest", scan.nextLine());
		assertEquals("Love Ken", scan.nextLine());
	}

	@Test
	public void testAddOrder() {
		assertEquals(4,orders1.getNumOrders());
		orders1.addOrder("Myers", "Stephanie", "8355 Grove Ave.", "Darnestown", 
				"MD", 20874, "Simco", "Rebecca", "34 Charleston St.", "Orlando",
				"FL", 11334, true, "May 8", 1, 1, "I miss you");
		assertEquals(5,orders1.getNumOrders());
		
	}

	@Test
	/**
	 * Delivery schedule is in order by the delivery date. Deliveries before noon come before
	 * other delivers on the same date.  Should be in this order:
	 * May 8 - from Peggy
	 * May 9 (before noon) - from Agnus
	 * May 9 - from George
	 * May 11 - from Ken
	 */
	public void testDeliverySchedule() {
		String result = orders1.deliverySchedule();
		Scanner scan = new Scanner(result);
		assertEquals("Delivery Schedule", scan.nextLine());
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("May 8", scan.nextLine());
		assertEquals("3399", scan.next());
		scan.nextLine(); // get rest of line
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("May 9", scan.nextLine());
		assertEquals("*55321", scan.next());
		scan.nextLine(); // get rest of line
		assertEquals("4488", scan.next());
		scan.nextLine(); // get rest of line
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("May 11", scan.nextLine());
		assertEquals("3356", scan.next());
		
	}

	@Test
	public void testSortClass() {
		String result = orders1.printMessageCards();
		Scanner scan = new Scanner(result);
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("Love ya", scan.nextLine());
		assertEquals("Love Peggy", scan.nextLine());
		
		// add a May 8 before noon order which should be
		// sorted to be first before Peggy
		
		orders1.addOrder("Myers", "Stephanie", "8355 Grove Ave.", "Darnestown", 
				"MD", 20874, "Simco", "Rebecca", "34 Charleston St.", "Orlando",
				"FL", 11334, true, "May 8", 1, 1, "I miss you");
		
		result = orders1.printMessageCards();
		scan = new Scanner(result);
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("I miss you", scan.nextLine());
		assertEquals("Love Rebecca", scan.nextLine());
		scan.nextLine(); // blank line
		scan.nextLine(); // blank line
		assertEquals("Dear Mom", scan.nextLine());
		assertEquals("Love ya", scan.nextLine());
		assertEquals("Love Peggy", scan.nextLine());
	}

}
