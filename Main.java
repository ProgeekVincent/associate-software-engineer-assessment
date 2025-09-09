import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import numberrangesummarizer.NumberRangeSummarizer;

// Implements the NumberRangeSummarizer
public class Main implements NumberRangeSummarizer{


	// convert the string array to an array
	public Collection<Integer> convertToInteger(String[] inputList)
	{
		Collection<Integer> newList = new ArrayList<>();

		for (String input : inputList){
			try{
				// cast to Integer and add to the list 
				newList.add(Integer.parseInt(input));
			}catch(NumberFormatException e){
				// throw a number format exception
				throw new NumberFormatException(e.getMessage());
			}
		}
		return newList;
	}


	// collect method implementation
	@Override
	public Collection<Integer> collect(String input){
		// check if the string is empty
		if (input.length() == 0)
			return null;

		// split the input string
		String[] inputList = input.split(",");

		// type cast the array to integers
		Collection<Integer> newList = convertToInteger(inputList);

		return newList ;
	}

	// summarizeCollection method implementation
	@Override
	public String summarizeCollection(Collection<Integer> input){

		// check if the input collection is empty or null
		if (input == null || input.size() == 0){
			return "";
		}

		// cast collections to a list
		List<Integer> integerList = new ArrayList<>(input);

		// list of to be added results
		List<String> resultList = new ArrayList<>();

		// sort the integer list
		Collections.sort(integerList);

		// find the range
		for (int i = 0; i < integerList.size(); i++)
		{
			int j = i;

			Integer startOfRange = integerList.get(i);

			while (j + 1 < integerList.size() && integerList.get(j + 1) == integerList.get(j) + 1){ j++; }

			Integer endOfRange = integerList.get(j);

			if (startOfRange == endOfRange){ resultList.add(String.valueOf(startOfRange)); }
			else{
				resultList.add(String.valueOf(startOfRange) + "-" + String.valueOf(endOfRange));
			}
		}

		//
		return String.join(", ", listResult);
	}



	public static void main(String[] args){
		Main obj = new Main();

		// input sample data
		Collection<Integer> sampleList = obj.collect("1,2,34,54,0,3,47,smiso");

		System.out.println(obj.summarizeCollection(sampleList));

	}
}