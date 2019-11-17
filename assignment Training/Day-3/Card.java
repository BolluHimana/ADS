/**
 * @author Bollu Himana
 */
class Card implements Comparable<Card> {
    String suit;
    String rank;
    int Csuit;
    int Crank;
    Card(String s,String r,int a,int b) {
        this.suit = s;
        this.rank = r;
        this.Csuit = a;
        this.Crank = b;
    }
     public int compareTo(Card c) {
        
         
         if (this.Csuit < c.Csuit) {
             return 1;
        }
        else if (this.Csuit > c.Csuit) {
           return -1;
        } 
        else {
           if (this.Crank < c.Crank) {
               return 1;
           }
           else if (this.Crank > c.Crank) {
           return -1;
           }
           else {
                return 0;
           }
        }

    }

    
}