package com.ga;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {


    static final List<String> rps = Arrays.asList("rock", "paper", "scissor");// verify if the input is valid

    public static void main(String[] args) {
        // write your code here
        while (true) {
            System.out.print("MAIN MENU\n" +
                    "=====\n" +
                    "Please Select from following options\n" +
                    "1. 2 players.\n" +
                    "2. vs. computer\n" +
                    "Please Enter Option Number (1 or 2):"
            );
            Scanner scanner = new Scanner(System.in);//initialize a scanner to get the input from the players
            String input = scanner.nextLine().toLowerCase();//to store the scanners input
            System.out.println(input);
            if (input.equals("quit")) {
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("2 players");
                    twoPlayers();
                    break;
                case "2":
                    System.out.println("vs computer");
                    vsComputer();
                    break;
                default:
                    System.out.println("Incorrect input, please try again!");
            }


        }
    }

    public static void twoPlayers() {
        Player playerOne = new Player("Player 1", false, 0, null) {
        };
        Player playerTwo = new Player("Player 2", false, 0, null) {
        };
        while (true) {
            System.out.print("PLAY\n" +
                    "=====\n" +
                    "Type 'rock', 'paper', or 'scissors' to play.\n" +
                    "Type 'quit' to go back to the main menu.\n"
            );
            Scanner scannerTwo = new Scanner(System.in);
            System.out.print("Player 1:");
            String p1input = scannerTwo.nextLine().toLowerCase();
            if (p1input.equals("quit")) return;
            if (rps.contains(p1input) == false) {
                System.out.println("Wrong input, Try Again");
                continue;
            }
            playerOne.setRecentMove(p1input);// store player 1 input
            System.out.print("Player 2:");
            scannerTwo = new Scanner(System.in);
            String p2in = scannerTwo.nextLine().toLowerCase();
            if (p1input.equals("quit")) return;
            if (rps.contains(p2in) == false) {
                System.out.println("Wrong input, Try Again");
                continue;
            }
            playerTwo.setRecentMove(p2in);
            announceWinner(playerOne, playerTwo);
        }

    }

    public static void vsComputer() {
        while (true) {
            Player playerOne = new Player("Player 1", false, 0, null) {
            };
            Player playerTwo = new Player("Computer", false, 0, null) {
            };
            System.out.print("PLAY\n" +
                    "=====\n" +
                    "Type 'rock', 'paper', or 'scissor' to play.\n" +
                    "Type 'quit' to go back to the main menu.\n"
            );
            Scanner scannerTwo = new Scanner(System.in);
            System.out.print("Player 1 input:");
            String p1input = scannerTwo.nextLine().toLowerCase();
            if (p1input.equals("quit")) return;
            if (rps.contains(p1input) == false) {
                System.out.println("Wrong input, Try Again");
                continue;
            }
            playerOne.setRecentMove(p1input);


            playerTwo.setRecentMove(computerWordPick());//set computer s move randomly
            System.out.println("Player 2 (Computer) Picks '" + playerTwo.getRecentMove() + "'");


            announceWinner(playerOne, playerTwo);
        }

    }

    public static String computerWordPick() { //random selection for the computer
        Random random = new Random();
        int randomIndex = random.nextInt(3);//boundary
        return rps.get(randomIndex);
    }


    public static void announceWinner(Player player1, Player player2) {
        if (player1.getRecentMove().equals(player2.getRecentMove())) {
            System.out.println("It's tie!!!");
        } else if (player1.getRecentMove().equals("rock")) {
            if (player2.getRecentMove().equals("paper")) {
                System.out.println("Player 2 Wins!!");
            } else if (player2.getRecentMove().equals("scissor")) {
                System.out.println("Player 1 Wins!!");
            }
        } else if (player1.getRecentMove().equals("paper")) {
            if (player2.getRecentMove().equals("rock")) {
                System.out.println("Player 1 Wins!!");
            } else if (player2.getRecentMove().equals("scissor")) {
                System.out.println("Player 2 Wins!!");
            }
        } else if (player1.getRecentMove().equals("scissor")) {
            if (player2.getRecentMove().equals("paper")) {
                System.out.println("Player 1 Wins!!");
            } else if (player2.getRecentMove().equals("rock")) {
                System.out.println("Player 2 Wins!!");
            }
        }
    }
}



