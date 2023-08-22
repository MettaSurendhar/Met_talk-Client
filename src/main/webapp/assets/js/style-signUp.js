// EmailAddress

const emailAddress = document.getElementById('emailAddress');
const mailReg = new RegExp('^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$');
const otp = document.getElementById('otp');

emailAddress.addEventListener('input',()=>{
  if(!mailReg.test(emailAddress.value)){
    emailAddress.classList.add('is-invalid');
  }
  else{
    emailAddress.classList.remove('is-invalid');
  }
})

// Function to generate OTP

function generateOtp() {
  const min = 100000;
  const max = 999999;
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

//Function To send new message
const otpValue = generateOtp();  
const sendBtn = document.querySelector('#send-btn');
sendBtn.onclick = () => {
	console.log(otpValue);
 	
    fetch('SendOtp', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ content : otpValue+emailAddress.value}),
    })
    .then(response => {
		console.log("sent the post")
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
    })
    .catch(error => console.error('Error sending message:', error));
};

// Confirm OTP

const otpEntered = document.getElementById('otpEntered');

otpEntered.addEventListener('input',()=>{
  if(otpEntered.value !== String(otpValue)){
    otpEntered.classList.add('is-invalid');
  }
  else{
    otpEntered.classList.remove('is-invalid');
  }
})

// Confirm password

const confirmPassword = document.getElementById('confirmPassword');
const actualPassword = document.getElementById('actualPassword');


confirmPassword.addEventListener('input',()=>{

  if(confirmPassword.value !== actualPassword.value){
    confirmPassword.classList.add('is-invalid');
  }
  else{
    confirmPassword.classList.remove('is-invalid');
  }
})

// Password 

const password = document.getElementById('actualPassword');
const passReg = new RegExp('^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*_-])[a-zA-Z0-9!@#$%^&*_-]{8,25}$');

password.addEventListener('input',()=>{

  if(!passReg.test(password.value)){
    password.classList.add('is-invalid');
  }
  else{
    password.classList.remove('is-invalid');
  }

})

// UserName

const userName = document.getElementById('userName');
const userReg = new RegExp('^((?![!@#$%^&*~`?|-]).)[a-zA-Z0-9_]{3,25}$');

userName.addEventListener('input',()=>{

  if(!userReg.test(userName.value)){
    userName.classList.add('is-invalid');
  }
  else{
    userName.classList.remove('is-invalid');
  }
})



