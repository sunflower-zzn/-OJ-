/**
 * @Author sunflower_zzn
 * @Date 2021/4/20 18:33
 * @Description 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class Solution210420x {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) return 0;
        if (haystack.length() < needle.length()) return -1;
        return haystack.indexOf(needle);
    }
}
