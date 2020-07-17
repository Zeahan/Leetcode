package NO297;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        return serializeHelper(root, "");
    }

    public String serializeHelper(TreeNode node, String str) {
        if (node == null) return str + "," + "null";
        str += "," + node.val;
        str = serializeHelper(node.left, str);
        str = serializeHelper(node.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        List<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        dataList.remove(0);
        return deserializeHelper(dataList);
    }

    public TreeNode deserializeHelper(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode cur = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);

        cur.left = deserializeHelper(dataList);
        cur.right = deserializeHelper(dataList);

        return cur;
    }
}


//public class Codec {
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null) return "[]";
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<String> res = new LinkedList<>();
//        queue.offer(root);
//        res.add(Integer.toString(root.val));
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i=0; i<size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.offer(node.left);
//                    res.add(Integer.toString(node.left.val));
//                } else res.add("null");
//
//                if (node.right != null) {
//                    queue.offer(node.right);
//                    res.add(Integer.toString(node.right.val));
//                } else res.add("null");
//            }
//        }
//        return res.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        data = data.replace(" ", "");
//        if (data.equals("")) return null;
//        Queue<String> queue = new LinkedList<>(Arrays.asList(data.substring(1, data.length() - 1).split(",")));
//        Queue<TreeNode> preLevel = new LinkedList<>();
//        if (queue.size() == 0) return null;
//        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
//        preLevel.add(root);
//        while (!queue.isEmpty() && !preLevel.isEmpty()) {
//            int size = preLevel.size();
//            for (int i=0; i<size; i++) {
//                TreeNode cur = preLevel.poll();
//                TreeNode left = null;
//                TreeNode right = null;
//                if (!queue.isEmpty() && !queue.peek().equals("null")) {
//                    left = new TreeNode(Integer.parseInt(queue.poll()));
//                    preLevel.offer(left);
//                } else queue.poll();
//                if (!queue.isEmpty() && !queue.peek().equals("null")) {
//                    right = new TreeNode(Integer.parseInt(queue.poll()));
//                    preLevel.offer(right);
//                } else queue.poll();
//                cur.left = left;
//                cur.right = right;
//            }
//        }
//        return root;
//    }
//}


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

            Codec codec = new Codec();
            String ret = codec.serialize(root);
            TreeNode root2 = codec.deserialize(ret);

            String out = (ret);

            System.out.print(out);
        }
    }
}