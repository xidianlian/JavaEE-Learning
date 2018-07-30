
/**  
 * @Title:  BankThread.java   
 * @Package com.webrelax.thread   
 * @TODO()   
 * @author: xidian_lian
 * @date:   2018年7月30日 上午9:50:27   
 * @version V1.0  
 */
    
package com.webrelax.thread;


/**   
 * @ClassName:  BankThread   
 * @TODO(线程安全问题)  
 * @author: xidian_lian 
 * @date:   2018年7月30日 上午9:50:27       
 */

public class SaleTicket extends Thread{
	 static int num = 50;//票数  非静态的成员变量,非静态的成员变量数据是在每个对象中都会维护一份数据的。
	 public SaleTicket(String name) {
		super(name);
	}
	/*
	方式一：同步代码块
        格式：synchronize（锁对象）{
              需要被同步的代码
      }

        同步代码块需要注意的事项：

        1.锁对象可以是任意的一个对象；

        2.一个线程在同步代码块中sleep了，并不会释放锁对象；

        3.如果不存在线程安全问题，千万不要使用同步代码块；

        4.锁对象必须是多线程共享的一个资源，否则锁不住。
	 * */
	@Override
	public void run() {
		while(true){
			//同步代码块
			synchronized ("锁") {				
				if(num>0){
					System.out.println(Thread.currentThread().getName()+"售出了第"+num+"号票");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}else{
					System.out.println("售罄了..");
					break;
				}
			}			
		}
	}	
	public static void main(String[] args) {
		//创建三个线程对象，模拟三个窗口
				SaleTicket thread1 = new SaleTicket("窗口1");
				SaleTicket thread2 = new SaleTicket("窗口2");
				SaleTicket thread3 = new SaleTicket("窗口3");
				//开启线程售票
				thread1.start();
				thread2.start();
				thread3.start();
		
	}

}
