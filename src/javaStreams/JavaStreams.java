package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alekhya");
		names.add("Abhijeeth");
		names.add("Don");
		names.add("Alice");
		names.add("Rama");
		
		int counter=0;
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				counter++;
			}
		}
		
		long value= names.stream().filter(s -> s.startsWith("Z")).count();
		
		//print count of names starting with A
		Long count=Stream.of("Abhijeeth","Don","Alekhya","Alice","Ron").filter(s->
		{
			if(s.startsWith("A"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}).count();
		System.out.println(count);
		
		
		//print all names in loop
		names.stream().forEach(s->System.out.println(s));
		
		System.out.println("------------------------------------------");
		
		//print names having more than 4 char
		
		names.stream().filter(s -> s.length()>4).forEach(s->System.out.println(s));
		
		System.out.println("---------------------------------------------");
		
		//limit
		names.stream().filter(s -> s.length()>4).limit(2).forEach(s->System.out.println(s));
		
		System.out.println("---------------------------------------------");

		
		//names ending with A
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		

		
		//print names having first letter as A wth upper case and sorted
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("---------------------------------------------");
		
		//Merge 2 lists

		String names2[] = new String[2];
		names2[0] = "BUNNY";
		names2[1] ="Amit";
		
		List<String> names1 = Arrays.asList(names2);
		
		Stream<String> newStream= Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		System.out.println(newStream.anyMatch(s->s.equalsIgnoreCase("AliCE")));
		
		System.out.println("---------------");
		
		// collectors
		
		List<String> nameList= names.stream().filter(s->s.length()>4).collect(Collectors.toList());
		System.out.println(nameList.get(0));
		
		
		int numbers[] = new int[10];
		
	}

}
