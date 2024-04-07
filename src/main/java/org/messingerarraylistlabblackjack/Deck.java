package org.messingerarraylistlabblackjack; //package

//imports necessary Classes
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck{ //Deck class
    private final ArrayList<String> rankArrayList = new ArrayList<>(); //initializes new ArrayList that holds Strings

    //fills the ArrayList with all possible ranks
    private void rankArrayListFill() {
        rankArrayList.add("Ace");
        for(byte i = 2; i <= 10; i++) {
            rankArrayList.add(String.valueOf(i));
        }
        rankArrayList.add("Jack");
        rankArrayList.add("Queen");
        rankArrayList.add("King");
    }

    private final ArrayList<String> suitArrayList = new ArrayList<>(); //initializes new ArrayList that holds Strings

    //fills the ArrayList with all 4 suits
    private void suitArrayListFill(){
        suitArrayList.add("Spades");
        suitArrayList.add("Diamonds");
        suitArrayList.add("Clubs");
        suitArrayList.add("Hearts");
    }

    public final ArrayList<Card> cardArrayList = new ArrayList<>(); //initializes new ArrayList that holds Cards

    public Deck() { //constructor of Deck
        rankArrayListFill();
        suitArrayListFill();
        Card tempCard = null; //sets a new Card = null
        int i = 1; //for id iteration
        for(String suit : suitArrayList) { //iterates through suitArrayList
            for(String rank : rankArrayList) { //iterates through suitArrayList
                String cardFileName = "c" + i + ".png"; //creates String which is changed every iteration and is used to set file name using concatenation
                //simplified switch layout using lambdas
                //constructs a Card; based on rank, each Card will have a different
                tempCard = switch (rank) {
                    case "Ace" -> new Card(rank, suit, 11, 1, i, cardFileName);
                    case "2" -> new Card(rank, suit, 2, i, cardFileName);
                    case "4" -> new Card(rank, suit, 4, i, cardFileName);
                    case "3" -> new Card(rank, suit, 3, i, cardFileName);
                    case "5" -> new Card(rank, suit, 5, i, cardFileName);
                    case "6" -> new Card(rank, suit, 6, i, cardFileName);
                    case "7" -> new Card(rank, suit, 7, i, cardFileName);
                    case "8" -> new Card(rank, suit, 8, i, cardFileName);
                    case "9" -> new Card(rank, suit, 9, i, cardFileName);
                    case "10", "Jack", "Queen", "King" -> new Card(rank, suit, 10, i, cardFileName);
                    default -> tempCard;
                };
                cardArrayList.add(tempCard); //adds the Card to the ArrayList of Cards
                i++;
            }
        }
    }

    //shuffles the ArrayList of Cards
    public void shuffleDeck() {
        Collections.shuffle(cardArrayList, new Random());
    }

    //abstraction! - allows the returning & removal of a Card from cardArrayList from outside the Deck class
    public Card nextCard() {
        return cardArrayList.removeFirst();
    }
}

