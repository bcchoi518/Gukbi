// Q2
const data = {
  id: 'hong',
  pw: '1234',
};

// Q5
function handleLogin() {
  const id = document.login_form.id.value.trim();
  const pw = document.login_form.passwd.value.trim();

  let url = './login_fail.html';

  if (id == '') {
    alert('아이디를 입력해주세요.');
    document.login_form.id.focus();
    return;
  } else if (pw == '') {
    alert('비밀번호를 입력해주세요.');
    document.login_form.passwd.focus();
    return;
  } else if (id == data.id && pw == data.pw) {
    url = 'login_success.html';
  }

  document.login_form.action = url;
  document.login_form.method = 'post';
  document.login_form.submit();
}

document.getElementById('login_btn').addEventListener('click', handleLogin);
