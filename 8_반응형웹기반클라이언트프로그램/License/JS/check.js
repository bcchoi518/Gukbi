//DOM
const custno = document.querySelector('#custno');
const custname = document.querySelector('#custname');
const phone = document.querySelector('#phone');
const address = document.querySelector('#address');
const joindate = document.querySelector('#joindate');
const grade = document.querySelector('#grade');
const city = document.querySelector('#city');

//function
function joinCheck() {
  if (custname.value.length == 0) {
    alert('회원성명이 입력되지 않았습니다.');
    custname.focus();
    return false;
  }
  if (phone.value.length == 0) {
    alert('회원전화가 입력되지 않았습니다.');
    phone.focus();
    return false;
  }
  if (address.value.length == 0) {
    alert('회원주소가 입력되지 않았습니다.');
    address.focus();
    return false;
  }
  if (joindate.value.length == 0) {
    alert('가입일자가 입력되지 않았습니다.');
    joindate.focus();
    return false;
  }
  if (grade.value.length == 0) {
    alert('고객등급이 입력되지 않았습니다.');
    grade.focus();
    return false;
  }
  if (city.value.length == 0) {
    alert('도시코드가 입력되지 않았습니다.');
    city.focus();
    return false;
  }
  success();
  return true;
}

function success() {
  alert('회원등록이 완료 되었습니다!');
}

function search() {
  window.location = 'list.html';
}

function modify() {
  alert('회원정보수정이 완료 되었습니다!');
}

//event
document.querySelector('#submitbtn').addEventListener('click', joinCheck);
// document.querySelector('#modifybtn').addEventListener('click', modify);
document.querySelector('#searchbtn').addEventListener('click', search);
