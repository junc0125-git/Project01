package essay.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-18 21:50
 */
public class Num989Test {
}

class Num989Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] k = new int[5];
        int a, j, i, sum, tag;
        j = k.length - 1;
        sum = 0;
        tag = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (i = 0; i < k.length; i++) {
            a = (int) Math.pow(10, i);
            k[j--] = K / a % 10;
        }
        for (i = 0; i < k.length; i++) {
            if (k[i] == 0)
                continue;
            else {
                  while(i<k.length){
                      temp.add(k[i++]);
                  }
                  break;
            }
        }
        Integer[] arr=new Integer[temp.size()];
        temp.toArray(arr);
        i = A.length - 1;
        j=arr.length-1;

        while (i >= 0 && j >= 0) {
            if (tag == 0)
                sum = A[i] + arr[j];
            else
                sum = A[i] + arr[j] + 1;
            if (sum < 10) {
                list.add(sum);
                tag = 0;
            } else {
                list.add(sum % 10);
                tag = 1;
            }
            i--;
            j--;
        }
        for (; i >= 0; i--) {
            if (tag == 1) {
                list.add(A[i] + 1);
                tag = 0;
            } else {
                list.add(A[i]);
            }
        }
        for (; j >= 0; j--) {
            if (tag == 1) {
                list.add(arr[j] + 1);
                tag = 0;
            } else {
                list.add(arr[j]);
            }
        }
        Collections.reverse(list);
        return list;
    }
}