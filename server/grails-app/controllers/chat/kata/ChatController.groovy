package chat.kata

import java.util.Collection;

//import chat.kata.command.SendChatMessageCommand;

class ChatController {

	ChatService chatService;

	def list(Integer seq) {
		Collection<ChatMessage> mCollector = new ArrayList<ChatMessage>();
		Integer _last_seq = chatService.collectChatMessages(mCollector, seq);
		if(hasErrors()){
			log.error("Invalid seq: ${errors.getFieldError('seq').rejectedValue}")
			//TODO: send error about invalid seq
		}
		render(contentType: "text/json"){
			messages =[]
			for(m in mCollector){
				messages.add(nick:m.nick, message:m.message)
			}
			last_seq = _last_seq
		}
	}

	def send(){
		chatService.putChatMessage(new ChatMessage(request.JSON))
		render(status: 201){
			
		}
	}
}