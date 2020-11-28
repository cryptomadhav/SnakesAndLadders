package managers;

import constants.GameConstraints;
import entities.Board;
import entities.Player;
import utils.GenerateUtils;
import utils.LoggerUtils;

import java.util.Scanner;

public class GameManager {

    private Board gameBoard;
    private Player[] players;
    private Scanner scanner;

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void gameInit() {
        this.gameBoard = new Board();
        this.scanner = new Scanner(System.in);
        generateSnakes();
        generateLadders();
        generatePlayers();
    }

    private void generateSnakes() {
        LoggerUtils.logRequest("snakes");
        int snakeCounts = this.scanner.nextInt();
        this.gameBoard.setSnakes(GenerateUtils.generatePaths(snakeCounts));
    }

    private void generateLadders() {
        LoggerUtils.logRequest("ladders");
        int ladderCount = this.scanner.nextInt();
        this.gameBoard.setLadders(GenerateUtils.generatePaths(ladderCount));
    }

    private void generatePlayers() {
        LoggerUtils.logRequest("player");
        int playerCount = this.scanner.nextInt();
        Player[] players = new Player[playerCount];
        for(int i = 0; i < playerCount; i ++) {
            LoggerUtils.logPlayerNameRequest(i + 1);
            String playerName = this.scanner.next();
            players[i] = new Player(playerName);
        }
        this.players = players;
    }

    public Player playRound() {
        for(Player playerWithTurn : players) {
            if (playTurn(playerWithTurn)) {
                return playerWithTurn;
            }
        }
        return null;
    }

    public boolean playTurn(Player player) {
        int diceRoll = GenerateUtils.rollDice();
        int startPos = player.getPosition();
        player.setPosition(player.getPosition() + diceRoll);
        playPostTurn(player);
        LoggerUtils.logMove(player.getName(), diceRoll, startPos, player.getPosition());
        return player.getPosition() >= GameConstraints.BOARD_SIZE;
    }

    private void playPostTurn(Player player) {
        if(gameBoard.getLadders().containsKey(player.getPosition())) {
            player.setPosition(gameBoard.getLadders().get(player.getPosition()));
        }
        if(gameBoard.getSnakes().containsKey(player.getPosition())) {
            player.setPosition(gameBoard.getSnakes().get(player.getPosition()));
        }
    }
}
