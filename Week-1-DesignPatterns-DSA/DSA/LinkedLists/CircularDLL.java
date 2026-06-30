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

public class CircularDLL {

    Node head = null;

    // Insert at Beginning
    void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;

        head = newNode;
    }

    // Insert at End
    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;
    }

    // Insert at Position
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

            if (temp.next == head) {
                System.out.println("Invalid Position");
                return;
            }

            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Delete Beginning
    void deleteBeginning() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;

        head = head.next;

        head.prev = last;
        last.next = head;
    }

    // Delete End
    void deleteEnd() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;
        Node secondLast = last.prev;

        secondLast.next = head;
        head.prev = secondLast;
    }

    // Delete at Position
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

            temp = temp.next;

            if (temp == head) {
                System.out.println("Invalid Position");
                return;
            }
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Search
    void search(int key) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        int pos = 1;

        do {

            if (temp.data == key) {
                System.out.println("Element Found at Position " + pos);
                return;
            }

            temp = temp.next;
            pos++;

        } while (temp != head);

        System.out.println("Element Not Found");
    }

    // Display Forward
    void displayForward() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        System.out.print("Forward : ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Display Reverse
    void displayReverse() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head.prev;

        System.out.print("Reverse : ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != head.prev);

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularDLL list = new CircularDLL();

        while (true) {

            System.out.println("\n===== Circular Doubly Linked List =====");
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
