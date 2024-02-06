package prob1;
import java.util.*;
import prob1.LinkedModel.Node;
class CLL{
	Node Last;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	CLL(){
		Last=null;
	}
	public void insertAtBeginning(int data) {
		Node n = new Node(data);
		if(Last==null) 
		{
			n.next=n;
			Last= n;
		}
		else
		{
			n.next=Last.next;
			Last.next=n;
		}
	}
	public void insertAtLast(int data) {
		Node n = new Node(data);
		if(Last==null) 
		{
			n.next=n;
			Last= n;
		}
		else
		{
			n.next=Last.next;
			Last.next=n;
			Last=n;
		}
	}
	public void insertAtPos(int pos,int val) {
		pos-=1;
		if(pos==0)
		{
			insertAtBeginning(val);
			return;
		}
		Node n=new Node(val);
		Node temp=Last;
		for (int i = 1; i <=pos; i++)
		{
			temp=temp.next;
		}
		
		n.next=Last;
		temp.next=n;
	}
	public void deleteAtBegining() {
		if(Last==null) {
			System.out.println("No data found");
			return;
		}
		if(Last.next==Last) {
			Last=null;
		}
		else {
			Last.next=Last.next.next;
		}
	}
	public int deleteAtEnd() {
		if(Last==null) {
			System.out.println("No data found");
		}
		int data=Last.next.data;
		if(Last.next==Last) {
			Last=null;
		}
		else {
			Node temp=Last.next;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=Last.next.next;
			Last=temp;
		}
		return data;
	}
	
	public void dispaly() {
		if(Last==null) 
			return;
		
		Node temp= Last.next;
		do
		{
			System.out.print(temp.data+" "+temp.next+" ");
			System.out.println();
			temp=temp.next;
		}while(temp!=Last.next);
	}
}
public class CircularLinkedlIstModel {
	public static void main(String[] args) {
		CLL cl=new CLL();
		cl.insertAtBeginning(10);
		cl.insertAtBeginning(20);
		cl.insertAtBeginning(30);
		cl.insertAtPos(1, 100);
        cl.dispaly();
        System.out.println("------------");
        cl.insertAtLast(40);
        cl.dispaly();
        System.out.println("------------");
        cl.deleteAtBegining();
        cl.dispaly();
	}

}
