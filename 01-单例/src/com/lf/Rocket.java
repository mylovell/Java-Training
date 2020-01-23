package com.lf;

//【推荐】饿汉式单例模式————一上来就创建个实例————无线程问题
public class Rocket {
	// 私有静态实例变量 （外界不能直接获取到）
	private static Rocket instance = new Rocket();
	// 私有构造方法 （外界不能调用，外界也就无法随意创建对象）
	private Rocket() { }
	// 公共静态方法，返回唯一实例
	public static Rocket getInstance() {
		return instance;
	}
}
//【不推荐】懒汉式单例模式————用到再创建————有线程问题
class Rocket1 {

	private static Rocket1 instance = null;
	private Rocket1() { }
	// 这个方法非线程安全，假单例
	public static Rocket1 getInstance() {
		if (instance == null) {
			instance = new Rocket1();
		}
		return instance;
	}
}
