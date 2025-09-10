/**
 * @author Siyabonga
 * 
 * Summarizer class implements the NumberRangeSummarizer Interface
 * 
 * */

import numberrangesummarizer.NumberRangeSummarizer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Summarizer implements NumberRangeSummarizer
{

	// Collect the input implementation
	@Override
	public Collection<Integer> collect(String input){

		if (input == null || input.trim().isEmpty()){
			return Collections.emptyList();
		}

		// split the input into tokens
		List<String> tokens = Arrays.stream(input.split("[,\\s]+"))
				.map(String::trim)
				.filter(s -> !s.isEmpty())
				.collect(Collectors.toList());

		List<Integer> numbers = new ArrayList<>();
		
		for (String token : tokens)
		{
			try{
				numbers.add(Integer.parseInt(token));
			}catch (NumberFormatException e){
				throw new IllegalArgumentException("'" + token +"' is not a valid number.");
			}
		}

		return numbers;
	}

	// get the summarizer string implementation
	@Override
	public String summarizeCollection(Collection<Integer> input){
		
		if (input == null || input.isEmpty())
			return "Oops! The dataset is not found.\nPlease input a valid dataset.";

		// remove the duplicates
		List<Integer> numbers = new ArrayList<>(new HashSet<>(input));

		Collections.sort(numbers); // sort the numbers

		return String.join(", ", summarizeRanges(numbers)); // get the summary
	}

	// helper method to find and collect and range
	private List<String> summarizeRanges(List<Integer> numbers){

		List<String> result = new ArrayList<>();

		int i = 0;

		while (i < numbers.size()){
			int j = i;

			int start = numbers.get(i); // first number of the range

			// iterate if there are consecutive numbers
			while ((j + 1) < numbers.size() && numbers.get(j + 1) == numbers.get(j) + 1){
				j++;
			}

			int end = numbers.get(j); // last number of the range

			if (start == end) 
				result.add(String.valueOf(start));
			else 
				result.add(String.valueOf(start + "-" + end));

			i = j + 1; // reset i for the next collection
		}

		return result;
	}

}