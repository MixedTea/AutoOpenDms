package nxty.test;

public class denyThread implements Runnable{

	private String message1_1 = " My direct message are open!";
	private String message1_2 = " You do not need to be on my friends list to message me";
	
	private String message2_1 = " You can message me without being on my friends list!";
	private String message2_2 = " Everybody can message me =D";		
	
	private String message3_1 = " My dms are open so you don't need to be on my friends list =/";
	private String message3_2 = " So im gonna remove you D:";
			
	
	public void run() {
		try {
		String message1 = "";
		String message2 = "";
		int stage = sendMessage.getStage();
		switch(stage) {
			case 1:
				message1 = message1_1;
				message2 = message1_2;
				break;
			case 2:
				message1 = message2_1;
				message2 = message2_2;
				break;
			case 3:
				message1 = message3_1;
				message2 = message3_2;
		}
		String username = sendMessage.getUsername();
		Main.mc.thePlayer.sendChatMessage("/friend accept " + username);
		Thread.sleep(1000);
		Main.mc.thePlayer.sendChatMessage("/msg " + username + message1);
		Thread.sleep(1000);
		Main.mc.thePlayer.sendChatMessage("/msg " + username + message2);
		Thread.sleep(1000);
		Main.mc.thePlayer.sendChatMessage("/friend remove " + username);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
