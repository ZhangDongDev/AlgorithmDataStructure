public class BracketsMatch {
    public static void main(String[] args) {
        String str = "(fdafds(fafds)())(()";
        boolean result = isMatch(str);
        System.out.println(str + "中的括号是否匹配:" + result);
    }

    private static boolean isMatch(String str) {
        // 1. 创建堆栈，用于存储左括号
        Stack<String> stack = new Stack<>();

        // 2. 遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            // 3. 如果是左括号，入栈
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                // 4. 如果是右括号，出栈
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }

        // 5. 判断栈是否为空，为空返回 true， 表示括号匹配，否则返回false
        return stack.isEmpty();
    }
}
