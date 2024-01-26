class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class main {
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;

        TreeNode left =  mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;


        return root;
    }

    public static void main(String[] args) {
        BinaryTreeMirror solution = new BinaryTreeMirror();

        // 构造二叉树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // 输出原始二叉树
        System.out.println("原始二叉树：");
        printTree(root);

        // 获取镜像二叉树
        TreeNode mirrorRoot = solution.mirrorTree(root);

        // 输出镜像二叉树
        System.out.println("镜像二叉树：");
        printTree(mirrorRoot);
    }

    // 递归打印二叉树
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
