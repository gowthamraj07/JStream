package com.jstream.sources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.jstream.core.AbstractSource;

public class FolderSource extends AbstractSource {

	@Override
	public void start() {
		File dir = new File("/home/gowtham/Desktop/temp3");
		File files[] = dir.listFiles();
		PrintWriter out = new PrintWriter(getOutputStream());
		for(File f : files) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				String line = null;
				while((line = br.readLine()) != null) {
					out.print(line);
				}
				out.flush();
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

}
