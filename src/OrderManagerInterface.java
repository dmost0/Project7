/**
 * This is the interface for the OrderManager.
 * There are methods to add an order, print
 * out the message cards, and print out the
 * delivery schedule.
 * It will contain an Arraylist<Comparable<Order>> of Order references
 * and keep track of the number of orders
 * @author Professor Myers
 */
import java.util.*;
import java.text.*;

public interface OrderManagerInterface {

    /**
     * Sorts all orders by date, before noon deliveries come before
	 * other delivers on the same date, and then
     * prints out the message cards for each order in the following format: </br>
	 * Dear Mom </br>
	 * {message} </br>
	 * Love {first name of FROM} </br>
	 * {blank line} </br>
	 * {blank line} </br>
     * @return String of all message cards from all orders
     */
    public String printMessageCards();
  
    /**
    * 
    * @param toLn  Last Name of TO
    * @param toFn  First Name of TO
    * @param toStr Street of TO
    * @param toC   City of TO
    * @param toSt  State of TO
    * @param toZ   Zip of TO
    * @param fromLn  Last Name of FROM
    * @param fromFn  First Name of FROM
    * @param fromStr Street of FROM
    * @param fromC   City of FROM
    * @param fromSt  State of FROM
    * @param fromZ   Zip of FROM
    * @param beforeN boolean - true if before noon delivery
    * @param date       date of delivery in form of string
    * @param ship    ship type (1=standard, 2=holiday)
    * @param bSize   bouquet size (1=small, 2=medium, 3=big)
    * @param msg     message from FROM
    * @return total cost of the bouquet
    */
    public double addOrder(String toLn, String toFn, String toStr, String toC, String toSt, int toZ,
		  String fromLn, String fromFn, String fromStr, String fromC, String fromSt, int fromZ,
		  boolean beforeN, String date, int ship, int bSize, String msg);
    
    /**
     * Sorts all orders by date, before noon deliveries come before
	 * other delivers on the same date, and then returns a string
     * in the following format: </br>
     * Delivery Schedule </br>
     * {blank} </br>
     * {blank} </br>
     * {Date} </br>
     * *{TO Street}, {TO City} - {TO Last Name}, {TO First Name} (a before noon delivery, preceeded by *)</br>
     * {TO Street}, {TO City} - {TO Last Name}, {TO First Name} (an after noon delivery)</br>
     * { . . .  the rest for this date} </br>
     * {blank} </br>
     * {blank} </br>
     * {next Date} </br>
     * { . . .} </br>   
     * Example: </br>
     * Delivery Schedule</br>
     * </br>
     * May 8</br>
     * 3399 Campus Dr., rockville - Miller, Karen </br>
     * </br>
     * </br>
     * May 9</br>
     * *55321 Sycamore St., Gaithersburg - Brown, Angela </br>
     * </br>
     * </br>
     * May 11</br>
     * 3356 Cypress Ln., North Potomac - Hanson, Beverly</br>
     * @return the delivery schedule
     */
    public String deliverySchedule();
    
    /**
     * returns the number of orders that have been placed
     * in the Arraylist
     * @return number of orders that have been submitted
     */
    public int getNumOrders();
}
