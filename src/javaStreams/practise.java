package javaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Priyanka");
		names.add("Kumar");
		names.add("Priya");
		names.add("Satya");
		names.add("Siva");
		names.add("Katakam");
		names.add("Priyanka");
		
		
		System.out.println("-------------LOOP Through Stream------------");
		names.stream().forEach(x->System.out.println(x));
		
		System.out.println("----------concate K at the beginning------------------");
		names.stream().map(x-> "K "+x).forEach(x->System.out.println(x));
		
		System.out.println("---------------Sort Stream----------------");
		names.stream().sorted().forEach(x->System.out.println(x));
		
		System.out.println("---------------print unique elements in stream----------------");
		names.stream().sorted().distinct().forEach(x->System.out.println(x));
		
		System.out.println("---------------print elements beginning with K----------------");
		names.stream().filter(x->x.startsWith("K")).forEach(x->System.out.println(x));
		
		System.out.println("---------------print elements ending with A----------------");
		names.stream().filter(x->x.endsWith("a")).distinct().forEach(x->System.out.println(x));
		
		System.out.println("---------------print elements ending with A in uppercase----------------");
		names.stream().filter(x->x.endsWith("a")).distinct().forEach(x->System.out.println(x.toUpperCase()));
		
		System.out.println("---------------print count of unique elements in stream----------------");
		System.out.println(names.stream().distinct().count());
		
		System.out.println("---------------arryas----------------");

		Integer[] num = new Integer[6];
		num[0] = 10;
		num[1]= 12;
		
		List<Integer> lists= Stream.of(num).collect(Collectors.toList());
		for(Integer list: lists)
		{
			if(list!=null)
			System.out.println(list);
		}

		
	}

}
