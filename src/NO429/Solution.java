package NO429;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        res.add(Arrays.asList(root.val));

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> valList = new LinkedList<>();
            for (int i=0; i<size; i++) {
                Node cur = queue.poll();
                collectChildren(cur.children, valList,queue);
            }
            res.add(valList);
        }
        return res;
    }

    public void collectChildren(List<Node> children, List<Integer> valList, Queue<Node> nodeList) {
        if (children == null) return;
//        for (Node child : children) {
//            valList.add(child.val);
//            nodeList.add(child);
//        }
        nodeList.addAll(children);
    }
}
