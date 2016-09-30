package modules.test;

import java.util.ArrayList;
import java.util.List;


public class EnumTest1{

    public enum Rank{ DEUCE,THREE,FOUR,FIVE,SIX,
    SEVEN,EIGHT,NINE,TEN,JACK,QUEE,KING,ACE};

    public enum Suit{CLUBS,DIAMONDS,HEARTS,SPADES};

    private final Rank rank;
    private final Suit suit;
    private EnumTest1(Rank rank,Suit suit){

        this.rank = rank;
        this.suit = suit;

    }


    public Rank rank(){return rank;}
    public Suit suit() { return suit;}
    public String toString(){ return rank+"of"+suit;}

    private static final List<EnumTest1> protoDeck = new ArrayList<EnumTest1>();

    //Initialize protope deck
    static {

         for(Suit suit:Suit.values())
             for(Rank rank:Rank.values()){

                 protoDeck.add(new EnumTest1(rank,suit));
                 System.out.println(rank+""+suit);

             }



    }

    public static ArrayList<EnumTest1> newDeck(){


        return new ArrayList<EnumTest1>(protoDeck);//Return copy of prototype deck
    }


    public static void main(String[] args){

    }

}
