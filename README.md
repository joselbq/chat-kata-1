chat-kata
=========

A Code Kata for building and REST client-server chat app for Android.

Server-side Kata
-----------------

Follow the README in [server directory](/server)

Client-side Kata
-----------------

Follow the README in [client directory](/client/SimpleChat)

API Contract
------------

The following are the definition of the API resources.

### Chat Resource ###

This the main resource of the chat server.

*Endpoint:* ```/api/chat```

#### Get chat messages ####

* *Method:* GET

* *Parameters:*

<table class="confluenceTable"><tbody><tr><th class="confluenceTh">Name</th><th colspan="1" class="confluenceTh">Type</th><th class="confluenceTh">Description</th><th colspan="1" class="confluenceTh">Mandatory</th><th colspan="1" class="confluenceTh">Cardinality</th><th class="confluenceTh">Example</th></tr><tr><td colspan="1" class="confluenceTd">seq</td><td colspan="1" class="confluenceTd">Integer</td><td colspan="1" class="confluenceTd">Sequence from last received message. No present if this is the first call</td><td colspan="1" class="confluenceTd">No</td><td colspan="1" class="confluenceTd">1</td><td colspan="1" class="confluenceTd">/api/chat?seq=3</td></tr></tbody></table><p><strong>Response:</strong></p><p><strong>Response when there are new messages:</strong></p><table class="wysiwyg-macro" data-macro-name="code" data-macro-parameters="language=javascript|title=/api/chat?seq\=4" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGU6dGl0bGU9L2FwaS9jaGF0P3NlcT00fGxhbmd1YWdlPWphdmFzY3JpcHR9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{
    "messages": [ {"nick":"user1", "message":"hi there"},
                  {"nick":"user2", "message":"hola"} ],
    "last_seq": 6
}</pre></td></tr></table><p><strong><strong>Response when there are no new messages:</strong></strong></p><table class="wysiwyg-macro" data-macro-name="code" data-macro-parameters="language=javascript|title=/api/chat?seq\=6" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGU6dGl0bGU9L2FwaS9jaGF0P3NlcT02fGxhbmd1YWdlPWphdmFzY3JpcHR9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{
    "messages": [],
    "last_seq": 6
}</pre></td></tr></table><p><span style="color: rgb(0,0,128);font-size: 10.0pt;line-height: 13.0pt;"> </span></p><p><strong>Errors:</strong><span style="color: rgb(0,0,128);font-size: 10.0pt;line-height: 13.0pt;"> </span></p><table class="confluenceTable"><tbody><tr><th class="confluenceTh">Status Code</th><th class="confluenceTh">Body</th><th class="confluenceTh">Description</th></tr><tr><td colspan="1" class="confluenceTd">400</td><td colspan="1" class="confluenceTd"><table class="wysiwyg-macro" data-macro-name="code" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGV9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{"message":"invalid seq parameter"}</pre></td></tr></table></td><td colspan="1" class="confluenceTd">When the seq parameter is invalid (e.g. an string)</td></tr></tbody></table>

#### Send chat messages ####

* *Method:* POST

* *Body:* 
 <table class="wysiwyg-macro" data-macro-name="code" data-macro-parameters="language=javascript|title=/api/chat?seq\=4" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGU6dGl0bGU9L2FwaS9jaGF0P3NlcT00fGxhbmd1YWdlPWphdmFzY3JpcHR9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{
    "nick":"user1",
	"message": "Hola Mundo Reader"
}</pre></td></tr></table>

* *Errors:*
<table class="confluenceTable"><tbody><tr><th class="confluenceTh">Status Code</th><th class="confluenceTh">Body</th><th class="confluenceTh">Description</th></tr><tr><td colspan="1" class="confluenceTd">400</td><td colspan="1" class="confluenceTd"><table class="wysiwyg-macro" data-macro-name="code" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGV9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{"message":"invalid body"}</pre></td></tr></table></td><td colspan="1" class="confluenceTd">When no body or invalid JSON is sent</td></tr><tr><td colspan="1" class="confluenceTd">400</td><td colspan="1" class="confluenceTd"><table class="wysiwyg-macro" data-macro-name="code" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGV9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{"message":"missing nick parameter"}</pre></td></tr></table></td><td colspan="1" class="confluenceTd">When the user nick is missing in the body</td></tr><tr><td colspan="1" class="confluenceTd">400</td><td colspan="1" class="confluenceTd"><table class="wysiwyg-macro" data-macro-name="code" style="background-image: url(/confluence/plugins/servlet/confluence/placeholder/macro-heading?definition=e2NvZGV9&amp;locale=en_GB&amp;version=2); background-repeat: no-repeat;" data-macro-body-type="PLAIN_TEXT"><tr><td class="wysiwyg-macro-body"><pre>{"message":"missing message parameter"}</pre></td></tr></table></td><td colspan="1" class="confluenceTd">When the message is missing in the body</td></tr></tbody></table>