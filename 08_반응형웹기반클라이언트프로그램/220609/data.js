function Student(name, pw, middle, final) {
  this.name = name; //학생 이름
  this.pw = pw; //학생 패스워드
  this.middle = middle; //중간시험 성적
  this.final = final; //기말시험 성적
}

var stu = [];
stu[0] = new Student('홍정아', 12345, 88, 77);
stu[1] = new Student('조민규', 54321, 82, 86);
stu[2] = new Student('이은준', 1357, 64, 78);
stu[3] = new Student('신은수', 24680, 94, 86);
stu[4] = new Student('송나현', 112233, 65, 75);
