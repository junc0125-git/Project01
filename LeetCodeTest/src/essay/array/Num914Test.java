package essay.array;

/**
 * @author cj
 * @create 2020-10-17 9:52
 */
public class Num914Test {
}
/*
class Num914Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==1)
            return false;
        int count,minCount;
        count=1;
        minCount=deck.length;
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(deck);
        for(int i=0;i<deck.length-1;i++){
            if(i==deck.length-2&&deck[i+1]!=deck[i])
                return false;
            if(deck[i]==deck[i+1]){
                count++;
                continue;
            }
            if(count<2)
                return false;
            else{
                minCount=minCount<count?minCount:count;
                set.add(count);
                count=1;
            }
        }
        minCount=minCount<count?minCount:count;
        set.add(count);
        for(int a:set){
            minCount=Math.gcd(minCount,a%minCount);
            if(minCount<2)
                return false;
        }
        return true;
    }
}*/
