import org.junit.jupiter.api.Test;

class StackTest {

    Stack<Integer> stack = new Stack<>();


    void print() {
        for (Integer i :
                stack) {
            System.out.print(i);
            System.out.println(" ");
        }
    }

    @Test
    void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        print();
    }

    @Test
    void pop() {
        push();
        System.out.println("-------");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("-------");
        print();

    }

    @Test
    void isEmpty() {
        System.out.println(stack.isEmpty());
        push();
        System.out.println(stack.isEmpty());
    }

    @Test
    void size() {
        System.out.println(stack.size());
        push();
        System.out.println(stack.size());

    }
}