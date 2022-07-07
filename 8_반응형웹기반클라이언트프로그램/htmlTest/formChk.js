function join() {
  const f = document.joinForm;

  if (f.id.value.trim() == '') {
    alert('아이디를 입력하세요');
    f.id.focus();
    return;
  }
  if (f.passwd.value.trim() == '') {
    alert('비밀번호를 입력하세요');
    f.passwd.focus();
    return;
  }
  if (f.passwdChk.value.trim() == '') {
    alert('비밀번호 확인을 입력하세요');
    f.passwdChk.focus();
    return;
  } else if (f.passwd.value.trim() !== f.passwdChk.value.trim()) {
    alert('입력한 비밀번호가 다릅니다. 다시 입력해 주세요');
    f.passwdChk.value.trim() = '';
    f.passwd.select();
    f.passwd.focus();
    return;
  }
  if (f.name.value.trim() == '') {
    alert('이름을 입력하세요');
    f.name.focus();
    return;
  }
  if (f.nickname.value.trim() == '') {
    alert('닉네임을 입력하세요');
    f.nickname.focus();
    return;
  }
  if (f.phone.value.trim() == '') {
    alert('전화번호를 입력하세요');
    f.phone.focus();
    return;
  }
  if (f.email.value.trim() == '') {
    alert('이메일을 입력하세요');
    f.email.focus();
    return;
  }
  if (f.jumin1.value.trim() == '') {
    alert('주민번호 앞자리를 입력하세요');
    f.jumin1.focus();
    return;
  }
  if (f.jumin2.value.trim() == '') {
    alert('주민번호 뒷자리를 입력하세요');
    f.jumin2.focus();
    return;
  }
  if (f.address.value.trim() == '') {
    alert('주소를 입력하세요');
    f.address.focus();
    return;
  }
  if (f.chuchunId.value.trim() == '') {
    alert('추천인아이디를 입력하세요');
    f.chuchunId.focus();
    return;
  }

  if (confirm('저장할까요?')) {
    f.submit(); // submit버튼으로 하지 않고 button 버튼으로 한 경우 submit을 실행해줘야 함
  }
}
