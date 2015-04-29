import java.util.*;
import java.util.ArrayList;
import java.util.List;
/**
 builds a deck out of cards from "card"
 gives methods for functionality of the deck
*/
public class deck
{
   //create array list 
   private ArrayList<card> deck;
  
   //constructor
   public deck()
   {
     //makes a newDeck 
     newDeck();
   }
      
   
   public void newDeck()
   {
      deck = new ArrayList<card>();
         
      for (int r = card.ACE; r<=card.KING;r++)
      {
         for (int s = card.SPADES; s<=card.CLUBS;s++)
         {
            deck.add(new card(r,s));
         }
      }
   }
   
   
   //adds some card to the deck
    
   public void add(card someCard)
   {
      deck.add(someCard);
   }

   
   /**
   gets the card at the top
   @param return the removed top card
   */
   
   public card getTopCard()
   {
      return deck.remove(0);
   }   
   
  
   //creates toString for deck
  
   public String toString()
   {
      return deck.toString();
   }
   
  
   /**
   gets the size of the deck
   @param size of deck as a integer
   */
  
   public int size()
   {
      return deck.size();
   }
   
   //clear deck
     
   public void clear()
   {
      deck.clear();
   }   
   
   /**
   see's if the deck is empty or not
   @param boolean true or false
   */
   
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
  
  // shuffle deck  
  
   public void shuffle()
   {
      int randNum; 
      card temp; 
      Random r = new Random(); 
      
      //shuffles deck
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }  
    
}