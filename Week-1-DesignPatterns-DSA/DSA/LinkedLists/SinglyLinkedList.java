import java.util.*;

class Node{
        int data;
        Node next;
        Node(){};
        Node(int data){
            this.data = data;
            this.next = null;
        }
}

public class SinglyLinkedList {

    Node head = null;

    public Node createNode(int data){
        Node node = new Node(data);
        return node;
    }

    public void insertElementAtEnd(int data){
        Node node = createNode(data);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        return;
    }

    public void insertElementAtBegin(int data){
        Node node = createNode(data);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        head = node;
        head.next = temp;
        return;
    }

    public void insertElementAtGivenPos(int data, int pos){
        if(pos<=0){
            System.out.println("Invalid position.");
            return;
        }

        if(pos == 1){
            insertElementAtBegin(data);
            System.out.println("Element inserted successfully at the given position.");
            return;
        }

        if(head == null){
            System.out.println("List is already null. Please add some elements before.");
            return;
        }

        Node temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }

        if(pos > size+1){
            System.out.println("Position doesn't exist.");
            return;
        }
        int count = 1;
        temp = head;

        while(count < pos-1){
            temp = temp.next;
            count++;
        }

        Node node = createNode(data);
        
        node.next = temp.next;
        temp.next = node;

        System.out.println("Element added successfully.");
        
    }

    public void deleteBeginning(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        System.out.println("Deleted successfully.");
        return;
    }

    public void deleteElementAtEnd(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        Node prevTemp = null;
        while(temp.next!=null){
            prevTemp = temp;
            temp = temp.next;
        }
        prevTemp.next = null;
        return;
    }

    void deleteElementAtGivenPosition(int pos) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid Position.");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }

        if(pos > size){
            System.out.println("Invalid position.");
            return;
        }
        int count = 1;
        temp = head;

        while(count < pos-1){
            temp = temp.next;
            count++;
        }

        temp.next = temp.next.next;;

        System.out.println("Element deleted successfully.");

       
    }

    void firstElement() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("First Element : " + head.data);
    }

    void lastElement() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println("Last Element : " + temp.data);
    }

     void elementAtPosition(int pos) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        System.out.println("Element : " + temp.data);
    }

    void size() {

        int count = 0;

        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Size : " + count);
    }

    void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    void isEmpty() {

        if (head == null)
            System.out.println("Linked List is Empty.");
        else
            System.out.println("Linked List is Not Empty.");
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        SinglyLinkedList list = new SinglyLinkedList();
        while(choice != 13){
            System.out.println("Enter your option: ");
            System.out.println("1  -> Insert element at the end.");
            System.out.println("2  -> Insert element at the beginning.");;
            System.out.println("3  -> Insert element at a given position.");
            System.out.println("4  -> Delete element at the beginning.");
            System.out.println("5  -> Delete element at the last.");
            System.out.println("6  -> Delete element at a given position.");
            System.out.println("7  -> Show the first element.");
            System.out.println("8  -> Show the last element.");
            System.out.println("9  -> Find element at a given position.");
            System.out.println("10 -> Size of the linked list.");
            System.out.println("11 -> Display Linked list.");
            System.out.println("12 -> Is empty?");
            System.out.println("13 -> 13 to quit.");
            choice = sc.nextInt();
            switch(choice){
                case 1:{
                    System.out.print("Enter the element: ");
                    list.insertElementAtEnd(sc.nextInt());
                    System.out.println("Element inserted at the end successfully.");
                    break;
                }
                case 2:{
                    System.out.print("Enter the element: ");
                    list.insertElementAtBegin(sc.nextInt());
                    System.out.println("Element inserted at the beginning successully");
                    break;
                }
                case 3:{
                    System.out.print("Enter the element: ");
                    int element = sc.nextInt();
                    System.out.println("Enter the position to insert: ");
                    list.insertElementAtGivenPos(element, sc.nextInt());
                    break;
                }
                case 4:{
                    list.deleteBeginning();
                    break;
                }
                case 5:{
                    list.deleteElementAtEnd();
                    break;
                }
                case 6:{
                    int pos = sc.nextInt();
                    list.deleteElementAtGivenPosition(pos);
                    break;
                }
                case 7:{
                    list.firstElement();
                    break;
                }
                case 8:{
                    list.lastElement();
                    break;
                }
                case 9:{
                    System.out.println("Enter the position: ");
                    int pos = sc.nextInt();
                    list.elementAtPosition(pos);
                }
                case 10:{
                    list.size();
                    break;
                }
                case 11:{
                    list.display();
                    break;
                }
                case 12:{
                    list.isEmpty();
                    break;
                }
                case 13:{
                    System.out.println("Program terminated.");
                    break;
                }
                default:
                    System.out.println("Invalid choice.");
            }

        }
        sc.close();
    }
}
