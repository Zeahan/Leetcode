package NO222;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int res;
    int totalDepth;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        totalDepth = 0;
        TreeNode node = root;
        while(node.left != null) {
            res += (int)Math.pow(2, totalDepth);
            node = node.left;
            totalDepth++;
        }
        res += (int)Math.pow(2, totalDepth);
        if (totalDepth == 0) return 1;

        findLastNode(root, totalDepth);
        return res;
    }

    public void findLastNode (TreeNode root, int depth) {
        if (depth == 0) return;

        TreeNode node = root;
        if (depth > 1) node = node.right;
        // 找到倒数第二层中间偏右的节点
        for (int i=2; i<depth; i++) {
            node = node.left;
        }

        if (node.left == null && node.right == null) {
            res -= Math.pow(2, depth) / 2;
            findLastNode(root.left, depth - 1);
            return;
        }

        if (node.left != null && node.right != null) {
            findLastNode(root.right, depth - 1);
            return;
        }

        if (depth == 1) res -= 1;
        else res = res - (int)Math.pow(2, depth) / 2 + 1;
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

            int ret = new Solution().countNodes(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
