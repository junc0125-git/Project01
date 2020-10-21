package essay.array;

/**
 * @author cj
 * @create 2020-10-21 9:25
 */
public class Num999Test {
}

class Num999Solution {
    public int numRookCaptures(char[][] board) {
        int count;
        count = 0;
        int rX, rY, tagBreak,changeCoordinate;
        rX = 0;
        rY = 0;
        tagBreak = 0;
        changeCoordinate=0;
        for (int i = 0; i < 8; i++) {
            if (tagBreak == 1)
                break;
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rX = j;
                    rY = i;
                    tagBreak = 1;
                    break;
                }
            }
        }
        //up rY--
        changeCoordinate=rY;
        while(--changeCoordinate>=0){
            if(board[changeCoordinate][rX]=='p'){
                count++;
                break;
            }else if(board[changeCoordinate][rX]=='B'){
                break;
            }
        }

        //down rY++
        changeCoordinate=rY;
        while(++changeCoordinate<8){
            if(board[changeCoordinate][rX]=='p'){
                count++;
                break;
            }else if(board[changeCoordinate][rX]=='B'){
                break;
            }
        }

        //left rX--
        changeCoordinate=rX;
        while(--changeCoordinate>=0){
            if(board[rY][changeCoordinate]=='p'){
                count++;
                break;
            }else if(board[rY][changeCoordinate]=='B'){
                break;
            }
        }

        //right rX++
        changeCoordinate=rX;
        while(++changeCoordinate<8){
            if(board[rY][changeCoordinate]=='p'){
                count++;
                break;
            }else if(board[rY][changeCoordinate]=='B'){
                break;
            }
        }

        return count;
    }
}