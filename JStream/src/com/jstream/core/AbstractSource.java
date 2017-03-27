package com.jstream.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public abstract class AbstractSource implements Source {
	
	private PipedInputStream is = null;
	private PipedOutputStream os = null;
	
	public AbstractSource() {
		this.is = new PipedInputStream();
		try {
			os = new PipedOutputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public InputStream getInputStream() {
		return is;
	}
	
	@Override
	public OutputStream getOutputStream() {
		return os;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

}
