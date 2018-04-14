package nxty.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.*;

public class AutoDenyThreadFactory implements ThreadFactory{

	private final AtomicInteger threadNumber;
	
	public AutoDenyThreadFactory() {
		this.threadNumber = new AtomicInteger(1);
	}
	
	@Override
	public Thread newThread(final Runnable r) {
		return new Thread(r, "Main" + this.threadNumber.getAndIncrement());
	}
	
}
