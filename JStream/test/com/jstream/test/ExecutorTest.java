package com.jstream.test;

import com.jstream.destinations.ConsoleDestination;
import com.jstream.filters.DivisableBy5Filter;
import com.jstream.filters.EvenNoFilter;
import com.jstream.main.Executor;
import com.jstream.sources.RandomNoSource;

public class ExecutorTest {

	public static void main(String[] args) {
		Executor.getInstance()
				.setSource(new RandomNoSource())
				.addFilters(new EvenNoFilter())
				.addFilters(new DivisableBy5Filter())
				.setDestination(new ConsoleDestination())
				.start();
				
	}

}
