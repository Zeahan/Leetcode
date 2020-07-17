package NO100;

import common.TreeNode;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty()) {
            int size = queueP.size();
            if (size != queueQ.size()) {
                return false;
            }
            for (int i=0; i<size; i++) {

                TreeNode pNode = queueP.poll();
                TreeNode qNode = queueQ.poll();

                if (pNode == null && qNode == null) {
                    continue;
                }
                if (pNode == null ^ qNode == null) {
                    return false;
                }
                if (pNode.val != qNode.val) {
                    return false;
                }
                queueP.offer(pNode.left);
                queueQ.offer(qNode.left);
                queueP.offer(pNode.right);
                queueQ.offer(qNode.right);
            }
        }
        return true;
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
//                int leftNumber = Integer.parseInt(item);
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String lineP = "[1,2,3]";
        String lineQ = "[1,2,3]";
            TreeNode p = stringToTreeNode(lineP);
            TreeNode q = stringToTreeNode(lineQ);

            boolean ret = new Solution().isSameTree(p, q);

            String out = booleanToString(ret);

            System.out.print(out);
    }
}
