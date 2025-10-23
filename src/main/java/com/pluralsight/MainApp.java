package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        for (Player player : players) {
            player.getHand().deal(deck.deal());
            player.getHand().deal(deck.deal());
        }

        for (Player player : players) {
            System.out.println("\n" + player.getName() + "'s turn:");
            player.getHand().showHand();

            while (player.getScore() < 21) {
                System.out.print("Hit or Stay? (h/s): ");
                String choice = scanner.nextLine().trim().toLowerCase();
                if (choice.equals("h")) {
                    player.getHand().deal(deck.deal());
                    player.getHand().showHand();
                } else {
                    break;
                }
            }
        }

        Player winner = null;
        int highestScore = 0;
        for (Player player : players) {
            int score = player.getScore();
            if (score <= 21 && score > highestScore) {
                highestScore = score;
                winner = player;
            }
        }

        System.out.println("\n=== FINAL SCORES ===");
        for (Player player : players) {
            System.out.println(player);
        }

        if (winner != null) {
            System.out.println("\n🏆 Winner: " + winner.getName() + " with " + winner.getScore() + " points!");
        } else {
            System.out.println("\nNo winners — everyone busted!");
        }
    }
}