import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Queue2Stacks {
    private static Stack<Integer> head;
    private static Stack<Integer> tail;

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
                 tail.push(secondArgument);
            }
        } else if (operation.charAt(0) == '2') {
            if (head.isEmpty()) {
                moveToHead(head, tail);
            }
            head.pop();

        } else if (operation.charAt(0) == '3') {
            if (head.isEmpty()) {
                moveToHead(head, tail);
            }
            System.out.println(head.peek());
        } else {
            try {
                throw new Exception("operation types are numbers between 1 and 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void moveToHead(Stack<Integer> head, Stack<Integer> tail) {
        while (!tail.isEmpty()) {
            head.push(tail.pop());
        }
    }

    public static void main(String[] args) {
        head = new Stack<>();
        tail = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());

        if (isValid(n)) {
            for (int i = 0; i < n; i++) {
                applyOperation(scanner.nextLine());
            }
        }
    }
}
