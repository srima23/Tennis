package tennis;


public class TennisMatch {
    private String player1;
    private String player2;
    private MatchScore scorePlayer1;
    private MatchScore scorePlayer2;

    public TennisMatch(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = new MatchScore();
        this.scorePlayer2 = new MatchScore();
    }

    public void updatePoints(String player) {
        if (player.equals(player1)) {
            scorePlayer1.updatePoints();
        } else if (player.equals(player2)) {
            scorePlayer2.updatePoints();
        } else {
            throw new IllegalArgumentException("Invalid player");
        }

        updateGamesAndSets();
    }
   private void updateGamesAndSets() {
        if (isDeuce()) {
            scorePlayer1.resetPoints();
            scorePlayer2.resetPoints();
        } else if (isAdvantage()) {
            if (scorePlayer1.getPoints() > scorePlayer2.getPoints()) {
                scorePlayer1.updateGames();
            } else {
                scorePlayer2.updateGames();
            }
            scorePlayer1.resetPoints();
            scorePlayer2.resetPoints();
        } else if (scorePlayer1.getPoints() >= 4 && Math.abs(scorePlayer1.getPoints() - scorePlayer2.getPoints()) >= 2) {
            if (scorePlayer1.getPoints() > scorePlayer2.getPoints()) {
                scorePlayer1.updateGames();
            } else {
                scorePlayer2.updateGames();
            }
            scorePlayer1.resetPoints();
            scorePlayer2.resetPoints();
        }

        updateSets();
    }

 private boolean isDeuce() {
        return scorePlayer1.getPoints() >= 3 && scorePlayer2.getPoints() == scorePlayer1.getPoints();
    }

    private boolean isAdvantage() {
        return scorePlayer1.getPoints() >= 4 && scorePlayer2.getPoints() >= 3 &&
               Math.abs(scorePlayer1.getPoints() - scorePlayer2.getPoints()) == 1;
    }

    private void updateSets() {
        if (scorePlayer1.getGames() >= 6 && Math.abs(scorePlayer1.getGames() - scorePlayer2.getGames()) >= 2) {
            if (scorePlayer1.getGames() > scorePlayer2.getGames()) {
                scorePlayer1.updateSets();
            } else {
                scorePlayer2.updateSets();
            }
            scorePlayer1.resetGames();
            scorePlayer2.resetGames();
        }
        updateMatches();
    }
    private void updateMatches() {
        if (scorePlayer1.getSets() >= 2) {
            scorePlayer1.updateMatches();
            scorePlayer1.resetSets();
            scorePlayer2.resetSets();
        } else if (scorePlayer2.getSets() >= 2) {
            scorePlayer2.updateMatches();
            scorePlayer1.resetSets();
            scorePlayer2.resetSets();
        }
    }
    

    
    public MatchScore getScorePlayer1() {
        return scorePlayer1;
    }

    public MatchScore getScorePlayer2() {
        return scorePlayer2;
    }

    public static void main(String[] args) {
        String player1Name = "Roger Federer";
        String player2Name = "Rafael Nadal";
        TennisMatch match = new TennisMatch(player1Name, player2Name);

       
        match.updatePoints(player1Name);
        match.updatePoints(player2Name);
        match.updatePoints(player1Name);
        match.updatePoints(player2Name);
        match.updatePoints(player1Name);
        match.updatePoints(player2Name);
        match.updatePoints(player1Name);
        match.updatePoints(player2Name);
        

        MatchScore scorePlayer1 = match.getScorePlayer1();
        MatchScore scorePlayer2 = match.getScorePlayer2();
        System.out.println(player1Name + " Score: " + scorePlayer1.toString());
        System.out.println(player2Name + " Score: " + scorePlayer2.toString());
    }
}


  

