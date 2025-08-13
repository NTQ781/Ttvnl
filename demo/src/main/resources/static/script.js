// Data for Hiragana characters
const hiraganaData = {
    'あ': 'a', 'い': 'i', 'う': 'u', 'え': 'e', 'お': 'o',
    'か': 'ka', 'き': 'ki', 'く': 'ku', 'け': 'ke', 'こ': 'ko',
    'さ': 'sa', 'し': 'shi', 'す': 'su', 'せ': 'se', 'そ': 'so',
    'た': 'ta', 'ち': 'chi', 'つ': 'tsu', 'て': 'te', 'と': 'to',
    'な': 'na', 'に': 'ni', 'ぬ': 'nu', 'ね': 'ne', 'の': 'no',
    'は': 'ha', 'ひ': 'hi', 'ふ': 'fu', 'へ': 'he', 'ほ': 'ho',
    'ま': 'ma', 'み': 'mi', 'む': 'mu', 'め': 'me', 'も': 'mo',
    'や': 'ya', 'ゆ': 'yu', 'よ': 'yo',
    'ら': 'ra', 'り': 'ri', 'る': 'ru', 'れ': 're', 'ろ': 'ro',
    'わ': 'wa', 'を': 'wo', 'ん': 'n'
};

// Data for Katakana characters
const katakanaData = {
    'ア': 'a', 'イ': 'i', 'ウ': 'u', 'エ': 'e', 'オ': 'o',
    'カ': 'ka', 'キ': 'ki', 'ク': 'ku', 'ケ': 'ke', 'コ': 'ko',
    'サ': 'sa', 'シ': 'shi', 'ス': 'su', 'セ': 'se', 'ソ': 'so',
    'タ': 'ta', 'チ': 'chi', 'ツ': 'tsu', 'テ': 'te', 'ト': 'to',
    'ナ': 'na', 'ニ': 'ni', 'ヌ': 'nu', 'ネ': 'ne', 'ノ': 'no',
    'ハ': 'ha', 'ヒ': 'hi', 'フ': 'fu', 'ヘ': 'he', 'ホ': 'ho',
    'マ': 'ma', 'ミ': 'mi', 'ム': 'mu', 'メ': 'me', 'モ': 'mo',
    'ヤ': 'ya', 'ユ': 'yu', 'ヨ': 'yo',
    'ラ': 'ra', 'リ': 'ri', 'ル': 'ru', 'レ': 're', 'ロ': 'ro',
    'ワ': 'wa', 'ヲ': 'wo', 'ン': 'n'
};

// Vocabulary data (NGUYÊN BẢN – không chỉnh)
const vocabularyData = [
    { japanese: 'こんにちは', reading: 'konnichiwa', meaning: 'Xin chào' },
    { japanese: 'ありがとう', reading: 'arigatou', meaning: 'Cảm ơn' },
    { japanese: 'すみません', reading: 'sumimasen', meaning: 'Xin lỗi' },
    { japanese: 'がくせい', reading: 'gakusei', meaning: 'Sinh viên' }
];

// Order for Hiragana and Katakana
const hiraganaOrder = ['あ', 'い', 'う', 'え', 'お', 'か', 'き', 'く', 'け', 'こ', 'さ', 'し', 'す', 'せ', 'そ', 'た', 'ち', 'つ', 'て', 'と', 'な', 'に', 'ぬ', 'ね', 'の', 'は', 'ひ', 'ふ', 'へ', 'ほ', 'ま', 'み', 'む', 'め', 'も', 'や', 'ゆ', 'よ', 'ら', 'り', 'る', 'れ', 'ろ', 'わ', 'を', 'ん'];
const katakanaOrder = ['ア', 'イ', 'ウ', 'エ', 'オ', 'カ', 'キ', 'ク', 'ケ', 'コ', 'サ', 'シ', 'ス', 'セ', 'ソ', 'タ', 'チ', 'ツ', 'テ', 'ト', 'ナ', 'ニ', 'ヌ', 'ネ', 'ノ', 'ハ', 'ヒ', 'フ', 'ヘ', 'ホ', 'マ', 'ミ', 'ム', 'メ', 'モ', 'ヤ', 'ユ', 'ヨ', 'ラ', 'リ', 'ル', 'レ', 'ロ', 'ワ', 'ヲ', 'ン'];

let currentSection = 'vocab'; // Mặc định hiển thị Từ vựng
let currentFlashcardIndex = 0;

window.onload = () => {
    showSection(currentSection); // Hiển thị section mặc định khi load
    document.querySelectorAll('.study-buttons .btn-vocab, .nav-menu .nav-btn:nth-child(1)').forEach(btn => {
        btn.addEventListener('click', () => showSection('vocab'));
    });
    document.querySelectorAll('.study-buttons .btn-kanji, .nav-menu .nav-btn:nth-child(2)').forEach(btn => {
        btn.addEventListener('click', () => showSection('kanji'));
    });
    document.querySelectorAll('.study-buttons .btn-grammar, .nav-menu .nav-btn:nth-child(3)').forEach(btn => {
        btn.addEventListener('click', () => showSection('grammar'));
    });
    document.querySelectorAll('.study-buttons .btn-exercise, .nav-menu .nav-btn:nth-child(4)').forEach(btn => {
        btn.addEventListener('click', () => showSection('exercise'));
    });
    document.querySelectorAll('.study-buttons .btn-flashcard, .nav-menu .nav-btn:nth-child(5)').forEach(btn => {
        btn.addEventListener('click', () => showSection('flashcard'));
    });

    // Gắn sự kiện cho bảng chữ cái (nếu cần)
    document.querySelectorAll('.char-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const char = btn.textContent;
            alert(`Bạn đã chọn: ${char} - ${hiraganaData[char] || katakanaData[char] || 'Không có phát âm'}`);
        });
    });
};

function showSection(section) {
    document.querySelectorAll('.card').forEach(card => card.style.display = 'none');
    currentSection = section;

    if (section === 'vocab') {
        document.getElementById('vocab-section').style.display = 'block';
    } else if (section === 'kanji') {
        document.getElementById('kanji-section').style.display = 'block';
    } else if (section === 'grammar') {
        document.getElementById('grammar-section').style.display = 'block';
    } else if (section === 'exercise') {
        document.getElementById('exercise-section').style.display = 'block';
    } else if (section === 'flashcard') {
        document.getElementById('flashcard-section').style.display = 'block';
        updateFlashcard();
    }

    document.querySelectorAll('.nav-btn').forEach(btn => btn.classList.remove('active'));
    document.querySelector(`.nav-menu .nav-btn:nth-child(${['vocab', 'kanji', 'grammar', 'exercise', 'flashcard'].indexOf(section) + 1})`)?.classList.add('active');
    document.querySelectorAll('.study-buttons button').forEach(btn => btn.classList.remove('active'));
    document.querySelector(`.study-buttons .btn-${section}`)?.classList.add('active');
}

function toggleFlashcard() {
    const card = document.getElementById('flashcard-inner');
    if (card) card.classList.toggle('flipped');
}

function updateFlashcard() {
    const vocabList = document.querySelectorAll('#vocab-section tbody tr');
    if (vocabList.length > 0 && document.getElementById('flashcard-section').style.display !== 'none') {
        const index = currentFlashcardIndex % vocabList.length;
        const row = vocabList[index];
        const front = row.cells[1].textContent;
        const back = row.cells[2].textContent;
        const frontElement = document.getElementById('flashcard-front');
        const backElement = document.getElementById('flashcard-back');
        if (frontElement && backElement) {
            frontElement.textContent = front;
            backElement.textContent = back;
        }
    }
    const card = document.getElementById('flashcard-inner');
    if (card) card.classList.remove('flipped');
}

function prevFlashcard() {
    const vocabList = document.querySelectorAll('#vocab-section tbody tr');
    if (vocabList.length > 0) {
        currentFlashcardIndex = (currentFlashcardIndex > 0) ? currentFlashcardIndex - 1 : vocabList.length - 1;
        updateFlashcard();
    }
}

function nextFlashcard() {
    const vocabList = document.querySelectorAll('#vocab-section tbody tr');
    if (vocabList.length > 0) {
        currentFlashcardIndex = (currentFlashcardIndex < vocabList.length - 1) ? currentFlashcardIndex + 1 : 0;
        updateFlashcard();
    }
}

function markRemembered() {
    alert('Đã đánh dấu từ vựng này là đã nhớ!');
}

// Các hàm từ file của bạn (dành cho bảng chữ cái và quiz, tạm thời để nguyên)
// Chưa tích hợp hoàn toàn vì cần điều chỉnh cho dữ liệu động
function showAlphabet(type) {
    const grid = document.getElementById('alphabet-grid');
    grid.innerHTML = '';
    const data = type === 'hiragana' ? hiraganaData : katakanaData;
    const order = type === 'hiragana' ? hiraganaOrder : katakanaOrder;

    order.forEach((char, index) => {
        const btn = document.createElement('button');
        btn.className = 'char-btn';
        btn.textContent = char;
        grid.appendChild(btn);

        if ([24, 30, 35].includes(index)) { // Rows with gaps (や, わ, ん)
            const empty = document.createElement('div');
            empty.className = 'char-empty';
            grid.appendChild(empty);
        }
    });

    grid.classList.add('alphabet-rows');
}

function generateQuiz() {
    const quizContainer = document.getElementById('quiz-container');
    if (!quizContainer) return;

    const data = currentSection === 'hiragana' ? hiraganaData : katakanaData;
    const keys = Object.keys(data);
    const randomKeys = keys.sort(() => Math.random() - 0.5).slice(0, 5);

    quizContainer.innerHTML = randomKeys.map((key, index) => `
        <div class="quiz-item" data-index="${index}">
            <p>${key}</p>
            <div class="quiz-options">
                ${[data[key], ...keys.filter(k => k !== key).sort(() => Math.random() - 0.5).slice(0, 2)].sort(() => Math.random() - 0.5).map(opt => `
                    <div class="quiz-option" onclick="checkAnswer(${index}, '${opt}')">${opt}</div>
                `).join('')}
            </div>
        </div>
    `).join('');

    document.querySelectorAll('.quiz-option').forEach(option => {
        option.addEventListener('click', () => {
            const item = option.closest('.quiz-item');
            const index = item.getAttribute('data-index');
            checkAnswer(index, option.textContent);
        });
    });
}

function checkAnswer(index, selected) {
    const correct = Object.keys(currentSection === 'hiragana' ? hiraganaData : katakanaData)[index];
    const options = document.querySelectorAll(`.quiz-item[data-index="${index}"] .quiz-option`);
    options.forEach(opt => {
        opt.classList.remove('correct', 'wrong');
        if (opt.textContent === (currentSection === 'hiragana' ? hiraganaData[correct] : katakanaData[correct])) {
            opt.classList.add('correct');
        } else if (opt.textContent === selected && selected !== (currentSection === 'hiragana' ? hiraganaData[correct] : katakanaData[correct])) {
            opt.classList.add('wrong');
        }
    });
}
