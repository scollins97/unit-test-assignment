import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
class TestDemoTest {
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		//not expecting an exception, this test will test if the two numbers passed in 
		//are equal to the expected amount
		if(expectException == false) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			//tests to make sure that if invalid arguments are passed in 
			//the exception will be thrown
			assertThatThrownBy(() -> 
								testDemo.addPositive(a, b))
								.isInstanceOf(IllegalArgumentException.class);
		}
	}
	//possible scenarios of different values passed in and if an exception is expected
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
			arguments(2, 4, 6, false),
			arguments(0, 1, 1, true),
			arguments(1, 0, 1, true),
			arguments(-1, 2, 1, true),
			arguments(2, -1, 1, true),
			arguments(15, 15, 30, false)
		);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		//for the purpose of testing this will "pretend" that the random number 
		//method returns a 5 so that it should equal 25 when squared
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}

}
