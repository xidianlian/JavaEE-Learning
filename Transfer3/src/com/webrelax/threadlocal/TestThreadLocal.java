
/**  
 * @Title:  TestThreadLocal.java   
 * @Package com.webrelax.threadlocal   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月31日 下午8:13:00   
 * @version V1.0  
 */
    
package com.webrelax.threadlocal;



class MyThread extends Thread{
	private ThreadLocal tl;
	public MyThread(ThreadLocal tl) {
		this.tl=tl;
	}
	/** 
	 * @see java.lang.Thread#run()
	 **/
	@Override
	public void run() {
		System.out.println(tl.get()+"/////");//这里tl.get()返回为Null
	}
	
}
/**   
 * @ClassName:  TestThreadLocal   
 * @TODO(帮助理解ThreadLocal的原理)   
 * @author: xidian_lian 
 * @date:   2018年7月31日 下午8:13:00       
 */
public class TestThreadLocal {

	/**@Title: main
	 * @TODO(main函数也是一个线程)
	*/

	public static void main(String[] args) {
		ThreadLocal tl=new ThreadLocal();
		tl.set("aaaaaaaaa");
		MyThread mt=new MyThread(tl);
		mt.start();//mt和main函数不是一个线程的
		System.out.println(tl.get());
	}

}
