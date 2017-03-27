package com.jstream.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.jstream.core.Destination;
import com.jstream.core.Filter;
import com.jstream.core.Source;

public final class Executor {
	
	private Source src;
	private Destination dest;
	private List<Filter> filters = new LinkedList<Filter>();
	private static Executor exec = null;
	
	public static Executor getInstance() {
		exec = new Executor();
		return exec;
	}
	
	public Executor setSource(Source src) {
		this.src = src;
		return exec;
	}
	
	public Executor setDestination(Destination dest) {
		this.dest = dest;
		return exec;
	}
	
	public Executor addFilters(Filter filter) {
		filters.add(filter);
		return exec;
	}
	
	public void start() {
		InputStream is = src.getInputStream();
		for(final Filter f : filters) {
			f.setInputStream(is);
			PipedInputStream isTemp = new PipedInputStream();
			try {
				f.setOutputStream(new PipedOutputStream(isTemp));
			} catch (IOException e) {
				e.printStackTrace();
			}
			is = isTemp;
			new Thread() {
				public void run() {
					f.execute();
				}
			}.start();
			
		}
		dest.setInputStream(is);
		new Thread() {
			public void run() {
				dest.capture();
			}
		}.start();
		
		//Starting the Source after completing the path
		new Thread() {
			public void run() {
				src.start();
			}
		}.start();
	}
}
