public class ReversePolishNotation {
    public static void main(String[] args) {
        // 中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    private static int calculate(String[] notation) {
        int[] num = new int[notation.length / 2 + 1];
        int index = 0;
        for (String s : notation) {
            switch (s) {
                case "+":
                    num[index - 2] = num[index - 2] + num[index - 1];
                    index--;
                    break;
                case "-":
                    num[index - 2] = num[index - 2] - num[index - 1];
                    index--;
                    break;
                case "*":
                    num[index - 2] = num[index - 2] * num[index - 1];
                    index--;
                    break;
                case "/":
                    num[index - 2] = num[index - 2] / num[index - 1];
                    index--;
                    break;
                default:
                    num[index++] = Integer.parseInt(s);
                    break;
            }
        }
        return num[0];
    }
}
