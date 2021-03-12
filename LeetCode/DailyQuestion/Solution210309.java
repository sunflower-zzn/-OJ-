// 3.9
// 1047. Remove All Adjacent Duplicates In String(删除字符串中的相邻重复项)

/*
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 
提示：
1 <= S.length <= 20000
S 仅由小写英文字母组成。
*/

public class Solution210309 {
    public String removeDuplicates(String S) {
/*
        //使用栈来处理，最后留在栈中的字母就是无法消除的
        Deque<Character> stack = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuffer sf = new StringBuffer();
        while (!stack.isEmpty()) {
            sf.append(stack.pop());
        }
        return sf.reverse().toString();
*/
/*

        //不用栈直接用StringBuffer处理也行，少了reverse这步
        StringBuffer sf = new StringBuffer();
        for (char ch : S.toCharArray()) {
            if (sf.length() != 0 && sf.charAt(sf.length() - 1) == ch) {
                sf.deleteCharAt(sf.length() - 1);
            } else {
                sf.append(ch);
            }
        }
        return sf.toString();
*/

        //直接用字符数组会更快
        char stack[]=new char[S.length()];
        int top=-1;
        for(char ch:S.toCharArray()){
            if(top>=0&&stack[top]==ch){
                top--;
            }
            else{
                stack[++top]=ch;
            }
        }
        return String.valueOf(stack,0,top+1);


    }

}
