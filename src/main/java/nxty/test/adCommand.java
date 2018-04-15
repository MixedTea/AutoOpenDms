package nxty.test;

import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class adCommand extends CommandBase{
	public static boolean toggle = true;
	
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "autodeny";
	}

	
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "Usage: /" + getCommandName() + " [" + EnumChatFormatting.GREEN + "on" + EnumChatFormatting.GRAY + 
				"/" + EnumChatFormatting.RED +"off" + EnumChatFormatting.GRAY +"]";
	}

	
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		return Arrays.asList("text", "textwriter");
	}

	
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		try {
			if(args[0].equals("on")) {
				this.showMessage("AutoDeny is now toggled " + EnumChatFormatting.GREEN + "on!", sender);
				toggle = true;
			} else if(args[0].equals("off")) {
				this.showMessage("AutoDeny is now toggled " + EnumChatFormatting.RED + "off!", sender);
				toggle = false;
			} else {
				this.showMessage(this.getCommandUsage(sender),sender);
			}
		} catch(Exception e) {
			this.showMessage(this.getCommandUsage(sender), sender);
		}
			//this.showMessage(args[0], sender);
	}

	
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void showMessage(final String args, final ICommandSender sender) {
        sender.addChatMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.BLUE + "AutoDeny> " + EnumChatFormatting.GRAY + args));
    }
	
}
