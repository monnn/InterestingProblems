import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class BalancedBrackets {

    private static boolean isValid(int n, List<String> bracketsList) {
        if (n < 1 || n > (Math.pow(10, 3))) {
            try {
                throw new Exception("Number of brackets sequences must be less than 10^3");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        bracketsList.forEach(brackets -> {
            if (brackets.length() > Math.pow(10, 3)) {
                try {
                    throw new Exception("Each brackets sequence must be less than 10^3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
        return true;
    }

    private static boolean areBalanced(String brackets) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < brackets.length(); i++) {
            ch = brackets.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                    //ok
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                    //ok
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                    //ok
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());
        List<String> bracketsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bracketsList.add(scanner.nextLine());
        }

        if (isValid(n, bracketsList)) {
            bracketsList.stream().forEach(brackets -> System.out.println(areBalanced(brackets) ? "YES" : "NO"));
        }
    }
}
