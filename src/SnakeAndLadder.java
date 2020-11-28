import entities.Board;
import entities.Player;
import managers.GameManager;
import utils.LoggerUtils;

public class SnakeAndLadder {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.gameInit();
        while(true) {
            Player winner = gameManager.playRound();
            if(winner != null) {
                LoggerUtils.logWin(winner.getName());
                break;
            }
        }
    }
}
