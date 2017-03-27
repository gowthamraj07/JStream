package com.jstream.core;

import java.io.InputStream;

public interface Destination {
	public void setInputStream(InputStream is);
	public void capture();
}
