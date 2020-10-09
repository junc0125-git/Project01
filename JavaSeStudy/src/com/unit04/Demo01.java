package com.unit04;

/**
 * @author cj
 * @create 2020-09-29 11:23
 */
public class Demo01 {
    public static void main(String[] args){
            int x = 1;
            for(show('a'); show('b') && x<3; show('c')){
                show('d');
                x++;
            }
        }
        public static boolean show(char ch){
            System.out.print(ch);
            return true;
        }//abdcbdcb
    }

