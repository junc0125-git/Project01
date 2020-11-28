package daily.question;

import org.junit.Test;

/**
 * @author cj
 * @create 2020-11-03 8:34
 */
public class Num941Test {
    @Test
    public void test(){

    }

    public boolean validMountainArray(int[] A) {//对方法一进行了优化，方法一每次循环都要判断，而优化后只需判断一次
        int i,len;
        i=0;
        len=A.length-1;
        //一直循环找上升
        while (i<len&&A[i]<A[i+1]) i++;
        //看看上升终止时不满足山的情况
        if(i==0||i==len||A[i]==A[i+1]) return false;
        //一直循环找下降
        while (i<len&&A[i]>A[i+1]) i++;
        //判断是否是山体
        if(i==len) return true;
        return false;
    }


    public boolean validMountainArray1(int[] A) {
        int tagUp,tagDown,tag;
        tagUp=0;
        tagDown=0;
        for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1]){
                tagUp=1;
                continue;

            }
            if(A[i]>A[i+1]&&tagUp!=1)
                return false;
            if(tagDown==-1)
                break;
            if(A[i]>A[i+1]&&tagUp==1){
                for(int j=i;j<A.length-1;j++){
                    if(A[j]>A[j+1]){
                        tagDown=-1;
                    }else{
                        return false;
                    }

                }

            }

        }
        return tagDown==-1&&tagUp==1;
    }
}
