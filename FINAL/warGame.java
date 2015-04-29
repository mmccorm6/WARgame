/**
warGame is the class that has all the functionality 
that puts functionality of deck and card and 
creates the game
*/
public class warGame
{ 
   private deck Deck; // the deck before it seperates
   private deck yourCards; // ypur deck of cards
   private deck oppCards; //opp deck of cards
   private card yourTopCard, oppTopCard;// top card for your deck and opponents
   private card yourDownCard, oppDownCard;// face down cards for yours and opponents
   private card yourUpCard, oppUpCard;//face up card on field for yours and opponents
   private String winningMsg; // the winning message for the either the match or war
   private boolean warFlag; // flags for possible war

  
  //constructor that creates a deck and then proceeds to shuffle the deck
  
  public warGame()
  {
   
      Deck = new deck();         
      Deck.shuffle();
      
  }
 
  /**creates a hand from Deck
  @param returns Deck
  */
   		
  public deck getHand()
   {
    return Deck;
    
   }
  
    /**
   creates your cards in your deck
   @param yourCards
  */ 
  public deck getYourHand()
   {
    return yourCards;
   }
  
   /**
   creates the opponents deck
   @param oppCards
  */ 
   
  public deck getOppHand()
   {
    return oppCards;
   }
   
  
   //deals out the cards for the decks
  
   public void deal()
   {
     //creates your deck
     yourCards = new deck();
     yourCards.clear();
     //creates opponents deck
     oppCards = new deck();
     oppCards.clear();
      
     //keeps adding cards to the deck until each has 26
     for(int i = 0; i < 26; i++)
     {
       yourCards.add(Deck.getTopCard());
       oppCards.add(Deck.getTopCard());
     }
   }

   
    // gets the top card
   public void flip()
   {
     yourTopCard = yourCards.getTopCard();
     oppTopCard = oppCards.getTopCard();
   }
   
   
      /**
     gets the top card of your deck
     while also getting the name of the card
     @param yourTopCard.toName()
   */ 
     
   public String getYourTopCard()
   {
     return yourTopCard.toName();     
   }
    
   
    /**
      gets the top card of your opponents deck
      while also getting the name of the card
      @param oppTopCard.toName()
   */ 
      
   public String getOppTopCard()
   {
     return oppTopCard.toName();
   }
   
   
     /**
      gets the face up card of your deck
      while also getting the name of the card
      @param yourUpCard.toName()
   */
     
   public String getYourUpCard()
   {
     return yourUpCard.toName();
   }
  
  /**
      gets the face up card of your opponent's deck
      while also getting the name of the card
      @param oppUpCard.toName()
  */
  public String getOppUpCard()
   {
    return oppUpCard.toName(); 
   }
 
 /**
      gets the size of your deck
      @param yourCards.size()
  */
    
  public int getYourCount()
   {
    return yourCards.size();
   }

   
     /**
      gets the size of your opponent's deck
      @param oppCards.size()
   */
    
   public int getOppCount()
   {
     return oppCards.size();  
   }
   
   //determines winner 
   public void winner()
   {
      if (yourTopCard.getRank() < (oppTopCard.getRank())) 
      {
         winningMsg = "Opponent won this time!";
         oppCards.add(yourTopCard);
         oppCards.add(oppTopCard);
      }    
      else if (yourTopCard.getRank() > (oppTopCard.getRank()))          
      { 
         winningMsg   = "You won this time!";  
         yourCards.add(yourTopCard);
         yourCards.add(oppTopCard); 
      }
      else 
      { 
         winningMsg = "Time for a war!";
         warFlag = true;
      }
   }
  
   
   public void cardWar()
   {
     //local variables
     yourDownCard = yourCards.getTopCard(); 
     oppDownCard = oppCards.getTopCard();
     yourUpCard = yourCards.getTopCard();
     oppUpCard = oppCards.getTopCard();
     //all cards go to your deck      
     if (yourUpCard.getRank() > (oppUpCard.getRank())) 
     {
        winningMsg = "You Won This War";
        yourCards.add(yourTopCard);
        yourCards.add(yourDownCard);
        yourCards.add(yourUpCard);
        yourCards.add(oppTopCard);
        yourCards.add(oppDownCard);
        yourCards.add(oppUpCard);
        warFlag = false;
        yourCards.shuffle();
        oppCards.shuffle(); 
     }
     // all cards go to opponent deck
     else if (yourUpCard.getRank() < (oppUpCard.getRank()) )         
     {
         winningMsg   = "Opponent Won This War";
         oppCards.add(yourTopCard);
         oppCards.add(yourDownCard);
         oppCards.add(yourUpCard);
         oppCards.add(oppTopCard);
         oppCards.add(oppDownCard);
         oppCards.add(oppUpCard);
         warFlag = false;
         yourCards.shuffle();
         oppCards.shuffle();
     } 
     /**
       another war must occur, players get their cards back
       in their decks and shuffles it
     */  
     else
     {   
        winningMsg = "Another war!";
        yourCards.add(yourTopCard);
        yourCards.add(yourDownCard);
        yourCards.add(yourUpCard);
        oppCards.add(oppTopCard);
        oppCards.add(oppDownCard);
        oppCards.add(oppUpCard);
        yourCards.shuffle();
        oppCards.shuffle();
     }
   }
  
   /**
    returns whether or not the warFlag
    if true or false
    @param warFlag
  */
  public boolean getWarFlag()
  {
      return warFlag;
  }
  
    /**
    returns the String for the message
    @param winningMsg
  */
    
  public String getWinningMsg()
  {
    return winningMsg;
  } 
}   