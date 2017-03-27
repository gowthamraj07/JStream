package com.jstream.filters;

import com.jstream.core.AbstractStringFilter;

public class DivisableBy5Filter extends AbstractStringFilter {

	@Override
	public String processString(String line) {
		try {
			int no = Integer.parseInt(line);
			if((no%5)==0) {
				return ""+no;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

}
