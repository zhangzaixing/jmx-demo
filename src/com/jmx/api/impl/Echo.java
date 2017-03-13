package com.jmx.api.impl;

public class Echo implements EchoMBean{

	@Override
	public void print(String printName) {
		System.out.println("my name is " + printName);
	}

}
