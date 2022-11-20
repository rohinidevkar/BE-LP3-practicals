package fractional_knapsack;

/**
 *
 * @author student
 */
import java.util.Scanner;
 
class Item {
  int value;
  int weight;
  float density;

  public Item(int value, int weight, float density) {
      this.value = value;
      this.weight = weight;
      this.density = density;
  }
}
 class Knapsack {
  Item[] items;
  int W;

  public Knapsack(Item[] items, int W) {
      this.items = items;
    this.W = W;
  }

  public float solve(){
    int i, j, pos;
    Item mx,temp;
    float totalValue=0, totalWeight=0;

    //calculating density of each item
    for(i=0; i<items.length; i++){
        items[i].density = (float) items[i].value/items[i].weight;
    }

    //sorting w.r.t to density by using compare function
    for(i=0; i<items.length; i++){
      mx = items[i];
      pos= i;
      for(j=i; j<items.length; j++){
        if(items[j].density> mx.density){
          mx= items[j];
          pos = j;
        }
      }
      temp = items[i];
      items[i] = mx;
      items[pos] = temp;
    }

    for(i=0; i<items.length; i++){
      if(totalWeight + items[i].weight<= W){
        totalValue += items[i].value ;
        totalWeight += items[i].weight;
      } else {
        int wt = (int) (W-totalWeight);
        totalValue += (wt * items[i].density);
        totalWeight += wt;
        break;
      }
    }
    System.out.println("total weight in bag "+totalWeight);
    return totalValue;
  }
}

public class Fractional_Knapsack {
  static Scanner in = new Scanner(System.in);

  public static void main(String args[]){
    int n=3, W;

    Item[] items = new Item[3];

    System.out.println("Enter data");

    System.out.println("Enter total "+n+" item's values and weight");
    for(int i=0; i<n; i++){
      Item item = new Item(0,0,0);
      System.out.print("Enter "+(i+1)+" Value ");
      item.value = in.nextInt();
      System.out.print("Enter "+(i+1)+" Weight ");
      item.weight = in.nextInt();
      items[i] = item;
    }

    System.out.println("Entered data");
    display(items);

    System.out.println("Enter Knapsack Weight");
    W = in.nextInt();

    Knapsack ks = new Knapsack(items, W);

    float mxVal = ks.solve();
    System.out.println("---Max value for "+ W +" weight is "+mxVal);
 
  }
 
  static void display(Item items[]){
    System.out.print("values:   ");
    for(int i=0; i<items.length; i++){
        System.out.print(items[i].value + "\t");
    }

    System.out.println();
    System.out.print("weight:   ");

    for(int i=0; i<items.length; i++){
        System.out.print(items[i].weight+"\t");
    }
    System.out.println();
  }
}