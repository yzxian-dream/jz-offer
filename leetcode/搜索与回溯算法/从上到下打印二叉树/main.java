package 从上到下打印二叉树;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

















 
class Solution {
    public int[] levelOrder(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>(); 
       List<Integer> list = new ArrayList<>();
       if(root == null){
           return new int[0];
       }
       //二叉树root节点加入到队列中
       queue.add(root);
       while(!queue.isEmpty()){
           //q弹出的root节点，完成使命，弹出的都是完成左右子节点鉴定完毕，并且将其子节点存放到q里的节点
           TreeNode node = queue.poll();
           //存放q弹出的root节点
           list.add(node.val);
           //当前节点从左到右的子节点放入q中，依次循环判断
           if(node.left != null){
               queue.add(node.left);
           }
           if(node.right != null){
               queue.add(node.right);
           }
       }
       int[] res = new int[list.size()];
       for(int i = 0;i<list.size();i++){
           res[i] = list.get(i);
       }
       return res;
   }
   }