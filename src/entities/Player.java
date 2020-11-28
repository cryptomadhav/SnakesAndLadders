package entities;

import constants.GameConstraints;

public class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = GameConstraints.STARTING_POSITION;
    }

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
