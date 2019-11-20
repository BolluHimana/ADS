import java.util.*;
/**
 * @author Bollu Himana
 */
public class Sol{
    /**
     * insertionsort to sort the cards based on suit and face values.
     * @param a
     */
      public void insertion(Card[] a) {
      Card key = new Card(0,0);
      List<Integer>I = new ArrayList<Integer>();
      String str = " ";
      int temp = 1;
      for(int j = 0; j < 4; j++) {
          for(int i = 0; i < a.length; i++) {
              key = a[i];
              if(key.suitvalue == temp){
                  I.add(key.facevalue);
                  //System.out.println(I.get(i));
              }
          }
          System.out.println("Before sorting"+I);
          Collections.sort(I);
          System.out.println("After sorting"+I);
          /**
           * as the suit values are given as integer type. so to get as suit names.
           */
          if(temp == 1) str+= "spades";
          else if (temp == 2) str+="Hearts";
          else if (temp == 3) str+="clubs";
          else if (temp == 4) str+="Diamonds";
          System.out.println(temp);
          for(int i = 0; i < 13; i++){
              if(I.get(i) == 1){
                  System.out.println("A" + " " + str + " ");
              }
                  else if (I.get(i) == 11){
                  System.out.println("J" + " " + str + " ");
                  }else if (I.get(i) == 12){
                      System.out.println("Q" + " " + str + " ");
                  }
                  else if (I.get(i) == 13){
                      System.out.println("k" + " " + str +" ");
                  }
              else 
                System.out.println(I.get(i) + " " + str +" ");
              }
              I.clear();
                 str = "";
                  temp++;
                  System.out.println("___" + I);
          } 
      }
     public static void main(String[] args){
        //here we are considering to arrays one for suit values and other for facevalues.
        int[] suit = {1,2,3,4};
        int[] rank = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        //here we are declaring a new array where we will be storing our cards.
        Card[] card = new Card[52];
        int count=0;
        for(int i=0;i<rank.length;i++){
        for(int j = 0;j<suit.length;j++){
        card[count++] = new Card(rank[i],suit[j]);
            }
        }
        //obj creation
        Sol s = new Sol();
        //for shuffling we are converting it to list.
        List<Card> Cardl = Arrays.asList(card);
        Collections.shuffle(Cardl);
        //again list to array conversion.
        Cardl.toArray(card);
        //using insertionsort we are sorting.
        s.insertion(card);

          }
      }
    class Card implements Comparable<Card>{
      int facevalue;
      int suitvalue;
      /**
      * @param facevalue is the face value of a card.
      * @param suitvalue is the suit value of a card.
      */
      public Card(int facevalue,int suitvalue) {
        this.facevalue = facevalue;  
        this.suitvalue = suitvalue;
        }
        public int compareTo(Card that) {
        if (this.suitvalue < that.suitvalue) {
            return 1;
        }
         else if (this.suitvalue > that.suitvalue) {
            return -1;
            }
            else{
                if (this.facevalue < that.facevalue) {
                    return 1;
                }
                else if (this.facevalue > that.facevalue) {
                    return -1;
                }
            }
            return 0;
        }
    }