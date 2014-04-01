// cmd: 大体２回に一回ハング
// cygwin: 大体200回に一回ハング
// yeild()しても変わらない
public class Friendly {
	private Friendly partner;
	private String name;
	
	public Friendly(String name) {
		this.name = name;
	}
	
	public synchronized void hug() {
		System.out.println(Thread.currentThread().getName() +
				" in " + name + ".hug() trying to invoke " + partner.name + ".hubBack()");
		//partner.hugBack();
		new Thread(new Runnable() {
			public void run() {
				partner.hugBack();
			}
		}, Thread.currentThread().getName() + "-hugback").start();
	}
	
	public synchronized void hugBack() {
		System.out.println(Thread.currentThread().getName() +
				" in " + name + ".hugBack()");
	}
	
	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}
	
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		new Thread(new Runnable() {
			public void run() {
				jareth.hug();
				Thread.yield();
			}
		}, "Thread1").start();
		
		new Thread(new Runnable() {
			public void run() {
				cory.hug();
				Thread.yield();
			}
		}, "Thread2").start();
	}
}
