package NO129;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int sum;
    int cur;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        cur = 0;
        collectNumbers(root);
        return sum;
    }

    public void collectNumbers(TreeNode root) {
        if (root == null) return;

        // 首先访问根节点，将根节点的值计入当前数字
        cur = cur * 10 + root.val;

        // 查找左子树
        collectNumbers(root.left);
        // 查找右子树
        collectNumbers(root.right);

        // 如果当前节点为叶子节点，将当前数值计入总和；
        if (root.left == null && root.right == null) sum += cur;

        // 结束一个节点后，将当前数值中该节点的值退回
        cur = cur / 10;
    }
}

class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution().sumNumbers(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}