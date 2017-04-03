import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class MaximumElement {

    private static Stack<Element> stack;
    private static boolean isValid(int length) {

        if (length > (Math.pow(10, 5))) {
            try {
                throw new Exception("Length must be less than 10^3");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static class Element {
        public int max;
        public int value;
    }

    private static void applyOperation(String operation) {
        int secondArgument;
        if (operation.charAt(0) == '1') {
            secondArgument = new Integer(operation.substring(2));
            if (secondArgument > Math.pow(10, 9)) {
                try {
                    throw new Exception("x must be less than 10^9");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Element current = new Element();
                current.value = secondArgument;
                if (stack.isEmpty()) {
                    current.max = secondArgument;
                } else {
                    Element last = stack.peek();
                    current.max = last.max > current.value ? last.max : current.value;
                }
                stack.push(current);
            }
        } else if (operation.charAt(0) == '2') {
            stack.pop();
        } else if (operation.charAt(0) == '3') {
            System.out.println(stack.peek().max);
        } else {
            try {
                throw new Exception("operation types are numbers between 1 and 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());

        if (isValid(n)) {
            for (int i = 0; i < n; i++) {
                applyOperation(scanner.nextLine());
            }
        }
    }
}
