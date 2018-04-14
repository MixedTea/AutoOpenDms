package nxty.test;

public class denyThread implements Runnable{

	public void run() {
		try {
		String username = sendMessage.getUsername();
		Main.mc.thePlayer.sendChatMessage("/friend accept " + username);
		Thread.sleep(1000);
		Main.mc.thePlayer.sendChatMessage("/msg " + username + " My direct messages are open!");
		Thread.sleep(1000);
		Main.mc.thePlayer.sendChatMessage("/msg " + username + " You do not need to be on my friends list to message me");
		Thread.sleep(1000);
		Main.mc.thePlayer.sendChatMessage("/friend remove " + username);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
