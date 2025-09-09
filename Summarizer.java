/**
 * @author Siyabonga Vincent Nkosi
 * 
 * This file implements the NumberRangeSummarizer
 * 
 * */

import numberrangesummarizer.NumberRangeSummarizer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Summarizer implements NumberRangeSummarizer
{
	// collect the input implementation
	@Override
	public Collection<Integer> collect(String input){

		// check if the string is empty
		try{

		}catch (NullPointerException e)
		{
			System.out.println(e.getMessage());
		}

		// split the input into an array
		String[] inputList = input.split(",");

		// create an empty array list
		List<Integer> integerList = new ArrayList<>();

		// convert and add the elements of the splited input
		for (String element : inputList)
		{
			try{
				integerList.add(Integer.parseInt(element));
			}catch (NumberFormatException e){
				// throw an exception if an integer is not found
				throw new NumberFormatException(e.getMessage());
			}
		}

		return integerList;
	}

	// get the summarizer string implementation
	@Override
	public String summarizeCollection(Collection<Integer> input){
		// 
		List<Integer> inputArray = new ArrayList<>(input);

		// sort the array
		Collections.sort(inputArray);

		System.out.println(inputArray);

		return "";
	}

	// 

}