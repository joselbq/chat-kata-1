package org.ejmc.android.simplechat.model;

/**
 * Server request error.
 * 
 * @author startic
 * 
 */
public class RequestError {

	String statusError;
	String messageError;

	public RequestError(String statusError, String messageError) {
		super();
		this.statusError = statusError;
		this.messageError = messageError;
	}

	public String getStatusError() {
		return statusError;
	}

	public void setStatusError(String statusError) {
		this.statusError = statusError;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
