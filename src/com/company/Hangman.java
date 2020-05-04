package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    private static Scanner _input = new Scanner(System.in);
    private static final ArrayList<String> _wordList = new ArrayList<>();
    private static String progressWord = "";

    public static void main(String[] args) {
        printWelcomeMessage();
        play();
        printGoodbyeMessage();
    }

    private static void play() {
        while (true){
            int difficulty = getDifficulty();
            if (difficulty == 0) {
                //exit game
                break;
            }

            startGame(difficulty);
        }
    }

    private static void startGame(int difficulty) {
        switch(difficulty) {
            case 1:
                easyGame();
            case 2:
                normalGame();
            case 3:
                hardGame();
            default:
                //TODO: Tell user zhe is dumb as fuck!
        }
    }

    private static void easyGame() {
        populateEasyWordList();
        gameCore();
    }
    
    private static void normalGame() {

    }

    private static void hardGame() {

    }

    private static void gameCore() {
        String answer = getRandomWord();
        initProgress(answer);
        for (int tries = 0; tries < 10; tries++) {
            char guess = getGuess();
            if(answer.contains(Character.toString(guess))){
                tries--;
            }
            printStatus(true, answer, guess);
        }
    }

    private static void initProgress(String answer) {
        for (Character c : answer.toCharArray()) {
            progressWord += "* ";
        }
    }

    private static void printStatus(boolean correctGuess, String answer, char guess) {
        if(correctGuess){

        }
        else{

        }
    }

    private static String getRandomWord() {
        int range = _wordList.size();
        int randomIndex = (int) (Math.random() * range);
        return _wordList.get(randomIndex);
    }

    private static void populateEasyWordList() {
        _wordList.clear();
        _wordList.add("bajs");
        _wordList.add("rumpa");
        _wordList.add("blöja");
        _wordList.add("fot");
    }

    private static void populateMediumWordList() {
        _wordList.clear();
        _wordList.add("bajsapa");
        _wordList.add("pruttrumpa");
        _wordList.add("kissblöja");
        _wordList.add("fotsvett");
    }

    private static void populateHardWordList() {
        _wordList.clear();
        _wordList.add("räserbajs");
        _wordList.add("rumpmuskel");
        _wordList.add("blöjexem");
        _wordList.add("fotspecialist");
    }

    private static char getGuess() {
        String inText = "";
        while (true){
            inText = _input.nextLine();
            if (inText.length() != 1) {
                System.out.println("has to be only one char");
                continue;
            }
            return inText.toCharArray()[0];
        }
    }

    private static int getDifficulty() {
        //TODO: Print difficulty menu
        return getValidIntegerInput();
    }

    private static int getValidIntegerInput() {
        while (true) {
            if (!_input.hasNextInt()) {
                _input.nextLine();
                //TODO: Tell user to input a number
                continue;
            }
            return _input.nextInt();
        }
    }

    private static void printWelcomeMessage() {
        //TODO: print welcome message
    }

    private static void printGoodbyeMessage() {
        System.out.println("Good Bye!");
    }

}
