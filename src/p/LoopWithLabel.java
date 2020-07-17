package p;


import java.util.HashMap;

public class LoopWithLabel {
    public static void main(String[] args) {
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;
        HashMap A;
        A:
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(j==3) {
                    break A;
                }
                System.out.print(""+i+j+" ");
            }
            System.out.println();
        }
        System.out.println("This is end");
    }
}
