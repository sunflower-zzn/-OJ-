import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/23 9:33
 * @Description 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class Solution210323 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public interface NestedInteger {
        public boolean isInteger(); //返回是否是整形

        public Integer getInteger();//如果是Integer就返回整型值，否则返回null

        public List<NestedInteger> getList();   //返回所含的列表

    }

    public static class NestedIterator implements Iterator<Integer> {
        private List<Integer> list;
        private int idx;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            nestnext(nestedList);
            idx = 0;
        }

        private void nestnext(List<NestedInteger> nestedList) {
            for (NestedInteger n : nestedList) {
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    nestnext(n.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < list.size();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
