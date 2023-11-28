document.getElementById("submitBtn").addEventListener("click", validateForm);
function validateForm() {
  const elements = document.querySelectorAll(".form__input");
  let errorMessages = "";
  let errorflag = 0;
  elements.forEach((element) => {
    if (element.tagName.toLowerCase() === "input") {
      if (element.value.trim() === "" && errorflag === 0) {
        errorMessages += "Please fill out all fields.\n";
        errorflag = 1;
      }
      if (element.id === "username" && !isValidUsername(element.value)) {
        errorMessages +=
          "Please enter a valid username. Use only letters, numbers, and underscores.\n";
      }
      if (element.id === "email" && !isValidEmail(element.value)) {
        errorMessages += "Please enter a valid email address.\n";
      }
      if (element.id === "phoneNumber" && !isValidPhoneNumber(element.value)) {
        errorMessages +=
          "Please enter a valid phone number. Use only numbers and optional hyphens.\n";
      }
    }
  });
  if (errorMessages !== "") {
    alert(errorMessages);
    return false;
  }
  window.open("index.html");
  return true;
}

function isValidUsername(username) {
  var usernameRegex = /^[a-zA-Z0-9_]+$/;
  return usernameRegex.test(username);
}

function isValidEmail(email) {
  const reg =
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return reg.test(String(email).toLowerCase());
}

function isValidPhoneNumber(phoneNumber) {
  var phoneNumberRegex = /^[0-9]+(-[0-9]+)*$/;
  return phoneNumberRegex.test(phoneNumber);
}
