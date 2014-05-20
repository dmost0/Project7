import java.util.ArrayList;

//********************************************************************
//  Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************

public class Sorting
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void selectionSort (Comparable[] list)
   {
      int min;
      Comparable temp;

      for (int index = 0; index < list.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[min]) < 0)
               min = scan;

         // Swap the values
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }
   }
   /**
    * Accepts an arraylist as param
    * @param a arraylist holds orders
    */
   public static void selectionSortAL(ArrayList<Comparable> a)
   {
	   Comparable[] list = new Comparable[a.size()];

	   for(int i = 0; i < a.size(); i++)
		   list[i] = a.get(i);
	   int min;
	   Comparable temp;

	      for (int index = 0; index < list.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < list.length; scan++)
	            if (list[scan].compareTo(list[min]) < 0)
	               min = scan;

	         // Swap the values
	         temp = list[min];
	         list[min] = list[index];
	         list[index] = temp;
	      }
	   a.clear();
	   for(int i = 0; i < a.size(); i++)
		   a.add(list[i]);
	   
   }

   /**
    * Accepts an arraylist as param
    * @param a arraylist holds orders
    */
   public static void insertionSort (ArrayList<Comparable> a)
   {
	   Comparable[] list = new Comparable[a.size()];

	   for(int i = 0; i < a.size(); i++)
		   list[i] = a.get(i);
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
      
	   for(int i = 0; i < a.size(); i++)
		   a.set(i, list[i]);
   }
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the insertion
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void insertionSort (Comparable[] list)
   {
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
   }
}
