class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeStructure {

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static int sum(Node root) {
        if (root == null)
            return 0;

        return root.data + sum(root.left) + sum(root.right);
    }

    static int countNodes(Node root) {

        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int height(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static boolean search(Node root, int target) {
        if (root == null)
            return false;
        if (root.data == target)
            return true;

        return search(root.left, target) || search(root.right, target);
    }

    static int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    static int internalNode(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + internalNode(root.left) + internalNode(root.right);
    }

    static int maxdata(Node root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = maxdata(root.left);
        int rightMax = maxdata(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    static int minData(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int leftMin = minData(root.left);
        int rightMin = minData(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    static boolean isLeaf(Node root) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return true;

        return false;
    }

    public static void main(String args[]) {
        Node root = new Node(5);

        root.left = new Node(10);
        root.left.left = new Node(15);
        root.left.right = new Node(20);
        root.left.left.left = new Node(43);
        root.left.left.right = new Node(71);

        root.right = new Node(30);
        root.right.left = new Node(22);
        root.right.right = new Node(32);
        root.right.right.left = new Node(63);
        root.right.right.right = new Node(21);

        System.out.print("InOrder : ");
        inOrder(root);

        System.out.println();

        System.out.print("PreOrder : ");
        preOrder(root);

        System.out.println();

        System.out.print("PostOrder : ");
        postOrder(root);

        System.out.println();
        System.out.println("Sum : " + sum(root));

        System.out.println("No of Nodes : " + countNodes(root));
        System.out.println("Height of Tree : " + height(root));

        System.out.println("Target is present : " + search(root, 45));
        System.out.println("Target is present : " + search(root, 30));
        System.out.println("Target is present : " + search(root, 65));
        System.out.println("Target is present : " + search(root, 43));

        System.out.println("NO of leaves : " + countLeaves(root));
        System.out.println("NO. of Internal Node : " + internalNode(root));

        System.out.println("Max data is : " + maxdata(root));

        System.out.println("Minimum element is the tree is : " + minData(root));

        System.out.println("Solution of is leaf : " + isLeaf(root));
        System.out.println("Solution of is leaf : " + isLeaf(root.left.left));
        System.out.println("Solution of is leaf : " + isLeaf(root.left.left.left));
        System.out.println("Solution of is leaf : " + isLeaf(root.left.right.right));
    }
}