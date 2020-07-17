package NO99;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//class Solution {
//    List<TreeNode> list = new ArrayList<>();
//    List<Integer> valList = new ArrayList<>();
//    public void recoverTree(TreeNode root) {
//        collectNodes(root);
//        Collections.sort(valList);
//        for (int i=0; i<list.size(); i++) {
//            list.get(i).val = valList.get(i);
//        }
//    }
//
//    public void collectNodes(TreeNode root) {
//        if (root == null) return;
//        collectNodes(root.left);
//        list.add(root);
//        valList.add(root.val);
//        collectNodes(root.right);
//    }
//}

//class Solution {
//    TreeNode prev;
//    TreeNode wrongNode1;
//    TreeNode wrongNode2;
//    public void recoverTree(TreeNode root) {
//        helper(root);
//        int temp = wrongNode1.val;
//        wrongNode1.val = wrongNode2.val;
//        wrongNode2.val = temp;
//    }
//
//    public void helper(TreeNode root) {
//        if (root == null) return;
//        helper(root.left);
//        if (prev != null && root.val <= prev.val) {
//            if (wrongNode1 == null) {
//                wrongNode1 = prev;
//            }
//            wrongNode2 = root;
//        }
//        prev = root;
//        helper(root.right);
//    }
//}

/*Morris*/
class Solution {

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode preTemp = null;
        TreeNode[] wrongNodes = {null, null};
        while (root != null) {
            // 左为空，直接处理，然后进入右边
            if (root.left == null) {
                // do something
                checkNode(pre, root, wrongNodes);
                pre = root;
                root = root.right;
            } else {

                // 左不为空，扫描左子树找到前序节点
                preTemp = root.left;
                // 从左子树的右child开始一直向右找到前序节点
                while (preTemp.right != null && preTemp.right != root) {
                    preTemp = preTemp.right;
                }
                // 找到的preTemp已有指向root的右指针，说明已经访问过，直接处理并删除指针，随后进入右子树
                if (preTemp.right != null) {
                    // do something
                    checkNode(pre, root, wrongNodes);

                    preTemp.right = null;
                    pre = root;
                    root = root.right;
                } else {
                    //找到的preTemp无指向root的右指针，说明root左子树未被访问，建立指针并进入左子树
                    preTemp.right = root;
                    root = root.left;
                }
            }
        }

        // 交换
        if (wrongNodes[0] != null && wrongNodes[1] != null) {
            int temp = wrongNodes[0].val;
            wrongNodes[0].val = wrongNodes[1].val;
            wrongNodes[1].val = temp;
        }
    }

    /**
     * 比较当前节点与前序结点的值，并在出现问题时记录
     * @param pre 前序节点
     * @param root 当前节点
     */
    public void checkNode(TreeNode pre, TreeNode root, TreeNode[] wrongNodes) {
        if (pre != null && root.val <= pre.val) {
            // 第一次大小比较出问题，前序节点必有问题（前面的都没有问题，只能把前序节点与后面某节点交换）
            if (wrongNodes[0] == null) wrongNodes[0] = pre;
            // 当前节点可能有问题，最后一次出现时必有问题（无法向后交换）
            wrongNodes[1] = root;
        }
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

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        String line = "[1,2,2,3,4,4,3]";

            TreeNode root = stringToTreeNode(line);

            new Solution().recoverTree(root);
            String out = treeNodeToString(root);

            System.out.print(out);

    }
}
