import java.util.ArrayList;

public class StackWithArrayList {

    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
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
    }
}
