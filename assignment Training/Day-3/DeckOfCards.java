/**
 * @author Bollu Himana
 */
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
class DeckOfCards {
    String[] suits = {"spades", "hearts", "clubs", "diamonds"};
    String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    Card[] cards = new Card[52];
    int size = 0;
    /**this function returns array of cards.
     * @return , Card[] which contains card elements.
     */
    Card[] cardArray() {
         for(int i = 0; i < suits.length; i++) {
             for(int j = 0; j < ranks.length; j++) {
                 
                  cards[size] = new Card(suits[i], ranks[j], i, j);
                  size++;
             }
         }
         return cards;
     }
     /**this function sorts  array whose elements are cards.
      * @param cards which is card array.
      * @return sorted card array.
      */
     public Card[] sort(Card[] cards) {
         for(int i = 0; i < cards.length; i++) {
             for(int j = i; j > 0; j--) {
                 if(cards[j].compareTo(cards[j - 1]) > 0) {
                     Card temp = cards[j - 1];
                     cards[j - 1] = cards[j];
                     cards[j] = temp;
                 }
                 else{
                     break;
                 }
             }
             
         }
         return cards;
     }
     /**this function print card fields.
      * @param cards which is a card array.
      */
     void toString(Card[] cards) {
         for(int i = 0; i < size; i++) {
             System.out.println(cards[i].suit + " " + cards[i].rank + " " + cards[i].Csuit + " " + cards[i].Crank);
         }
     }
     public static void main(String[] args){
         
         DeckOfCards obj = new DeckOfCards();
         Card[] cards = obj.cardArray();
         Collections.shuffle(Arrays.asList(cards));
         System.out.println("--------- in random order---------");
         obj.toString(cards);
         System.out.println("--------cards in order---------");
         obj.toString(obj.sort(cards));
     
 
         
         
     }
    }