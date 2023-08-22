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