/**
 * @author Siyabonga
 * 
 * SummarizerTest is a test class for Summarizer class methods
 * 
 * */

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class SummarizerTest {
	private final Summarizer summarizer = new Summarizer();

	// Test collect with valid input (Best Case)
	@Test
	public void testCollectValidInput(){
		Collection<Integer> result = summarizer.collect("1, 2, 5, 6, 7,8");
		assertEquals(Arrays.asList(1, 2, 5, 6, 7, 8), result);
	}

	// Test collect with invalid input
	@Test(expected = IllegalArgumentException.class)
	public void testCollectInvalidInput(){
		summarizer.collect("1, 2, null, 4x,");
	}

	// Test collect with messy spacing
	@Test
	public void testCollectMessyInput(){
		Collection<Integer> result = summarizer.collect("1,2,4, 6 7");
		assertEquals(Arrays.asList(1, 2, 4, 6, 7), result);
	}

	// Test collect with empty input
	@Test
	public void testCollectEmptyInput(){
		Collection<Integer> result = summarizer.collect("");
		assertTrue(result.isEmpty());
	}

	// Test collect with null input
	@Test
	public void testCollectNullInput(){
		Collection<Integer> result = summarizer.collect(null);
		assertTrue(result.isEmpty());
	}

	// Test summarize collection with best case input
	@Test
	public void testSummarizeCollectionBestCase(){
		List<Integer> input = Arrays.asList(1,3,6,7,8);
		String result = summarizer.summarizeCollection(input);
		assertEquals("1, 3, 6-8", result);
	}

	// Test summarize collection with single value input
	@Test
	public void testSummarizeCollectionSingleInput(){
		String result = summarizer.summarizeCollection(Arrays.asList(10));
		assertEquals("10", result);
	}

	// Test summarize collection with empty collection
	@Test
	public void testSummarizeCollectionEmptyInput(){
		String result = summarizer.summarizeCollection(new ArrayList<>());
		assertEquals("Oops! The dataset is not found.\nPlease input a valid dataset.", result);
	}

	// Test summarize collection with duplicate collection
	@Test
	public void testSummarizeCollectionDuplicateInputs(){
		List<Integer> input = Arrays.asList(1,1,3,4,5,5,6,6,10);
		String result = summarizer.summarizeCollection(input);
		assertEquals("1, 3-6, 10", result);
	}
}