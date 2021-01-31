// 1.31
// 839. Similar String Groups(相似字符串组)

/*
如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？

输入：strs = ["tars","rats","arts","star"]
输出：2

输入：strs = ["omv","ovm"]
输出：1
 
提示：
1 <= strs.length <= 100
1 <= strs[i].length <= 1000
sum(strs[i].length) <= 2 * 104
strs[i] 只包含小写字母。
strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。

备注：
      字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词
*/

public class Solution210131 {
    public int numSimilarGroups(String[] strs) {
        UF uf=new UF(strs.length);
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(uf.find(i)==uf.find(j))continue;
                if(check(strs[i],strs[j])){
                    uf.union(i,j);
                }
            }
        }
        return uf.groups;
    }

    boolean check(String s1,String s2){
        //因为strs数组内都是字母异位词，所以不同的字符数一定是偶数，如果大于2就不相似
        int ans=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) ans++;
            if(ans>2)return false;
        }
        return true;
    }

    class UF{
        int[] parent;
        int count;      //记录并查集元素个数
        int groups;     //记录并查集元素组数

        public UF(int n){
            parent = new int[n];
            count=n;
            groups=n;
            for(int i=0;i<count;i++){
                parent[i]=i;
            }
        }

        public int find(int u){
            if(parent[u]==u)return u;
            return find(parent[u]);
        }

        public void union(int p,int q){
            int rootp=find(p);
            int rootq=find(q);
            if(rootp==rootq)return;
            parent[rootq]=rootp;
            groups--;       //组数减一
        }
    }

}
