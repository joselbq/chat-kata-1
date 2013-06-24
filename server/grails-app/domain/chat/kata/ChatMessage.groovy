package chat.kata

//import com.google.common.base.Objects

class ChatMessage {

	String nick
	String message

	static constraints = {
		nick instanceof: String, blank: false
		message instanceof: String, blank: false
	}

	int hashCode(){
		return Objects.hashCode(nick, message)
	}

	boolean equals(obj){
		if(obj == null || !(obj instanceof ChatMessage)){
			return false
		}
		return nick.compareTo(obj.nick) == 0 && message.compareTo(obj.message) == 0
		//return Objects.equal(this.nick, obj.nick) && Objects.equal(this.message, obj.message)
	}

	String toString(){
		return nick+":"+message
	}


}
