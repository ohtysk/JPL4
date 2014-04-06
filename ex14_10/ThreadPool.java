
/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */
import java.util.LinkedList;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class. 
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public final class ThreadPool {
	enum State { INIT, STARTED, STOPPED };
    private int queueSize;
	private volatile State state;
	private Object signal = new Object();
	private PooledThread[] threads;
	private LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	
	private class PooledThread extends Thread {
		private Runnable task = null;

		public void run() {
			while (true) {
				try {
					synchronized (signal) {
						while (state == ThreadPool.State.STARTED && tasks.isEmpty())
							signal.wait();
					}

					if (state == ThreadPool.State.STOPPED) return;

					synchronized (tasks) {
						if (tasks.isEmpty()) continue;
						task = tasks.remove();
						tasks.notifyAll();
					}

					if (task != null) {
						task.run();
						task = null;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) throws IllegalArgumentException {
    	if (queueSize < 1 || numberOfThreads < 1) throw new IllegalArgumentException();
    	this.queueSize = queueSize;

    	threads = new PooledThread[numberOfThreads];
    	for (int i = 0; i < numberOfThreads; i++)
    		threads[i] = new PooledThread();
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() throws IllegalStateException {
    	if (state == State.STARTED) throw new IllegalStateException();
    	state = State.STARTED;

    	for (PooledThread thread : threads) {
    		thread.start();
    	}
    }   

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() throws IllegalStateException {
    	if (state != State.STARTED) throw new IllegalStateException();

    	try {
    		synchronized (tasks) {
  	   	    	while (!tasks.isEmpty()) 
    				tasks.wait();
   	    	}
        	state = State.STOPPED;
        	synchronized (signal) {
        		signal.notifyAll();
        	}
        	joinAll();
    	} catch (InterruptedException e) {
			e.printStackTrace();    			
    	}
    }
    
    private void joinAll() {
    	for (PooledThread thread : threads) {
    		try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}    	
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     * 
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) throws IllegalStateException, NullPointerException {
    	if (state != State.STARTED) throw new IllegalStateException();
    	if (runnable == null) throw new NullPointerException();
    	
		try {
	    	synchronized (tasks) {
	    		while (tasks.size() == queueSize)
					tasks.wait();
	    		tasks.offer(runnable);
	    		tasks.notifyAll();
	    	}
	    	synchronized (signal) {
	    		signal.notifyAll();
	    	}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
