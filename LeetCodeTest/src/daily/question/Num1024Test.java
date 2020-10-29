package daily.question;

/**
 * @author cj
 * @create 2020-10-24 10:00
 *
 * [[0,5],[1,6],[2,7],[3,8],[4,9],[5,10],[6,11],[7,12],[8,13],[9,14],
 * [10,15],[11,16],[12,17],[13,18],[14,19],[15,20],[16,21],[17,22],[18,23],
 * [19,24],[20,25],[21,26],[22,27],[23,28],[24,29],[25,30],[26,31],[27,32],
 * [28,33],[29,34],[30,35],[31,36],[32,37],[33,38],[34,39],[35,40],[36,41],
 * [37,42],[38,43],[39,44],[40,45],[41,46],[42,47],[43,48],[44,49],[45,50],
 * [46,51],[47,52],[48,53],[49,54]]
 * 50
 */
public class Num1024Test {
}

class Num1024Solution01 {
    public int videoStitching(int[][] clips, int T) {
        //
        int[] target = new int[2], left = new int[2], right = new int[2];
        int count,tagL,tagR;
        target[0] = 0;
        target[1] = T;
        count = 0;
        //clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] <= target[0]) {
                left[0] = clips[i][0];
                left[1] = clips[i][1];
                break;
            }
            if (i == clips.length - 1)
                return -1;
        }
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][1] >= target[1]) {
                right[0] = clips[i][0];
                right[1] = clips[i][1];
                break;
            }
            if (i == clips.length - 1)
                return -1;
        }
        while (true) {
            if (target[0] >= target[1]){
                count--;
                break;
            }

            tagL=0;
            tagR=0;
            for (int i = 0; i < clips.length; i++) {

                if (clips[i][0] <= target[0]) {
                    if (clips[i][1] >= target[1]) {
                        count++;
                        return count;
                    }
                    if (clips[i][1] > left[1]) {
                        left[0] = clips[i][0];
                        left[1] = clips[i][1];
                    }
                }
                if (clips[i][1] >= target[1]) {
                    if(clips[i][0] <= target[0]){
                        count++;
                        return count;
                    }
                    if(clips[i][0] < right[0]){
                        right[0] = clips[i][0];
                        right[1] = clips[i][1];
                    }
                    right[0] = clips[i][0];
                    right[1] = clips[i][1];
                }
            }

            if(target[0]!=left[1]){
                target[0] = left[1];
                tagL=1;
                count++;
            }
            if(target[1] != right[0]){
                target[1] = right[0];
                tagR=1;
                count++;
            }
            if(tagL!=0||tagR!=0){
                continue;
            }else {
                return -1;
            }
        }

        return count;
    }
}