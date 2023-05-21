/* Given the head of the Linked List, rotate the Linked ist to the right by k places.
 * Eg 1 :   head = [1,2,3,4,5]     k = 2        Output = [4,5,1,2,3]
 * Eg 2 :   head = [0,1,2]         k = 4        Output = [2,0,1]
 */
import java.util.*;
public class Rotate
{
      public class Node    // Linked List Node class...
      {
            public int data;      // data variable...
            public Node next;     // pointer variable...
            public Node(int val)
            {
                  this.data = val;
                  this.next = null;
            }
      }
      Node head = null;     // head pointer...
      public void Insert(int value)     // Inserting Node at the end...
      {
            Node n = new Node(value);
            if(head == null)
            {
                  head = n;
                  n.next = null;
            }
            Node temp = head;
            while(temp.next != null)
                  temp = temp.next;
            temp.next = n;
            n.next = null;
            return;
      }
      public void Display()    // Displaying the Linked List...
      {
            Node temp = head;
            while(temp != null)
            {
                  System.out.print(temp.data+" -> ");
                  temp = temp.next;
            }
            System.out.println("null");
      }
      public void RotateRight(int k)
      {
            int length = 0;      //*  Variable -> O(1)
            Node temp = head;
            while(temp != null)      //! Iteration -> O(N)
            {
                  temp = temp.next;   // Finding length of the linked list...
                  length++;
            }
            int start = (k % length), i = 0;    // Finding the start of the rotated List...
            temp = head;
            Node temp1 = head;      // Another temporary pointer created  //* Variable -> O(1)
            while(i != start)     //! Iteration -> O(N)
            {
                  i++;     // Reaching to the start of the rotated list...
                  temp = temp.next;
            }
            temp1 = temp.next;      // Storing the start address...
            temp.next = null;       // Making the previous node as the end node...
            temp = temp1;
            while(temp1.next != null)
                  temp1 = temp1.next;     // Reaching the end of the original list from the calculated start...
            temp1.next = head;    // Connecting the two ends...
            head = temp;    // Setting up the head as the start address...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x, k;
            System.out.print("Enter length of the Linked List : ");
            x = sc.nextInt();
            Rotate rotate = new Rotate();      // Object creation...
            for(int i = 0; i < x; i++)
            {
                  System.out.print("Enter Node data : ");
                  k = sc.nextInt();
                  rotate.Insert(k);
            }
            System.out.print("Enter value of K : ");
            k = sc.nextInt();
            rotate.Display();
            rotate.RotateRight(k);    // Function calling...
            rotate.Display();
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(1)