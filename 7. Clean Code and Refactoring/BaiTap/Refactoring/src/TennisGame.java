public class TennisGame {

    static final int LOVE = 0, FIFTEEN = 1, THIRTY = 2, FORTY = 3, DEUCE = 4;
    String score = "";

    public String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {

        int tempScore;
        if (player1Score == player2Score) {
            equalsScore(player1Score);
        } else if (player1Score >= DEUCE || player2Score >= DEUCE) {
            score(player1Score, player2Score);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score += "-";
                    tempScore = player2Score;
                }
                playerScore(tempScore);
            }
        }
        return score;
    }

    public String score(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    public String playerScore(int tempScore) {
        switch (tempScore) {
            case LOVE:
                score += "Love";
                break;
            case FIFTEEN:
                score += "Fifteen";
                break;
            case THIRTY:
                score += "Thirty";
                break;
            case FORTY:
                score += "Forty";
                break;
        }
        return score;
    }

    public String equalsScore(int playerScore) {
        switch (playerScore) {
            case LOVE:
                score = "Love-All";
                break;
            case FIFTEEN:
                score = "Fifteen-All";
                break;
            case THIRTY:
                score = "Thirty-All";
                break;
            case FORTY:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
