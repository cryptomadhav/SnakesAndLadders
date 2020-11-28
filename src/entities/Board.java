package entities;

import constants.GameConstraints;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        Map<Integer, Integer> invertedPaths = new HashMap<>();
        for (Integer entryPoint: snakes.keySet()) {
            invertedPaths.put(GameConstraints.BOARD_SIZE - entryPoint, GameConstraints.BOARD_SIZE - snakes.get(entryPoint));
        }
        this.snakes = invertedPaths;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }
}
