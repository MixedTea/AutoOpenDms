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
	private String[] tempBlocked;
	public static String username = "";
	private Pattern req = Pattern.compile(
			"\u00A7m----------------------------------------------------Friend request from (?<name>.+)\\[ACCEPT\\] - \\[DENY\\] - \\[IGNORE\\].*");
	@SubscribeEvent
	public void chatReceived(ClientChatReceivedEvent event){
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
				if(tempBlocked[i] == name) {
					isBlocked = true;
					break;
				}
			}
			if(!isBlocked) {
				username = name;
				Main.Threadpool.submit(new denyThread());
				tempBlocked = push(tempBlocked, name);
			}
		}
	}
	public static String getUsername(){
		return username;
	}
}
