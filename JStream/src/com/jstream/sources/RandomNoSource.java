package com.jstream.sources;

import java.io.PrintWriter;

import com.jstream.core.AbstractSource;

public class RandomNoSource extends AbstractSource {

	@Override
	public void start() {
		PrintWriter pw = new PrintWriter(getOutputStream());
		for(int i=0;i<100;i++) {
			pw.println(""+i);
		}
		pw.flush();
		pw.close();
	}
}
