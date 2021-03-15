// 3.13
// 705. Design HashSet(设计hashset)

/*
不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
实现 MyHashSet 类：
void add(key) 向哈希集合中插入值 key 。
bool contains(key) 返回哈希集合中是否存在这个值 key 。
void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

输入：
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
输出：
[null, null, null, true, false, null, true, null, false]

解释：
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // 返回 True
myHashSet.contains(3); // 返回 False ，（未找到）
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // 返回 True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // 返回 False ，（已移除）
 
提示：
0 <= key <= 106
最多调用 104 次 add、remove 和 contains 。
*/

import java.util.ArrayList;
import java.util.List;

public class Solution210313_less {
    class MyHashSet {
        List<Integer> set;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            set = new ArrayList<>();
        }

        public void add(int key) {
            if(!set.contains(key)){
                set.add(key);
            }
        }

        public void remove(int key) {
            if(set.contains(key)){
                set.remove(Integer.valueOf(key));
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return set.contains(key);
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
