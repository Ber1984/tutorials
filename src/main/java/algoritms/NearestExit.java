package algoritms;

import java.util.ArrayList;
import java.util.List;

public class NearestExit {


    public static void main(String[] args) {
        //System.out.println(nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1,0}));
        System.out.println(nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1,0}));

    }
    public static int nearestExit(char[][] maze, int[] entrance) {
        int nearestExit = Integer.MAX_VALUE;
        List<List<Integer>> possibleExists = new ArrayList<>();
        for(int i = 0;i<maze.length;i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0;j<maze[i].length;j++) {
                if(i != entrance[0] || j != entrance[1]) {
                    if (maze[i][j] == '.') {
                        tmp.add(i);
                        tmp.add(j);
                        possibleExists.add(tmp);
                        System.out.println(tmp);
                    }
                }
                tmp = new ArrayList<>();
            }
        }
        System.out.print(possibleExists);

        for(int i  = 0;i<possibleExists.size();i++) {
            for(int j = 0;j<possibleExists.get(i).size();j++) {
                int k = 0, diff = 0;
                while(true) {
                    if(k == entrance.length - 1) break;
                    if(possibleExists.get(i).get(j) == entrance[k]) break;
                    if(possibleExists.get(i).get(j) != entrance[k]) {
                        diff =  Math.abs(possibleExists.get(i).get(j) - entrance[k]);
                        System.out.println("nearest" + diff);
                        break;
                    }
                    k++;
                }
                nearestExit = Math.min(nearestExit, diff);

                System.out.println("diff" + diff);
            }
        }
        return nearestExit;
    }
}
