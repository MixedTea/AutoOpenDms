package nxty.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class sendMessage {
	private static String[] push(String[] array, String push) {
	    String[] longer = new String[array.length + 1];
	    for (int i = 0; i < array.length; i++)
	        longer[i] = array[i];
	    longer[array.length] = push;
	    return longer;
	}
	
	private String[] tempBlocked = new String[0];
	private static String username = "";
	private static int stage = 1;
	
	private Pattern req = Pattern.compile(
			"\u00A7m----------------------------------------------------Friend request from (?<name>.+)\\[ACCEPT\\] - \\[DENY\\] - \\[IGNORE\\].*");
	@SubscribeEvent
	public void chatReceived(ClientChatReceivedEvent event){
		
		if(!adCommand.toggle) return;
		
		boolean isBlocked = false;
		
		String message = event.message.getUnformattedText();
		
		message = message.replaceAll("\n", "");
		
		Matcher matcher = req.matcher(message);
		
		if(matcher.matches()) {
			String name = matcher.group("name");
			if(name.startsWith("[")) {
				name = name.substring(name.indexOf("] ") + 2);
			}
			
			for(int i = 0; i < tempBlocked.length; i++) {
				if(tempBlocked[i].equals(name)) {
					isBlocked = true;
					break;
				}
			} 
			
			if(isBlocked != true) {
				username = name;
				stage += 1;
				if(stage > 3) {
					stage = 1;
				}
				Main.Threadpool.submit(new denyThread());
				tempBlocked = push(tempBlocked, name);
			}
		}
	}
	public static int getStage() {
		return stage;
	}
	public static String getUsername(){
		return username;
	}
}
