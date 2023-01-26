package org.ZilongKang;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test1 {

    @Test
    public void test() {
        System.out.println("Hello World!");
        //assertTrue(5<10);
        //assertFalse(5<10);
    }

    @Test
    public void testGuessJudge1() {
        String[] prompt = GuessJudge.getGuessPrompt(new int[]{1, 2, 4, 3}, new int[]{1, 2, 3, 4});
        assertArrayEquals(prompt, new String[]{"N", "N", "B", "B"});
    }

    @Test
    public void testGuessJudge2() {
        String[] prompt = GuessJudge.getGuessPrompt(new int[]{1, 2, 2, 4}, new int[]{1, 1, 1, 1});
        assertArrayEquals(prompt, new String[]{"N",null,null,null});
    }

}
