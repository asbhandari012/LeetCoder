import java.util.*;

public class StackAddAtBottom {

    public static void pushBottom(int data, java.util.Stack<Integer> s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(data, s);
        s.push(top);
    }

    public static void main(String[] args) {
        java.util.Stack<Integer> s = new java.util.Stack<>();
        s.push(1);
        s.push(3);
        s.push(2);

        pushBottom(4, s);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
