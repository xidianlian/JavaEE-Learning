
/**  
 * @Title:  BankThread.java   
 * @Package com.webrelax.thread   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 上午9:56:28   
 * @version V1.0  
 */
    
package com.webrelax.thread;


/**   
 * @ClassName:  BankThread   
 * @TODO()   
 * @author: xidian_lian 
 * @date:   2018年7月30日 上午9:56:28       
 */

public class BankThread extends Thread{
	static int count = 5000;
	public BankThread(String name){
		super(name);
	}
//	方式二：同步函数（同步函数就是使用synchronized修饰一个函数）
//
//    同步函数注意事项：
//
//        1.如果函数是一个非静态的同步函数，那么锁对象是this对象；
//
//        2.如果函数是静态的同步函数，那么锁对象是当前函数所属的类的字节码文件（class对象）；
//
//        3.同步函数的锁对象是固定的，不能由自己指定。
//
//    例子：两夫妻取钱
	@Override  //
	public synchronized  void run() {
		while(true){
			synchronized ("锁") {				
				if(count>0){
					System.out.println(Thread.currentThread().getName()+"取走了1000块,还剩余"+(count-1000)+"元");
					count= count - 1000;
				}else{
					System.out.println("取光了...");
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		//创建两个线程对象
		BankThread thread1 = new BankThread("老公");
		BankThread thread2 = new BankThread("老婆");
		//调用start方法开启线程取钱
		thread1.start();
		thread2.start();
	}
}
