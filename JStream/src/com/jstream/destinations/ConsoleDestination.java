package com.jstream.destinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jstream.core.Destination;

public class ConsoleDestination implements Destination {

	private InputStream is = null;
	
	@Override
	public void setInputStream(InputStream is) {
		System.out.println("setting Destination's InputStream");
		this.is = is;
	}

	@Override
	public void capture() {
		System.out.println("Capturing in Destination...");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println("DEST >> "+line);
			}
			System.out.println("All the inputs are processed");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
