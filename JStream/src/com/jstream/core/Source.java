package com.jstream.core;

import java.io.InputStream;
import java.io.OutputStream;

public interface Source {
	public InputStream getInputStream();
	public OutputStream getOutputStream();
	public void start();
}
