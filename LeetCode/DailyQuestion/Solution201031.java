// 10.31
// 381 Insert Delete GetRandom O(1) - Duplicates allowed

/*
    设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
    注意: 允许出现重复元素。
    insert(val)：向集合中插入元素 val。
    remove(val)：当 val 存在时，从集合中移除一个 val。
    getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。

    // 初始化一个空的集合。
    RandomizedCollection collection = new RandomizedCollection();

    // 向集合中插入 1 。返回 true 表示集合不包含 1 。
    collection.insert(1);

    // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
    collection.insert(1);

    // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
    collection.insert(2);

    // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
    collection.getRandom();

    // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
    collection.remove(1);

    // getRandom 应有相同概率返回 1 和 2 。
    collection.getRandom();
*/

import java.util.*;

public class Solution201031 {
    List<Integer> nums = new ArrayList<Integer>();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    static Random rand = new Random();

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1); //set中记录下每一个val出现的下标
        map.put(val, set);
        return set.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false; //val不存在
        Iterator<Integer> iterator = map.get(val).iterator();
        int idx = iterator.next(); //获得HashSet中的一个下标
        if (idx == nums.size() - 1) {
            //如果idx就是最后一个，将map中val的最后一个下标删除以及删去nums的最后一个即可
            map.get(val).remove(idx);
        } else {
            //否则，为了O1，需要将nums最后一个移动到idx位置，填补位置，并修改两个数在map中的对应值
            int lastNum = nums.get(nums.size() - 1);
            nums.set(idx, lastNum);
            map.get(val).remove(idx);
            //删去lastNum的最后一个下标并加上idx下标
            map.get(lastNum).remove(nums.size() - 1);
            map.get(lastNum).add(idx);
        }
        if (map.get(val).size() == 0) map.remove(val); //如果删去一个后val清空了，remove对应的键值对
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size())); //Math.random()返回0~1的一个伪随机数
    }
}
