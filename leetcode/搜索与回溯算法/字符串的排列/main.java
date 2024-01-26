package 搜索与回溯算法.字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
 * 输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8

//回溯算法的理解
https://blog.csdn.net/qq_32727095/article/details/115672861
这是一棵非常简单的3叉树，假如要对他进行DFS遍历，当沿着1→2这条路径走下去的时候，list中应该是[1，2]。

因为是递归调用最终还会回到节点1，如果不把2给移除掉，当沿着1→4这个分支走下去的时候就变成[1，2，4]，但实际上1→4这个分支的结果应该是[1，4]，
这是因为我们把前一个分支的值给带过来了。

当1，2这两个节点遍历完之后最终还是返回节点1，在回到节点1的时候就应该把节点2的值给移除掉，让list变为[1]，然后再沿着1→4这个分支走下去，结果就是[1，4]。
 */
// public class main {
//     List<String> list = new ArrayList<>();
//     public String[] permutation(String s) {
//         if (s.length() == 0) {
//             return new String[0];
//         }
//         char[] charArr = s.toCharArray();
//         Arrays.sort(charArr); //排序字符数组让重复的字符排在一起，便于dfs时进行剪枝和去重
//         dfs(charArr,new boolean[charArr.length],new StringBuilder());        
//         String[] ret = new String[list.size()];
//         for (int i = 0; i < list.size(); i++) {
//             ret[i] = list.get(i);
//         }
//         return ret;
//     }

//     private void dfs(char[] charArr, boolean[] visited, StringBuilder sb) {
//         //当stringbuilder存储的字符达到了给定字符串的长度时，就说明一个完整的排列组合就完成了，装进list就行。
//         if (charArr.length == sb.length()) {
//             list.add(sb.toString());
//             return;
//         }
//         for (int i = 0; i < charArr.length; i++) {
//             if (visited[i]) {
//                 continue;
//             }
//             if (i>0 && charArr[i] == charArr[i-1] && !visited[i-1]) {
//                 continue;
//             }
//             visited[i] = true;
//             sb.append(charArr[i]);
//             dfs(charArr, visited, sb);
//             //为了不把当前分枝深搜的最后一个值回溯到另一个分支，要进行删除后再进行下一步搜索。
//             sb.deleteCharAt(sb.length()-1);
//             visited[i] = false;
//         }
//     }
// }

//方法二
//set转数组
/**
        类似于 全排列2，本题使用set来去除重复元素
        使用set去重外，使用visited数组进行剪枝！
        除了使用set去重外，还可以对数组进行排序，使用visited数组进行剪枝！
*/
//有了set就不用考虑去重等操作了

public class main {
    Set<String> res = new HashSet<>();
    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        boolean[] visitid = new boolean[s.length()];
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(charArr,sb,visitid);
        return res.toArray(new String[0]);
    }
    private void dfs(char[] charArr, StringBuilder sb,boolean[] visited) {
        if (charArr.length == sb.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < charArr.length; i++) {
            if (visited[i]) {
                continue;
            }
            sb.append(charArr[i]);
            visited[i] = true;
            dfs(charArr, sb,visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
        
    }
}

//超出时间限制
// public class main {
//     // Set<String> res = new HashSet<>();
//     public String[] permutation(String s) {
//         ArrayList<String> list = new ArrayList<>();
//         if(s != null && s.length() > 0) {
//             PermutationHelper(list, s.toCharArray(), 0);
//             Collections.sort(list);
//         }
//         String[] ret = new String[list.size()];
//         for (int index = 0; index < list.size(); index++) {
//             ret[index] = list.get(index);
//         }
//         return ret;
//     }

//     public void PermutationHelper(ArrayList<String> list, char[] characters, int i) {
//     	// 如果只剩一个字符，则比较结果集中是否已存在当前组合，没有就添加
//         if(i == characters.length - 1) {
//             String str = new String(characters);
//             if(!list.contains(str)) {
//                 list.add(str);
//             }
//         } else {
//         	// 递归的主体，第一次交换相当于固定字符，之后还要交换回来
//             for(int j = i; j < characters.length; j++) {
//                 swap(characters, i, j);
//                 PermutationHelper(list, characters, i + 1);
//                 swap(characters, i, j);
//             }
//         }
//     }
    
//     public void swap(char[] characters, int i, int j) {
//         char temp = characters[i];
//         characters[i] = characters[j];
//         characters[j] = temp;
//     }

// }

