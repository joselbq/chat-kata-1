package org.ejmc.android.simplechat.model;

import java.util.ArrayList;

/**
 * List off chat messages..
 * 
 * @author startic
 * 
 */
public class ChatList {

	private ArrayList<Message> messagessList;

	public ChatList(ArrayList<Message> messagessList) {
		this.messagessList = messagessList;
	}

	public ArrayList<Message> getMessagessList() {
		return messagessList;
	}

	public void setMessagessList(ArrayList<Message> messagessList) {
		this.messagessList = messagessList;
	}

}
