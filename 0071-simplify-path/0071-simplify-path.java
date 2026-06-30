import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        StringTokenizer st = new StringTokenizer(path, "/");
        Stack<String> stack = new Stack<>();

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();

            if (temp.equals(".") || temp.equals("")) {

                continue;
            } 
            else if (temp.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {

                stack.push(temp);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.toString();
    }
}