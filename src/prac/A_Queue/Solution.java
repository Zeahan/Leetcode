package prac.A_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> tested = new ArrayList<>();
        int step = 0;

        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                String currentNode = queue.poll();
                if (currentNode == null) {
                    return -1;
                }
                tested.add(currentNode);
                if (currentNode.equals(target)) {
                    return step;
                }
                if (!Arrays.asList(deadends).contains(currentNode)) {
                    changePwd(currentNode, 0, queue, tested);
                    changePwd(currentNode, 1, queue, tested);
                    changePwd(currentNode, 2, queue, tested);
                    changePwd(currentNode, 3, queue, tested);
                }
            }
            step += 1;
        }
        return step;
    }


    public void changePwd(String pwd, int bit, Queue<String> queue, ArrayList<String>tested){
        int i = Integer.parseInt(pwd.substring(bit, bit + 1));
        int newBitUp = (i + 1) % 10;
        int newBitDown = (i + 9) % 10;
        String newPwdUp = pwd.substring(0, bit) + newBitUp + pwd.substring(bit + 1, 4);
        String newPwdDown = pwd.substring(0, bit) + newBitDown + pwd.substring(bit + 1, 4);
        if (!tested.contains(newPwdUp)) {
            queue.offer(newPwdUp);
        }
        if (!tested.contains(newPwdDown)) {
            queue.offer(newPwdDown);
        }
    }
}
