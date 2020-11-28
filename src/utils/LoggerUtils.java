package utils;

public class LoggerUtils {
    public LoggerUtils() {
    }

    private static final String MOVE_FORMAT = "%s rolled a %s and moved from %s to %s.";
    private static final String WIN_FORMAT = "%s wins the game.";
    private static final String REQUEST_FORMAT = "Please enter number of %s";
    private static final String NAME_REQUEST_FORMAT = "Please name of player %d";

    public static void logPlayerNameRequest(int playerId) {
        System.out.println(String.format(NAME_REQUEST_FORMAT, playerId));
    }

    public static void logRequest(String requestParam) {
        System.out.println(String.format(REQUEST_FORMAT, requestParam));
    }

    public static void logMove(String playerName, int diceValue, int startPos, int endPos) {
        System.out.println(String.format(MOVE_FORMAT, playerName, diceValue, startPos, endPos));
    }

    public static void logWin(String playerName) {
        System.out.println(String.format(WIN_FORMAT, playerName));
    }
}
