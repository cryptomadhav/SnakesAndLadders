package utils;

import constants.GameConstraints;

import java.util.HashMap;
import java.util.Map;

public class GenerateUtils {

    public static Map<Integer, Integer> generatePaths(int count) {
        HashMap<Integer, Integer> paths = new HashMap<>();
        for(int i = 0; i < count; i ++) {
            int start =  MiscUtils.generateUnusedBetween(1, GameConstraints.BOARD_SIZE - 1, paths);
            paths.put(start, MiscUtils.generateUnusedBetween(start + 1, GameConstraints.BOARD_SIZE, new HashMap<>()));
        }
        return paths;
    }

    public static int[] generateMoves(int movesCount) {
        int[] moves = new int[movesCount];
        for(int i = 0; i < movesCount; i ++) {
            moves[i] = rollDice();
        }
        return moves;
    }

    public static int rollDice() {
        return MiscUtils.generateBetween(1, 6) + MiscUtils.generateBetween(1, 6);
    }
}
