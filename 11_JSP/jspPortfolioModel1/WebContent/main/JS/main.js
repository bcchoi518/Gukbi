const toggleBtn = document.querySelector('.navbar__toggleBtn');
const menu = document.querySelector('.navbar__menu');
const sidebarMenu = document.querySelectorAll('.aside_portfolio_menu li');

toggleBtn.addEventListener('click', () => {
  menu.classList.toggle('active');
});
