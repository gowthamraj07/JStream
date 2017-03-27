package com.jstream.core;

import java.io.InputStream;
import java.io.OutputStream;

public interface Filter {
	
	public InputStream getInputStream();
	public void setInputStream(InputStream ip);
	public OutputStream getOutputStream();
	public void setOutputStream(OutputStream op);
	public void execute();
	
}
