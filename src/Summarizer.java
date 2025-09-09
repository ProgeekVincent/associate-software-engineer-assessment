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
import java.util.ArrayList;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Summarizer implements NumberRangeSummarizer
{

	// collect the input implementation
	@Override
	public Collection<Integer> collect(String input){

		if (input == null || input.isEmpty()){
			return null;
		}

		// split the input into an array
		List<String> inputArray = Arrays.stream(input.split(",")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());

		// new input list
		List<Integer> newInput = new ArrayList<>();
		
		for (String element : inputArray)
		{
			try{
				// add to new input list
				newInput.add(Integer.parseInt(element));
			}catch (NumberFormatException e){
				// if invalid number terminate the loop.
				String errorMessage = "'" + element + "'" + " is found to be an invalid number.";
				System.out.println(errorMessage);
				return null;
			}
		}

		return newInput;
	}

	// get the summarizer string implementation
	@Override
	public String summarizeCollection(Collection<Integer> input){
		// check if input is null or empty
		if (input == null || input.isEmpty())
			return "Oops! The dataset is not found.\nPlease input a valid dataset.";

		// type cast input to an array list
		List<Integer> inputArray = new ArrayList<>(input);

		// sort the array
		Collections.sort(inputArray);

		// return the outcome
		return String.join(", ", findAndCollectRange(inputArray));
	}

	// helper method to find and collect and range
	private List<String> findAndCollectRange(List<Integer> input){

		// array list for summarized collections
		List<String> summarizedInput = new ArrayList<>();

		// index to iterate the loop
		int i = 0;

		while (i < input.size()){
			int j = i; // initialize j to find the last element of the range

			// first the element of the range
			Integer startOfRange = input.get(i);

			while ((j + 1) < input.size() && input.get(j + 1) == (input.get(j) + 1)){ j++; /* increment j if a range is found */}

			// last element of the range
			Integer endOfRange = input.get(j);

			if (startOfRange == endOfRange)
				// last and first element are the same
				summarizedInput.add(String.valueOf(startOfRange));
			else
				// last and first element are not the same
				summarizedInput.add(String.valueOf(startOfRange+"-"+endOfRange));

			// initialize i with next index of the last range value
			i = j + 1;
		}

		// return the summarized input
		return summarizedInput;
	}

}