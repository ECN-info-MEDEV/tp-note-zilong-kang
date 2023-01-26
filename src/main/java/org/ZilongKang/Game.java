package org.ZilongKang;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
private static final int LINES = 12;
    private static final int PIONSNUMBER = 4;
    /**
     * 1 for player1, 2 for player2.
     * which player is current codeur.
     */
    private int currentCoudeur;
    /**
     * the total tours of game, given by random.
     */
    private int tour;
    /**
     * current tour number.
     */
    private int currentTour;
    /**
     * The step number of decoudeur, 0 - 11
     */
    private int currentStep;
    /**
     * the 4 pions entered by decodeur.
     */
    private int[] currentPions = new int[4];
    /**
     * records all pions entered by decodeur.
     */
    private int[][] plateau = new int[LINES][4];
    /**
     * to indicates the corresponding results for each enter of decodeur.
     */
    private List<int[]> indicateur = new ArrayList<>();

    /**
     * score[0]:player1's score;
     * score[1]:player2's score.
     */
    private int[] score = new int[2];

    /**
     * "jaune", "bleu", "rouge", "vert", "blanc", "noir"
     * 1         2         3        4       5       6
     */
    private final int[] color = {1, 2, 3, 4, 5, 6};

    /**
     * Initialization
     */
    public Game() {
        GameInitialization();
    }

    /**
     * Start game.
     */
    public void runTour() {
        boolean invalid = true;
        currentTour = 0;

        while (currentTour < tour) {
            currentStep = 0;
            refreshPlateau();


            if (currentTour % 2 == 0) {
                currentCoudeur = 1;
            } else {
                currentCoudeur = 2;
            }
            System.out.println("\ncurrent coudeur is player" + currentCoudeur + ", No." + (currentTour + 1) + " tour");
            System.out.println("codeur please enter 4 colors(1-6), seperated by space, like: \"1 3 4 5\"");

            if (!readCode(currentStep)) {
                System.out.println("invalid enter, try again");
                continue;
            }

            //decodeur actions.
            while (currentStep < LINES) {
                System.out.println("\ndecodeur No." + (currentStep + 1) + " try");
                System.out.println("decodeur please enter 4 pions colors(1-6)");
                if (!readInputPions(currentStep)) {
                    System.out.println("invalid input, please enter again");
                    continue;
                }

                // whether decodeur's enter is correct
                if (GuessJudge.getGuessResult(plateau[currentStep], currentPions)) {//correct
                    System.out.println("current tour is over");
                    if (currentCoudeur == 1) {
                        score[0] += currentStep + 1;
                    } else {
                        score[1] += currentStep + 1;
                    }
                    System.out.println("current score:\n    player1 : " + score[0] + ", player2 : " + score[1]);
                    break; // current tour is over
                }
                currentStep++;
            }
            if(currentStep == LINES){
                System.out.println("All 12 chances were used. Start next tour");
            }
            currentTour++;
        }

        if (score[0] > score[1]) {
            System.out.println("winner is player1");
        } else if (score[0] < score[1]) {
            System.out.println("winner is player2");
        } else {
            System.out.println("match");
        }
        System.out.println("game over");

    }

    /**
     * refresh game parameters at the beginning of each tour.
     */
    public void refreshPlateau() {
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < 4; j++) {
                plateau[i][j] = 0;
            }
        }
        for (int i = 0; i < PIONSNUMBER; i++) {
            currentPions[i] = 0;
        }
    }


    /**
     * Read current decodeur's input (4 pions color).
     *
     * @param currentStep current step that decodeur has.
     */
    public boolean readInputPions(int currentStep) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String input[] = inputStr.split("\\s+");
        if (input.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(input[i]) > 6 || Integer.parseInt(input[i]) <= 0) {
                return false;
            }
            plateau[currentStep][i] = Integer.parseInt(input[i]);
        }
        return true;
    }

    /**
     * Read the pattern setted by codeur.
     * @param currentStep one of the 12 tours.
     * @return  pattern entered by codeur.
     */
    public boolean readCode(int currentStep) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String input[] = inputStr.split("\\s+");
        if (input.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(input[i]) > 6 || Integer.parseInt(input[i]) <= 0) {
                return false;
            }
            currentPions[i] = Integer.parseInt(input[i]);
        }
        return true;
    }

    /**
     * Set the total tour of game.
     */
    public void GameInitialization() {
        SecureRandom rd = new SecureRandom();
        boolean player1Code = false;
        boolean player2Code = false;
        int even = (rd.nextInt(5) + 1) * 2;
        Scanner scanner = new Scanner(System.in);
        while (!player2Code && !player1Code) {

            System.out.println("Current tour number is " + even + ", please enter 1 agree, else number to regenerate");
            System.out.println("player1 please confirm: ");
            player1Code = scanner.nextInt() == 1;
            if (!player1Code) {
                continue;
            }
            System.out.println("player2 please confirm: ");

            player2Code = scanner.nextInt() == 1 ? true : false;
            if (!player2Code) {
                continue;
            }

            this.tour = even;
            even = (rd.nextInt(10) + 1) * 2;
        }


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

    public int[] getCurrentPions() {
        return currentPions;
    }

    public void setCurrentPions(int[] currentPions) {
        this.currentPions = currentPions;
    }
}
