import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class q394 {
    public static void main(String args[]) {
        StringBuffer res = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int temp = 0;
        Deque<Integer> stack = new LinkedList<>();
        Deque<String> ans = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(temp);
                ans.push(res.toString());
                temp = 0;
                res = new StringBuffer();
            } else if (ch == ']') {
                StringBuffer sf = new StringBuffer();
                int cur_temp = stack.removeLast();
                for (int i = 0; i < cur_temp; i++) sf.append(res);
                res = new StringBuffer(ans.removeLast() + sf);

            } else if (ch >= '0' && ch <= '9') temp = temp * 10 + Integer.parseInt((ch + ""));
            else res.append(ch);
        }
        System.out.println(res.toString());
    }
}
