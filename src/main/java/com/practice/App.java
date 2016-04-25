package com.practice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	private static class Sync extends AbstractQueuedSynchronizer {
		// Report whether in locked state
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		@Override
		// Acquire the lock if state is zero
		protected boolean tryAcquire(int arg) {
			assert arg == 1;
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		// Release the lock by setting state to zero
		protected boolean tryRelease(int arg) {
			assert arg == 1;
			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
	      // Provide a Condition
	      Condition newCondition() { return new ConditionObject(); }

	      // Deserialize properly
	      private void readObject(ObjectInputStream s) 
	        throws IOException, ClassNotFoundException {
	        s.defaultReadObject();
	        setState(0); // reset to unlocked state
	      }
	}
}
