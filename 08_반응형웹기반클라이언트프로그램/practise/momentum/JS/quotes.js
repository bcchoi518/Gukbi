const quotes = [
  {
    quote: 'The only way to learn a new programming language is by writing programs in it.',
    author: 'Dennis Ritchie',
  },
  {
    quote: '새로운 프로그래밍 언어를 배우는 유일한 방법은 그 언어로 프로그램을 만드는 것이다.',
    author: '데니스 리치',
  },
  {
    quote: 'Programming isn’t about what you know; it’s about what you can figure out.',
    author: 'Chris Pine',
  },
  {
    quote: '프로그래밍은 무엇을 알고 있는가에 대한 것이 아니다. 그것은 당신이 무엇을 알아낼 수 있는 가에 대한 것이다.',
    author: '크리스 파인',
  },
];

const quote = document.querySelector('#quote span:first-child');
const author = document.querySelector('#quote span:last-child');

const todaysQuote = quotes[Math.floor(Math.random() * quotes.length)];

quote.innerText = todaysQuote.quote;
author.innerText = todaysQuote.author;
