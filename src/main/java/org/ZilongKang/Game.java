package org.ZilongKang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    /**
     * 1 for player1, 2 for player2.
     */
    private int currentCoudeur;
    /**
     * the total tours of game, given by random.
     */
    private int tour;
    /**
     * current tour.
     */
    private int currentTour;
    /**
     * The step number of decoudeur, must <= 12
     */
    private int currentStep;
    /**
     *
     */
    private int[][] plateau = new int[12][4];
    /**
     *
     */
    private List<int[]> indicateur = new ArrayList<>();
    /**
     * score[1]:player1's score;
     * score[2]:player2's score.
     */
    private int[] score = new int[2];

    private final String[] color ={"jaune","bleu", "rouge", "vert", "blanc", "noir"};

    public Game() {

    }

    public void GameInitilization(){
        Random rd = new Random();
        boolean player1Code = false;
        boolean player2Code = false;
        Scanner scanner = new Scanner(System.in);
        while(!player2Code && !player1Code){
            int even = (rd.nextInt(10) + 1) * 2;
            System.out.println("Current tour is" + even+"pleasr enter 1 agree, 0 to regenerate");
        }
    }
}
