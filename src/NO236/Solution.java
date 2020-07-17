package NO236;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    HashMap<TreeNode,TreeNode> childParentPairs = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getParents(root, null);

        TreeNode pAncestor = p;
        TreeNode qAncestor = q;

        List<TreeNode> visitedAncestorsOfP = new ArrayList<>();
        visitedAncestorsOfP.add(pAncestor);
        while(childParentPairs.containsKey(pAncestor)) {
            pAncestor = childParentPairs.get(pAncestor);
            visitedAncestorsOfP.add(pAncestor);
        }

        do {
            if (visitedAncestorsOfP.contains(qAncestor)) break;
            qAncestor = childParentPairs.get(qAncestor);
        } while (childParentPairs.containsKey(qAncestor));

        return qAncestor;
    }

    public void getParents(TreeNode cur, TreeNode parent) {
        if (cur == null) return;
        if (parent != null) childParentPairs.put(cur, parent);
        getParents(cur.left, cur);
        getParents(cur.right, cur);
    }
}


//class Solution {
//    LinkedList<TreeNode> pAncestor;
//    LinkedList<TreeNode> qAncestor;
//    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
//        pAncestor = new LinkedList<>();
//        qAncestor = new LinkedList<>();
//
//        findAncestors(root, p, pAncestor);
//        findAncestors(root, q, qAncestor);
//
//        TreeNode pTemp = null;
//        TreeNode qTemp = null;
//        while (true) {
//            pTemp = pAncestor.pollFirst();
//            if (pTemp != qAncestor.getFirst()) break;
//            qTemp = qAncestor.pollFirst();
//        }
//
//        return qTemp;
//    }
//
//    public boolean findAncestors(TreeNode root, int target, LinkedList<TreeNode> ancestors) {
//        if (root == null) return false;
//        ancestors.add(root);
//        if (root.val == target) return true;
//
//        boolean isAncestor = findAncestors(root.left, target, ancestors)
//                || findAncestors(root.right, target, ancestors);
//
//        if (!isAncestor) ancestors.removeLast();
//        return isAncestor;
//    }
//}



//class MainClass {
//    public static TreeNode stringToTreeNode(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return null;
//        }
//
//        String[] parts = input.split(",");
//        String item = parts[0];
//        TreeNode root = new TreeNode(Integer.parseInt(item));
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//
//        int index = 1;
//        while(!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.remove();
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int leftNumber = Integer.parseInt(item);
//                node.left = new TreeNode(leftNumber);
//                nodeQueue.add(node.left);
//            }
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int rightNumber = Integer.parseInt(item);
//                node.right = new TreeNode(rightNumber);
//                nodeQueue.add(node.right);
//            }
//        }
//        return root;
//    }
//
//    public static String treeNodeToString(TreeNode root) {
//        if (root == null) {
//            return "[]";
//        }
//
//        String output = "";
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//        while(!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.remove();
//
//            if (node == null) {
//                output += "null, ";
//                continue;
//            }
//
//            output += String.valueOf(node.val) + ", ";
//            nodeQueue.add(node.left);
//            nodeQueue.add(node.right);
//        }
//        return "[" + output.substring(0, output.length() - 2) + "]";
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            TreeNode root = stringToTreeNode(line);
//            line = in.readLine();
//            int p = Integer.parseInt(line);
//            line = in.readLine();
//            int q = Integer.parseInt(line);
//
//            TreeNode ret = new Solution().lowestCommonAncestor(root, p, q);
//
//            String out = treeNodeToString(ret);
//
//            System.out.print(out);
//        }
//    }
//}