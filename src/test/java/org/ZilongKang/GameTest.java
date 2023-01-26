package org.ZilongKang;

import org.junit.Test;

public class GameTest {
    Game game = new Game();
    @Test
    public void GameInitiTest(){
        System.out.println(game.getTour());
    }

    @Test
    public void ToutTest(){
        game.runTour();
    }
    @Test
    public void refreshPalteauTest(){
        game.setPlateau(new int[][]{{1,2,3,4},{1,1,1,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}});
        game.refreshPlateau();
    }

    @Test
    public void readInputPionsTest(){
        game.readInputPions(2);
        System.out.println(game.getCurrentPions());
    }
}
