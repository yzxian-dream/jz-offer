package 数学.数组中出现次数超过一半的数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
    public int inventoryManagement(int[] stock) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int id : stock) {
            if (!map.containsKey(id)) {
                map.put(id, 1);
            }else{
                map.put(id, map.get(id)+1);
            }
        }
        // ArrayList<Integer> l = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue()>stock.length/2) {
                // l.add(entry.getKey());
                return entry.getKey();
            }
        }
        return -1;
    }
}
