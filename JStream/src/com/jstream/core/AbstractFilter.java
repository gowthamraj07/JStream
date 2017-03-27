package com.jstream.core;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractFilter implements Filter {
	
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

	public abstract void execute();

}
