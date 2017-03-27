package com.jstream.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class AbstractStringFilter implements Filter {
	
	protected InputStream is = null;
	protected OutputStream os = null;

	@Override
	public InputStream getInputStream() {
		System.out.println("getting Filter's InputStream");
		return is;
	}

	@Override
	public void setInputStream(InputStream ip) {
		System.out.println("setting Filter's InputStream");
		is = ip;
	}

	@Override
	public OutputStream getOutputStream() {
		System.out.println("getting Filter's OutputStream");
		return os;
	}

	@Override
	public void setOutputStream(OutputStream op) {
		System.out.println("setting Filter's OutputStream");
		os = op;
	}

	public void execute() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream()));
			PrintWriter out = new PrintWriter(getOutputStream());
			String line = null;
			while((line = br.readLine()) != null) {
				String tempStr = processString(line);
				if(tempStr != null) {
					out.println(tempStr);
				}
			}
			out.flush();
			out.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String processString(String line);

}
