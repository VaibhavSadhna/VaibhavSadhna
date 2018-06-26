
/*public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}*/
import java.util.*;
public class Dice {

	

	int numberOfSides = 0;

	

	public Dice(int numberOfSides) {

		if (numberOfSides < 2 || numberOfSides == 3 || numberOfSides == 5 || numberOfSides > 6) {

			System.out.println("Invalid input");

			System.exit(0);

		}

		else {

			this.numberOfSides = numberOfSides;

		}

	}

	

	public int diceRoll() {

		return 1 + (int)( Math.random() * numberOfSides);

	}

	

	public String tossCoin() {

		int rand = 1 + (int)(Math.random() * numberOfSides);

		if(rand == 1) {

			return "HEAD";

		}

		else {

			return "TAIL";

		}

	}


	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sides");
		int sides=sc.nextInt();
		
		Dice D = new Dice(sides);

		if (sides == 2) {

			System.out.println(D.tossCoin());

		} else {

			System.out.println(D.diceRoll());

		}

	}


}
