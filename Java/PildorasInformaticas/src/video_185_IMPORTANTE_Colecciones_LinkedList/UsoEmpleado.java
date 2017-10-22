package video_185_IMPORTANTE_Colecciones_LinkedList;
// https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/
import java.util.*;
public class UsoEmpleado {
     public static void main(String args[]) {

       /* Linked List Declaration */
       LinkedList<String> l=new LinkedList<String>();

       /*add(String Element) is used for adding 
        * the elements to the linked list*/
       l.add("Item1");
       l.add("Item5");
       l.add("Item3");
       l.add("Item6");
       l.add("Item2");

       /*Display Linked List Content*/
       System.out.println("Linked List Content: " +l);

       /*Add First and Last Element*/
       l.addFirst("First Item");
       l.addLast("Last Item");
       System.out.println("LinkedList Content after addition: " +l);

       /*This is how to get and set Values*/
       Object var1 = l.get(0);
       System.out.println("First element: " +var1);
       l.set(0, "Changed first item");
       Object var2 = l.get(0);
       System.out.println("First element after update by set method: " +var2);

       /*Remove first and last element*/
       l.removeFirst();
       l.removeLast();
       System.out.println("LinkedList after deletion of first and last element: " +l);

       /* Add to a Position and remove from a position*/
       l.add(0, "Newly added item");
       l.remove(2);
       System.out.println("Final Content: " +l); 
     }
}