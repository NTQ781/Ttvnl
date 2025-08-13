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

const vocabularyData = [
    { japanese: 'こんにちは', reading: 'konnichiwa', meaning: 'Xin chào' },
    { japanese: 'ありがとう', reading: 'arigatou', meaning: 'Cảm ơn' },
    { japanese: 'すみません', reading: 'sumimasen', meaning: 'Xin lỗi' },
    { japanese: 'はじめまして', reading: 'hajimemashite', meaning: 'Rất vui được gặp bạn' },
    { japanese: 'さようなら', reading: 'sayounara', meaning: 'Tạm biệt' },
    { japanese: 'おはよう', reading: 'ohayou', meaning: 'Chào buổi sáng' },
    { japanese: 'こんばんは', reading: 'konbanwa', meaning: 'Chào buổi tối' },
    { japanese: 'おやすみ', reading: 'oyasumi', meaning: 'Chúc ngủ ngon' },
    { japanese: 'はい', reading: 'hai', meaning: 'Có/Vâng' },
    { japanese: 'いいえ', reading: 'iie', meaning: 'Không' }
];

const hiraganaOrder = [
    ['あ','い','う','え','お'],
    ['か','き','く','け','こ'],
    ['さ','し','す','せ','そ'],
    ['た','ち','つ','て','と'],
    ['な','に','ぬ','ね','の'],
    ['は','ひ','ふ','へ','ほ'],
    ['ま','み','む','め','も'],
    ['や','ゆ','よ'],
    ['ら','り','る','れ','ろ'],
    ['わ','を','ん']
];

// Thêm logic tab-switching và flashcard
document.addEventListener('DOMContentLoaded', () => {
    // Lấy dữ liệu từ vựng từ Thymeleaf (nếu có)
    const flashcards = window.vocabData || []; // vocabData được nhúng từ Thymeleaf
    let currentCardIndex = 0;
    let isFlipped = false;

    // Hàm chuyển đổi tab
    function switchTab(event) {
        const section = event.target.dataset.section;
        if (!section) return;

        // Ẩn tất cả nội dung
        document.querySelectorAll('.content-section').forEach(el => {
            el.style.display = 'none';
        });

        // Hiển thị nội dung tương ứng
        const targetSection = document.getElementById(`${section}-content`);
        if (targetSection) {
            targetSection.style.display = 'block';
        }

        // Highlight nút được chọn
        document.querySelectorAll('.study-buttons button').forEach(btn => {
            btn.classList.remove('active');
        });
        event.target.classList.add('active');

        // Nếu là flashcard, khởi tạo
        if (section === 'flashcard') {
            displayFlashcards();
        }
    }

    // Hàm hiển thị flashcard
    function displayFlashcards() {
        const flashcardContainer = document.getElementById('flashcard-content');
        if (!flashcards.length) {
            flashcardContainer.innerHTML = '<p>Chưa có flashcard.</p>';
            return;
        }

        const card = flashcards[currentCardIndex];
        flashcardContainer.innerHTML = `
            <div class="flashcard-item ${isFlipped ? 'flipped' : ''}">
                <div class="flashcard-front">${card.japanese}</div>
                <div class="flashcard-back">${card.reading} - ${card.meaning}</div>
            </div>
            <div class="flashcard-controls">
                <button onclick="prevCard()">⬅ Quay lại</button>
                <button onclick="nextCard()">▶ Tiếp theo</button>
                <button onclick="flipCard()">👁️ Lật thẻ</button>
                <button onclick="markAsKnown()">✅ Đã nhớ</button>
            </div>
        `;
    }

    // Hàm lật thẻ
    window.flipCard = function() {
        isFlipped = !isFlipped;
        displayFlashcards();
    };

    // Hàm chuyển thẻ tiếp theo
    window.nextCard = function() {
        if (currentCardIndex < flashcards.length - 1) {
            currentCardIndex++;
            isFlipped = false;
            displayFlashcards();
        }
    };

    // Hàm quay lại thẻ trước
    window.prevCard = function() {
        if (currentCardIndex > 0) {
            currentCardIndex--;
            isFlipped = false;
            displayFlashcards();
        }
    };

    // Hàm đánh dấu đã nhớ
    window.markAsKnown = function() {
        flashcards.splice(currentCardIndex, 1);
        if (currentCardIndex >= flashcards.length) {
            currentCardIndex = Math.max(0, flashcards.length - 1);
        }
        displayFlashcards();
    };

    // Gắn sự kiện cho nút study-buttons
    document.querySelectorAll('.study-buttons button').forEach(btn => {
        btn.addEventListener('click', switchTab);
    });

    // Mặc định hiển thị mục Từ vựng
    const vocabBtn = document.querySelector('.study-buttons button[data-section="vocabulary"]');
    if (vocabBtn) {
        vocabBtn.click(); // Kích hoạt mục Từ vựng khi load
    }
});

// Giữ nguyên các phần còn lại (listening, quiz, v.v.)
function displayListening() {
    const listeningContainer = document.querySelector('.listening-content');
    listeningContainer.innerHTML = listeningData.map((item, index) => `
        <div class="listening-tab-item">
            <h4>${item.title}</h4>
            <p>${item.description}</p>
            <audio controls style="width: 100%; margin-bottom: 10px;">
                <source src="${item.audio}" type="audio/mp3" />
                Trình duyệt của bạn không hỗ trợ audio.
            </audio>
            <div class="fill-toggle" data-index="${index}" style="cursor: pointer; color: #2563eb; font-weight: bold; margin-bottom: 8px;">
                🔸 Trả lời câu hỏi
            </div>
            <div class="script-toggle" data-index="${index}" style="cursor: pointer; color: green; font-weight: bold; margin-bottom: 6px;">
                📄 Bài nghe
            </div>
            <div id="script-text-${index}" style="display: none; white-space: pre-wrap; border-left: 3px solid #ccc; padding-left: 10px; margin-bottom: 12px;">
                ${item.script || "<

i>Chưa có nội dung bài nghe</i>"}
            </div>
            <div class="fill-question" id="fill-question-${index}" style="display: none;">
                ${item.questions.map((q, i) => `
                    <div style="margin-bottom: 10px;">
                        <label>${q.question}</label><br/>
                        <input type="text" placeholder="${q.placeholder}" style="width: 100%; padding: 8px; margin-top: 4px;" />
                    </div>
                `).join('')}
            </div>
        </div>
    `).join('');

    document.querySelectorAll('.fill-toggle').forEach(el => {
        el.addEventListener('click', () => {
            const index = el.getAttribute('data-index');
            const target = document.getElementById(`fill-question-${index}`);
            target.style.display = (target.style.display === 'none') ? 'block' : 'none';
        });
    });

    document.querySelectorAll('.script-toggle').forEach(el => {
        el.addEventListener('click', () => {
            const index = el.getAttribute('data-index');
            const target = document.getElementById(`script-text-${index}`);
            target.style.display = (target.style.display === 'none') ? 'block' : 'none';
        });
    });
}
