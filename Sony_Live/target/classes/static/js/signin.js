function printError(elemId, hintMsg) {
  document.getElementById(elemId).innerHTML = hintMsg;
}

var mobile = document.getElementById("mob");
var email = document.getElementById("email");
var empid = document.getElementById("empid");
var ename = document.getElementById("name");
var password = document.getElementById("password");

let nameregex = /^[a-zA-Z\s]+$/;
let mobregex = /^[1-9]\d{9}$/;
let emailregex = /^\S+@\S+\.\S+$/;
let passregex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
let empidregex = /^[0-9]+$/;

mobile.addEventListener("keyup", () => {
  if (mobregex.test(mobile.value) === false) {
    printError("mobileErr", "Please enter a valid 10 digit mobile number");
  } else {
    printError("mobileErr", "");
  }
});

email.addEventListener("keyup", () => {
  if (emailregex.test(email.value) === false) {
    printError("emailErr", "Please enter a valid email address");
  } else {
    printError("emailErr", "");
  }
});

empid.addEventListener("keyup", () => {
  if (empidregex.test(empid.value) === false) {
    printError("empidErr", "Please enter valid Employee id");
  } else {
    printError("empidErr", "");
  }
});

ename.addEventListener("keyup", () => {
  if (nameregex.test(ename.value) === false) {
    printError("nameErr", "Please enter a valid name");
  } else {
    printError("nameErr", "");
  }
});

password.addEventListener("keyup", () => {
  if (passregex.test(password.value) === false) {
    printError(
      "passwordErr",
      "include both uppercase and lowercase characters, numbers and symbols, be atleast 8 characters long"
    );
  } else {
    printError("passwordErr", "");
  }
});

function validate() {
  if (
    nameregex.test(ename.value) &&
    mobregex.test(mobile.value) &&
    emailregex.test(email.value) &&
    empidregex.test(empid.value) &&
    passregex.test(password.value)
  ) {
    document.getElementById("submitbtn").disabled = false;
  } else {
    document.getElementById("submitbtn").disabled = true;
  }
}

// let gender = document.getElementsByName("gender");
// for (let i = 0; i < gender.length; i++) {
//   if (gender[i].checked)
//     gender = (gender[i].value);
// }


/*
let successMsg =  document.getElementById('successMsg')
let form = document.getElementById("form");
let formData;
form.addEventListener("submit", (e) => {
  e.preventDefault();
  formData = {
    name: document.getElementById("name").value,
    empId: document.getElementById("empid").value,
    mobile: document.getElementById("mob").value,
    email: document.getElementById("email").value,
    password: document.getElementById("password").value,
    gender: "Male",
    status: "active"
  }
  submitData(formData);
})

function submitData(formdata) {
  let Options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
      Authorization: "Bearer 885296be999888b017eec05a42cfcd1ee7c13a4340d89a0a64dec90219d06624"
    },
    body: JSON.stringify(formdata)
  };
  // "https://gorest.co.in/public-api/users"

  fetch("https://gorest.co.in/public-api/users", Options)
    .then(function (Response) {
      return Response.json();
    })
    .then(function (fdata) {
      console.log(fdata);
      if(fdata.code == 201){
        localStorage.setItem(formData.empId, JSON.stringify(formData));
        successMsg.innerHTML = `${formdata.name} your registration is successful!`;
      }
      else if(fdata.code == 422)
      successMsg.innerHTML = "EMP-ID already exists";
    });
}

for (var i = 0; i < localStorage.length; i++) {
  let parseData = JSON.parse(localStorage.getItem(localStorage.key(i)));
  let tableBody = document.getElementById("data");
  let tableRow = `<td>${parseData.name}</td><td>${parseData.empId}</td><td>${parseData.mobile}</td><td>${parseData.email}</td>`;
  let createTr = document.createElement('tr');
  createTr.innerHTML = tableRow;  
  tableBody.appendChild(createTr);
}

*/