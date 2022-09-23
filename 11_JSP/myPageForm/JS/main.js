const toggleBtn = document.querySelector('.navbar__toggleBtn');
const menu = document.querySelector('.navbar__menu');
const sidebarMenu = document.querySelectorAll('.aside_portfolio_menu li');

toggleBtn.addEventListener('click', () => {
  menu.classList.toggle('active');
});

sidebarMenu.forEach((menu) => {
  menu.addEventListener('click', () => {
    sidebarMenu.forEach((item) => {
      if (item.classList.contains('active')) {
        item.classList.toggle('active');
      } //if
    });
    menu.classList.toggle('active');
  });
});