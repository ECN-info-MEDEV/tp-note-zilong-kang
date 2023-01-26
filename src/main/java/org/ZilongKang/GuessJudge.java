package org.ZilongKang;

import java.util.Arrays;
import java.util.Objects;

public class GuessJudge {
    /**
     * It's the guess that player make
     */
    public static int[] guessInput;
    /**
     * It's the right answer of the tour
     */
    public static int[] answer;
    /**
     * after comparing with the answer, it will give out the prompt
     */
    static public String[] guessPrompt;
    /**
     * whether the player has get the right answer, which means four Black
     */
    static public Boolean guessResult;

    public GuessJudge(int[] guessInput, int[] answer) {
        this.guessInput = guessInput;
        this.answer = answer;
        guessPrompt = new String[4];
    }


    public static String[] getGuessPrompt(int[] guessInput, int[] answer) {
        guessPrompt = new String[4];
        /*
        J is used to indicate the position in guessPrompt
         */
        int j = 0;
        /*
        judge how many Noir, meaning the same position, same color
         */
        for (int i = 0; i < guessInput.length; i++) {
            if (guessInput[i] == answer[i]) {
                guessPrompt[j] = "N";
                j += 1;
            }
        }
        /*
        judge how many blanch, meaning the same color, different color
         */
        int sameColor = 0;
        int color1 = 0;
        int color2 = 0;
        for (int color = 1; color < 7; color++) {
            for (int i = 0; i < guessInput.length; i++) {
                if (guessInput[i] == color) {
                    color1++;
                }
            }
            for (int k = 0; k < guessInput.length; k++) {
                if (answer[k] == color) {
                    color2++;
                }
            }
            sameColor+=Math.min(color1,color2);
            System.out.println(sameColor);
            color1=0;color2=0;
        }
        /*
        change the number of Blanch
         */
        while(j<sameColor){
            guessPrompt[j] = "B";
            j += 1;
        }
        System.out.println(guessPrompt);
        guessResult = Arrays.equals(guessPrompt, new String[]{"B", "B", "B", "B"});
        System.out.println(guessResult);
        return guessPrompt;
    }

    /**
     *
     * @param guessInput
     * @param answer
     * @return boolean guessResult
     */
    public static Boolean getGuessResult(int[] guessInput, int[] answer) {
        guessPrompt = new String[4];
        /*
        J is used to indicate the position in guessPrompt
         */
        int j = 0;
        /*
        judge how many Noir, meaning the same position, same color
         */
        for (int i = 0; i < guessInput.length; i++) {
            if (guessInput[i] == answer[i]) {
                guessPrompt[j] = "N";
                j += 1;
            }
        }
        /*
        judge how many blanch, meaning the same color, different color
         */
        int sameColor = 0;
        int color1 = 0;
        int color2 = 0;
        for (int color = 1; color < 7; color++) {
            for (int i = 0; i < guessInput.length; i++) {
                if (guessInput[i] == color) {
                    color1++;
                }
            }
            for (int k = 0; k < guessInput.length; k++) {
                if (answer[k] == color) {
                    color2++;
                }
            }
            sameColor+=Math.min(color1,color2);
//            System.out.println(sameColor);
            color1=0;color2=0;
        }
        /*
        change the number of Blanch
         */
        while(j<sameColor){
            guessPrompt[j] = "B";
            j += 1;
        }
        System.out.println(Arrays.toString(guessPrompt));
        guessResult = Arrays.equals(guessPrompt, new String[]{"N", "N", "N", "N"});
        System.out.println(guessResult);
        return guessResult;
    }


}
