package essay.array;

/**
 * @author cj
 * @create 2020-10-13 11:03
 */
public class Num566Test {
}

class Num566Solution01 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[0].length!=r*c)
            return nums;
        int[][] temp = new int[r][c];
        int m,n;
        m=0;
        n=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp[m][n]=nums[i][j];
                n++;
                if(n>=c){
                    n=0;
                    m++;
                }
            }
        }
        return temp;
    }
}