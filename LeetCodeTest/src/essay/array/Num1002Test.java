package essay.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-21 9:57
 */
public class Num1002Test {
    public static void main(String[] args) {
        Num1002Solution test=new Num1002Solution();
        String[] str={"bellar","label","roller"};
        List<String> rt=test.commonChars(str);
        System.out.println(rt);
    }
}
class Num1002Solution {
    public List<String> commonChars(String[] A) {
        //创建字符列表数组，每个字符串都存到一个字符列表中
        List<HashMap<Character,Integer>> list=new ArrayList<>();
        List<String> rt=new ArrayList<>();

        //hashmap: key: 字符的值  value: 字符在字符串中出现的次数
        for(int i=0;i<A.length;i++){
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=0;j<A[i].length();j++){
                char key=A[i].charAt(j);
                map.put(key,map.getOrDefault(key,0)+1);

            }
            list.add(map);
        }
        //通过key查找各个字符的出现次数，选取最小值，存到一个新的map中

        int minCount,count,tagBreak;
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < A[0].length(); i++) {
            set.add(A[0].charAt(i));
        }
        for (Character key:set) {

            minCount=Integer.MAX_VALUE;
            count=0;
            tagBreak=0;
            for (int j = 0; j < list.size(); j++) {
                if(!list.get(j).containsKey(key)){
                    tagBreak=1;
                    break;
                }
                count=list.get(j).get(key);
                minCount=minCount<count?minCount:count;
            }
            if(tagBreak==1)
                continue;
            for (int j = 0; j < minCount; j++) {
                rt.add(Character.toString(key));
            }
        }
        return rt;
    }
}