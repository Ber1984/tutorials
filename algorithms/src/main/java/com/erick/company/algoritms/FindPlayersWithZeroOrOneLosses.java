package com.erick.company.algoritms;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        int[][] matches = new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        findWinners(matches);

    }

    private static List<List<Integer>> findWinners(int[][] matches){
        Map<Integer, Integer> lossesCount = new HashMap<>();
        for (int[] match : matches) {
            System.out.println(Arrays.toString(match));
            int winner = match[0], loser = match[1];
            lossesCount.put(winner, lossesCount.getOrDefault(winner, 0));
            lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
        }
        lossesCount.forEach((k,v) -> System.out.println("key" + k + "value" + v));
        List<List<Integer>> answer =
                Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Integer player : lossesCount.keySet())
            if (lossesCount.get(player) == 0) {
                answer.get(0).add(player);
            } else if (lossesCount.get(player) == 1) {
                answer.get(1).add(player);
            }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
 }
