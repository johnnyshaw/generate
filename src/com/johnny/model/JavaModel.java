//pizza
package com.johnny.model;

import java.util.List;

public class JavaModel {
	
	private String packageName;
	
	private String className;
	
	private String implementsName;
	
	private List<String> inputpackageList;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getInputpackageList() {
		return inputpackageList;
	}

	public void setInputpackageList(List<String> inputpackageList) {
		this.inputpackageList = inputpackageList;
	}

	public String getImplementsName() {
		return implementsName;
	}

	public void setImplementsName(String implementsName) {
		this.implementsName = implementsName;
	}
}
