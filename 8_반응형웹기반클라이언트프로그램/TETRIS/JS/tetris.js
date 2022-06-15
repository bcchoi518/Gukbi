import BLOCKS from './blocks.js';

// DOM
const playground = document.querySelector('.playground > ul');
const gameText = document.querySelector('.game-text');
const scoreDisplay = document.querySelector('.score');
const levelDisplay = document.querySelector('.level');
const restartButton = document.querySelector('.game-text > button');

// Setting
const GAME_ROWS = 20;
const GAME_COLS = 10;

// variables
let score = 0;
let level = 1;
let duration = 500;
let downInterval;
let tempMovingItem;

const movingItem = {
  type: '',
  direction: 0,
  top: 0,
  left: 0,
};

init();

// functions
function init() {
  tempMovingItem = { ...movingItem };
  for (let i = 0; i < GAME_ROWS; i++) {
    prependNewLine();
  } //end for
  generateNewBlock();
} //end init

function prependNewLine() {
  const li = document.createElement('li');
  const ul = document.createElement('ul');
  for (let j = 0; j < GAME_COLS; j++) {
    const matrix = document.createElement('li');
    ul.prepend(matrix);
  } //end for
  li.prepend(ul);
  playground.prepend(li);
} //end prependNewLine

function renderBlocks(moveType = '') {
  const { type, direction, top, left } = tempMovingItem;
  const movingBlocks = document.querySelectorAll('.moving');
  movingBlocks.forEach((moving) => {
    moving.classList.remove(type, 'moving');
  });
  // forEach는 반복문을 중간에 break 할 수 없음(some으로 대체)
  BLOCKS[type][direction].some((block) => {
    const x = block[0] + left;
    const y = block[1] + top;
    const target = playground.childNodes[y] ? playground.childNodes[y].childNodes[0].childNodes[x] : null;
    const isAvailable = checkEmpty(target);
    if (isAvailable) {
      target.classList.add(type, 'moving');
    } else {
      tempMovingItem = { ...movingItem };
      if (moveType === 'retry') {
        clearInterval(downInterval);
        showGameoverText();
      } //end if
      setTimeout(() => {
        renderBlocks('retry');
        if (moveType === 'top') {
          seizeBlock();
        } //end if
      }, 0); //end setTimeout
      return true;
    } //end if
  }); //end BLOCKS
  movingItem.left = left;
  movingItem.top = top;
  movingItem.direction = direction;
} //end renderBlocks

function seizeBlock() {
  const movingBlocks = document.querySelectorAll('.moving');
  movingBlocks.forEach((moving) => {
    moving.classList.remove('moving');
    moving.classList.add('seized');
  });
  checkMatch();
} //end seizeBlock

function checkMatch() {
  const childNodes = playground.childNodes;
  childNodes.forEach((child) => {
    let matched = true;
    child.children[0].childNodes.forEach((li) => {
      if (!li.classList.contains('seized')) {
        matched = false;
      } //end if
    });
    if (matched) {
      child.remove();
      prependNewLine();
      score++;
      scoreDisplay.innerText = score;
      if (score !== 0 && score % 10 === 0) {
        levelUp();
      } //end if
    } //end if
  });
  generateNewBlock();
} //end checkMatch

function levelUp() {
  level++;
  levelDisplay.innerText = level;
  duration -= level * 10;
  clearInterval(downInterval);
  downInterval = setInterval(() => {
    moveBlock('top', 1);
  }, duration);
} //end levelUp

function generateNewBlock() {
  clearInterval(downInterval);
  downInterval = setInterval(() => {
    moveBlock('top', 1);
  }, duration);
  const blockArray = Object.entries(BLOCKS);
  const randomIndex = Math.floor(Math.random() * blockArray.length);
  movingItem.type = blockArray[randomIndex][0];
  movingItem.top = 0;
  movingItem.left = 3;
  movingItem.direction = 0;
  tempMovingItem = { ...movingItem };
  renderBlocks();
} //end generateNewBlock

function checkEmpty(target) {
  if (!target || target.classList.contains('seized')) {
    return false;
  } //end if
  return true;
} //end checkEmpty

function moveBlock(moveType, amount) {
  tempMovingItem[moveType] += amount;
  renderBlocks(moveType);
} //end moveBlock

function changeDirection() {
  const direction = tempMovingItem.direction;
  direction === 3 ? (tempMovingItem.direction = 0) : (tempMovingItem.direction += 1);
  renderBlocks();
} //end changeDirection

function dropBlock() {
  clearInterval(downInterval);
  downInterval = setInterval(() => {
    moveBlock('top', 1);
  }, 10);
} //end dropBlock

function showGameoverText() {
  gameText.style.display = 'flex';
} //end showGameoverText

// event handling
document.addEventListener('keydown', (e) => {
  switch (e.keyCode) {
    case 39:
      moveBlock('left', 1);
      break;
    case 37:
      moveBlock('left', -1);
      break;
    case 40:
      moveBlock('top', 1);
      break;
    case 38:
      changeDirection();
      break;
    case 32:
      dropBlock();
      break;
    default:
      break;
  } //end switch
}); //end addEventListener

restartButton.addEventListener('click', () => {
  playground.innerHTML = '';
  gameText.style.display = 'none';
  init();
});
