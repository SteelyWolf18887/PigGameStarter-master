package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState pgs = new PigGameState((PigGameState)info);
        if(pgs.getIdPLayerTurn() != playerNum){
            return;
        }
        Random random = new Random();
        if(random.nextBoolean()){
            sleep(2000);
            PigHoldAction pha = new PigHoldAction(this);
            this.game.sendAction(pha);
        }else{
            sleep(2000);
            PigRollAction pna = new PigRollAction(this);
            this.game.sendAction(pna);
        }
    }//receiveInfo

}
