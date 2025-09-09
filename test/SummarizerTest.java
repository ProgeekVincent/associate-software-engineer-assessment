import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class SummarizerTest {

	@Test
	public void collect(){
		Summarizer summarizerObj = new Summarizer();

		Collection<Integer> currentResult = summarizerObj.collect("1,2,3,4,5");

		List<Integer> expectedResult = new ArrayList<>();
		for (int i = 1; i < 6; i++)
			expectedResult.add(i);

		assertEquals(expectedResult, currentResult);
	}

	@Test
	public void summarizeCollection(){
		Summarizer obj = new Summarizer();
		String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";

		Integer[] input = {1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31};

		Collection<Integer> currentList = new ArrayList<>();
		for (Integer data : input)
			currentList.add(data);

		String currentResult = obj.summarizeCollection(currentList);

		assertEquals(expectedResult, currentResult);
	}


}