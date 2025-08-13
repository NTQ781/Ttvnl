
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
    { japanese: 'はじめまして', reading: 'hajimemashite', meaning: 'Rất vui được gặp bạn' },
    { japanese: 'さようなら', reading: 'sayounara', meaning: 'Tạm biệt' },
    { japanese: 'おはよう', reading: 'ohayou', meaning: 'Chào buổi sáng' },
    { japanese: 'こんばんは', reading: 'konbanwa', meaning: 'Chào buổi tối' },
    { japanese: 'おやすみ', reading: 'oyasumi', meaning: 'Chúc ngủ ngon' },
    { japanese: 'はい', reading: 'hai', meaning: 'Có/Vâng' },
    { japanese: 'いいえ', reading: 'iie', meaning: 'Không' }
];

// ===== Thứ tự chuẩn bảng chữ cái (5 cột) =====
const hiraganaOrder = [
    ['あ','い','う','え','お'],
    ['か','き','く','け','こ'],
    ['さ','し','す','せ','そ'],
    ['た','ち','つ','て','と'],
    ['な','に','ぬ','ね','の'],
    ['は','ひ','ふ','へ','ほ'],
    ['ま','み','む','め','も'],
    ['や','','ゆ','','よ'],
    ['ら','り','る','れ','ろ'],
    ['わ','','を','','ん'],
];

const katakanaOrder = [
    ['ア','イ','ウ','エ','オ'],
    ['カ','キ','ク','ケ','コ'],
    ['サ','シ','ス','セ','ソ'],
    ['タ','チ','ツ','テ','ト'],
    ['ナ','ニ','ヌ','ネ','ノ'],
    ['ハ','ヒ','フ','ヘ','ホ'],
    ['マ','ミ','ム','メ','モ'],
    ['ヤ','','ユ','','ヨ'],
    ['ラ','リ','ル','レ','ロ'],
    ['ワ','','ヲ','','ン'],
];

// ===== Trạng thái =====
let currentData = hiraganaData;
let currentSection = 'hiragana';
let currentQuiz = null;
let quizScore = 0;
let totalQuestions = 0;

const USERS_KEY = 'nihongo_users';
const CURRENT_USER_KEY = 'nihongo_current_user';
function showResetPassword() {
  const username = document.getElementById('username').value.trim();
  const users = JSON.parse(localStorage.getItem(USERS_KEY) || '{}');

  if (!username) {
    return showAuthMessage('Vui lòng nhập tài khoản cần đặt lại mật khẩu');
  }

  if (users[username]) {
    document.getElementById('reset-password-section').style.display = 'block';
    showAuthMessage('Nhập mật khẩu mới cho tài khoản "' + username + '"', 'green');
  } else {
    showAuthMessage('Tài khoản không tồn tại', 'red');
  }
}

function resetPassword() {
  const username = document.getElementById('username').value.trim();
  const newPassword = document.getElementById('new-password').value.trim();
  const users = JSON.parse(localStorage.getItem(USERS_KEY) || '{}');

  if (!newPassword) {
    return showAuthMessage('Vui lòng nhập mật khẩu mới');
  }

  users[username] = newPassword;
  localStorage.setItem(USERS_KEY, JSON.stringify(users));
  document.getElementById('reset-password-section').style.display = 'none';
  document.getElementById('new-password').value = '';
  showAuthMessage('✅ Đặt lại mật khẩu thành công! Hãy đăng nhập.', 'green');
}

function register() {
  const username = document.getElementById('username').value.trim();
  const password = document.getElementById('password').value.trim();
  const users = JSON.parse(localStorage.getItem(USERS_KEY) || '{}');

  if (!username || !password) return showAuthMessage('Vui lòng nhập đủ thông tin');
  if (users[username]) return showAuthMessage('Tài khoản đã tồn tại');

  users[username] = password;
  localStorage.setItem(USERS_KEY, JSON.stringify(users));
  showAuthMessage('Tạo tài khoản thành công. Hãy đăng nhập!', 'green');
}

function login() {
  const username = document.getElementById('username').value.trim();
  const password = document.getElementById('password').value.trim();
  const users = JSON.parse(localStorage.getItem(USERS_KEY) || '{}');

  if (users[username] === password) {
    localStorage.setItem(CURRENT_USER_KEY, username);
    location.reload();
  } else {
    showAuthMessage('Sai tài khoản hoặc mật khẩu');
  }
}

function logout() {
  localStorage.removeItem(CURRENT_USER_KEY);
  location.reload();
}

function showAuthMessage(msg, color = 'red') {
  const box = document.getElementById('auth-message');
  box.style.color = color;
  box.textContent = msg;
}

window.onload = () => {
  const user = localStorage.getItem(CURRENT_USER_KEY);
  if (user) {
    document.getElementById('auth-container').style.display = 'none';
    document.querySelector('.container').style.display = 'block';
    document.getElementById('user-info').style.display = 'block';
    document.getElementById('current-user').textContent = user;
    generateVocabulary();
    generateQuiz();
  } else {
    document.getElementById('auth-container').style.display = 'block';
    document.querySelector('.container').style.display = 'none';
  }
};


// ===== Hiển thị Section =====

function showSection(section, btnEl) {
  // Xoá class active khỏi tất cả nút
  document.querySelectorAll('.nav-btn').forEach(btn => btn.classList.remove('active'));
  if (btnEl) btnEl.classList.add('active');

  currentSection = section;

  // Ẩn tất cả các section
  document.getElementById('alphabet-section').style.display = 'none';
  document.getElementById('vocab-section').style.display = 'none';
  document.getElementById('quiz-section').style.display = 'none';
  document.getElementById('reading-section').style.display = 'none'; // 🛠️ THÊM DÒNG NÀY
  document.getElementById('listening-section').style.display = 'none'; // Ẩn phần nghe hiểu


  // Hiện đúng section được yêu cầu
  if (section === 'hiragana') {
    currentData = hiraganaData;
    document.getElementById('alphabet-title').textContent = 'Bảng chữ cái Hiragana';
    document.getElementById('alphabet-section').style.display = 'block';
    generateAlphabet();
  } else if (section === 'katakana') {
    currentData = katakanaData;
    document.getElementById('alphabet-title').textContent = 'Bảng chữ cái Katakana';
    document.getElementById('alphabet-section').style.display = 'block';
    generateAlphabet();
  } else if (section === 'vocab') {
    document.getElementById('vocab-section').style.display = 'block';
  } else if (section === 'quiz') {
    document.getElementById('quiz-section').style.display = 'block';
    generateQuiz();
  } else if (section === 'reading') {
    document.getElementById('reading-section').style.display = 'block';
    renderReadingList();
  }
  else if (section === 'listening') {
  document.getElementById('listening-section').style.display = 'block';
  renderListeningList();
}

}


// ===== Generate Alphabet Grid (theo thứ tự chuẩn) =====
function generateAlphabet() {
    const grid = document.getElementById('alphabet-grid');
    grid.innerHTML = '';

    // Thêm class để áp dụng style hàng
    grid.classList.add('alphabet-rows');

    // Chọn mảng order theo section
    const order = (currentSection === 'hiragana') ? hiraganaOrder : katakanaOrder;

    order.forEach(row => {
        const rowDiv = document.createElement('div');
        rowDiv.className = 'alpha-row';

        row.forEach(char => {
            if (char && currentData[char]) {
                const button = document.createElement('button');
                button.className = 'char-btn';
                button.textContent = char;
                button.onclick = () => selectCharacter(char, button);
                rowDiv.appendChild(button);
            } else {
                const empty = document.createElement('div');
                empty.className = 'char-empty';
                rowDiv.appendChild(empty);
            }
        });

        grid.appendChild(rowDiv);
    });

    // Đặt lại hộp phát âm về placeholder
    const pronunciation = document.getElementById('pronunciation');
    pronunciation.innerHTML = `
        <h3>Phát âm</h3>
        <p>Chọn một ký tự để nghe phát âm</p>
    `;
}

// ===== Chọn ký tự & phát âm =====
function selectCharacter(char, button) {
    // Remove previous selection (chỉ trong bảng)
    document.querySelectorAll('#alphabet-grid .char-btn').forEach(btn => btn.classList.remove('selected'));
    button.classList.add('selected');

    // Show pronunciation
    const pronunciation = document.getElementById('pronunciation');
    pronunciation.innerHTML = `
        <h3>Phát âm</h3>
        <p>${char} → ${currentData[char]}</p>
    `;

    // Play audio từ thư mục tương ứng
    const folder = (currentSection === 'hiragana') ? 'hiragana' : 'katakana';
    const audioFile = `audio/${folder}/${currentData[char]}.mp3`;
    const audio = new Audio(audioFile);
    audio.play().catch(err => {
        console.warn(`Không phát được audio: ${audioFile}`, err);
        pronunciation.innerHTML += `<div style="margin-top:8px;color:#d00;font-size:0.9rem;">Không tìm thấy file âm thanh (${audioFile}).</div>`;
    });
}

// ======= (GIỮ NGUYÊN) Generate vocabulary list =======
function generateVocabulary() {
    const vocabList = document.getElementById('vocab-list');
    vocabList.innerHTML = '';
    
    vocabularyData.forEach(item => {
        const vocabItem = document.createElement('div');
        vocabItem.className = 'vocab-item';
        vocabItem.innerHTML = `
            <div class="vocab-japanese">${item.japanese}</div>
            <div class="vocab-reading">${item.reading}</div>
            <div class="vocab-meaning">${item.meaning}</div>
        `;
        vocabList.appendChild(vocabItem);
    });
}

//


//

//
function showStudy(level, type) {
  const content = levelContent[level][type];
  const titleMap = { vocab: 'Từ vựng', kanji: 'Kanji', grammar: 'Ngữ pháp' };

  document.getElementById('study-display').innerHTML = `
    <h3>${titleMap[type]} cấp độ ${level.toUpperCase()}</h3>
    <ul>${content.map(item => `<li>${item}</li>`).join('')}</ul>
  `;
}
function toggleLevelContent(level) {
  const content = document.getElementById(`${level}-content`);
  if (content.style.display === 'none') {
    content.style.display = 'block';
  } else {
    content.style.display = 'none';
  }
}
function flipCard(card) {
    card.classList.toggle("flipped");
}
// ======= (GIỮ NGUYÊN) Render Reading List =======
function renderReadingList() {
  const readings = [
    {
      title: "Bài 1: Cuộc sống hàng ngày - 日常生活",
      content: "わたしは まいにち 6じに おきます。そして、7じに あさごはんを たべます。",
      translation: "Tôi dậy lúc 6 giờ mỗi sáng và ăn sáng lúc 7 giờ.",
      questions: [
        { q: "わたしは 何時に おきますか？", a: "6時に起きます。", t: "Tôi thức dậy lúc 6 giờ." },
        { q: "あさごはんを たべるのは 何時ですか？", a: "7時に朝ごはんを食べます。", t: "Ăn sáng lúc 7 giờ." }
      ]
    },

    {
      title:"Bài 2: Cuối tuần của tôi - 私の週末",
      content:"現在、私は会社員をしています。どようびと にちようびに、わたしは ともだちと あそびます。えいがを みたり、こうえんで さんぽしたり します。",
      translation:"Hiện tại, tôi đang là một nhân viên văn phòng. Thứ 7 và chủ nhật, tôi cùng bạn đi chơi. Chúng tôi cùng xem phim, đi dạo trong công viên",
      questions:[
        {q:"どんなことを しますか？",a: "かいしゃいんです",t:"Nhân viên văn phòng"},
        {q:"どようびと にちようびに 何を しますか？",a:"えいがを みたり、こうえんで さんぽしたり します。",t:"Chúng tôi cùng xem phim, đi dạo trong công viên"}
      ]
    },
    {
      title:"Bài 3: Mua sắm -  買い物",
      content:"スーパーに行く前に、私はメモを作ります。今日は牛乳と卵とパンを買います。でも、スーパーに行ったとき、チョコレートも買ってしまいました。",
      translation:"Trước khi đi siêu thị, tôi ghi chú: Hôm nay tôi sẽ mua sữa, trứng và bánh mì. Nhưng khi đi siêu thị, tôi cũng mua một ít sô cô la.",
      questions:[
        {q:"メモに書いてあったものは何ですか？",a:"今日は牛乳と卵とパンを買います。でも、スーパーに行ったとき",t:"Hôm nay tôi sẽ mua sữa, trứng và bánh mì"},
        {q:"チョコレートはメモにありましたか？",a:"チョコレートはメモにありましたか？",t:"メモにはチョコレートはありません"}
      ]
    },
    {
      title:"Bài 4: Thời tiết - 天気",
      content:"昨日は朝から雨でした。午後になると、風も強くなりました。だから、友だちとの約束をキャンセルしました。",
      translation:"Hôm qua trời mưa từ sáng. Chiều gió mạnh hơn nên tôi phải hủy bỏ kế hoạch đi chơi với bạn.",
      questions:[
        {q:"昨日はどんな天気でしたか？",a:"昨日は朝から雨でした。午後になると、風も強くなりました。",t:"Hôm qua trời mưa từ sáng. Chiều gió mạnh hơn"},
        {q:"どうして友だちに会いませんでしたか？",a:"雨が降ったため、午後は風が強くなりました。",t:"Vì trời mưa, chiều thì gió mạnh hơn "}
      ]
    },
    {
      title:"Bài 5: Con chó của Tanaka -  田中さんの犬",
      content:"田中さんの家には白くて小さい犬がいます。その犬の名前は「しろ」です。毎日、田中さんと一緒に散歩します。",
      translation:"Tanaka-san có một chú chó nhỏ màu trắng. Tên của nó là Shiro. Nó đi dạo cùng Tanaka-san mỗi ngày.",
      questions:[
        {q:"犬の名前は何ですか？",a:"その犬の名前は「しろ」です。",t:"Tên của nó là Shiro."},
        {q:"田中さんは毎日犬と何をしますか？",a:"毎日、田中さんと一緒に散歩します。",t:"Nó đi dạo cùng Tanaka-san mỗi ngày."}
      ]
    },
    {
      title:"Bài 6: 4 mùa của Nhật Bản - 日本の四季 ",
      content:"日本には春、夏、秋、冬の四つの季節があります。春は桜が咲いて、とてもきれいです。夏は暑いですが、海や花火大会を楽しめます。秋は涼しくて、山や公園の木が赤や黄色になります。冬は雪が降る地域もあり、スキーや温泉が人気です。季節によって、いろいろな楽しみ方があります。",
      translation:"Nhật Bản có bốn mùa: xuân, hạ, thu, đông. Mùa xuân, hoa anh đào nở rộ, đẹp tuyệt vời. Mùa hè nóng nực nhưng bạn vẫn có thể tận hưởng bãi biển và lễ hội pháo hoa. Mùa thu mát mẻ, cây cối trên núi và công viên chuyển sang màu đỏ vàng. Mùa đông, tuyết rơi ở một số khu vực, và trượt tuyết cùng suối nước nóng là những hoạt động được ưa chuộng. Có rất nhiều cách để tận hưởng mỗi mùa.",
      questions:[
        {q:"春にはどんな花が咲きますか？",a:"春は桜が咲いて、とてもきれいです",t:"Mùa xuân, hoa anh đào nở rộ, đẹp tuyệt vời."},
        {q:"冬はなぜ人気がありますか？",a:"スキーや温泉が人気です",t:"trượt tuyết cùng suối nước nóng là những hoạt động đục ưa chuộng"}
      ]
    },
    {
      title:"Bài 7: Chuyến đi đầu tiên đến Nhật Bản - 初めての日本旅行",
      content:"去年の夏、私は初めて日本へ旅行しました。東京や京都、大阪などをまわりました。東京では高いビルやにぎやかな街を見て、京都ではお寺や神社を訪れました。大阪ではお好み焼きやたこ焼きを食べました。日本の人たちはとても親切で、道に迷ったときも丁寧に教えてくれました。また日本に行きたいと思っています。",
      translation:"Hè năm ngoái, tôi đi du lịch Nhật Bản lần đầu tiên. Tôi đã đi vòng quanh Tokyo, Kyoto, Osaka và nhiều thành phố khác. Ở Tokyo, tôi được chiêm ngưỡng những tòa nhà cao tầng và những con phố nhộn nhịp, còn ở Kyoto, tôi được ghé thăm các đền chùa. Ở Osaka, tôi được thưởng thức okonomiyaki và takoyaki. Người Nhật rất tốt bụng, họ đã kiên nhẫn giúp đỡ tôi khi tôi bị lạc. Tôi rất muốn quay lại Nhật Bản.",
      questions:[
        {q:"大阪で何をしましたか？",a:"大阪ではお好み焼きやたこ焼きを食べました",t:"Ở Osaka, tôi đã ăn okonomiyaki và takoyaki."},
        {q:"日本の人たちはどうでしたか？",a:"日本の人たちはとても親切で、道に迷ったときも丁寧に教えてくれました",t:"Người Nhật rất tốt bụng, họ đã kiên nhẫn giúp đỡ tôi khi tôi bị lạc. "}
      ]
    },
    {
      title:"Bài 8: Bạn làm gì cho sức khỏe của mình - 健康のためにしていること",
      content:"私は健康のために毎朝ジョギングをしています。最初は10分しか走れませんでしたが、今は30分ぐらい走れるようになりました。また、毎日野菜をたくさん食べるようにしています。たまに甘いものも食べますが、食べすぎないように気をつけています。健康な体は、毎日の小さな努力から作られると思います。",
      translation:"Tôi chạy bộ mỗi sáng để giữ gìn sức khỏe. Ban đầu, tôi chỉ chạy được 10 phút, nhưng giờ tôi có thể chạy được khoảng 30 phút. Tôi cũng cố gắng ăn nhiều rau mỗi ngày. Thỉnh thoảng tôi cũng ăn đồ ngọt, nhưng cố gắng không ăn quá nhiều. Tôi tin rằng một cơ thể khỏe mạnh được xây dựng từ những nỗ lực nhỏ mỗi ngày.",
      questions:[
        {q:"ジョギングはどれくらいできるようになりましたか？",a:"最初は10分しか走れませんでしたが、今は30分ぐらい走れるようになりました。",t:"Ban đầu, tôi chỉ chạy được 10 phút, nhưng giờ tôi có thể chạy được khoảng 30 phút"},
        {q:"この人は健康のために何をしていますか？",a:"私は健康のために毎朝ジョギングをしています。毎日野菜をたくさん食べるようにしています。",t:"Tôi chạy bộ mỗi sáng để giữ gìn sức khỏe. Tôi cố gắng ăn nhiều rau mỗi ngày."}
      ]
    },
    {
      title:"Bài 9: Cuộc sống của sinh viên quốc tế - 留学生の生活",
      content:"私はベトナムから来た留学生です。今、日本の大学で経済を勉強しています。最初は日本語が難しくて、授業についていくのが大変でした。でも、毎日少しずつ勉強して、先生や友だちにもたくさん助けてもらいました。今では、日本での生活にも慣れて、アルバイトも始めました。将来は日本の会社で働きたいと思っています。",
      translation:"Tôi là du học sinh đến từ Việt Nam. Hiện tôi đang theo học ngành kinh tế tại một trường đại học Nhật Bản. Ban đầu, tiếng Nhật khá khó và tôi gặp khó khăn trong việc theo kịp các bài giảng. Tuy nhiên, tôi đã cố gắng học mỗi ngày và nhận được rất nhiều sự giúp đỡ từ thầy cô và bạn bè. Hiện tại, tôi đã quen với cuộc sống ở Nhật và bắt đầu đi làm thêm. Trong tương lai, tôi muốn làm việc cho một công ty Nhật Bản.",
      questions:[
        {q:"最初に何が大変でしたか？",a:"最初は日本語が難しくて、授業についていくのが大変でした。",t:" Ban đầu, tiếng Nhật khá khó và tôi gặp khó khăn trong việc theo kịp các bài giảng."},
        {q:"今はどんな生活をしていますか？",a:"今では、日本での生活にも慣れて、アルバイトも始めました。",t:"Hiện tại, tôi đã quen với cuộc sống ở Nhật và bắt đầu đi làm thêm."}
      ]
    },
     {
      title:"Bài 10: Ngày khó quên - 忘れられない日",
      content:"先月のある日、私は大学へ行く途中で財布を落としてしまいました。気がついたときには、もうバスの中でした。とても困って、すぐにバスを降りて元の道を戻りました。しかし、どこにも財布は見つかりませんでした。その日は大切なテストがあったのに、試験のことも忘れるくらい心配していました。仕方なく大学へ行ったら、受付で「これ、あなたのですか？」と言われて、なんと誰かが私の財布を届けてくれていたのです。中身も何もなくなっていませんでした。親切な人がいるんだなと、本当に感動しました。その日から、私も困っている人を助けるように心がけています。",
      translation:"Một ngày nọ trong tháng trước, trên đường đến trường đại học, tôi đã làm rơi ví. Khi nhận ra thì tôi đã ở trên xe buýt. Tôi rất lo lắng, lập tức xuống xe và quay lại con đường đã đi. Tuy nhiên, tôi không tìm thấy ví ở đâu cả. Hôm đó tôi có một bài kiểm tra quan trọng, nhưng tôi lo lắng đến mức quên cả việc thi cử. Không còn cách nào khác, tôi đành đến trường, và tại quầy tiếp tân, một người hỏi: “Đây có phải ví của bạn không?” Thật bất ngờ, ai đó đã nhặt và mang ví đến giao lại. Mọi thứ trong ví vẫn còn nguyên vẹn. Tôi thực sự xúc động vì lòng tốt của người đó. Kể từ hôm ấy, tôi luôn cố gắng giúp đỡ những người gặp khó khăn.",
      questions:[
        {q:"財布が見つからなかったとき、この人はどんな気持ちでしたか？",a:"心配です",t:"lo lắng"},
        {q:"あなたなら、このような経験のあとで何を考えますか？",a:"もっと注意して、同じような困難な状況にある他の人を助けるように自分自身に言い聞かせてください。",t:"Nhắc nhở bản thân cẩn thận hơn và giúp đỡ người khác trong những hoàn cảnh khó khăn tương tự"}
      ]
    }
  
  ];

  const container = document.getElementById('reading-list');
  container.innerHTML = readings.map((item, index) => `
    <div class="vocab-item">
      <h4 class="reading-title" data-index="${index}" style="cursor: pointer; color: #1d4ed8;">
        ${item.title}
      </h4>
      <div class="reading-content" id="reading-content-${index}" style="display: none;">
        <p style="font-size: 1.2rem; line-height: 1.6;">${item.content}</p>

        <div class="reading-questions" style="margin-top: 10px;">
          <strong>❓ Câu hỏi:</strong>
          <ul>
            ${item.questions.map((qObj, qIndex) => `
              <li class="question-toggle" data-index="${index}" data-q="${qIndex}" style="cursor: pointer; margin-bottom: 6px;">
                🔹 ${qObj.q}
                <div id="answer-${index}-${qIndex}" style="display: none; margin-top: 6px; padding-left: 10px;">
                  <div><strong>✅ Đáp án:</strong> ${qObj.a}</div>
                  <div><strong>📖 Dịch:</strong> ${qObj.t}</div>
                </div>
              </li>
            `).join('')}
          </ul>
        </div>

        <div class="reading-translation" style="margin-top: 12px;">
          <strong class="translation-toggle" data-index="${index}" style="cursor: pointer; color: green;">📘 Bài dịch</strong>
          <div id="translation-${index}" style="display: none; margin-top: 6px; padding-left: 10px;">
            ${item.translation}
          </div>
        </div>
      </div>
    </div>
  `).join('');

  // Hiện/ẩn nội dung bài khi click tiêu đề
  document.querySelectorAll('.reading-title').forEach(titleEl => {
    titleEl.addEventListener('click', () => {
      const idx = titleEl.getAttribute('data-index');
      const contentEl = document.getElementById(`reading-content-${idx}`);
      contentEl.style.display = (contentEl.style.display === 'none') ? 'block' : 'none';
    });
  });

  // Hiện/ẩn câu trả lời
  document.querySelectorAll('.question-toggle').forEach(el => {
    el.addEventListener('click', () => {
      const index = el.getAttribute('data-index');
      const q = el.getAttribute('data-q');
      const ansEl = document.getElementById(`answer-${index}-${q}`);
      ansEl.style.display = (ansEl.style.display === 'none') ? 'block' : 'none';
    });
  });

  // Hiện/ẩn bản dịch khi click "📘 Bài dịch"
  document.querySelectorAll('.translation-toggle').forEach(el => {
    el.addEventListener('click', () => {
      const index = el.getAttribute('data-index');
      const transEl = document.getElementById(`translation-${index}`);
      transEl.style.display = (transEl.style.display === 'none') ? 'block' : 'none';
    });
  });
}
function renderListeningList() {
  const listenings = [
    {
      title: "第13課 問題 1 - Mondai 1",
      audio: "audio/listening/mondai13-1.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script: "1: あなたは　サントスさんですか？\n2: おなまえは？\n3: なんさいですか？\n4: アメリカ人ですか？\n5:かいしゃいんですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "3.", placeholder: "......" },
        { question: "4.", placeholder: "......" },
        { question: "5.", placeholder: "......" },
      ]
    },
    {
      title: "第13課 問題 3 - Mondai 1",
      audio: "audio/listening/mondai13-2.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script: "1: お国はどちらですか？\n2:うちはどちらですか？\n3:あなたのとけいはどこのとけいですか？\n4:あなたのカメラは日本のですか？\n5:あなたのカメラはいくらですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },

      ]
    },
    {
      title: "第13課 問題 2 - Mondai 1",
      audio: "audio/listening/mondai13-3.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:　これは　てちょううですか？\n2:これは　'あ'ですか　'お'ですか？\n3：これは　なんですか？\n4:これは　なんの　ざっしですか？\n5:このかばんはあなたのですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }    
      ]
    },
    {
      title: "第13課 問題 4 - Mondai 1",
      audio: "audio/listening/mondai14-4.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:今何時ですか？\n2:あなたの国の銀行は何時からなんじまですか？\n3:毎日なんじにおきますか？\n4:きのうべんきょうしましたか？\n5:あなたのうちの電話番号は何番ですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },
{
      title: "第13課 問題 6 - Mondai 1",
      audio: "audio/listening/mondai15-5.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:あなたはたばこをすいますか？\n2:まあさ　新聞を読みますか？\n3:けさ　何を飲みましたか？\n4:あした　何をしますか？\n5:いつも　どこで　昼ごはんをたべますか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },
{
      title: "第13課 問題 8 - Mondai 1",
      audio: "audio/listening/mondai16-6.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:家族は天気ですか？\n2:　あなたの国は暑いですか？\n3:仕事は　おもしろいですか？\n4:あなたの国はどんな国ですか？\n5:日本語はどうですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },
{
      title: "第13課 問題 5 - Mondai 1",
      audio: "audio/listening/mondai17-7.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:日曜日　どこへ　いきますか？\n2:何で　スーパーへ　いきますか？\n3:だれと　スーパーへ　いきますか？\n4:きのうどこへいきましたか？\n5:誕生日は何月何日ですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },
{
      title: "第13課 問題 9 - Mondai 1",
      audio: "audio/listening/mondai18-8.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:お母さんは　料理　が上手ですか？\n2:どんな　スポーツが好きですか？\n3:今晩約束がありますか？\n4:かんじがわかりますか？\n5:どうして日本語を勉強しますか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },
{
      title: "第13課 問題 7 - Mondai 1",
      audio: "audio/listening/mondai19-9.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:もうばんごはんをたべましたか？\n2:なんでごはんをたべますか？\n3:去年の誕生日にプレゼントもらいましたか？\n4:お母さんの誕生あげますか？\n5:'Thank you' は日本語でなんですか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },
{
      title: "第13課 問題 10 - Mondai 1",
      audio: "audio/listening/mondai20-10.mp3",
      description: "Nghe đoạn hội thoại và trả lời câu hỏi.",
      script:"1:あなたは今いきますか\n2:あなたのうちに犬がいますか\n3:あなたの部屋に時計がありますか？\n4:日本語のじしょはどこにありますか？\n5:うちの近くに何がありますか？",
      questions: [
        { question: "1.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" },
        { question: "2.", placeholder: "......" }
      ]
    },

  ];

  const container = document.getElementById("listening-list");
  container.innerHTML = listenings.map((item, index) => `
    <div class="vocab-item">
      <h4>${item.title}</h4>
      <p>${item.description}</p>
      <audio controls style="width: 100%; margin-bottom: 10px;">
        <source src="${item.audio}" type="audio/mp3" />
        Trình duyệt của bạn không hỗ trợ audio.
      </audio>

      <!-- Nút bấm để hiện phần câu hỏi -->
      <div class="fill-toggle" data-index="${index}" style="cursor: pointer; color: #2563eb; font-weight: bold; margin-bottom: 8px;">
        🔸 Trả lời câu hỏi
      </div>
      <!-- Nút bấm để hiện văn bản bài nghe -->
<div class="script-toggle" data-index="${index}" style="cursor: pointer; color: green; font-weight: bold; margin-bottom: 6px;">
  📄 Bài nghe
</div>
<!-- Nội dung văn bản bài nghe -->
<div id="script-text-${index}" style="display: none; white-space: pre-wrap; border-left: 3px solid #ccc; padding-left: 10px; margin-bottom: 12px;">
  ${item.script || "<i>Chưa có nội dung bài nghe</i>"}
</div>


      <!-- Phần câu hỏi bị ẩn -->
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

  // Gắn sự kiện click vào dòng "Điền vào chỗ trống"
  document.querySelectorAll('.fill-toggle').forEach(el => {
    el.addEventListener('click', () => {
      const index = el.getAttribute('data-index');
      const target = document.getElementById(`fill-question-${index}`);
      target.style.display = (target.style.display === 'none') ? 'block' : 'none';
    });
  });
  // Gắn sự kiện click vào nút "📄 Bài nghe"
document.querySelectorAll('.script-toggle').forEach(el => {
  el.addEventListener('click', () => {
    const index = el.getAttribute('data-index');
    const target = document.getElementById(`script-text-${index}`);
    target.style.display = (target.style.display === 'none') ? 'block' : 'none';
  });
});

}
