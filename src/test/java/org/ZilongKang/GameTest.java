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
}
