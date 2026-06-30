import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

public class DoublyLinkedList {

    Node head = null;

    void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    void insertPosition(int data, int pos) {

        if (pos <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            insertBeginning(data);
            return;
        }

        if (head == null) {
            System.out.println("Invalid Position");
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {

            if (temp.next == null) {
                System.out.println("Invalid Position");
                return;
            }

            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;
    }

    void deleteBeginning() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    void deleteEnd() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.prev.next = null;
    }

    void deletePosition(int pos) {

        if (pos <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos; i++) {

            if (temp == null) {
                System.out.println("Invalid Position");
                return;
            }

            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    void search(int key) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        int pos = 1;

        while (temp != null) {

            if (temp.data == key) {
                System.out.println("Element Found at Position " + pos);
                return;
            }

            temp = temp.next;
            pos++;
        }

        System.out.println("Element Not Found");
    }

    void displayForward() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        System.out.print("Forward : ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    void displayReverse() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        System.out.print("Reverse : ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {

            System.out.println("\n===== Doubly Linked List =====");
            System.out.println("1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete Beginning");
            System.out.println("5. Delete End");
            System.out.println("6. Delete Position");
            System.out.println("7. Search");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Data : ");
                    list.insertBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter Data : ");
                    list.insertEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Data : ");
                    int data = sc.nextInt();
                    System.out.print("Enter Position : ");
                    int pos = sc.nextInt();
                    list.insertPosition(data, pos);
                    break;

                case 4:
                    list.deleteBeginning();
                    break;

                case 5:
                    list.deleteEnd();
                    break;

                case 6:
                    System.out.print("Enter Position : ");
                    list.deletePosition(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Element : ");
                    list.search(sc.nextInt());
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 10:
                    System.out.println("Program Terminated");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
