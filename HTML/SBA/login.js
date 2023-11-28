document.getElementById("loginBtn").addEventListener("click", validatelogin);
function validatelogin() {
  var usernameOrEmail = document.getElementById("usernameOrEmail").value;
  var password = document.getElementById("password").value;
  if (!usernameOrEmail.trim() || !password.trim()) {
    alert("Please enter both username/email and password.");
    return false;
  }
  window.open("index.html");
  return true;
}
