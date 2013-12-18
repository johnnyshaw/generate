package com.johnny.generator.base;

import java.util.List;
import java.util.Map;

public interface Generator {

	public void generate(String templateFileName, Map data,String fileName);
	
}
