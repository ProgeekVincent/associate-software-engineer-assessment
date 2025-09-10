/**
 * @author Siyabonga
 * 
 * Demo class runs the program
 * 
 * */

import java.util.Collection;

public class Demo
{
	public static void main(String[] args){

		Summarizer summarizer = new Summarizer();

		try{
			// sample data 
			Collection<Integer> data = summarizer.collect("1,2, , , , ,  , , 3, ,44 ,5 ,4 5,5 6,6, 32, 33, 34, 35, 36, 37, 38, 39, 50, 21, ");

			String summarizedData = summarizer.summarizeCollection(data);

			System.out.println(summarizedData);

		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

		try{
			Collection<Integer> sampleData = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");

			String summarizedSample = summarizer.summarizeCollection(sampleData);

			System.out.println(summarizedSample);

		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}


	}
}