package NO155;



class MinStack {
    int top_index;
    int[] min_indexs;
    int cur_min;
    int[] contents;
    int size = 10;

    /** initialize your data structure here. */
    public MinStack() {
        top_index = -1;
        cur_min = 0;
        contents = new int[size];
        min_indexs = new int[100];
    }

    public void push(int x) {
        if (top_index >= size - 1) {
            size = size*2;
            int[] newArray = new int[size];
            for (int i=0; i<contents.length; i++) {
                newArray[i] = contents[i];
            }
            contents = newArray;
        }
        top_index += 1;
        contents[top_index] = x;
        if (contents[min_indexs[cur_min]] > x) {
            cur_min++;
            min_indexs[cur_min] = top_index;
        }
    }

    public void pop() {
        if (top_index == min_indexs[cur_min]) {
            if (cur_min == 0) {
                min_indexs[cur_min] = 0;
            } else {
                cur_min--;
            }
        }

        if (top_index >= 0) {
            top_index -= 1;
        }

    }

    public int top() {
        return contents[top_index];
    }

    public int getMin() {
        return contents[min_indexs[cur_min]];
    }
}
