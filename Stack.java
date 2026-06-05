import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        int x = head.data;
        head = head.next;
        return x;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        Stack s = new Stack();

        s.push(4);
        s.push(9);
        s.push(12);
        s.push(54);
        s.push(45);

        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();

        Stack s2 = new Stack();

        s2.push(3);
        s2.push(5);
        s2.push(21);
        s2.push(98);
        s2.push(43);

        while (!s2.isEmpty()) {
            System.out.print(s2.peek() + " ");
            s2.pop();
        }

        ui.close();
    }
}