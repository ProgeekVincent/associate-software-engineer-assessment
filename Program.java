import java.util.Collection;

public class Program
{
	public static void main(String[] args){
		Summarizer summarizer = new Summarizer();

		// collect the input
		// Collection<Integer> data = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		Collection<Integer> data = summarizer.collect(null);

		// summarize the data
		String summarizedData = summarizer.summarizeCollection(data);

		System.out.println(data);

		// print the summarized results
		System.out.println(summarizedData);
	}
}