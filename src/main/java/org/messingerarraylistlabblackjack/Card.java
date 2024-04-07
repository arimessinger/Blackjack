package org.messingerarraylistlabblackjack; //package


public final class Card { //Card class

    //declarations
    private final String rank; //rank of Card - Ace, 2, ...
    private final String suit; //suit of Card - Spades, Diamonds, ...
    private int value; //value of Card - 1-11
    private int secondValue; //second value for ace
    private final int cardId; //id - used with file name - 1-52
    private final String cardFileName; //filename - the name of the .png file associated with the Card


    public Card(String rank, String suit, int value, int cardId, String cardFileName) { //constructor
        //following code sets each constructor parameter equal to its corresponding data member
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.cardId = cardId;
        this.cardFileName = cardFileName;
    }
    public Card(String rank, String suit, int value, int secondValue, int cardId, String cardFileName) { //overloaded constructor - for aces
        //following code sets each constructor parameter equal to its corresponding data member
        //includes secondValue
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.secondValue = secondValue;
        this.cardId = cardId;
        this.cardFileName = cardFileName;
    }


    @Override
    public String toString() { //overrides toString() to return more useful info
        return "Rank: " + rank + "\tSuit: " + suit +
                "\tCardId: " + cardId +
                "\tFile Name: " + cardFileName +
                "\tValue: " + value +
                "\n";
    }

    public String getRank() { //returns rank
        return rank;
    }

    public String getSuit() { //returns suit
        return suit;
    }

    public int getValue() { //returns value
        return value;
    }

    public void setValue(int value) { //sets value of a card
        this.value = value;
    }
    public int getSecondValue() { //returns SecondValue
        return secondValue;
    }

    public String getCardFileName() { //returns cardFileName
        return cardFileName;
    }

    public int getCardId() { //returns cardId
        return cardId;
    }

    public byte compareValue(Card card) { //compareValue() - returns 1 if the initiating Card is greater, -1 if less, 0 if equal
        if(value > card.getValue()){
            return 1;
        } else if (value < card.getValue()) {
            return -1;
        }
        return 0;
    }
}

