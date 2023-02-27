package demo1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MainDemo {
    public static void main(String args[]){
        HashSet<Integer> hsI = new HashSet<>();
        hsI.add(2);
        hsI.add(3);
        hsI.add(1);
        hsI.add(2);
        System.out.println("So luong: "+hsI.size());

        PriorityQueue<Integer> pqi = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2>0?-1:1;
            }
        });
        pqi.add(6);
        pqi.add(4);
        pqi.add(7);
        pqi.add(5);
        pqi.add(2);
        while (pqi.size() > 0){
            Integer x = pqi.poll();
            System.out.println(x);
            System.out.println("SL pqi: "+pqi.size());
        }
        HashMap<String,String> hsm = new HashMap<>();
        hsm.put("name","Nguyen Van An");
        hsm.put("class name","T2207A");

        System.out.println(hsm.get("name"));
        System.out.println(hsm.get("class name"));
    }
}
