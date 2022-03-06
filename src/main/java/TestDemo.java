import java.util.Random;

public class TestDemo {
	//takes two numbers and adds returns the sum of them
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		}else {
			//if one of the two numbers passed in are zero or negative, the method will
			//throw an exception instead
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	//pulls a number from the random number method and returns it squared
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number * number;
	}
	//generates a random number between 1 and 10
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
