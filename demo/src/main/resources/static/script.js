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

document.addEventListener('DOMContentLoaded', () => {
    console.log("DOM loaded");

    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');

    // Đăng nhập
    window.login = function () {
        const username = usernameInput.value.trim();
        const password = passwordInput.value.trim();

        if (username && password) {
            localStorage.setItem("currentUser", username);
            window.location.href = "/main";
        } else {
            document.getElementById('auth-message').textContent = "Vui lòng nhập tài khoản và mật khẩu!";
        }
    };

    // Đăng ký (giả lập)
    window.register = function () {
        if (usernameInput.value && passwordInput.value) {
            document.getElementById('auth-message').textContent = "Đăng ký thành công! Vui lòng đăng nhập.";
        } else {
            document.getElementById('auth-message').textContent = "Vui lòng nhập tài khoản và mật khẩu!";
        }
    };

    // Quên mật khẩu
    window.showResetPassword = function () {
        document.getElementById('reset-password-section').style.display = 'block';
    };

    // Đặt lại mật khẩu
    window.resetPassword = function () {
        const newPass = document.getElementById('new-password').value;
        if (newPass) {
            document.getElementById('auth-message').textContent = "Mật khẩu đã được đặt lại!";
            document.getElementById('reset-password-section').style.display = 'none';
        } else {
            document.getElementById('auth-message').textContent = "Vui lòng nhập mật khẩu mới!";
        }
    };

    // Nếu đang ở trang main.html → Hiển thị user và gắn sự kiện cho N1–N5
    if (document.querySelector('#user-info')) {
        const currentUser = localStorage.getItem("currentUser") || "";
        if (!currentUser) {
            window.location.href = "/";
            return;
        }
        document.getElementById('current-user').textContent = currentUser;

    }

    // Đăng xuất
    window.logout = function () {
        localStorage.removeItem("currentUser");
        window.location.href = "/";
    };
});

