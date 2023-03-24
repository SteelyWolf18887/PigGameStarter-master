package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int idPLayerTurn;

    public int getIdPLayerTurn() {
        return idPLayerTurn;
    }

    public void setIdPLayerTurn(int idPLayerTurn) {
        this.idPLayerTurn = idPLayerTurn;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getCurrentPlayerScore() {
        return currentPlayerScore;
    }

    public void setCurrentPlayerScore(int currentPlayerScore) {
        this.currentPlayerScore = currentPlayerScore;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    private int player0Score;
    private int player1Score;
    private int currentPlayerScore;
    private int diceValue;

    public PigGameState(){
        idPLayerTurn = 0;
        diceValue = 1;
        player0Score = 0;
        player1Score = 0;
        currentPlayerScore = 0;
    }

    public PigGameState(PigGameState piggameState) {
        idPLayerTurn = piggameState.getIdPLayerTurn();
        player1Score = piggameState.getPlayer1Score();
        player0Score = piggameState.getPlayer0Score();
        diceValue = piggameState.getDiceValue();
        currentPlayerScore = piggameState.getCurrentPlayerScore();
    }
}
