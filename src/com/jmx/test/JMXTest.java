package com.jmx.test;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.jmx.api.impl.Echo;

public class JMXTest {
	public static void main(String[] args) throws Exception {
		//1.创建MBeanServer
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		//2.新建MBean ObjectName,在MbeanServer里标识注册的Mbean
		ObjectName name = new ObjectName("com.jmx.api.impl:type=Echo"); 
		
		//3.创建MBean
		Echo mbean = new Echo();
		
		//4.在MBeanServer里注册MBean,标识为ObjectName(com.jmx.api.impl:type=EchoImpl)
		mbs.registerMBean(mbean, name);
		
		//5.在MBeanServer里调用已注册的EchoMBean的print方法
		mbs.invoke(name,"print", new Object[]{ "zzx"}, new String[]{"java.lang.String"});
		
		Thread.sleep(Long.MAX_VALUE);
	}
}
