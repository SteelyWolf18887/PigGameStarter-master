package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {


    public PigGameState pigGameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        this.pigGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == pigGameState.getCurrentPlayerScore()) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigHoldAction) {
            if (pigGameState.getIdPLayerTurn() == 0) {
                pigGameState.setPlayer0Score(pigGameState.getCurrentPlayerScore() + pigGameState.getPlayer0Score());
            } else {
                pigGameState.setPlayer1Score(pigGameState.getCurrentPlayerScore() + pigGameState.getPlayer1Score());
            }
            pigGameState.setCurrentPlayerScore(0);
            return true;
        } else if (action instanceof PigRollAction) {
            Random random = new Random();
            pigGameState.setCurrentPlayerScore(random.nextInt(5) + 1);
            if (pigGameState.getDiceValue() == 1) {
                pigGameState.setIdPLayerTurn(0);
                alternatingPlayer();
            } else {
                pigGameState.setCurrentPlayerScore(pigGameState.getCurrentPlayerScore() + pigGameState.getDiceValue());
                return true;
            }
            return true;
        }//makeMove
        return false;
    }

        /**
         * send the updated state to a given player
         */
        @Override
        protected void sendUpdatedStateTo(GamePlayer p) {
                //TODO  You will implement this method
            PigGameState copyPGS = new PigGameState(pigGameState);
            p.sendInfo(copyPGS);
        }//sendUpdatedSate

        /**
         * Check if the game is over
         *
         * @return
         *                a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pigGameState.getPlayer0Score() >= 50){
            return this.playerNames[0] + "WINS! Score;" + pigGameState.getPlayer0Score();
        } else if (pigGameState.getPlayer1Score() >= 50) {
            return this.playerNames[1] + "WINS! Score:" + pigGameState.getPlayer1Score();
        }
        return null;
    }

    protected void alternatingPlayer() {
            if (this.players.length == 1) {
                 //Do nothing
            } else if (this.players.length == 2) {
                if (pigGameState.getIdPLayerTurn() == 0) {
                    pigGameState.setIdPLayerTurn(1);
                } else {
                    pigGameState.setIdPLayerTurn(0);
                }
            }
        }
}// class PigLocalGame


