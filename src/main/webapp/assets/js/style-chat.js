const form = document.querySelector(".typing-area");
const incoming_id = form.querySelector(".incoming_id").value;
const inputField = form.querySelector(".input-field");
const sendBtn = form.querySelector("button");
const chatBox = document.querySelector(".chat-box");
const profile = document.getElementById("profile-img");
const filler = document.getElementById("filler");
const header  = document.querySelector(".main-header");
const userCode = document.querySelector(".userCode");
const imageCode = document.querySelector(".imageCode");

const userDetails = (header.textContent+":"+userCode.textContent+":"+imageCode.textContent+":").split(" ").join("");

let lastIndex = -1;

form.onsubmit = (e)=>{
    e.preventDefault();
}

inputField.focus();
inputField.onkeyup = ()=>{
    if(inputField.value != ""){
        sendBtn.classList.add("active");
    }else{
        sendBtn.classList.remove("active");
    }
}

chatBox.onmouseenter = ()=>{
    chatBox.classList.add("active");
}

chatBox.onmouseleave = ()=>{
    chatBox.classList.remove("active");
}

function scrollToBottom(){
  chatBox.scrollTop = chatBox.scrollHeight;
}

fetchActiveUsers();
console.log("hello world");
// Function to update the chat area

  function updateChatArea(messages,type) {
  	
  	
    if(type === "incoming"){
		
		messages.forEach((message,index) => {
			const messageDetails = message.content.substring(0,message.content.lastIndexOf(":"));
			const currentUserDetails = userDetails.substring(0,message.content.lastIndexOf(":"));
      	if(index>lastIndex && messageDetails !== currentUserDetails){
			  filler.style.display = "none";
		  const msgArray = message.content.split(':');
		  const messageElement = ` <div class="chat ${type}">
            <img src="assets/images/user-images/profile-image-${msgArray[2]}.jpg" alt="image">
            <div class="details">
                <p>${msgArray[3]}</p>
            </div>
          </div> `;
      chatBox.innerHTML += messageElement;
	  }
    });
	}
	else{
		 filler.style.display = "none";
		const messageElement = ` <div class="chat ${type}">
            <div class="details">
                <p>${messages}</p>
         	</div> `;
      chatBox.innerHTML += messageElement;
	}
    
    scrollToBottom();
  }
  
  
// Function to fetch new messages using AJAX
  function fetchNewMessages() {
	console.log("fetching msg")
    fetch('getMessage')
      .then(response =>{
		  if (!response.ok) {
                throw new Error(`Network response was not ok (${response.status} ${response.statusText})`);
            }
           return response.json()
	  })
      .then(messages => {
		  
		  updateChatArea(messages,'incoming');
		  lastIndex = messages.length -1;
	  })
      .catch(error => console.error('Error fetching messages:', error));
  }

  setInterval(fetchNewMessages, 2000);
  
  
//Function To send new message  

sendBtn.onclick = () => {
	console.log("hello world");
  const message = inputField.value.trim();
  
  if (message !== "") {
    inputField.value = "";
 	updateChatArea(message,'outgoing');
 	
    fetch('ClientSession', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ content: userDetails + message  }),
    })
    .then(response => {
		console.log("sent the post");
		console.log("hello world");
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
    })
    .catch(error => console.error('Error sending message:', error));
    scrollToBottom();
  }
};

// Function to update the users area

function fetchActiveUsers() {
	console.log("fetching")
    fetch('getActiveUsers')
      .then(response =>{
		  if (!response.ok) {
                throw new Error(`Network response was not ok (${response.status} ${response.statusText})`);
            }
           return response.json()
	  })
      .then(messages => {
		  console.log(messages);
		  /*updateUserArea(messages);*/
		  /*lastIndex = messages.length -1;*/
	  })
      .catch(error => console.error('Error fetching messages:', error));
  }

  setInterval(fetchActiveUsers, 2000);


// Function to update the chat area
  function updateUserArea(messages) {
  	
  	
    if(type === "incoming"){
		
		messages.forEach((message,index) => {
			const messageDetails = message.content.substring(0,message.content.lastIndexOf(":"));
			const currentUserDetails = userDetails.substring(0,message.content.lastIndexOf(":"));
      	if(index>lastIndex && messageDetails !== currentUserDetails){
			  filler.style.display = "none";
		  const msgArray = message.content.split(':');
		  const messageElement = ` <div class="chat ${type}">
            <img src="assets/images/user-images/profile-image-${msgArray[2]}.jpg" alt="image">
            <div class="details">
                <p>${msgArray[3]}</p>
            </div>
          </div> `;
      chatBox.innerHTML += messageElement;
	  }
    });
	}
	else{
		 filler.style.display = "none";
		const messageElement = ` <div class="chat ${type}">
            <div class="details">
                <p>${messages}</p>
         	</div> `;
      chatBox.innerHTML += messageElement;
	}
    
    scrollToBottom();
  }