$(document).ready(function () {
  $('#loginButton').hide();
  $('#newUserForm').hide();
})

$('#newUserButton').click(function () {
  $('#newUserForm').show();
  $('#loginForm').hide();
  $('#loginButton').show();
  $('#newUserButton').hide();
});

$('#loginButton').click(function () {
  $('#newUserForm').hide();
  $('#loginForm').show();
  $('#loginButton').hide();
  $('#newUserButton').show();
})

$('#cancelButton').click(function () {
  $('#loginForm').show();
  $('#newUserForm').hide();
  $('#newUserButton').show();
  $('#loginButton').hide();
})
