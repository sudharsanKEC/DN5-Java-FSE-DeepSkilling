import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSLL {

    Node head = null;

    void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
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

            if (temp.next == head) {
                System.out.println("Invalid Position");
                return;
            }

            temp = temp.next;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteBeginning() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != head)
            temp = temp.next;

        temp.next = head.next;
        head = head.next;
    }

    void deleteEnd() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != head)
            temp = temp.next;

        temp.next = head;
    }

    void deletePosition(int pos) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        if (temp.next == head) {
            System.out.println("Invalid Position");
            return;
        }

        temp.next = temp.next.next;
    }

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

    void display() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        System.out.print("List : ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularSLL list = new CircularSLL();

        while (true) {

            System.out.println("\n===== Circular Singly Linked List =====");
            System.out.println("1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete Beginning");
            System.out.println("5. Delete End");
            System.out.println("6. Delete Position");
            System.out.println("7. Search");
            System.out.println("8. Display");
            System.out.println("9. Exit");
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
                    list.display();
                    break;

                case 9:
                    System.out.println("Program Terminated");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
