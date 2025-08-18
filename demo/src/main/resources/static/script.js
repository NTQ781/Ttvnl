// ========== HIRAGANA & KATAKANA DATA ==========
const hiraganaData = [
  { char: "あ", romaji: "a", audio: "/audio/hiragana/a.mp3" },
  { char: "い", romaji: "i", audio: "/audio/hiragana/i.mp3" },
  { char: "う", romaji: "u", audio: "/audio/hiragana/u.mp3" },
  { char: "え", romaji: "e", audio: "/audio/hiragana/e.mp3" },
  { char: "お", romaji: "o", audio: "/audio/hiragana/o.mp3" },

  { char: "か", romaji: "ka", audio: "/audio/hiragana/ka.mp3" },
  { char: "き", romaji: "ki", audio: "/audio/hiragana/ki.mp3" },
  { char: "く", romaji: "ku", audio: "/audio/hiragana/ku.mp3" },
  { char: "け", romaji: "ke", audio: "/audio/hiragana/ke.mp3" },
  { char: "こ", romaji: "ko", audio: "/audio/hiragana/ko.mp3" },

  { char: "さ", romaji: "sa", audio: "/audio/hiragana/sa.mp3" },
  { char: "し", romaji: "shi", audio: "/audio/hiragana/shi.mp3" },
  { char: "す", romaji: "su", audio: "/audio/hiragana/su.mp3" },
  { char: "せ", romaji: "se", audio: "/audio/hiragana/se.mp3" },
  { char: "そ", romaji: "so", audio: "/audio/hiragana/so.mp3" },

  { char: "た", romaji: "ta", audio: "/audio/hiragana/ta.mp3" },
  { char: "ち", romaji: "chi", audio: "/audio/hiragana/chi.mp3" },
  { char: "つ", romaji: "tsu", audio: "/audio/hiragana/tsu.mp3" },
  { char: "て", romaji: "te", audio: "/audio/hiragana/te.mp3" },
  { char: "と", romaji: "to", audio: "/audio/hiragana/to.mp3" },

  { char: "な", romaji: "na", audio: "/audio/hiragana/na.mp3" },
  { char: "に", romaji: "ni", audio: "/audio/hiragana/ni.mp3" },
  { char: "ぬ", romaji: "nu", audio: "/audio/hiragana/nu.mp3" },
  { char: "ね", romaji: "ne", audio: "/audio/hiragana/ne.mp3" },
  { char: "の", romaji: "no", audio: "/audio/hiragana/no.mp3" },

  { char: "は", romaji: "ha", audio: "/audio/hiragana/ha.mp3" },
  { char: "ひ", romaji: "hi", audio: "/audio/hiragana/hi.mp3" },
  { char: "ふ", romaji: "fu", audio: "/audio/hiragana/fu.mp3" },
  { char: "へ", romaji: "he", audio: "/audio/hiragana/he.mp3" },
  { char: "ほ", romaji: "ho", audio: "/audio/hiragana/ho.mp3" },

  { char: "ま", romaji: "ma", audio: "/audio/hiragana/ma.mp3" },
  { char: "み", romaji: "mi", audio: "/audio/hiragana/mi.mp3" },
  { char: "む", romaji: "mu", audio: "/audio/hiragana/mu.mp3" },
  { char: "め", romaji: "me", audio: "/audio/hiragana/me.mp3" },
  { char: "も", romaji: "mo", audio: "/audio/hiragana/mo.mp3" },

  { char: "や", romaji: "ya", audio: "/audio/hiragana/ya.mp3" },
  { char: "ゆ", romaji: "yu", audio: "/audio/hiragana/yu.mp3" },
  { char: "よ", romaji: "yo", audio: "/audio/hiragana/yo.mp3" },

  { char: "ら", romaji: "ra", audio: "/audio/hiragana/ra.mp3" },
  { char: "り", romaji: "ri", audio: "/audio/hiragana/ri.mp3" },
  { char: "る", romaji: "ru", audio: "/audio/hiragana/ru.mp3" },
  { char: "れ", romaji: "re", audio: "/audio/hiragana/re.mp3" },
  { char: "ろ", romaji: "ro", audio: "/audio/hiragana/ro.mp3" },

  { char: "わ", romaji: "wa", audio: "/audio/hiragana/wa.mp3" },
  { char: "を", romaji: "wo", audio: "/audio/hiragana/wo.mp3" },

  { char: "ん", romaji: "n", audio: "/audio/hiragana/n.mp3" }
];

const katakanaData = [
  { char: "ア", romaji: "a", audio: "/audio/katakana/a.mp3" },
  { char: "イ", romaji: "i", audio: "/audio/katakana/i.mp3" },
  { char: "ウ", romaji: "u", audio: "/audio/katakana/u.mp3" },
  { char: "エ", romaji: "e", audio: "/audio/katakana/e.mp3" },
  { char: "オ", romaji: "o", audio: "/audio/katakana/o.mp3" },

  { char: "カ", romaji: "ka", audio: "/audio/katakana/ka.mp3" },
  { char: "キ", romaji: "ki", audio: "/audio/katakana/ki.mp3" },
  { char: "ク", romaji: "ku", audio: "/audio/katakana/ku.mp3" },
  { char: "ケ", romaji: "ke", audio: "/audio/katakana/ke.mp3" },
  { char: "コ", romaji: "ko", audio: "/audio/katakana/ko.mp3" },

  { char: "サ", romaji: "sa", audio: "/audio/katakana/sa.mp3" },
  { char: "シ", romaji: "shi", audio: "/audio/katakana/shi.mp3" },
  { char: "ス", romaji: "su", audio: "/audio/katakana/su.mp3" },
  { char: "セ", romaji: "se", audio: "/audio/katakana/se.mp3" },
  { char: "ソ", romaji: "so", audio: "/audio/katakana/so.mp3" },

  { char: "タ", romaji: "ta", audio: "/audio/katakana/ta.mp3" },
  { char: "チ", romaji: "chi", audio: "/audio/katakana/chi.mp3" },
  { char: "ツ", romaji: "tsu", audio: "/audio/katakana/tsu.mp3" },
  { char: "テ", romaji: "te", audio: "/audio/katakana/te.mp3" },
  { char: "ト", romaji: "to", audio: "/audio/katakana/to.mp3" },

  { char: "ナ", romaji: "na", audio: "/audio/katakana/na.mp3" },
  { char: "ニ", romaji: "ni", audio: "/audio/katakana/ni.mp3" },
  { char: "ヌ", romaji: "nu", audio: "/audio/katakana/nu.mp3" },
  { char: "ネ", romaji: "ne", audio: "/audio/katakana/ne.mp3" },
  { char: "ノ", romaji: "no", audio: "/audio/katakana/no.mp3" },

  { char: "ハ", romaji: "ha", audio: "/audio/katakana/ha.mp3" },
  { char: "ヒ", romaji: "hi", audio: "/audio/katakana/hi.mp3" },
  { char: "フ", romaji: "fu", audio: "/audio/katakana/fu.mp3" },
  { char: "ヘ", romaji: "he", audio: "/audio/katakana/he.mp3" },
  { char: "ホ", romaji: "ho", audio: "/audio/katakana/ho.mp3" },

  { char: "マ", romaji: "ma", audio: "/audio/katakana/ma.mp3" },
  { char: "ミ", romaji: "mi", audio: "/audio/katakana/mi.mp3" },
  { char: "ム", romaji: "mu", audio: "/audio/katakana/mu.mp3" },
  { char: "メ", romaji: "me", audio: "/audio/katakana/me.mp3" },
  { char: "モ", romaji: "mo", audio: "/audio/katakana/mo.mp3" },

  { char: "ヤ", romaji: "ya", audio: "/audio/katakana/ya.mp3" },
  { char: "ユ", romaji: "yu", audio: "/audio/katakana/yu.mp3" },
  { char: "ヨ", romaji: "yo", audio: "/audio/katakana/yo.mp3" },

  { char: "ラ", romaji: "ra", audio: "/audio/katakana/ra.mp3" },
  { char: "リ", romaji: "ri", audio: "/audio/katakana/ri.mp3" },
  { char: "ル", romaji: "ru", audio: "/audio/katakana/ru.mp3" },
  { char: "レ", romaji: "re", audio: "/audio/katakana/re.mp3" },
  { char: "ロ", romaji: "ro", audio: "/audio/katakana/ro.mp3" },

  { char: "ワ", romaji: "wa", audio: "/audio/katakana/wa.mp3" },
  { char: "ヲ", romaji: "wo", audio: "/audio/katakana/wo.mp3" },

  { char: "ン", romaji: "n", audio: "/audio/katakana/n.mp3" }
];

// ========== SHOW SECTIONS ==========
function showSection(id) {
  document.querySelectorAll("main section").forEach(sec => {
    sec.style.display = "none";
  });
  document.getElementById(id).style.display = "block";

  if (id === "hiragana") renderHiraganaGrid();
  if (id === "katakana") renderKatakanaGrid();
  if (id === "doc-hieu") renderReadingList();
  if (id === "nghe-hieu") renderListeningList();
}

// ========== HIRAGANA ==========
function renderHiraganaGrid() {
  const grid = document.getElementById("hiragana-grid");
  grid.innerHTML = "";
  hiraganaData.forEach(item => {
    const cell = document.createElement("div");
    cell.className = "kana-cell";
    cell.innerHTML = `<div>${item.char}</div><div>${item.romaji}</div>`;
    cell.onclick = () => playAudio(item.audio);
    grid.appendChild(cell);
  });
}

// ========== KATAKANA ==========
function renderKatakanaGrid() {
  const grid = document.getElementById("katakana-grid");
  grid.innerHTML = "";
  katakanaData.forEach(item => {
    const cell = document.createElement("div");
    cell.className = "kana-cell";
    cell.innerHTML = `<div>${item.char}</div><div>${item.romaji}</div>`;
    cell.onclick = () => playAudio(item.audio);
    grid.appendChild(cell);
  });
}

// ========== AUDIO PLAYER ==========
function playAudio(url) {
  const audio = new Audio(url);
  audio.play();
}

// ========== READING (Đọc-Hiểu) ==========
async function renderReadingList(level = null) {
  const container = document.getElementById("reading-list");
  container.innerHTML = "<p>Đang tải dữ liệu...</p>";

  let url = "/api/readings";
  if (level) url += "?level=" + level;

  const res = await fetch(url);
  const readings = await res.json();
  container.innerHTML = "";

  readings.forEach((r, idx) => {
    const item = document.createElement("div");
    item.className = "reading-item";
    item.innerHTML = `<div class="title">📖 ${r.title}</div>`;
    const details = document.createElement("div");
    details.className = "details";

    // Nội dung bài
    const content = document.createElement("pre");
    content.textContent = r.content;
    details.appendChild(content);

    // Câu hỏi
    r.questions.forEach((qa, i) => {
      const qDiv = document.createElement("div");
      qDiv.innerHTML = `<b>Câu ${i+1}:</b> ${qa.q}`;
      const ansBtn = document.createElement("button");
      ansBtn.textContent = "Xem đáp án";
      const ansDiv = document.createElement("div");
      ansDiv.style.display = "none";
      ansDiv.innerHTML = `<i>Đáp án:</i> ${qa.a} <br><i>Dịch:</i> ${qa.t}`;
      ansBtn.onclick = (e) => {
        e.stopPropagation();
        ansDiv.style.display = ansDiv.style.display === "none" ? "block" : "none";
      };
      qDiv.appendChild(ansBtn);
      qDiv.appendChild(ansDiv);
      details.appendChild(qDiv);
    });

    // Bài dịch
    const transBtn = document.createElement("button");
    transBtn.textContent = "📘 Bài dịch";
    const transDiv = document.createElement("pre");
    transDiv.style.display = "none";
    transDiv.textContent = r.translation;
    transBtn.onclick = (e) => {
      e.stopPropagation();
      transDiv.style.display = transDiv.style.display === "none" ? "block" : "none";
    };
    details.appendChild(transBtn);
    details.appendChild(transDiv);

    details.style.display = "none";
    item.appendChild(details);

    item.querySelector(".title").onclick = () => {
      details.style.display = details.style.display === "none" ? "block" : "none";
    };

    container.appendChild(item);
  });
}

// ========== LISTENING (Nghe-Hiểu) ==========
async function renderListeningList(level = null) {
  const container = document.getElementById("listening-list");
  container.innerHTML = "<p>Đang tải dữ liệu...</p>";

  let url = "/api/listenings";
  if (level) url += "?level=" + level;

  const res = await fetch(url);
  const listenings = await res.json();
  container.innerHTML = "";

  listenings.forEach((l, idx) => {
    const item = document.createElement("div");
    item.className = "listening-item";
    item.innerHTML = `<div class="title">🎧 ${l.title}</div>`;
    const details = document.createElement("div");
    details.className = "details";

    // Audio
    const audio = document.createElement("audio");
    audio.controls = true;
    audio.src = l.audio || l.audioUrl;
    details.appendChild(audio);

    // Câu hỏi
    l.questions.forEach((q, i) => {
      const qDiv = document.createElement("div");
      qDiv.innerHTML = `<b>Câu ${i+1}:</b> ${q} <br>`;
      const input = document.createElement("input");
      input.placeholder = "Nhập câu trả lời...";
      qDiv.appendChild(input);
      details.appendChild(qDiv);
    });

    // Script (bản chép lời)
    const scriptBtn = document.createElement("button");
    scriptBtn.textContent = "📄 Bài nghe";
    const scriptDiv = document.createElement("pre");
    scriptDiv.style.display = "none";
    scriptDiv.textContent = l.script;
    scriptBtn.onclick = (e) => {
      e.stopPropagation();
      scriptDiv.style.display = scriptDiv.style.display === "none" ? "block" : "none";
    };
    details.appendChild(scriptBtn);
    details.appendChild(scriptDiv);

    details.style.display = "none";
    item.appendChild(details);

    item.querySelector(".title").onclick = () => {
      details.style.display = details.style.display === "none" ? "block" : "none";
    };

    container.appendChild(item);
  });
}

// ========== SHOW LEVEL (N1-N5) ==========
function showLevel(level) {
  showSection("doc-hieu");
  renderReadingList(level);
  renderListeningList(level);
}

// ========== INIT ==========
window.onload = () => {
  // mặc định hiện Hiragana
  showSection("hiragana");

  // gắn sự kiện cho menu nav
  document.querySelectorAll(".nav li").forEach(item => {
    item.addEventListener("click", () => {
      const sectionId = item.getAttribute("data-section");
      if (sectionId) showSection(sectionId);
    });
  });
};
