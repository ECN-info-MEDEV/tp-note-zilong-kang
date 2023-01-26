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
    private int[] currentPions = new int[4];
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
    /**
     * "jaune", "bleu", "rouge", "vert", "blanc", "noir"
     * 1         2         3        4       5       6
     */
    private final int[] color = {1, 2, 3, 4, 5, 6};

    public Game() {
        GameInitilization();

    }

    public void Tour() {
        boolean invalid = true;
        currentStep = 0;
        while (currentTour < tour) {
            if (currentTour % 2 == 0) {
                currentCoudeur = 1;
            } else {
                currentCoudeur = 2;
            }
            System.out.println("current coudeur is player" + currentCoudeur);
            System.out.println("please enter 4 colors, seperated by space, like \"1 3 4 5\"");
            Scanner scanner = new Scanner(System.in);
            String inputStr = scanner.nextLine();
            String input[] = inputStr.split(" ");
            if (input.length > 4) {
                System.out.println("invalid input");
                continue;
            }
            for (int i = 0; i < 4; i++) {
                currentPions[i] = Integer.parseInt(input[i]);
                if (currentPions[i] > 6 || currentPions[i] < 0) {
                    System.out.println("invalid input, try again");
                    invalid = false;
                    break;
                }
            }
            if (!invalid) {
                continue;
            }

            while (currentStep < 12) {
                System.out.println("decodeur " + (currentStep + 1) + "try");
                readInputPions(currentStep);
                if(judge()){
                    
                }
                currentStep++;
            }

            currentTour++;

        }


    }

    /**
     * judge enter with
     * @return
     */
    public boolean judge(){
        return false;
    }

    /**
     *
     * @param currentStep current step that decodeur has.
     */
    public void readInputPions(int currentStep) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String input[] = inputStr.split(" ");
        for (int i = 0; i < 4; i++) {
            plateau[currentStep][i] = Integer.parseInt( input[i]);
        }
    }

    public void GameInitilization() {
        Random rd = new Random();
        boolean player1Code = false;
        boolean player2Code = false;
        int even = (rd.nextInt(5) + 1) * 2;
        Scanner scanner = new Scanner(System.in);
        while (!player2Code && !player1Code) {

            System.out.println("Current tour is " + even + ", pleasr enter 1 agree, 0 to regenerate");
            player1Code = scanner.nextInt() == 1 ? true : false;
            if (!player1Code) {
                continue;
            }
            player2Code = scanner.nextInt() == 1 ? true : false;
            if (!player2Code) {
                continue;
            }

            this.tour = even;
            even = (rd.nextInt(10) + 1) * 2;
        }


    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getCurrentCoudeur() {
        return currentCoudeur;
    }

    public void setCurrentCoudeur(int currentCoudeur) {
        this.currentCoudeur = currentCoudeur;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getCurrentTour() {
        return currentTour;
    }

    public void setCurrentTour(int currentTour) {
        this.currentTour = currentTour;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }

    public List<int[]> getIndicateur() {
        return indicateur;
    }

    public void setIndicateur(List<int[]> indicateur) {
        this.indicateur = indicateur;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public int[] getColor() {
        return color;
    }
}
