/**
 * @author Siyabonga
 * 
 * Program class runs the program
 * 
 * */

import java.util.Collection;

public class Program
{
	public static void main(String[] args){
		// create an object summarizer
		Summarizer summarizer = new Summarizer();

		// collect the input
		Collection<Integer> data = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31,,");

		// collect the summarized input
		String summarizedData = summarizer.summarizeCollection(data);

		// print the output
		System.out.println(summarizedData);

	}
}