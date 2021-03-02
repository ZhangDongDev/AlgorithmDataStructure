import org.junit.jupiter.api.Test;

class OrderSymbolTableTest {

    @Test
    void test() {
        OrderSymbolTable<Integer,String> s = new OrderSymbolTable<>();

        s.put(1, "111");
        s.put(22, "2");
        s.put(33, "333");
        s.put(44, "444");

        String s1 = s.get(33);

        s.put(11, "111");

        s.delete(33);
    }
}