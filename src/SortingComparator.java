/*
 * A comparison function, which imposes a total ordering on some collection of objects. Comparators can be passed to
 *  a sort method (such as Collections.sort or Arrays.sort)
 * */
import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
//my code start here: 
class Checker implements Comparator<Player> {
  	//sort first descending by score, then ascending by name.
	public int compare(Player a, Player b) {
        if(a.score>b.score) return -1;
        if(a.score<b.score) return 1;
        //equal scores
        //a.name before b.name->return 1
        //a before b
        if( (a.name).compareTo(b.name) < 0)    return -1;
        return 1;
    }
}
//ends here

public class SortingComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}