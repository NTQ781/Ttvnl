package com.example.japanese.controller;

import com.example.japanese.model.Vocabulary;
import com.example.japanese.model.Kanji;
import com.example.japanese.model.Grammar;
import com.example.japanese.model.Exercise;
import com.example.japanese.model.Reading;
import com.example.japanese.model.Listening;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.japanese.model.User;
import com.example.japanese.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private static final List<Vocabulary> vocabularyData = Arrays.asList(
         // N1 Vocabulary (100 từ)
        new Vocabulary("あいず", "aizu", "Tín hiệu", "N1"),
        new Vocabulary("あせっかく", "asekkaku", "Tức là", "N1"),
        new Vocabulary("いきおい", "ikioi", "Động lực", "N1"),
        new Vocabulary("とっさ", "tossa", "Đột ngột", "N1"),
        new Vocabulary("いちじるしい", "ichijirushii", "Nổi bật", "N1"),
        new Vocabulary("おうせつ", "ousetsu", "Tiếp đón", "N1"),
        new Vocabulary("かくしん", "kakushin", "Niềm tin", "N1"),
        new Vocabulary("かんがい", "kangai", "Cảm động", "N1"),
        new Vocabulary("きかく", "kikaku", "Kế hoạch", "N1"),
        new Vocabulary("きゅうそく", "kyuusoku", "Nhanh chóng", "N1"),
        new Vocabulary("きょういく", "kyouiku", "Giáo dục", "N1"),
        new Vocabulary("けいかく", "keikaku", "Lập kế hoạch", "N1"),
        new Vocabulary("けんきゅう", "kenkyuu", "Nghiên cứu", "N1"),
        new Vocabulary("こうかい", "koukai", "Hối tiếc", "N1"),
        new Vocabulary("こうりつ", "kouritsu", "Hiệu quả", "N1"),
        new Vocabulary("さくせん", "sakusen", "Chiến lược", "N1"),
        new Vocabulary("しきゅう", "shikyuu", "Cấp bách", "N1"),
        new Vocabulary("しせい", "shisei", "Thái độ", "N1"),
        new Vocabulary("しゅうし", "shuushi", "Thu chi", "N1"),
        new Vocabulary("せいかく", "seikaku", "Tính cách", "N1"),
        new Vocabulary("せいじ", "seiji", "Chính trị", "N1"),
        new Vocabulary("せいひん", "seihin", "Sản phẩm", "N1"),
        new Vocabulary("せつめい", "setsumei", "Giải thích", "N1"),
        new Vocabulary("そくざ", "sokuzai", "Ngay lập tức", "N1"),
        new Vocabulary("たいしょう", "taishou", "Đối tượng", "N1"),
        new Vocabulary("たくわえる", "takuwaeru", "Tích lũy", "N1"),
        new Vocabulary("たんじゅん", "tanjun", "Đơn giản", "N1"),
        new Vocabulary("ちゅうい", "chuui", "Chú ý", "N1"),
        new Vocabulary("ていあん", "teian", "Đề xuất", "N1"),
        new Vocabulary("てんかい", "tenkai", "Phát triển", "N1"),
        new Vocabulary("とうひょう", "touhyou", "Bỏ phiếu", "N1"),
        new Vocabulary("ねんりょう", "nenryou", "Nhiên liệu", "N1"),
        new Vocabulary("はんえい", "han'ei", "Phản ánh", "N1"),
        new Vocabulary("ひかく", "hikaku", "So sánh", "N1"),
        new Vocabulary("ひんしつ", "hinshitsu", "Chất lượng", "N1"),
        new Vocabulary("ふくざつ", "fukuzatsu", "Phức tạp", "N1"),
        new Vocabulary("ふんいき", "fun'iki", "Bầu không khí", "N1"),
        new Vocabulary("べんり", "benri", "Tiện lợi", "N1"),
        new Vocabulary("ほうほう", "houhou", "Phương pháp", "N1"),
        new Vocabulary("ほんやく", "honyaku", "Dịch thuật", "N1"),
        new Vocabulary("みとめる", "mitomeru", "Thừa nhận", "N1"),
        new Vocabulary("むじゅん", "mujun", "Mâu thuẫn", "N1"),
        new Vocabulary("めいかく", "meikaku", "Rõ ràng", "N1"),
        new Vocabulary("やくそく", "yakusoku", "Lời hứa", "N1"),
        new Vocabulary("ゆうり", "yuuri", "Lợi ích", "N1"),
        new Vocabulary("ようそ", "youso", "Yếu tố", "N1"),
        new Vocabulary("りかい", "rikai", "Hiểu biết", "N1"),
        new Vocabulary("りろん", "riron", "Lý thuyết", "N1"),
        new Vocabulary("れんらく", "renraku", "Liên lạc", "N1"),
        new Vocabulary("あんぜん", "anzen", "An toàn", "N1"),
        // Thêm các từ N1 khác để đủ 100 từ...
        new Vocabulary("こうじょう", "koujou", "Nhà máy", "N1"),
        new Vocabulary("けいけん", "keiken", "Kinh nghiệm", "N1"),
        new Vocabulary("しゅうかん", "shuukan", "Thói quen", "N1"),
        new Vocabulary("せいこう", "seikou", "Thành công", "N1"),
        new Vocabulary("たいせつ", "taisetsu", "Quan trọng", "N1"),
        new Vocabulary("てってい", "tettei", "Triệt để", "N1"),
        new Vocabulary("ひょうか", "hyouka", "Đánh giá", "N1"),
        new Vocabulary("ふくしゅう", "fukushuu", "Ôn tập", "N1"),
        new Vocabulary("みらい", "mirai", "Tương lai", "N1"),
        new Vocabulary("ようけん", "youken", "Yêu cầu", "N1"),
        new Vocabulary("りよう", "riyou", "Sử dụng", "N1"),
        new Vocabulary("せいび", "seibi", "Bảo trì", "N1"),
        new Vocabulary("せいふ", "seifu", "Chính phủ", "N1"),
        new Vocabulary("たいおう", "taiou", "Ứng phó", "N1"),
        new Vocabulary("たんとう", "tantou", "Phụ trách", "N1"),
        new Vocabulary("ちゅうもく", "chuumoku", "Chú ý", "N1"),
        new Vocabulary("ていき", "teiki", "Định kỳ", "N1"),
        new Vocabulary("てんじ", "tenji", "Triển lãm", "N1"),
        new Vocabulary("とうけい", "toukei", "Thống kê", "N1"),
        new Vocabulary("はっけん", "hakken", "Phát hiện", "N1"),
        new Vocabulary("ひつよう", "hitsuyou", "Cần thiết", "N1"),
        new Vocabulary("ふへん", "fuhen", "Phổ biến", "N1"),
        new Vocabulary("ぶんや", "bunya", "Lĩnh vực", "N1"),
        new Vocabulary("へいきん", "heikin", "Trung bình", "N1"),
        new Vocabulary("ほうこく", "houkoku", "Báo cáo", "N1"),
        new Vocabulary("ほしょう", "hoshou", "Bảo đảm", "N1"),
        new Vocabulary("まんぞく", "manzoku", "Hài lòng", "N1"),
        new Vocabulary("めんせつ", "mensetsu", "Phỏng vấn", "N1"),
        new Vocabulary("ゆうこう", "yuukou", "Hiệu quả", "N1"),
        new Vocabulary("ようい", "youi", "Chuẩn bị", "N1"),
        new Vocabulary("りょういき", "ryouiki", "Lãnh vực", "N1"),
        new Vocabulary("れいがい", "reigai", "Ngoại lệ", "N1"),
        new Vocabulary("あんしん", "anshin", "Yên tâm", "N1"),
        new Vocabulary("かくじつ", "kakujitsu", "Chắc chắn", "N1"),
        new Vocabulary("かんり", "kanri", "Quản lý", "N1"),
        new Vocabulary("きそ", "kiso", "Cơ sở", "N1"),
        new Vocabulary("けんとう", "kentou", "Xem xét", "N1"),
        new Vocabulary("こうぞう", "kouzou", "Cơ cấu", "N1"),
        new Vocabulary("さいよう", "saiyou", "Tuyển dụng", "N1"),
        new Vocabulary("しけん", "shiken", "Kỳ thi", "N1"),
        new Vocabulary("しゅうり", "shuuri", "Sửa chữa", "N1"),
        new Vocabulary("せいさん", "seisan", "Sản xuất", "N1"),
        new Vocabulary("せんたく", "sentaku", "Lựa chọn", "N1"),
        new Vocabulary("たいかい", "taikai", "Hội nghị", "N1"),
        new Vocabulary("ていねい", "teinei", "Lịch sự", "N1"),
        new Vocabulary("てんけい", "tenkei", "Điển hình", "N1"),
        new Vocabulary("はんだん", "handan", "Phán đoán", "N1"),
        new Vocabulary("ひかく", "hikaku", "So sánh", "N1"),
        new Vocabulary("ふくごう", "fukugou", "Phức hợp", "N1"),
        new Vocabulary("ほうしん", "houshin", "Phương châm", "N1"),
        // N2 Vocabulary (100 từ)
        new Vocabulary("かのう", "kanou", "Khả năng", "N2"),
        new Vocabulary("かいけつ", "kaiketsu", "Giải quyết", "N2"),
        new Vocabulary("じょうきょう", "joukyou", "Tình trạng, tình huống", "N2"),
        new Vocabulary("しつもん", "shitsumon", "Câu hỏi", "N2"),
        new Vocabulary("あんない", "annai", "Hướng dẫn", "N2"),
        new Vocabulary("いけん", "iken", "Ý kiến", "N2"),
        new Vocabulary("うんどう", "undou", "Vận động", "N2"),
        new Vocabulary("おおぜい", "oozei", "Đông người", "N2"),
        new Vocabulary("かかく", "kakaku", "Giá cả", "N2"),
        new Vocabulary("かてい", "katei", "Gia đình", "N2"),
        new Vocabulary("かんけい", "kankei", "Quan hệ", "N2"),
        new Vocabulary("きじゅん", "kijun", "Tiêu chuẩn", "N2"),
        new Vocabulary("きゅうに", "kyuuni", "Đột nhiên", "N2"),
        new Vocabulary("けいさつ", "keisatsu", "Cảnh sát", "N2"),
        new Vocabulary("こうつう", "koutsuu", "Giao thông", "N2"),
        new Vocabulary("さくひん", "sakuhin", "Tác phẩm", "N2"),
        new Vocabulary("しあい", "shiai", "Trận đấu", "N2"),
        new Vocabulary("しゅうかん", "shuukan", "Tạp chí", "N2"),
        new Vocabulary("せいかつ", "seikatsu", "Cuộc sống", "N2"),
        new Vocabulary("せいじ", "seiji", "Chính trị", "N2"),
        new Vocabulary("せんせい", "sensei", "Giáo viên", "N2"),
        new Vocabulary("たいいく", "taiiku", "Thể dục", "N2"),
        new Vocabulary("たくわえ", "takuwae", "Tiết kiệm", "N2"),
        new Vocabulary("ちゅうい", "chuui", "Sự chú ý", "N2"),
        new Vocabulary("ていあん", "teian", "Đề nghị", "N2"),
        new Vocabulary("てんじょう", "tenjou", "Trần nhà", "N2"),
        new Vocabulary("とうろく", "touroku", "Đăng ký", "N2"),
        new Vocabulary("ねんかん", "nenkan", "Hàng năm", "N2"),
        new Vocabulary("はっぴょう", "happyou", "Công bố", "N2"),
        new Vocabulary("ひひょう", "hihyou", "Phê bình", "N2"),
        new Vocabulary("ふくし", "fukushi", "Phúc lợi", "N2"),
        new Vocabulary("ふんいき", "fun'iki", "Bầu không khí", "N2"),
        new Vocabulary("べんきょう", "benkyou", "Học tập", "N2"),
        new Vocabulary("ほうこく", "houkoku", "Báo cáo", "N2"),
        new Vocabulary("ほんもの", "honmono", "Hàng thật", "N2"),
        new Vocabulary("みんぞく", "minzoku", "Dân tộc", "N2"),
        new Vocabulary("むりょう", "muryou", "Miễn phí", "N2"),
        new Vocabulary("ゆうめい", "yuumei", "Nổi tiếng", "N2"),
        new Vocabulary("ようし", "youshi", "Mẫu đơn", "N2"),
        new Vocabulary("りかい", "rikai", "Sự hiểu biết", "N2"),
        new Vocabulary("りゅうがく", "ryuugaku", "Du học", "N2"),
        new Vocabulary("れんしゅう", "renshuu", "Luyện tập", "N2"),
        new Vocabulary("あんぜん", "anzen", "An toàn", "N2"),
        new Vocabulary("いじょう", "ijou", "Bất thường", "N2"),
        new Vocabulary("おく", "oku", "Đặt", "N2"),
        new Vocabulary("かくにん", "kakunin", "Xác nhận", "N2"),
        new Vocabulary("きぼう", "kibou", "Hy vọng", "N2"),
        new Vocabulary("けいけん", "keiken", "Kinh nghiệm", "N2"),
        new Vocabulary("こうがい", "kougai", "Ô nhiễm", "N2"),
        new Vocabulary("さいしょ", "saisho", "Ban đầu", "N2"),
        new Vocabulary("しゅうり", "shuuri", "Sửa chữa", "N2"),
        new Vocabulary("せいせき", "seiseki", "Thành tích", "N2"),
        new Vocabulary("たいせい", "taisei", "Chế độ", "N2"),
        new Vocabulary("たんじょう", "tanjou", "Sinh ra", "N2"),
        new Vocabulary("ちゅうこ", "chuuko", "Đã qua sử dụng", "N2"),
        new Vocabulary("ていねい", "teinei", "Lịch sự", "N2"),
        new Vocabulary("てんかん", "tenkan", "Chuyển đổi", "N2"),
        new Vocabulary("はんたい", "hantai", "Phản đối", "N2"),
        new Vocabulary("ひつよう", "hitsuyou", "Cần thiết", "N2"),
        new Vocabulary("ふくざつ", "fukuzatsu", "Phức tạp", "N2"),
        new Vocabulary("ほうほう", "houhou", "Phương pháp", "N2"),
        new Vocabulary("ほんやく", "honyaku", "Dịch thuật", "N2"),
        new Vocabulary("まんぞく", "manzoku", "Hài lòng", "N2"),
        new Vocabulary("めいかく", "meikaku", "Rõ ràng", "N2"),
        new Vocabulary("ゆうこう", "yuukou", "Hiệu quả", "N2"),
        new Vocabulary("ようい", "youi", "Chuẩn bị", "N2"),
        new Vocabulary("りよう", "riyou", "Sử dụng", "N2"),
        new Vocabulary("れいがい", "reigai", "Ngoại lệ", "N2"),
        new Vocabulary("あんしん", "anshin", "Yên tâm", "N2"),
        new Vocabulary("かくじつ", "kakujitsu", "Chắc chắn", "N2"),
        new Vocabulary("かんり", "kanri", "Quản lý", "N2"),
        new Vocabulary("きそ", "kiso", "Cơ sở", "N2"),
        new Vocabulary("けんとう", "kentou", "Xem xét", "N2"),
        new Vocabulary("こうぞう", "kouzou", "Cơ cấu", "N2"),
        new Vocabulary("さいよう", "saiyou", "Tuyển dụng", "N2"),
        new Vocabulary("しけん", "shiken", "Kỳ thi", "N2"),
        new Vocabulary("せいさん", "seisan", "Sản xuất", "N2"),
        new Vocabulary("せんたく", "sentaku", "Lựa chọn", "N2"),
        new Vocabulary("たいかい", "taikai", "Hội nghị", "N2"),
        new Vocabulary("てんけい", "tenkei", "Điển hình", "N2"),
        new Vocabulary("はんだん", "handan", "Phán đoán", "N2"),
        new Vocabulary("ひかく", "hikaku", "So sánh", "N2"),
        new Vocabulary("ふくごう", "fukugou", "Phức hợp", "N2"),
        new Vocabulary("ほうしん", "houshin", "Phương châm", "N2"),
        new Vocabulary("みらい", "mirai", "Tương lai", "N2"),
        new Vocabulary("ようけん", "youken", "Yêu cầu", "N2"),
        new Vocabulary("りょういき", "ryouiki", "Lãnh vực", "N2"),
        new Vocabulary("あんぜん", "anzen", "An toàn", "N2"),
        new Vocabulary("いじょう", "ijou", "Bất thường", "N2"),
        new Vocabulary("おく", "oku", "Đặt", "N2"),
        new Vocabulary("かくにん", "kakunin", "Xác nhận", "N2"),
        new Vocabulary("きぼう", "kibou", "Hy vọng", "N2"),
        new Vocabulary("けいけん", "keiken", "Kinh nghiệm", "N2"),
        new Vocabulary("こうがい", "kougai", "Ô nhiễm", "N2"),
        new Vocabulary("さいしょ", "saisho", "Ban đầu", "N2"),
        // N3
        new Vocabulary("あう", "au", "Gặp", "N3"),
        new Vocabulary("あげる", "ageru", "Cho, tặng", "N3"),
        new Vocabulary("あつめる", "atsumeru", "Thu thập", "N3"),
        new Vocabulary("いじめる", "ijimeru", "Bắt nạt", "N3"),
        new Vocabulary("うける", "ukeru", "Nhận", "N3"),
        new Vocabulary("おきる", "okiru", "Thức dậy", "N3"),
        new Vocabulary("おしえる", "oshieru", "Dạy", "N3"),
        new Vocabulary("おなじ", "onaji", "Giống nhau", "N3"),
        new Vocabulary("おぼえる", "oboeru", "Ghi nhớ", "N3"),
        new Vocabulary("かう", "kau", "Mua", "N3"),
        new Vocabulary("かく", "kaku", "Viết", "N3"),
        new Vocabulary("かける", "kakeru", "Gọi (điện thoại)", "N3"),
        new Vocabulary("かぞえる", "kazoeru", "Đếm", "N3"),
        new Vocabulary("きく", "kiku", "Nghe", "N3"),
        new Vocabulary("きめる", "kimeru", "Quyết định", "N3"),
        new Vocabulary("くう", "kuu", "Ăn (động vật)", "N3"),
        new Vocabulary("くる", "kuru", "Đến", "N3"),
        new Vocabulary("ける", "keru", "Đá", "N3"),
        new Vocabulary("さがす", "sagasu", "Tìm kiếm", "N3"),
        new Vocabulary("さわる", "sawaru", "Chạm", "N3"),
        new Vocabulary("しまう", "shimau", "Cất, để", "N3"),
        new Vocabulary("しめる", "shimeru", "Đóng", "N3"),
        new Vocabulary("しる", "shiru", "Biết", "N3"),
        new Vocabulary("すむ", "sumu", "Sống, ở", "N3"),
        new Vocabulary("そと", "soto", "Bên ngoài", "N3"),
        new Vocabulary("たつ", "tatsu", "Đứng", "N3"),
        new Vocabulary("たのむ", "tanomu", "Nhờ, yêu cầu", "N3"),
        new Vocabulary("つかう", "tsukau", "Sử dụng", "N3"),
        new Vocabulary("つくる", "tsukuru", "Làm, tạo", "N3"),
        new Vocabulary("でかける", "dekakeru", "Đi ra ngoài", "N3"),
        new Vocabulary("でる", "deru", "Ra, rời", "N3"),
        new Vocabulary("なおる", "naoru", "Khỏi bệnh", "N3"),
        new Vocabulary("なく", "naku", "Khóc", "N3"),
        new Vocabulary("なる", "naru", "Trở thành", "N3"),
        new Vocabulary("ねる", "neru", "Ngủ", "N3"),
        new Vocabulary("のる", "noru", "Lên (xe)", "N3"),
        new Vocabulary("はいる", "hairu", "Vào", "N3"),
        new Vocabulary("はう", "hau", "Bò", "N3"),
        new Vocabulary("はしる", "hashiru", "Chạy", "N3"),
        new Vocabulary("はたらく", "hataraku", "Làm việc", "N3"),
        new Vocabulary("ひく", "hiku", "Kéo", "N3"),
        new Vocabulary("ふる", "furu", "Rung, lắc", "N3"),
        new Vocabulary("まつ", "matsu", "Chờ", "N3"),
        new Vocabulary("みせる", "miseru", "Cho xem", "N3"),
        new Vocabulary("みる", "miru", "Nhìn, xem", "N3"),
        new Vocabulary("もつ", "motsu", "Cầm, giữ", "N3"),
        new Vocabulary("やすむ", "yasumu", "Nghỉ ngơi", "N3"),
        new Vocabulary("よぶ", "yobu", "Gọi", "N3"),
        new Vocabulary("わかる", "wakaru", "Hiểu", "N3"),
        new Vocabulary("あける", "akeru", "Mở", "N3"),
        new Vocabulary("あそぶ", "asobu", "Chơi", "N3"),
        new Vocabulary("いきる", "ikiru", "Sống", "N3"),
        new Vocabulary("うたう", "utau", "Hát", "N3"),
        new Vocabulary("おどる", "odoru", "Nhảy múa", "N3"),
        new Vocabulary("かえる", "kaeru", "Trở về", "N3"),
        new Vocabulary("かくす", "kakusu", "Giấu", "N3"),
        new Vocabulary("きる", "kiru", "Mặc", "N3"),
        new Vocabulary("くむ", "kumu", "Múc", "N3"),
        new Vocabulary("こたえる", "kotaeru", "Trả lời", "N3"),
        new Vocabulary("さける", "sakeru", "Tránh", "N3"),
        new Vocabulary("しめる", "shimeru", "Thắt chặt", "N3"),
        new Vocabulary("すべる", "suberu", "Trượt", "N3"),
        new Vocabulary("たおれる", "taoreru", "Ngã", "N3"),
        new Vocabulary("たべる", "taberu", "Ăn", "N3"),
        new Vocabulary("つける", "tsukeru", "Gắn, bật", "N3"),
        new Vocabulary("てつだう", "tetsudau", "Giúp đỡ", "N3"),
        new Vocabulary("とぶ", "tobu", "Bay", "N3"),
        new Vocabulary("なおす", "naosu", "Sửa", "N3"),
        new Vocabulary("はく", "haku", "Mang (giày)", "N3"),
        new Vocabulary("はなす", "hanasu", "Nói", "N3"),
        new Vocabulary("ひらく", "hiraku", "Mở rộng", "N3"),
        new Vocabulary("ふく", "fuku", "Thổi", "N3"),
        new Vocabulary("まける", "makeru", "Thua", "N3"),
        new Vocabulary("みがく", "migaku", "Đánh bóng", "N3"),
        new Vocabulary("もらう", "morau", "Nhận", "N3"),
        new Vocabulary("やく", "yaku", "Nướng", "N3"),
        new Vocabulary("よむ", "yomu", "Đọc", "N3"),
        new Vocabulary("あらう", "arau", "Rửa", "N3"),
        new Vocabulary("いそぐ", "isogu", "Vội", "N3"),
        new Vocabulary("うごく", "ugoku", "Di chuyển", "N3"),
        new Vocabulary("おく", "oku", "Đặt", "N3"),
        new Vocabulary("かぶる", "kaburu", "Đội (mũ)", "N3"),
        new Vocabulary("きえる", "kieru", "Tắt, biến mất", "N3"),
        new Vocabulary("こむ", "komu", "Đông đúc", "N3"),
        new Vocabulary("しずむ", "shizumu", "Chìm", "N3"),
        new Vocabulary("そだつ", "sodatsu", "Phát triển", "N3"),
        new Vocabulary("たのしい", "tanoshii", "Vui vẻ", "N3"),
        new Vocabulary("つかれる", "tsukareru", "Mệt mỏi", "N3"),
        new Vocabulary("なげる", "nageru", "Ném", "N3"),
        new Vocabulary("ねむい", "nemui", "Buồn ngủ", "N3"),
        new Vocabulary("のむ", "nomu", "Uống", "N3"),
        new Vocabulary("はれる", "hareru", "Trời quang", "N3"),
        new Vocabulary("ふむ", "fumu", "Giẫm", "N3"),
        new Vocabulary("まわる", "mawaru", "Xoay", "N3"),
        new Vocabulary("みつかる", "mitsukaru", "Được tìm thấy", "N3"),
        new Vocabulary("やぶる", "yaburu", "Xé", "N3"),
        new Vocabulary("ゆるす", "yurusu", "Tha thứ", "N3"),
        new Vocabulary("わすれる", "wasureru", "Quên", "N3"),
        new Vocabulary("あつい", "atsui", "Nóng", "N3"),
        new Vocabulary("さむい", "samui", "Lạnh", "N3"),
         // N4
        new Vocabulary("あう", "au", "Gặp", "N4"),
        new Vocabulary("あかい", "akai", "Màu đỏ", "N4"),
        new Vocabulary("あかるい", "akarui", "Sáng", "N4"),
        new Vocabulary("あき", "aki", "Mùa thu", "N4"),
        new Vocabulary("あける", "akeru", "Mở", "N4"),
        new Vocabulary("あげる", "ageru", "Cho, tặng", "N4"),
        new Vocabulary("あさ", "asa", "Buổi sáng", "N4"),
        new Vocabulary("あした", "ashita", "Ngày mai", "N4"),
        new Vocabulary("あそぶ", "asobu", "Chơi", "N4"),
        new Vocabulary("あたらしい", "atarashii", "Mới", "N4"),
        new Vocabulary("あつい", "atsui", "Nóng", "N4"),
        new Vocabulary("あぶない", "abunai", "Nguy hiểm", "N4"),
        new Vocabulary("いく", "iku", "Đi", "N4"),
        new Vocabulary("いそがしい", "isogashii", "Bận rộn", "N4"),
        new Vocabulary("いち", "ichi", "Số một", "N4"),
        new Vocabulary("いちにち", "ichinichi", "Một ngày", "N4"),
        new Vocabulary("いぬ", "inu", "Con chó", "N4"),
        new Vocabulary("いま", "ima", "Bây giờ", "N4"),
        new Vocabulary("うえ", "ue", "Trên", "N4"),
        new Vocabulary("うしろ", "ushiro", "Phía sau", "N4"),
        new Vocabulary("うたう", "utau", "Hát", "N4"),
        new Vocabulary("うまれる", "umareru", "Sinh ra", "N4"),
        new Vocabulary("うみ", "umi", "Biển", "N4"),
        new Vocabulary("うる", "uru", "Bán", "N4"),
        new Vocabulary("えいが", "eiga", "Phim", "N4"),
        new Vocabulary("えき", "eki", "Nhà ga", "N4"),
        new Vocabulary("おおきい", "ookii", "To, lớn", "N4"),
        new Vocabulary("おかね", "okane", "Tiền", "N4"),
        new Vocabulary("おきる", "okiru", "Thức dậy", "N4"),
        new Vocabulary("おく", "oku", "Đặt", "N4"),
        new Vocabulary("おす", "osu", "Đẩy", "N4"),
        new Vocabulary("おちゃ", "ocha", "Trà", "N4"),
        new Vocabulary("おと", "oto", "Âm thanh", "N4"),
        new Vocabulary("おなじ", "onaji", "Giống nhau", "N4"),
        new Vocabulary("おぼえる", "oboeru", "Ghi nhớ", "N4"),
        new Vocabulary("おりる", "oriru", "Xuống", "N4"),
        new Vocabulary("おわる", "owaru", "Kết thúc", "N4"),
        new Vocabulary("かう", "kau", "Mua", "N4"),
        new Vocabulary("かえす", "kaesu", "Trả lại", "N4"),
        new Vocabulary("かかる", "kakaru", "Mất (thời gian, tiền)", "N4"),
        new Vocabulary("かく", "kaku", "Viết", "N4"),
        new Vocabulary("かさ", "kasa", "Cái ô", "N4"),
        new Vocabulary("かぞく", "kazoku", "Gia đình", "N4"),
        new Vocabulary("かた", "kata", "Người, cách", "N4"),
        new Vocabulary("かぶる", "kaburu", "Đội (mũ)", "N4"),
        new Vocabulary("かよう", "kayou", "Đi lại", "N4"),
        new Vocabulary("かわ", "kawa", "Sông", "N4"),
        new Vocabulary("き", "ki", "Cây", "N4"),
        new Vocabulary("きいろい", "kiiroi", "Màu vàng", "N4"),
        new Vocabulary("きく", "kiku", "Nghe", "N4"),
        new Vocabulary("きたない", "kitanai", "Bẩn", "N4"),
        new Vocabulary("きる", "kiru", "Mặc", "N4"),
        new Vocabulary("くすり", "kusuri", "Thuốc", "N4"),
        new Vocabulary("くる", "kuru", "Đến", "N4"),
        new Vocabulary("くろい", "kuroi", "Màu đen", "N4"),
        new Vocabulary("けす", "kesu", "Tắt", "N4"),
        new Vocabulary("こえ", "koe", "Giọng nói", "N4"),
        new Vocabulary("こたえる", "kotaeru", "Trả lời", "N4"),
        new Vocabulary("ことし", "kotoshi", "Năm nay", "N4"),
        new Vocabulary("こまる", "komaru", "Gặp rắc rối", "N4"),
        new Vocabulary("これ", "kore", "Cái này", "N4"),
        new Vocabulary("さく", "saku", "Nở (hoa)", "N4"),
        new Vocabulary("さむい", "samui", "Lạnh", "N4"),
        new Vocabulary("しお", "shio", "Muối", "N4"),
        new Vocabulary("しずか", "shizuka", "Yên tĩnh", "N4"),
        new Vocabulary("しる", "shiru", "Biết", "N4"),
        new Vocabulary("しろい", "shiroi", "Màu trắng", "N4"),
        new Vocabulary("すき", "suki", "Thích", "N4"),
        new Vocabulary("すむ", "sumu", "Sống", "N4"),
        new Vocabulary("せい", "sei", "Chiều cao", "N4"),
        new Vocabulary("せかい", "sekai", "Thế giới", "N4"),
        new Vocabulary("そこ", "soko", "Chỗ đó", "N4"),
        new Vocabulary("そと", "soto", "Bên ngoài", "N4"),
        new Vocabulary("たかい", "takai", "Cao, đắt", "N4"),
        new Vocabulary("たつ", "tatsu", "Đứng", "N4"),
        new Vocabulary("たな", "tana", "Kệ", "N4"),
        new Vocabulary("たべる", "taberu", "Ăn", "N4"),
        new Vocabulary("ちいさい", "chiisai", "Nhỏ", "N4"),
        new Vocabulary("つかう", "tsukau", "Sử dụng", "N4"),
        new Vocabulary("つくる", "tsukuru", "Làm, chế tạo", "N4"),
        new Vocabulary("つよい", "tsuyoi", "Mạnh", "N4"),
        new Vocabulary("て", "te", "Tay", "N4"),
        new Vocabulary("てんき", "tenki", "Thời tiết", "N4"),
        new Vocabulary("とおい", "tooi", "Xa", "N4"),
        new Vocabulary("とまる", "tomaru", "Dừng lại", "N4"),
        new Vocabulary("ともだち", "tomodachi", "Bạn bè", "N4"),
        new Vocabulary("なおす", "naosu", "Sửa chữa", "N4"),
        new Vocabulary("なか", "naka", "Bên trong", "N4"),
        new Vocabulary("なつ", "natsu", "Mùa hè", "N4"),
        new Vocabulary("ならう", "narau", "Học", "N4"),
        new Vocabulary("にく", "niku", "Thịt", "N4"),
        new Vocabulary("ねる", "neru", "Ngủ", "N4"),
        new Vocabulary("のみもの", "nomimono", "Đồ uống", "N4"),
        new Vocabulary("はいる", "hairu", "Vào", "N4"),
        new Vocabulary("はしる", "hashiru", "Chạy", "N4"),
        new Vocabulary("はなす", "hanasu", "Nói", "N4"),
        new Vocabulary("はやい", "hayai", "Nhanh, sớm", "N4"),
        new Vocabulary("ひく", "hiku", "Kéo", "N4"),
        new Vocabulary("ふるい", "furui", "Cũ", "N4"),
        new Vocabulary("みず", "mizu", "Nước", "N4"),
        // N5
        new Vocabulary("ありがとう", "arigatou", "Cảm ơn", "N5"),
        new Vocabulary("いぬ", "inu", "Con chó", "N5"),
        new Vocabulary("ねこ", "neko", "Con mèo", "N5"),
        new Vocabulary("わたし", "watashi", "Tôi", "N5"),
        new Vocabulary("アメリカ", "amerika", "Mỹ", "N5"),
        new Vocabulary("イギリス", "igirisu", "Anh", "N5"),
        new Vocabulary("にほん", "nihon", "Nhật Bản", "N5"),
        new Vocabulary("インド", "indo", "Ấn Độ", "N5"),
        new Vocabulary("せんせい", "sensei", "Thầy, cô", "N5"),
        new Vocabulary("かいしゃ", "kaisha", "Công ty", "N5"),
        new Vocabulary("だいがく", "daigaku", "Trường đại học", "N5"),
        new Vocabulary("びょういん", "byouin", "Bệnh viện", "N5"),
        new Vocabulary("だれ", "dare", "Ai", "N5"),
        new Vocabulary("これ", "kore", "Cái này", "N5"),
        new Vocabulary("それ", "sore", "Cái đó", "N5"),
        new Vocabulary("あれ", "are", "Cái kia", "N5"),
        new Vocabulary("えんぴつ", "enpitsu", "Bút chì", "N5"),
        new Vocabulary("テレビ", "terebi", "Ti vi", "N5"),
        new Vocabulary("えいご", "eigo", "Tiếng Anh", "N5"),
        new Vocabulary("なん", "nan", "Cái gì", "N5"),
        new Vocabulary("どうぞ", "douzo", "Xin mời", "N5"),
        new Vocabulary("ざっし", "zasshi", "Tạp chí", "N5"),
        new Vocabulary("つくえ", "tsukue", "Cái bàn", "N5"),
        new Vocabulary("きょうしつ", "kyoushitsu", "Phòng học", "N5"),
        new Vocabulary("へや", "heya", "Căn phòng", "N5"),
        new Vocabulary("くつ", "kutsu", "Giày", "N5"),
        new Vocabulary("えん", "en", "Yên (Đồng Yên của Nhật Bản)", "N5"),
        new Vocabulary("いくら", "ikura", "Bao nhiêu tiền", "N5"),
        new Vocabulary("すみません", "sumimasen", "Xin lỗi", "N5"),
        new Vocabulary("おきます", "okimasu", "Dậy", "N5"),
        new Vocabulary("ねます", "nemasu", "Ngủ", "N5"),
        new Vocabulary("ぎんこ", "ginko", "Ngân hàng", "N5"),
        new Vocabulary("いま", "ima", "Bây giờ", "N5"),
        new Vocabulary("あさ", "asa", "Buổi sáng", "N5"),
        new Vocabulary("ひる", "hiru", "Buổi trưa", "N5"),
        new Vocabulary("けさ", "kesa", "Sáng nay", "N5"),
        new Vocabulary("あした", "ashita", "Ngày mai", "N5"),
        new Vocabulary("しけん", "shiken", "Thí nghiệm", "N5"),
        new Vocabulary("いきます", "ikimasu", "Đi", "N5"),
        new Vocabulary("きます", "kimasu", "Đến", "N5"),
        new Vocabulary("がっこう", "gakkou", "Trường học", "N5"),
        new Vocabulary("ふね", "fune", "Thuyền", "N5"),
        new Vocabulary("バス", "basu", "Xe Bus", "N5"),
        new Vocabulary("いつ", "itsu", "Bao giờ", "N5"),
        new Vocabulary("ひと", "hito", "Người", "N5"),
        new Vocabulary("そうですね", "sou desu ne", "Ừ nhỉ", "N5"),
        new Vocabulary("たべます", "tabemasu", "Ăn", "N5"),
        new Vocabulary("のみます", "nomimasu", "Uống", "N5"),
        new Vocabulary("みます", "mimasu", "Xem", "N5"),
        new Vocabulary("ごはん", "gohan", "Cơm, bữa ăn", "N5"),
        new Vocabulary("てがみ", "tegami", "Thư", "N5"),
        new Vocabulary("しゃしん", "shashin", "Ảnh", "N5"),
        new Vocabulary("なに", "nani", "Cái gì", "N5"),
        new Vocabulary("いっしょに", "issho ni", "Cùng ~", "N5"),
        new Vocabulary("にわ", "niwa", "Vườn", "N5"),
        new Vocabulary("きります", "kirimasu", "Cắt", "N5"),
        new Vocabulary("おくります", "okurimasu", "Gửi", "N5"),
        new Vocabulary("あげます", "agemasu", "Cho, tặng", "N5"),
        new Vocabulary("もらいます", "moraimasu", "Nhận", "N5"),
        new Vocabulary("て", "te", "Tay", "N5"),
        new Vocabulary("はし", "hashi", "Đũa", "N5"),
        new Vocabulary("パソコン", "pasokon", "Máy tính cá nhân", "N5"),
        new Vocabulary("ケータイ", "keitai", "Điện thoại di động", "N5"),
        new Vocabulary("ちち", "chichi", "Bố", "N5"),
        new Vocabulary("はは", "haha", "Mẹ", "N5"),
        new Vocabulary("もう", "mou", "Đã, rồi", "N5"),
        new Vocabulary("まだ", "mada", "Chưa", "N5"),
        new Vocabulary("これから", "korekara", "Kể từ bây giờ", "N5"),
        new Vocabulary("はな", "hana", "Hoa", "N5"),
        new Vocabulary("パンチ", "panchi", "Cái đục lỗ", "N5"),
        new Vocabulary("きれい", "kirei", "Đẹp", "N5"),
        new Vocabulary("ハンサム", "hansamu", "Đẹp, sạch", "N5"),
        new Vocabulary("しずか", "shizuka", "Yên tĩnh", "N5"),
        new Vocabulary("ところ", "tokoro", "Nơi, ở", "N5"),
        new Vocabulary("りょう", "ryou", "Ký túc xá", "N5"),
        new Vocabulary("せいかつ", "seikatsu", "Cuộc sống", "N5"),
        new Vocabulary("どう", "dou", "Thế nào", "N5"),
        new Vocabulary("とても", "totemo", "Rất, lắm", "N5"),
        new Vocabulary("そして", "soshite", "Không ~ lắm", "N5"),
        new Vocabulary("あります", "arimasu", "Ở (tồn tại cho đồ vật)", "N5"),
        new Vocabulary("います", "imasu", "Ở (tồn tại cho người và động vật)", "N5"),
        new Vocabulary("でんち", "denchi", "Đèn pin", "N5"),
        new Vocabulary("うえ", "ue", "Trên", "N5"),
        new Vocabulary("した", "shita", "Dưới", "N5"),
        new Vocabulary("なか", "naka", "Trong, giữa", "N5"),
        new Vocabulary("かんたん", "kantan", "Đơn giản", "N5"),
        new Vocabulary("おもい", "omoi", "Ngọt", "N5"),
        new Vocabulary("からい", "karai", "Cay", "N5"),
        new Vocabulary("てんき", "tenki", "Thời tiết", "N5"),
        new Vocabulary("どちら", "dochira", "Cái nào (trong 2 cái)", "N5"),
        new Vocabulary("あそびます", "asobimasu", "Chơi", "N5"),
        new Vocabulary("ひろい", "hiroi", "Rộng", "N5"),
        new Vocabulary("せまい", "semai", "Chật, hẹp", "N5"),
        new Vocabulary("つり", "tsuri", "Việc câu cá", "N5"),
        new Vocabulary("つけます", "tsukemasu", "Bật", "N5"),
        new Vocabulary("いそぎます", "isogimasu", "Bận", "N5"),
        new Vocabulary("もんだい", "mondai", "Câu hỏi, vấn đề", "N5"),
        new Vocabulary("また", "mata", "Lại", "N5"),
        new Vocabulary("おつり", "otsuri", "Tiền thừa", "N5"),
        new Vocabulary("なまえ", "namae", "Tên", "N5")
    );
    

    private static final List<Kanji> kanjiData = Arrays.asList(
        // N1 Kanji (50 Kanji)
        new Kanji("曖", "", "アイ", "Mơ hồ", "曖昧: mơ hồ", "N1"),
        new Kanji("圧", "おさーえる", "アツ", "Áp lực", "圧倒: áp đảo, 圧力: áp lực", "N1"),
        new Kanji("和", "やわーらぐ", "ワ", "Hòa hợp", "和解: hòa giải, 和風: phong cách Nhật", "N1"),
        new Kanji("案", "", "アン", "Ý tưởng", "提案: đề xuất, 案: kế hoạch", "N1"),
        new Kanji("易", "やさーしい", "エキ・イ", "Dễ dàng", "貿易: mậu dịch, 易しい: dễ dàng", "N1"),
        new Kanji("越", "こーす", "エツ", "Vượt qua", "超越: vượt qua, 引っ越し: chuyển nhà", "N1"),
        new Kanji("押", "おーす", "オウ", "Đẩy", "押収: tịch thu, 押す: đẩy", "N1"),
        new Kanji("乙", "おつ", "オツ", "Thứ hai", "乙: thứ hai", "N1"),
        new Kanji("佳", "", "カ", "Tốt đẹp", "佳作: tác phẩm xuất sắc", "N1"),
        new Kanji("果", "はーたす", "カ", "Kết quả", "結果: kết quả, 効果: hiệu quả", "N1"),
        new Kanji("介", "", "カイ", "Giới thiệu", "紹介: giới thiệu, 介護: chăm sóc", "N1"),
        new Kanji("快", "こころよーい", "カイ", "Thoải mái", "愉快: vui vẻ, 快感: khoái cảm", "N1"),
        new Kanji("覚", "おぼーえる", "カク", "Ghi nhớ", "覚悟: quyết tâm, 記憶: ký ức", "N1"),
        new Kanji("各", "おのおの", "カク", "Mỗi", "各自: mỗi người, 各駅: các ga", "N1"),
        new Kanji("拡", "ひろーげる", "カク", "Mở rộng", "拡大: mở rộng, 拡張: mở rộng", "N1"),
        new Kanji("格", "", "カク", "Cách, quy tắc", "資格: tư cách, 格好: dáng vẻ", "N1"),
        new Kanji("確", "たしーか", "カク", "Chắc chắn", "確認: xác nhận, 確実: chắc chắn", "N1"),
        new Kanji("監", "", "カン", "Giám sát", "監視: giám sát, 監督: giám đốc", "N1"),
        new Kanji("管", "くだ", "カン", "Ống, quản lý", "管理: quản lý, 管轄: quyền hạn", "N1"),
        new Kanji("観", "みーる", "カン", "Quan sát", "観察: quan sát, 観光: du lịch", "N1"),
        new Kanji("基", "もと", "キ", "Cơ sở", "基準: tiêu chuẩn, 基本: cơ bản", "N1"),
        new Kanji("規", "", "キ", "Quy tắc", "規則: quy tắc, 規範: chuẩn mực", "N1"),
        new Kanji("技", "わざ", "ギ", "Kỹ thuật", "技術: kỹ thuật, 技能: kỹ năng", "N1"),
        new Kanji("義", "", "ギ", "Nghĩa vụ", "義務: nghĩa vụ, 正義: công lý", "N1"),
        new Kanji("議", "", "ギ", "Thảo luận", "会議: hội nghị, 議会: nghị viện", "N1"),
        new Kanji("挙", "あーげる", "キョ", "Cử, nâng", "挙動: hành vi, 選挙: bầu cử", "N1"),
        new Kanji("居", "いーる", "キョ", "Ở, cư trú", "居住: cư trú, 居間: phòng khách", "N1"),
        new Kanji("競", "きそーう", "キョウ", "Cạnh tranh", "競争: cạnh tranh, 競技: thi đấu", "N1"),
        new Kanji("境", "さかい", "キョウ", "Biên giới", "環境: môi trường, 境界: biên giới", "N1"),
        new Kanji("橋", "はし", "キョウ", "Cầu", "橋: cầu, 鉄橋: cầu sắt", "N1"),
        new Kanji("協", "", "キョウ", "Hợp tác", "協力: hợp tác, 協会: hiệp hội", "N1"),
        new Kanji("極", "きわーめる", "キョク", "Cực điểm", "積極的: tích cực, 極端: cực đoan", "N1"),
        new Kanji("均", "ならーす", "キン", "Cân bằng", "平均: trung bình, 均衡: cân bằng", "N1"),
        new Kanji("禁", "きんーじる", "キン", "Cấm", "禁止: cấm, 禁煙: cấm hút thuốc", "N1"),
        new Kanji("区", "く", "ク", "Khu vực", "地区: khu vực, 区分: phân chia", "N1"),
        new Kanji("駆", "かーける", "ク", "Chạy, thúc đẩy", "駆動: truyền động, 駆ける: chạy", "N1"),
        new Kanji("件", "くだん", "ケン", "Vụ việc", "事件: sự kiện, 条件: điều kiện", "N1"),
        new Kanji("券", "", "ケン", "Vé", "乗車券: vé xe, 入場券: vé vào cửa", "N1"),
        new Kanji("険", "けわーしい", "ケン", "Nguy hiểm", "危険: nguy hiểm, 保険: bảo hiểm", "N1"),
        new Kanji("検", "", "ケン", "Kiểm tra", "検査: kiểm tra, 検診: khám sức khỏe", "N1"),
        new Kanji("限", "かぎーる", "ゲン", "Giới hạn", "制限: giới hạn, 限定: hạn chế", "N1"),
        new Kanji("個", "", "コ", "Cá nhân", "個人: cá nhân, 個別: riêng lẻ", "N1"),
        new Kanji("雇", "やとーう", "コ", "Thuê", "雇用: thuê mướn, 雇う: thuê", "N1"),
        new Kanji("顧", "かえりーみる", "コ", "Nhìn lại", "顧問: cố vấn, 顧客: khách hàng", "N1"),
        new Kanji("護", "まもーる", "ゴ", "Bảo vệ", "保護: bảo vệ, 擁護: bênh vực", "N1"),
        new Kanji("厚", "あつーい", "コウ", "Dày, tử tế", "厚意: lòng tốt, 厚さ: độ dày", "N1"),
        new Kanji("効", "きーく", "コウ", "Hiệu quả", "効果: hiệu quả, 効力: hiệu lực", "N1"),
        new Kanji("構", "かまーう", "コウ", "Cấu trúc", "構造: cấu trúc, 構成: cấu thành", "N1"),
        new Kanji("講", "", "コウ", "Bài giảng", "講義: bài giảng, 講演: diễn thuyết", "N1"),
        // N2 Kanji (50 Kanji)
        new Kanji("感", "かんじる", "カン", "Cảm giác, cảm nhận", "感じる: cảm thấy, 感動: cảm động", "N2"),
        new Kanji("情", "なさけ", "ジョウ", "Tình cảm, cảm xúc", "情報: thông tin, 感情: cảm xúc", "N2"),
        new Kanji("策", "", "サク", "Sách lược", "政策: chính sách, 対策: biện pháp", "N2"),
        new Kanji("史", "", "シ", "Lịch sử", "歴史: lịch sử, 史学: sử học", "N2"),
        new Kanji("資", "", "シ", "Tư liệu", "資料: tài liệu, 資源: tài nguyên", "N2"),
        new Kanji("示", "しめーす", "ジ", "Chỉ thị", "指示: chỉ thị, 表示: biểu thị", "N2"),
        new Kanji("視", "みーる", "シ", "Nhìn, quan sát", "視察: khảo sát, 視力: thị lực", "N2"),
        new Kanji("実", "み", "ジツ", "Thực tế", "実際: thực tế, 実現: thực hiện", "N2"),
        new Kanji("写", "うつーす", "シャ", "Sao chép", "写真: bức ảnh, 写す: sao chép", "N2"),
        new Kanji("社", "やしろ", "シャ", "Xã hội, công ty", "社会: xã hội, 会社: công ty", "N2"),
        new Kanji("者", "もの", "シャ", "Người", "学者: học giả, 記者: phóng viên", "N2"),
        new Kanji("車", "くるま", "シャ", "Xe", "自動車: ô tô, 電車: tàu điện", "N2"),
        new Kanji("主", "おも", "シュ", "Chủ, chính", "主義: chủ nghĩa, 主人: chủ nhân", "N2"),
        new Kanji("取", "とーる", "シュ", "Lấy", "取引: giao dịch, 取得: thu được", "N2"),
        new Kanji("守", "まもーる", "シュ", "Giữ, bảo vệ", "保守: bảo thủ, 守る: bảo vệ", "N2"),
        new Kanji("種", "たね", "シュ", "Loại, giống", "種類: loại, 種: hạt giống", "N2"),
        new Kanji("受", "うーける", "ジュ", "Nhận", "受ける: nhận, 受験: thi cử", "N2"),
        new Kanji("術", "すべ", "ジュツ", "Kỹ thuật", "技術: kỹ thuật, 手術: phẫu thuật", "N2"),
        new Kanji("述", "のーべる", "ジュツ", "Trình bày", "記述: mô tả, 陳述: trình bày", "N2"),
        new Kanji("準", "じゅんーじる", "ジュン", "Chuẩn bị, chuẩn", "準備: chuẩn bị, 準決勝: bán kết", "N2"),
        new Kanji("純", "じゅん", "ジュン", "Thuần khiết", "純粋: thuần khiết, 純情: ngây thơ", "N2"),
        new Kanji("処", "しょ", "ショ", "Xử lý", "処理: xử lý, 処分: xử lý", "N2"),
        new Kanji("署", "", "ショ", "Cơ quan", "署名: chữ ký, 警察署: đồn cảnh sát", "N2"),
        new Kanji("勝", "かーつ", "ショウ", "Thắng", "勝利: chiến thắng, 勝負: cuộc thi", "N2"),
        new Kanji("商", "あきなーう", "ショウ", "Thương mại", "商業: thương mại, 商品: hàng hóa", "N2"),
        new Kanji("章", "", "ショウ", "Chương", "文章: văn chương, 章: chương", "N2"),
        new Kanji("笑", "わらーう", "ショウ", "Cười", "笑顔: nụ cười, 笑う: cười", "N2"),
        new Kanji("証", "あかし", "ショウ", "Chứng cứ", "証拠: chứng cứ, 証明: chứng minh", "N2"),
        new Kanji("常", "つね", "ジョウ", "Thường xuyên", "常識: lẽ thường, 異常: bất thường", "N2"),
        new Kanji("乗", "のーる", "ジョウ", "Lên, cưỡi", "乗車: lên xe, 乗る: lên", "N2"),
        new Kanji("条", "じょう", "ジョウ", "Điều khoản", "条件: điều kiện, 条約: hiệp ước", "N2"),
        new Kanji("状", "", "ジョウ", "Tình trạng", "状況: tình trạng, 状態: trạng thái", "N2"),
        new Kanji("場", "ば", "ジョウ", "Nơi, địa điểm", "会場: hội trường, 場合: trường hợp", "N2"),
        new Kanji("信", "しんーじる", "シン", "Tin tưởng", "信頼: tin cậy, 信号: tín hiệu", "N2"),
        new Kanji("身", "み", "シン", "Thân thể", "自身: chính mình, 身体: cơ thể", "N2"),
        new Kanji("進", "すすーむ", "シン", "Tiến bộ", "進行: tiến hành, 進む: tiến lên", "N2"),
        new Kanji("親", "おや", "シン", "Cha mẹ, thân thiết", "親友: bạn thân, 両親: cha mẹ", "N2"),
        new Kanji("真", "ま", "シン", "Thật", "写真: bức ảnh, 真実: sự thật", "N2"),
        new Kanji("図", "ず", "ズ", "Hình vẽ", "地図: bản đồ, 図書館: thư viện", "N2"),
        new Kanji("世", "よ", "セイ", "Thế giới", "世界: thế giới, 世代: thế hệ", "N2"),
        new Kanji("制", "", "セイ", "Chế độ", "制度: chế độ, 制限: giới hạn", "N2"),
        new Kanji("製", "", "セイ", "Sản xuất", "製造: sản xuất, 製品: sản phẩm", "N2"),
        new Kanji("勢", "いきおーい", "セイ", "Thế lực", "勢力: thế lực, 情勢: tình thế", "N2"),
        new Kanji("政", "", "セイ", "Chính trị", "政治: chính trị, 政府: chính phủ", "N2"),
        new Kanji("成", "なーる", "セイ", "Hoàn thành", "成功: thành công, 成長: trưởng thành", "N2"),
        new Kanji("性", "さが", "セイ", "Tính chất", "性格: tính cách, 性別: giới tính", "N2"),
        new Kanji("晴", "はーれる", "セイ", "Nắng, trong trẻo", "晴天: trời nắng, 晴れる: trời quang", "N2"),
        new Kanji("精", "せい", "セイ", "Tinh tế", "精神: tinh thần, 精巧: tinh xảo", "N2"),
        new Kanji("績", "つむーぐ", "セキ", "Thành tích", "成績: thành tích, 実績: kết quả thực tế", "N2"),
        new Kanji("責", "せーめる", "セキ", "Trách nhiệm", "責任: trách nhiệm, 責める: trách mắng", "N2"),
        // N3
        new Kanji("安", "やすーい", "アン", "An toàn, rẻ", "安全: an toàn, 安心: yên tâm", "N3"),
        new Kanji("意", "", "イ", "Ý, ý định", "意味: ý nghĩa, 意見: ý kiến", "N3"),
        new Kanji("響", "ひびーく", "キョウ", "Âm vang, ảnh hưởng", "影響: ảnh hưởng, 反響: tiếng vang", "N3"),
        new Kanji("解", "とーく", "カイ", "Giải, tháo", "解決: giải quyết, 理解: hiểu biết", "N3"),
        new Kanji("環", "わ", "カン", "Vòng, môi trường", "環境: môi trường, 環状: hình vòng", "N3"),
        new Kanji("危", "あぶーない", "キ", "Nguy hiểm", "危険: nguy hiểm, 危機: khủng hoảng", "N3"),
        new Kanji("計", "はかーる", "ケイ", "Kế hoạch, đo", "計画: kế hoạch, 計測: đo lường", "N3"),
        new Kanji("経", "へーる", "ケイ", "Kinh tế, trải qua", "経済: kinh tế, 経験: kinh nghiệm", "N3"),
        new Kanji("健", "すこーやか", "ケン", "Khỏe mạnh", "健康: sức khỏe, 健全: lành mạnh", "N3"),
        new Kanji("最", "", "サイ", "Tối đa, nhất", "最近: gần đây, 最高: cao nhất", "N3"),
        new Kanji("作", "つくーる", "サク", "Tạo, làm", "作業: công việc, 作成: tạo ra", "N3"),
        new Kanji("失", "うしなーう", "シツ", "Mất, thất bại", "失敗: thất bại, 失礼: bất lịch sự", "N3"),
        new Kanji("自", "みずかーら", "ジ", "Bản thân, tự", "自由: tự do, 自分: bản thân", "N3"),
        new Kanji("準", "じゅんーじる", "ジュン", "Chuẩn bị, chuẩn", "準備: chuẩn bị, 基準: tiêu chuẩn", "N3"),
        new Kanji("条", "", "ジョウ", "Điều khoản", "条件: điều kiện, 条約: hiệp ước", "N3"),
        new Kanji("活", "いーきる", "カツ", "Hoạt động, sống", "生活: cuộc sống, 活用: vận dụng", "N3"),
        new Kanji("成", "なーる", "セイ", "Thành công, trở thành", "成功: thành công, 成績: thành tích", "N3"),
        new Kanji("説", "とーく", "セツ", "Giải thích, thuyết", "説明: giải thích, 説得: thuyết phục", "N3"),
        new Kanji("存", "そんーずる", "ソン", "Tồn tại", "存在: sự tồn tại, 存知: biết", "N3"),
        new Kanji("退", "しりぞーく", "タイ", "Rút lui", "退院: xuất viện, 退職: nghỉ việc", "N3"),
        new Kanji("態", "", "タイ", "Thái độ, trạng thái", "態度: thái độ, 状態: trạng thái", "N3"),
        new Kanji("単", "ひとーえ", "タン", "Đơn, đơn giản", "単語: từ vựng, 単純: đơn giản", "N3"),
        new Kanji("注", "そそーぐ", "チュウ", "Chú ý, rót", "注意: chú ý, 注目: sự chú ý", "N3"),
        new Kanji("提", "さーげる", "テイ", "Đề xuất", "提案: đề xuất, 提供: cung cấp", "N3"),
        new Kanji("努", "つとーめる", "ド", "Nỗ lực", "努力: nỗ lực, 勤勉: chăm chỉ", "N3"),
        new Kanji("内", "うち", "ナイ", "Bên trong", "内容: nội dung, 国内: trong nước", "N3"),
        new Kanji("入", "いーる", "ニュウ", "Vào", "入院: nhập viện, 入学: nhập học", "N3"),
        new Kanji("発", "はつ", "ハツ", "Phát ra", "発音: phát âm, 発見: phát hiện", "N3"),
        new Kanji("必", "", "ヒツ", "Cần thiết", "必要: cần thiết, 必須: bắt buộc", "N3"),
        new Kanji("不", "", "フ", "Không, bất", "不安: lo âu, 不満: bất mãn", "N3"),
        new Kanji("普", "", "フ", "Phổ biến", "普通: bình thường, 普及: phổ biến", "N3"),
        new Kanji("文", "ふみ", "ブン", "Văn, văn bản", "文法: ngữ pháp, 文化: văn hóa", "N3"),
        new Kanji("間", "あいだ", "カン", "Khoảng cách, thời gian", "間違い: sai lầm, 時間: thời gian", "N3"),
        new Kanji("満", "みーちる", "マン", "Đầy, hài lòng", "満足: hài lòng, 満点: điểm tối đa", "N3"),
        new Kanji("未", "", "ミ", "Chưa, tương lai", "未来: tương lai, 未定: chưa quyết định", "N3"),
        new Kanji("目", "め", "モク", "Mắt, mục đích", "目的: mục đích, 注目: sự chú ý", "N3"),
        new Kanji("約", "やく", "ヤク", "Lời hứa, khoảng", "約束: lời hứa, 予約: đặt trước", "N3"),
        new Kanji("理", "ことわり", "リ", "Lý do, lý trí", "理由: lý do, 理解: hiểu biết", "N3"),
        new Kanji("利", "きーく", "リ", "Lợi ích", "利用: sử dụng, 利益: lợi ích", "N3"),
        new Kanji("旅", "たび", "リョ", "Du lịch", "旅行: du lịch, 旅客: hành khách", "N3"),
        new Kanji("歴", "", "レキ", "Lịch sử", "歴史: lịch sử, 経歴: lý lịch", "N3"),
        new Kanji("連", "つらーなる", "レン", "Liên kết", "連絡: liên lạc, 連合: liên minh", "N3"),
        new Kanji("運", "はこーぶ", "ウン", "Vận chuyển, vận may", "運動: vận động, 運命: số phận", "N3"),
        new Kanji("関", "せき", "カン", "Quan hệ, cửa ải", "関係: mối quan hệ, 関心: quan tâm", "N3"),
        new Kanji("気", "き", "キ", "Khí, tâm trạng", "気分: tâm trạng, 気候: khí hậu", "N3"),
        new Kanji("研", "とーぐ", "ケン", "Nghiên cứu", "研究: nghiên cứu, 研修: đào tạo", "N3"),
        new Kanji("国", "くに", "コク", "Quốc gia", "国際: quốc tế, 国内: trong nước", "N3"),
        new Kanji("社", "やしろ", "シャ", "Xã hội, công ty", "社会: xã hội, 会社: công ty", "N3"),
         // N4
        new Kanji("妹", "いもうと", "マイ", "Em gái", "妹さん: em gái (người khác)", "N4"),
        new Kanji("姉", "あね", "シ", "Chị gái", "お姉さん: chị gái (người khác)", "N4"),
        new Kanji("兄", "あに", "ケイ・キョウ", "Anh trai", "お兄さん: anh trai (người khác)", "N4"),
        new Kanji("弟", "おとうと", "テイ・ダイ", "Em trai", "弟さん: em trai (người khác)", "N4"),
        new Kanji("家", "いえ・や", "カ・ケ", "Nhà", "家族: gia đình, 家: ngôi nhà", "N4"),
        new Kanji("族", "", "ゾク", "Gia tộc", "家族: gia đình, 民族: dân tộc", "N4"),
        new Kanji("主", "ぬし・おも", "シュ", "Chủ", "主人: chồng, 主に: chủ yếu", "N4"),
        new Kanji("住", "す-む", "ジュウ", "Sống, cư trú", "住む: sống, 住所: địa chỉ", "N4"),
        new Kanji("所", "ところ", "ショ", "Nơi chốn", "場所: địa điểm, 近所: hàng xóm", "N4"),
        new Kanji("都", "みやこ", "ト・ツ", "Thủ đô", "東京都: Tokyo, 都会: đô thị", "N4"),
        new Kanji("県", "", "ケン", "Tỉnh", "大阪府: tỉnh Osaka, 県: tỉnh", "N4"),
        new Kanji("市", "いち", "シ", "Thành phố", "市長: thị trưởng, 市: thành phố", "N4"),
        new Kanji("区", "", "ク", "Quận", "区役所: ủy ban quận, 中央区: quận trung tâm", "N4"),
        new Kanji("国", "くに", "コク", "Quốc gia", "国: quốc gia, 外国: nước ngoài", "N4"),
        new Kanji("外", "そと・はず-す", "ガイ・ゲ", "Bên ngoài", "外国: nước ngoài, 外す: tháo ra", "N4"),
        new Kanji("内", "うち", "ナイ", "Bên trong", "国内: trong nước, 家内: vợ", "N4"),
        new Kanji("英", "", "エイ", "Nước Anh, tiếng Anh", "英語: tiếng Anh, 英国: nước Anh", "N4"),
        new Kanji("語", "かた-る", "ゴ", "Ngôn ngữ", "日本語: tiếng Nhật, 外国語: ngoại ngữ", "N4"),
        new Kanji("勉", "", "ベン", "Cố gắng", "勉強: học hành, 勤勉: chăm chỉ", "N4"),
        new Kanji("強", "つよ-い", "キョウ・ゴウ", "Mạnh mẽ", "勉強: học, 強い: mạnh", "N4"),
        new Kanji("教", "おし-える", "キョウ", "Dạy", "教える: dạy, 教室: lớp học", "N4"),
        new Kanji("室", "むろ", "シツ", "Phòng", "教室: lớp học, 会議室: phòng họp", "N4"),
        new Kanji("方", "かた・ほう", "ホウ", "Phía, vị (người)", "あの方: vị kia, 夕方: chiều tối", "N4"),
        new Kanji("朝", "あさ", "チョウ", "Buổi sáng", "朝ご飯: cơm sáng, 今朝: sáng nay", "N4"),
        new Kanji("昼", "ひる", "チュウ", "Buổi trưa", "昼ご飯: cơm trưa, 昼休み: nghỉ trưa", "N4"),
        new Kanji("夜", "よる・よ", "ヤ", "Đêm", "夜ご飯: cơm tối, 今夜: đêm nay", "N4"),
        new Kanji("夕", "ゆう", "セキ", "Chiều", "夕方: chiều tối, 夕食: bữa tối", "N4"),
        new Kanji("飯", "めし", "ハン", "Cơm", "ご飯: cơm, 朝ご飯: bữa sáng", "N4"),
        new Kanji("新", "あたら-しい", "シン", "Mới", "新聞: báo, 新しい: mới", "N4"),
        new Kanji("古", "ふる-い", "コ", "Cũ", "古い: cũ, 古本: sách cũ", "N4"),
        new Kanji("間", "あいだ・ま", "カン・ケン", "Khoảng cách, giữa", "時間: thời gian, 間に合う: kịp", "N4"),
        new Kanji("会", "あ-う", "カイ・エ", "Gặp, hội", "会う: gặp, 会社: công ty", "N4"),
        new Kanji("社", "やしろ", "シャ", "Công ty", "会社: công ty, 社員: nhân viên", "N4"),
        new Kanji("員", "", "イン", "Nhân viên", "会社員: nhân viên công ty, 駅員: nhân viên nhà ga", "N4"),
        new Kanji("医", "", "イ", "Y học", "医者: bác sĩ, 医学: y học", "N4"),
        new Kanji("者", "もの", "シャ", "Người (chỉ nghề)", "医者: bác sĩ, 学者: học giả", "N4"),
        new Kanji("病", "や-む・やまい", "ビョウ", "Bệnh", "病気: bệnh, 病院: bệnh viện", "N4"),
        new Kanji("院", "", "イン", "Viện", "病院: bệnh viện, 大学院: cao học", "N4"),
        new Kanji("歩", "ある-く", "ホ・ブ・フ", "Đi bộ", "歩く: đi bộ, 散歩: đi dạo", "N4"),
        new Kanji("走", "はし-る", "ソウ", "Chạy", "走る: chạy, 競走: chạy đua", "N4"),
        new Kanji("起", "お-きる・お-こす", "キ", "Thức dậy, xảy ra", "起きる: thức dậy, 起こす: đánh thức", "N4"),
        new Kanji("寝", "ね-る・ね-かす", "シン", "Ngủ", "寝る: ngủ, 寝室: phòng ngủ", "N4"),
        new Kanji("使", "つか-う", "シ", "Sử dụng", "使う: dùng, 使用中: đang sử dụng", "N4"),
        new Kanji("作", "つく-る", "サク・サ", "Làm, chế tạo", "作文: bài văn, 作る: làm", "N4"),
        new Kanji("待", "ま-つ", "タイ", "Chờ", "待つ: chờ, 招待: mời", "N4"),
        new Kanji("持", "も-つ", "ジ", "Cầm, mang", "持つ: cầm, 気持ち: cảm xúc", "N4"),
        new Kanji("知", "し-る", "チ", "Biết", "知る: biết, 知人: người quen", "N4"),
        new Kanji("考", "かんが-える", "コウ", "Suy nghĩ", "考える: suy nghĩ, 考え方: cách nghĩ", "N4"),
        new Kanji("開", "あ-く・ひら-く", "カイ", "Mở", "開ける: mở, 開会: khai mạc", "N4"),
        new Kanji("閉", "し-まる・と-じる", "ヘイ", "Đóng", "閉める: đóng, 閉会: bế mạc", "N4"),
         // N5
        new Kanji("一", "ひとーつ", "イチ・いっ", "Nhất", "一まん: 10000, 一さい: 1 tuổi", "N5"),
        new Kanji("二", "ふたーつ", "二", "Nhị", "二がつ: tháng 2, 二: 2 cái", "N5"),
        new Kanji("三", "みっーつ", "サン", "Tam", "三じ: 3 giờ, 三かげつ: 3 tháng", "N5"),
        new Kanji("四", "よっーつ、よ、よん", "シ", "Tứ", "シがつ: tháng 4, 四人: 4 người", "N5"),
        new Kanji("五", "いつーつ", "ゴ", "Ngũ", "五びょう: 5 giây", "N5"),
        new Kanji("六", "むっーつ", "ロク・ロッ", "Lục", "ロッさい: 6 tuổi, 六つ: 6 cái", "N5"),
        new Kanji("七", "ななーつ", "シチ", "Thất", "七じ: 7 giờ, 七日: mùng 7", "N5"),
        new Kanji("八", "やっーつ", "ハチ・ハツ", "Bát", "八つ: 8 cái, ハじ: 8 giờ", "N5"),
        new Kanji("九", "ここのーつ", "キュウ・ク", "Cửu", "クじ: 9 giờ, 九びょう: 9 giây", "N5"),
        new Kanji("十", "とお", "ジュウ・ジッ", "Thập", "ジュウじ: 10 giờ, ジュウ人: 10 người", "N5"),
        new Kanji("百", "", "ヒャク・ピャク・ビャク", "Bách", "八百: 800, 三百: 300", "N5"),
        new Kanji("千", "", "せん・ぜん", "Thiên", "千人: 1000, 三千: 3000", "N5"),
        new Kanji("万", "", "マン", "Vạn", "三万: 30000, 二万: 20000", "N5"),
        new Kanji("円", "", "エン", "Viên", "二万円: 20000 Yên", "N5"),
        new Kanji("月", "つき", "ゲツ・ガツ", "Nguyệt", "来月: tuần sau, 月曜日: thứ 2", "N5"),
        new Kanji("火", "ひ", "カ", "Hỏa", "たばこの火: khói thuốc, 火山: núi lửa", "N5"),
        new Kanji("水", "みず", "すい", "Thủy", "水曜日: thứ 4, 水えい: bơi lội", "N5"),
        new Kanji("木", "き", "ぼく・もく", "Mộc", "木曜日: thứ 5, 大木: cây lớn", "N5"),
        new Kanji("金", "かね", "きん", "Kim", "お金: tiền, 金曜日: thứ 6", "N5"),
        new Kanji("土", "つち", "ド", "Thổ", "土曜日: thứ 7", "N5"),
        new Kanji("日", "ひ・び・ぴ・か", "ニチ", "Nhật", "休日: ngày nghỉ, 毎日: mỗi ngày", "N5"),
        new Kanji("年", "とし", "ネン", "Niên", "三年: 3 năm, 年より: lớn tuổi", "N5"),
        new Kanji("人", "ひと", "ジン・ニン", "Nhân", "ベトナム人: người Việt Nam, 何人: bao nhiêu người", "N5"),
        new Kanji("口", "くち・ぐち", "コウ", "Khẩu", "人口: dân số, 出口: lối ra", "N5"),
        new Kanji("目", "め", "もく", "Mục", "目薬: thuốc nhỏ mắt, か目: môn học", "N5"),
        new Kanji("耳", "みみ", "ジ", "Nhĩ", "耳びか: khoa tai mũi, 耳: tai", "N5"),
        new Kanji("手", "て", "シュ", "Thủ", "手がみ: thư, 歌手: ca sĩ", "N5"),
        new Kanji("足", "あし・たす", "ソク・ゾク", "Túc", "まん足: hài lòng, 足: chân", "N5"),
        new Kanji("力", "ちから", "リョク", "Lực", "きょう力: cùng hợp tác, し力: thị lực", "N5"),
        new Kanji("山", "やま", "サン・ザン", "Sơn", "ふじ山: núi Phú Sĩ, 小山: núi lửa", "N5"),
        new Kanji("川", "かわ・がわ", "", "Xuyến", "川: sông, ナイル川: sông Nile", "N5"),
        new Kanji("田", "た・だ", "デン", "Điền", "田ぼん: ruộng, 水田: ruộng nước", "N5"),
        new Kanji("石", "いし", "セキ", "Thạch", "ほう石: đá quý, 石: đá", "N5"),
        new Kanji("花", "はな", "ヵ", "Hoa", "花火: pháo hoa, 花火: pháo hoa", "N5"),
        new Kanji("竹", "たけ", "チク", "Trúc", "竹のこ: măng, 竹林: rừng tre", "N5"),
        new Kanji("雨", "あめ", "ウ", "Vũ", "雨てん: trời mưa, 大雨: mưa lớn", "N5"),
        new Kanji("上", "うえ・あがーる・のぼーる", "ジョウ", "Thượng", "上手: giỏi, 年上: cao tuổi", "N5"),
        new Kanji("下", "した・さーがる・くだーる", "ゲ", "Hạ", "年下: nhỏ tuổi", "N5"),
        new Kanji("左", "ひだり", "サ", "Tả", "左せつ: rẽ trái, 左: trái", "N5"),
        new Kanji("右", "みぎ", "ウ", "Hữu", "右足: chân phải, 右せつ: rẽ phải", "N5"),
        new Kanji("外", "そと", "ガイ", "Ngoại", "外しゅう: ra ngoài, 外こく: nước ngoài", "N5"),
        new Kanji("内", "うち", "ナイ", "Nội", "こく内: trong nước, 内か: khoa nội", "N5"),
        new Kanji("中", "なか", "ジュウ・チュウ", "Trung", "水中: nước ngầm, 中: bên trong, giữa", "N5"),
        new Kanji("学", "まなーぶ", "ガク", "Học", "学びます: học, 学校: trường học", "N5"),
        new Kanji("交", "", "コウ", "Giáo", "中学校: trường cấp 2, 小学校: trường tiểu học", "N5"),
        new Kanji("先", "さき", "セン", "Tiên", "先に: trước, 先生: giáo viên", "N5"),
        new Kanji("生", "いーきる・うーまれる", "セイ・ショウ・ジョウ", "Sinh", "学生: sinh viên, 人生: cuộc đời", "N5"),
        new Kanji("名", "な", "めい・ミョウ", "Danh", "名前: tên, ゆう名: nổi tiếng", "N5"),
        new Kanji("字", "", "ジ", "Tự", "漢字: chữ Hán, も字: chữ cái", "N5"),
        new Kanji("本", "もと", "ホン・ボン・ポン", "Bổn", "日本: Nhật Bản, 一本: 1 cái", "N5")
    );

    private static final List<Grammar> grammarData = Arrays.asList(
        // N1 Grammar (25 cấu trúc)
        new Grammar("～あげく", "Sau nhiều nỗ lực, cuối cùng", "考えたあげく、辞めた。", "N1"),
        new Grammar("～いかん", "Tùy thuộc vào", "結果はいかんによる。", "N1"),
        new Grammar("～をよそに", "Bỏ qua", "忠告をよそに進む。", "N1"),
        new Grammar("～かたがた", "Nhân tiện", "挨拶かたがた伺いました。", "N1"),
        new Grammar("～かねない", "Có khả năng", "失敗しかねない状況だ。", "N1"),
        new Grammar("～かねる", "Khó mà làm", "この要求には応じかねる。", "N1"),
        new Grammar("～きらいがある", "Có xu hướng", "彼は怠けきらいがある。", "N1"),
        new Grammar("～きわまる", "Cực kỳ", "その美しさはきわまる。", "N1"),
        new Grammar("～げ", "Có vẻ", "彼は疲れげだ。", "N1"),
        new Grammar("～ずくめ", "Toàn là", "良いことずくめの話だ。", "N1"),
        new Grammar("～ずにはおかない", "Nhất định phải", "感動せずにはおかない映画だ。", "N1"),
        new Grammar("～そばから", "Ngay sau khi", "教えたそばから忘れる。", "N1"),
        new Grammar("～たところで", "Dù có làm", "今更謝ったところで遅い。", "N1"),
        new Grammar("～だに", "Chỉ cần nghĩ đến", "想像するだに恐ろしい。", "N1"),
        new Grammar("～つつある", "Đang dần", "状況は悪化しつつある。", "N1"),
        new Grammar("～てはかなわない", "Không chịu nổi nếu", "こんな暑さではかなわない。", "N1"),
        new Grammar("～てやまない", "Luôn luôn", "成功を祈ってやまない。", "N1"),
        new Grammar("～とあって", "Vì lý do", "試験とあって緊張した。", "N1"),
        new Grammar("～とばかりに", "Như thể", "成功したとばかりに喜んだ。", "N1"),
        new Grammar("～ともなく", "Một cách mơ hồ", "何となく不安だ。", "N1"),
        new Grammar("～ないではいられない", "Không thể không", "笑わないではいられない。", "N1"),
        new Grammar("～なり", "Ngay khi", "見たなり驚いた。", "N1"),
        new Grammar("～に堪えない", "Không thể chịu nổi", "この美しさに堪えない。", "N1"),
        new Grammar("～にひきかえ", "Trái ngược với", "彼にひきかえ、彼女は優しい。", "N1"),
        new Grammar("～にもかかわらず", "Mặc dù", "雨にもかかわらず行った。", "N1"),
        // N2 Grammar (25 cấu trúc)
        new Grammar("～ことになる", "Được quyết định là, trở nên là", "来年日本へ転勤することになりました。", "N2"),
        new Grammar("～ことにする", "Tôi quyết định là...", "毎日運動することにしています。", "N2"),
        new Grammar("～うちに", "Trong khi còn...", "若いうちに海外旅行したほうがいい。", "N2"),
        new Grammar("～おそれがある", "Có nguy cơ", "事故のおそれがあります。", "N2"),
        new Grammar("～かえって", "Trái lại", "急ぐとかえって遅れる。", "N2"),
        new Grammar("～かけだ", "Bắt đầu nhưng chưa xong", "宿題をやりかけた。", "N2"),
        new Grammar("～かねる", "Khó mà làm", "この仕事は引き受けかねる。", "N2"),
        new Grammar("～きる", "Làm hoàn toàn", "本を読みきった。", "N2"),
        new Grammar("～くせに", "Mặc dù", "子供のくせに生意気だ。", "N2"),
        new Grammar("～こそ", "Chính là", "今こそ行動する時だ。", "N2"),
        new Grammar("～さえ", "Thậm chí", "水さえあれば生きられる。", "N2"),
        new Grammar("～さえ～ば", "Nếu thậm chí", "時間さえあればできる。", "N2"),
        new Grammar("～たび", "Mỗi lần", "会うたびに嬉しくなる。", "N2"),
        new Grammar("～たびに", "Mỗi khi", "見るたびに懐かしい。", "N2"),
        new Grammar("～だらけ", "Đầy rẫy", "間違いだらけの答案だ。", "N2"),
        new Grammar("～っぽい", "Có vẻ", "子供っぽい態度だ。", "N2"),
        new Grammar("～つつ", "Trong khi", "考えつつ歩く。", "N2"),
        new Grammar("～てからでないと", "Chỉ sau khi", "確認してからでないと進めない。", "N2"),
        new Grammar("～てたまらない", "Không thể chịu nổi", "眠くてたまらない。", "N2"),
        new Grammar("～とおり", "Như", "計画のとおり進む。", "N2"),
        new Grammar("～ないではいられない", "Không thể không", "助けないではいられない。", "N2"),
        new Grammar("～にちがいない", "Chắc chắn là", "彼にちがいない。", "N2"),
        new Grammar("～にともなって", "Cùng với", "成長にともなって責任が増える。", "N2"),
        new Grammar("～にほかならない", "Chính là", "これは運命にほかならない。", "N2"),
        new Grammar("～ばかりだ", "Chỉ toàn là", "失敗ばかりだ。", "N2"),
        // N3
        new Grammar("～にあたる", "Tương ứng với", "この問題は試験にあたる。", "N3"),
        new Grammar("～かける", "Sắp làm, chưa hoàn thành", "電話をかけかけた時、誰かが来た。", "N3"),
        new Grammar("～きる", "Làm hoàn toàn", "本を読みきった。", "N3"),
        new Grammar("～にくい", "Khó làm", "この字は読みにくい。", "N3"),
        new Grammar("～やすい", "Dễ làm", "この本は読みやすい。", "N3"),
        new Grammar("～てしまう", "Làm xong (thường kèm tiếc nuối)", "ケーキを食べてしまった。", "N3"),
        new Grammar("～ばかりだ", "Chỉ toàn, cứ tiếp tục", "最近、忙しいばかりだ。", "N3"),
        new Grammar("～わけだ", "Không lạ gì, hợp lý", "彼が疲れているわけだ。", "N3"),
        new Grammar("～わけにはいかない", "Không thể", "約束を破るわけにはいかない。", "N3"),
        new Grammar("～おそれがある", "Có nguy cơ", "雨が降るおそれがある。", "N3"),
        new Grammar("～かねない", "Có thể xảy ra", "失敗しかねない。", "N3"),
        new Grammar("～たびに", "Mỗi khi", "彼に会うたびに緊張する。", "N3"),
        new Grammar("～につれて", "Cùng với, theo tỷ lệ", "年を取るにつれて健康が大事になる。", "N3"),
        new Grammar("～くせに", "Mặc dù", "子供なのに、大人っぽいくせに。", "N3"),
        new Grammar("～っぽい", "Giống như, mang tính", "彼女は子供っぽい。", "N3"),
        new Grammar("～わけがない", "Không thể nào", "彼がそんなことをするわけがない。", "N3"),
        new Grammar("～限り", "Chừng nào, trong phạm vi", "知っている限り、問題はない。", "N3"),
        new Grammar("～ず", "Không làm", "食べずに出かけた。", "N3"),
        new Grammar("～だす", "Bắt đầu làm", "走りだした。", "N3"),
        new Grammar("～てみる", "Thử làm", "食べてみる？", "N3"),
        new Grammar("～つつある", "Đang trong quá trình", "状況が改善しつつある。", "N3"),
        new Grammar("～ないで", "Không làm", "見ないで答えた。", "N3"),
        new Grammar("～ながら", "Trong khi", "音楽を聴きながら勉強する。", "N3"),
        new Grammar("～ようにする", "Cố gắng để", "毎日運動するようにする。", "N3"),
        new Grammar("～ことにする", "Quyết định", "明日から勉強することにした。", "N3"),
        // N4
        new Grammar("～てから", "Sau khi ~", "ご飯を食べてから、勉強します。", "N4"),
        new Grammar("～ながら", "Vừa ~ vừa ~", "音楽を聴きながら、歩きます。", "N4"),
        new Grammar("～たり～たりする", "Lúc thì ~ lúc thì ~", "休日は映画を見たり、買い物したりします。", "N4"),
        new Grammar("～やすい", "Dễ ~", "この本は読みやすいです。", "N4"),
        new Grammar("～にくい", "Khó ~", "この問題は解きにくいです。", "N4"),
        new Grammar("～てしまう", "Hoàn thành (thường mang sắc thái tiếc nuối)", "ケーキを全部食べてしまいました。", "N4"),
        new Grammar("～なければならない", "Phải ~", "宿題をしなければなりません。", "N4"),
        new Grammar("～なくてもいい", "Không cần ~", "傘を持たなくてもいいです。", "N4"),
        new Grammar("～てもいい", "Được phép ~", "ここで写真を撮ってもいいですか。", "N4"),
        new Grammar("～と", "Nếu ~ thì ~", "ボタンを押すと、ドアが開きます。", "N4"),
        new Grammar("～ば", "Nếu ~", "早く起きれば、電車に間に合います。", "N4"),
        new Grammar("～なら", "Nếu là ~", "日本へ行くなら、寿司を食べたいです。", "N4"),
        new Grammar("～のに", "Mặc dù ~", "一生懸命勉強したのに、試験に落ちました。", "N4"),
        new Grammar("～つもり", "Dự định ~", "来年、日本へ行くつもりです。", "N4"),
        new Grammar("～予定です", "Dự kiến ~", "来週、旅行する予定です。", "N4"),
        new Grammar("～ように", "Để ~", "毎日運動するようにしています。", "N4"),
        new Grammar("～ようです", "Có vẻ như ~", "雨が降るようです。", "N4"),
        new Grammar("～かもしれない", "Có lẽ ~", "明日、雪が降るかもしれません。", "N4"),
        new Grammar("～すぎる", "Quá ~", "このスープは熱すぎます。", "N4"),
        new Grammar("～なくなる", "Hết ~", "牛乳がなくなりました。", "N4"),
        new Grammar("～ておく", "Làm trước ~ để chuẩn bị", "旅行のために荷物をまとめておきます。", "N4"),
        new Grammar("～ところ", "Vừa mới ~ / Đang ~ / Sắp ~", "今、家に帰ったところです。", "N4"),
        new Grammar("～あげる", "Cho / Làm cho (ai đó)", "友達にプレゼントをあげました。", "N4"),
        new Grammar("～くれる", "(Ai đó) cho / làm cho mình", "友達がケーキをくれました。", "N4"),
        new Grammar("～たら", "Khi ~ / Nếu ~", "時間があれば、映画を見ます。", "N4"),
         // N5
        new Grammar("～です", "Là (dùng để khẳng định)", "わたしは学生です。", "N5"),
        new Grammar("～ます", "Thì (thì hiện tại/lịch sự)", "毎日べんきょうします。", "N5"),
        new Grammar("～ません", "Không (thì phủ định)", "肉を食べません。", "N5"),
        new Grammar("～ました", "Đã (quá khứ khẳng định)", "昨日日本へ行きました。", "N5"),
        new Grammar("～ませんでした", "Đã không (quá khứ phủ định)", "昨日は飲みませんでした。", "N5"),
        new Grammar("～がほしい", "Muốn (vật)", "新しいかばんがほしいです。", "N5"),
        new Grammar("～たい", "Muốn (làm gì)", "寿司を食べたいです。", "N5"),
        new Grammar("～てください", "Hãy làm gì (mệnh lệnh nhẹ nhàng)", "ここに名前を書いてください。", "N5"),
        new Grammar("～てもいいです", "Làm gì cũng được", "たばこを吸ってもいいですか。", "N5"),
        new Grammar("～てはいけません", "Không được làm gì", "ここで写真を撮ってはいけません。", "N5"),
        new Grammar("～ながら", "Vừa làm A vừa làm B", "音楽を聞きながら勉強します。", "N5"),
        new Grammar("～たり～たりする", "Liệt kê hành động (làm A, làm B...)", "日曜日は映画を見たり、本を読んだりします。", "N5"),
        new Grammar("～のが好き", "Thích làm gì", "料理を作るのが好きです。", "N5"),
        new Grammar("～ことがある", "Đã từng", "日本へ行ったことがあります。", "N5"),
        new Grammar("～ましょう", "Rủ rê: hãy cùng làm gì", "一緒に行きましょう。", "N5"),
        new Grammar("～ましょうか", "Đề nghị làm gì cho người khác", "手伝いましょうか？", "N5"),
        new Grammar("～から", "Vì...", "寒いから、窓を閉めました。", "N5"),
        new Grammar("～ので", "Vì... (lịch sự hơn から)", "お腹が痛いので、帰ります。", "N5"),
        new Grammar("～のに", "Mặc dù...", "勉強したのに、試験に落ちました。", "N5"),
        new Grammar("～より～のほうが", "So sánh hơn", "寿司よりラーメンのほうが好きです。", "N5"),
        new Grammar("～の中で～が一番", "So sánh nhất", "果物の中で、りんごが一番好きです。", "N5"),
        new Grammar("～くて/～で", "Nối tính từ/động từ", "この店は安くて、おいしいです。", "N5"),
        new Grammar("～てもいい", "Được phép làm gì", "ここに座ってもいいですか。", "N5"),
        new Grammar("～なければなりません", "Phải làm gì", "薬を飲まなければなりません。", "N5"),
        new Grammar("～なくてもいいです", "Không cần làm gì cũng được", "明日は来なくてもいいです。", "N5")
    );

    private static final List<Exercise> exerciseData = Arrays.asList(
        // N1 Exercises (20 câu)
        new Exercise("彼の提案___納得できるものではなかった。", Arrays.asList("に", "が", "を"), "は", "N1"),
        new Exercise("この問題___解決するには、専門家の意見が必要だ。", Arrays.asList("を", "に", "で"), "を", "N1"),
        new Exercise("彼は失敗___恐れずに挑戦し続けた。", Arrays.asList("を", "に", "が"), "を", "N1"),
        new Exercise("この計画は___見直す必要がある。", Arrays.asList("を", "に", "が"), "を", "N1"),
        new Exercise("彼の行動は___理解しにくい。", Arrays.asList("を", "に", "が"), "を", "N1"),
        new Exercise("この状況___どう対応すべきか。", Arrays.asList("に", "を", "で"), "に", "N1"),
        new Exercise("彼の意見は___参考になる。", Arrays.asList("を", "に", "が"), "が", "N1"),
        new Exercise("この製品は市場___人気がある。", Arrays.asList("で", "に", "を"), "で", "N1"),
        new Exercise("彼女の話___誰もが感動した。", Arrays.asList("に", "を", "で"), "に", "N1"),
        new Exercise("この決定は会社___大きな影響を与える。", Arrays.asList("に", "を", "で"), "に", "N1"),
        new Exercise("彼は責任___果たした。", Arrays.asList("を", "に", "が"), "を", "N1"),
        new Exercise("この会議は___延期された。", Arrays.asList("が", "を", "に"), "が", "N1"),
        new Exercise("彼の提案___誰も賛成しなかった。", Arrays.asList("に", "を", "が"), "に", "N1"),
        new Exercise("この仕事は期限___間に合わない。", Arrays.asList("に", "を", "で"), "に", "N1"),
        new Exercise("彼女は困難___乗り越えた。", Arrays.asList("を", "に", "が"), "を", "N1"),
        new Exercise("この計画___成功する可能性が高い。", Arrays.asList("が", "を", "に"), "が", "N1"),
        new Exercise("彼の行動___批判された。", Arrays.asList("が", "を", "に"), "が", "N1"),
        new Exercise("この問題は慎重___扱うべきだ。", Arrays.asList("に", "を", "で"), "に", "N1"),
        new Exercise("彼女の努力___報われた。", Arrays.asList("が", "を", "に"), "が", "N1"),
        new Exercise("この状況___冷静に対処する必要がある。", Arrays.asList("に", "を", "で"), "に", "N1"),
        // N2 Exercises (20 câu)
        new Exercise("この仕事___終わるのに、3日かかった。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("彼___話はいつも面白い。", Arrays.asList("が", "の", "に"), "の", "N2"),
        new Exercise("彼の意見___、私は賛成だ。", Arrays.asList("に", "を", "が"), "に", "N2"),
        new Exercise("この本を___、とても勉強になった。", Arrays.asList("読む", "読んだ", "読み"), "読んで", "N2"),
        new Exercise("彼女は忙しい___勉強を続けた。", Arrays.asList("のに", "から", "ので"), "のに", "N2"),
        new Exercise("この計画は___進めるべきだ。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("彼は約束___守った。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("この映画は___感動した。", Arrays.asList("に", "を", "で"), "に", "N2"),
        new Exercise("彼女は毎日___練習している。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("この問題は___解決できる。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("彼の説明は___分かりやすかった。", Arrays.asList("が", "を", "に"), "が", "N2"),
        new Exercise("この仕事は___難しい。", Arrays.asList("が", "を", "に"), "が", "N2"),
        new Exercise("彼女は試験___合格した。", Arrays.asList("に", "を", "で"), "に", "N2"),
        new Exercise("この本は学生___人気がある。", Arrays.asList("に", "を", "で"), "に", "N2"),
        new Exercise("彼は責任___感じている。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("この計画は___見直す必要がある。", Arrays.asList("を", "に", "が"), "を", "N2"),
        new Exercise("彼女の努力は___認められた。", Arrays.asList("が", "を", "に"), "が", "N2"),
        new Exercise("この会議は___延期された。", Arrays.asList("が", "を", "に"), "が", "N2"),
        new Exercise("彼の提案は___採用された。", Arrays.asList("が", "を", "に"), "が", "N2"),
        new Exercise("この状況は___慎重に対応すべきだ。", Arrays.asList("に", "を", "で"), "に", "N2"),
        // N3
        new Exercise("彼に___たびに緊張します。", Arrays.asList("会う", "会った", "会うたびに"), "会うたびに", "N3"),
        new Exercise("この計画は___に失敗する。", Arrays.asList("かねない", "わけがない", "つもり"), "かねない", "N3"),
        new Exercise("最近、忙しい___だ。", Arrays.asList("ばかり", "たびに", "につれて"), "ばかり", "N3"),
        new Exercise("彼女は___っぽい性格です。", Arrays.asList("大人", "子供", "子供っぽい"), "子供っぽい", "N3"),
        new Exercise("約束を破る___いかない。", Arrays.asList("わけには", "つもり", "ように"), "わけには", "N3"),
        new Exercise("この字は___です。", Arrays.asList("読みやすい", "読みにくい", "読む"), "読みにくい", "N3"),
        new Exercise("状況が___ある。", Arrays.asList("改善しつつ", "改善して", "改善した"), "改善しつつ", "N3"),
        new Exercise("食べ___出かけた。", Arrays.asList("ず", "ないで", "て"), "ず", "N3"),
        new Exercise("彼がそんなことをする___。", Arrays.asList("わけがない", "かもしれない", "つもり"), "わけがない", "N3"),
        new Exercise("毎日運動する___する。", Arrays.asList("つもり", "ように", "予定"), "ように", "N3"),
        new Exercise("この問題を___解決しました。", Arrays.asList("完全に", "解決して", "解決"), "完全に", "N3"),
        new Exercise("健康が___大事になる。", Arrays.asList("年を取る", "年を取るにつれて", "年を取るたびに"), "年を取るにつれて", "N3"),
        new Exercise("食べて___？", Arrays.asList("みる", "てみる", "みます"), "てみる", "N3"),
        new Exercise("失敗する___がある。", Arrays.asList("おそれ", "つもり", "予定"), "おそれ", "N3"),
        new Exercise("見___答えた。", Arrays.asList("ないで", "ず", "て"), "ないで", "N3"),
        new Exercise("明日から勉強する___にした。", Arrays.asList("ことに", "つもり", "予定"), "ことに", "N3"),
        new Exercise("環境を___する。", Arrays.asList("守る", "守ります", "守りました"), "守る", "N3"),
        new Exercise("最近、___をしています。", Arrays.asList("研究", "研究する", "研究します"), "研究", "N3"),
        new Exercise("会社で___をします。", Arrays.asList("働く", "働きます", "働きました"), "働きます", "N3"),
        new Exercise("この提案は___です。", Arrays.asList("良い", "良く", "良いです"), "良い", "N3"),
        // N4
        new Exercise("この本を___か？", Arrays.asList("読みます", "読む", "読みました"), "読みます", "N4"),
        new Exercise("友達にプレゼントを___。", Arrays.asList("あげました", "くれました", "もらいました"), "あげました", "N4"),
        new Exercise("毎日運動する___しています。", Arrays.asList("つもり", "ように", "予定"), "ように", "N4"),
        new Exercise("このスープは___です。", Arrays.asList("熱い", "熱すぎる", "熱く"), "熱すぎる", "N4"),
        new Exercise("宿題を___なければなりません。", Arrays.asList("する", "して", "し"), "し", "N4"),
        new Exercise("ここで写真を___いいですか。", Arrays.asList("撮って", "撮っても", "撮り"), "撮っても", "N4"),
        new Exercise("日本へ行く___、寿司を食べたい。", Arrays.asList("なら", "ば", "と"), "なら", "N4"),
        new Exercise("ご飯を___、勉強します。", Arrays.asList("食べてから", "食べながら", "食べたり"), "食べてから", "N4"),
        new Exercise("この問題は___です。", Arrays.asList("解きやすい", "解きにくい", "解く"), "解きにくい", "N4"),
        new Exercise("ケーキを全部___。", Arrays.asList("食べてしまった", "食べた", "食べる"), "食べてしまった", "N4"),
        new Exercise("この服は___です。", Arrays.asList("古い", "新しい", "安い"), "古い", "N4"),
        new Exercise("彼は___を話します。", Arrays.asList("英語", "日本語", "外国語"), "英語", "N4"),
        new Exercise("朝ご飯を___。", Arrays.asList("食べる", "食べます", "食べました"), "食べます", "N4"),
        new Exercise("医者に___。", Arrays.asList("なる", "なります", "なりました"), "なる", "N4"),
        new Exercise("時間に___。", Arrays.asList("間に合う", "間に合います", "間に合いました"), "間に合います", "N4"),
        new Exercise("会社で___します。", Arrays.asList("働く", "働きます", "働きました"), "働きます", "N4"),
        new Exercise("この部屋は___です。", Arrays.asList("狭い", "広い", "高い"), "狭い", "N4"),
        new Exercise("友達に手紙を___。", Arrays.asList("書く", "書きます", "書きました"), "書きます", "N4"),
        new Exercise("傘を___なくてもいいです。", Arrays.asList("持つ", "持た", "持ち"), "持た", "N4"),
        new Exercise("旅行する___です。", Arrays.asList("予定", "つもり", "ように"), "予定", "N4"),
          // N5
        new Exercise("わたし___学生です。", Arrays.asList("が", "を", "は"), "は", "N5"),
        new Exercise("昨日は雨___降りました。", Arrays.asList("を", "が", "で"), "が", "N5"),
        new Exercise("コーヒーを___か？", Arrays.asList("飲みます", "飲みました", "飲みませんか"), "飲みませんか", "N5"),
        new Exercise("いっしょに映画を___か？", Arrays.asList("見ましょう", "見ました", "見ません"), "見ましょう", "N5"),
        new Exercise("パンを___、牛乳を飲みました。", Arrays.asList("食べて", "食べた", "食べます"), "食べて", "N5"),
        new Exercise("これは田中さん___かばんです。", Arrays.asList("の", "が", "を"), "の", "N5"),
        new Exercise("教室に先生が___。", Arrays.asList("います", "あります", "いきます"), "います", "N5"),
        new Exercise("私はにほんごを___。", Arrays.asList("べんきょうします", "ききます", "たべます"), "べんきょうします", "N5"),
        new Exercise("今朝、６時に___。", Arrays.asList("おきました", "ねました", "いきました"), "おきました", "N5"),
        new Exercise("日本語の新聞が___。", Arrays.asList("読めます", "書けます", "飲めます"), "読めます", "N5"),
        new Exercise("どこでこの本を___か？", Arrays.asList("買いました", "聞きました", "読みました"), "買いました", "N5"),
        new Exercise("日曜日にともだちと___。", Arrays.asList("あそびました", "はなしました", "かきました"), "あそびました", "N5"),
        new Exercise("この店はやすくて、___。", Arrays.asList("おいしいです", "ひろいです", "たかいです"), "おいしいです", "N5"),
        new Exercise("でんしゃに___、かいしゃへ行きます。", Arrays.asList("のって", "はいって", "あらって"), "のって", "N5"),
        new Exercise("わたしの趣味は___ことです。", Arrays.asList("およぐ", "はなす", "きく"), "およぐ", "N5"),
        new Exercise("けさ、朝ごはんを___ませんでした。", Arrays.asList("食べ", "飲み", "行き"), "食べ", "N5"),
        new Exercise("雨がふっている___、出かけます。", Arrays.asList("けれど", "ので", "から"), "けれど", "N5"),
        new Exercise("たなかさんは　とても___人です。", Arrays.asList("しんせつな", "にぎやかな", "へんな"), "しんせつな", "N5"),
        new Exercise("どようびは　なにを　___か？", Arrays.asList("します", "いきます", "のみます"), "します", "N5"),
        new Exercise("すみません、えきは　どこ___　ありますか？", Arrays.asList("に", "で", "を"), "に", "N5")
    );
    List<String> words = vocabularyRepository.findAllWords(); 
private static final List<Reading> readingData = List.of(
    new Reading(
        "Bài 1: Cuộc sống hàng ngày - 日常生活",
        """
        わたしは まいにち 6じに おきます。そして、7じに あさごはんを たべます。
        """,
        "Tôi dậy lúc 6 giờ mỗi sáng và ăn sáng lúc 7 giờ.",
        List.of(
            new Reading.QA("わたしは 何時に おきますか？", "6時に起きます。", "Tôi thức dậy lúc 6 giờ."),
            new Reading.QA("あさごはんを たべるのは 何時ですか？", "7時に朝ごはんを食べます。", "Ăn sáng lúc 7 giờ.")
        ),
        "N5"
    ),
    new Reading(
        "Bài 2: Cuối tuần của tôi - 私の週末",
        """
        現在、私は会社員をしています。どようびと にちようびに、わたしは ともだちと あそびます。えいがを みたり、こうえんで さんぽしたり します。
        """,
        "Hiện tại, tôi đang là một nhân viên văn phòng. Thứ 7 và chủ nhật, tôi cùng bạn đi chơi. Chúng tôi cùng xem phim, đi dạo trong công viên",
        List.of(
            new Reading.QA("どんなことを しますか？", "かいしゃいんです", "Nhân viên văn phòng"),
            new Reading.QA("どようびと にちようびに 何を しますか？", "えいがを みたり、こうえんで さんぽしたり します。", "Chúng tôi cùng xem phim, đi dạo trong công viên")
        ),
        "N5"
    ),
    new Reading(
        "Bài 3: Mua sắm -  買い物",
        """
        スーパーに行く前に、私はメモを作ります。今日は牛乳と卵とパンを買います。でも、スーパーに行ったとき、チョコレートも買ってしまいました。
        """,
        "Trước khi đi siêu thị, tôi ghi chú: Hôm nay tôi sẽ mua sữa, trứng và bánh mì. Nhưng khi đi siêu thị, tôi cũng mua một ít sô cô la.",
        List.of(
            new Reading.QA("メモに書いてあったものは何ですか？", "今日は牛乳と卵とパンを買います。でも、スーパーに行ったとき", "Hôm nay tôi sẽ mua sữa, trứng và bánh mì"),
            new Reading.QA("チョコレートはメモにありましたか？", "チョコレートはメモにありましたか？", "メモにはチョコレートはありません")
        ),
        "N5"
    ),
    new Reading(
        "Bài 4: Thời tiết - 天気",
        """
        昨日は朝から雨でした。午後になると、風も強くなりました。だから、友だちとの約束をキャンセルしました。
        """,
        "Hôm qua trời mưa từ sáng. Chiều gió mạnh hơn nên tôi phải hủy bỏ kế hoạch đi chơi với bạn.",
        List.of(
            new Reading.QA("昨日はどんな天気でしたか？", "昨日は朝から雨でした。午後になると、風も強くなりました。", "Hôm qua trời mưa từ sáng. Chiều gió mạnh hơn"),
            new Reading.QA("どうして友だちに会いませんでしたか？", "雨が降ったため、午後は風が強くなりました。", "Vì trời mưa, chiều thì gió mạnh hơn ")
        ),
        "N5"
    ),
    new Reading(
        "Bài 5: Con chó của Tanaka -  田中さんの犬",
        """
        田中さんの家には白くて小さい犬がいます。その犬の名前は「しろ」です。毎日、田中さんと一緒に散歩します。
        """,
        "Tanaka-san có một chú chó nhỏ màu trắng. Tên của nó là Shiro. Nó đi dạo cùng Tanaka-san mỗi ngày.",
        List.of(
            new Reading.QA("犬の名前は何ですか？", "その犬の名前は「しろ」です。", "Tên của nó là Shiro."),
            new Reading.QA("田中さんは毎日犬と何をしますか？", "毎日、田中さんと一緒に散歩します。", "Nó đi dạo cùng Tanaka-san mỗi ngày.")
        ),
        "N5"
    ),
    new Reading(
        "Bài 6: 4 mùa của Nhật Bản - 日本の四季 ",
        """
        日本には春、夏、秋、冬の四つの季節があります。春は桜が咲いて、とてもきれいです。夏は暑いですが、海や花火大会を楽しめます。秋は涼しくて、山や公園の木が赤や黄色になります。冬は雪が降る地域もあり、スキーや温泉が人気です。季節によって、いろいろな楽しみ方があります。
        """,
        "Nhật Bản có bốn mùa: xuân, hạ, thu, đông. Mùa xuân, hoa anh đào nở rộ, đẹp tuyệt vời. Mùa hè nóng nực nhưng bạn vẫn có thể tận hưởng bãi biển và lễ hội pháo hoa. Mùa thu mát mẻ, cây cối trên núi và công viên chuyển sang màu đỏ vàng. Mùa đông, tuyết rơi ở một số khu vực, và trượt tuyết cùng suối nước nóng là những hoạt động được ưa chuộng. Có rất nhiều cách để tận hưởng mỗi mùa.",
        List.of(
            new Reading.QA("春にはどんな花が咲きますか？", "春は桜が咲いて、とてもきれいです", "Mùa xuân, hoa anh đào nở rộ, đẹp tuyệt vời."),
            new Reading.QA("冬はなぜ人気がありますか？", "スキーや温泉が人気です", "trượt tuyết cùng suối nước nóng là những hoạt động đục ưa chuộng")
        ),
        "N5"
    ),
    new Reading(
        "Bài 7: Chuyến đi đầu tiên đến Nhật Bản - 初めての日本旅行",
        """
        去年の夏、私は初めて日本へ旅行しました。東京や京都、大阪などをまわりました。東京では高いビルやにぎやかな街を見て、京都ではお寺や神社を訪れました。大阪ではお好み焼きやたこ焼きを食べました。日本の人たちはとても親切で、道に迷ったときも丁寧に教えてくれました。また日本に行きたいと思っています。
        """,
        "Hè năm ngoái, tôi đi du lịch Nhật Bản lần đầu tiên. Tôi đã đi vòng quanh Tokyo, Kyoto, Osaka và nhiều thành phố khác. Ở Tokyo, tôi được chiêm ngưỡng những tòa nhà cao tầng và những con phố nhộn nhịp, còn ở Kyoto, tôi được ghé thăm các đền chùa. Ở Osaka, tôi được thưởng thức okonomiyaki và takoyaki. Người Nhật rất tốt bụng, họ đã kiên nhẫn giúp đỡ tôi khi tôi bị lạc. Tôi rất muốn quay lại Nhật Bản.",
        List.of(
            new Reading.QA("大阪で何をしましたか？", "大阪ではお好み焼きやたこ焼きを食べました", "Ở Osaka, tôi đã ăn okonomiyaki và takoyaki."),
            new Reading.QA("日本の人たちはどうでしたか？", "日本の人たちはとても親切で、道に迷ったときも丁寧に教えてくれました", "Người Nhật rất tốt bụng, họ đã kiên nhẫn giúp đỡ tôi khi tôi bị lạc. ")
        ),
        "N5"
    ),
    new Reading(
        "Bài 8: Bạn làm gì cho sức khỏe của mình - 健康のためにしていること",
        """
        私は健康のために毎朝ジョギングをしています。最初は10分しか走れませんでしたが、今は30分ぐらい走れるようになりました。また、毎日野菜をたくさん食べるようにしています。たまに甘いものも食べますが、食べすぎないように気をつけています。健康な体は、毎日の小さな努力から作られると思います。
        """,
        "Tôi chạy bộ mỗi sáng để giữ gìn sức khỏe. Ban đầu, tôi chỉ chạy được 10 phút, nhưng giờ tôi có thể chạy được khoảng 30 phút. Tôi cũng cố gắng ăn nhiều rau mỗi ngày. Thỉnh thoảng tôi cũng ăn đồ ngọt, nhưng cố gắng không ăn quá nhiều. Tôi tin rằng một cơ thể khỏe mạnh được xây dựng từ những nỗ lực nhỏ mỗi ngày.",
        List.of(
            new Reading.QA("ジョギングはどれくらいできるようになりましたか？", "最初は10分しか走れませんでしたが、今は30分ぐらい走れるようになりました。", "Ban đầu, tôi chỉ chạy được 10 phút, nhưng giờ tôi có thể chạy được khoảng 30 phút"),
            new Reading.QA("この人は健康のために何をしていますか？", "私は健康のために毎朝ジョギングをしています。毎日野菜をたくさん食べるようにしています。", "Tôi chạy bộ mỗi sáng để giữ gìn sức khỏe. Tôi cố gắng ăn nhiều rau mỗi ngày.")
        ),
        "N5"
    ),
    new Reading(
        "Bài 9: Cuộc sống của sinh viên quốc tế - 留学生の生活",
        """
        私はベトナムから来た留学生です。今、日本の大学で経済を勉強しています。最初は日本語が難しくて、授業についていくのが大変でした。でも、毎日少しずつ勉強して、先生や友だちにもたくさん助けてもらいました。今では、日本での生活にも慣れて、アルバイトも始めました。将来は日本の会社で働きたいと思っています。
        """,
        "Tôi là du học sinh đến từ Việt Nam. Hiện tôi đang theo học ngành kinh tế tại một trường đại học Nhật Bản. Ban đầu, tiếng Nhật khá khó và tôi gặp khó khăn trong việc theo kịp các bài giảng. Tuy nhiên, tôi đã cố gắng học mỗi ngày và nhận được rất nhiều sự giúp đỡ từ thầy cô và bạn bè. Hiện tại, tôi đã quen với cuộc sống ở Nhật và bắt đầu đi làm thêm. Trong tương lai, tôi muốn làm việc cho một công ty Nhật Bản.",
        List.of(
            new Reading.QA("最初に何が大変でしたか？", "最初は日本語が難しくて、授業についていくのが大変でした。", " Ban đầu, tiếng Nhật khá khó và tôi gặp khó khăn trong việc theo kịp các bài giảng."),
            new Reading.QA("今はどんな生活をしていますか？", "今では、日本での生活にも慣れて、アルバイトも始めました。", "Hiện tại, tôi đã quen với cuộc sống ở Nhật và bắt đầu đi làm thêm.")
        ),
        "N5"
    ),
    new Reading(
        "Bài 10: Ngày khó quên - 忘れられない日",
        """
        先月のある日、私は大学へ行く途中で財布を落としてしまいました。気がついたときには、もうバスの中でした。とても困って、すぐにバスを降りて元の道を戻りました。しかし、どこにも財布は見つかりませんでした。その日は大切なテストがあったのに、試験のことも忘れるくらい心配していました。仕方なく大学へ行ったら、受付で「これ、あなたのですか？」と言われて、なんと誰かが私の財布を届けてくれていたのです。中身も何もなくなっていませんでした。親切な人がいるんだなと、本当に感動しました。その日から、私も困っている人を助けるように心がけています。
        """,
        "Một ngày nọ trong tháng trước, trên đường đến trường đại học, tôi đã làm rơi ví. Khi nhận ra thì tôi đã ở trên xe buýt. Tôi rất lo lắng, lập tức xuống xe và quay lại con đường đã đi. Tuy nhiên, tôi không tìm thấy ví ở đâu cả. Hôm đó tôi có một bài kiểm tra quan trọng, nhưng tôi lo lắng đến mức quên cả việc thi cử. Không còn cách nào khác, tôi đành đến trường, và tại quầy tiếp tân, một người hỏi: “Đây có phải ví của bạn không?” Thật bất ngờ, ai đó đã nhặt và mang ví đến giao lại. Mọi thứ trong ví vẫn còn nguyên vẹn. Tôi thực sự xúc động vì lòng tốt của người đó. Kể từ hôm ấy, tôi luôn cố gắng giúp đỡ những người gặp khó khăn.",
        List.of(
            new Reading.QA("財布が見つからなかったとき、この人はどんな気持ちでしたか？", "心配です", "lo lắng"),
            new Reading.QA("あなたなら、このような経験のあとで何を考えますか？", "もっと注意して、同じような困難な状況にある他の人を助けるように自分自身に言い聞かせてください。", "Nhắc nhở bản thân cẩn thận hơn và giúp đỡ người khác trong những hoàn cảnh khó khăn tương tự")
        ),
        "N5"
    )
);

// ========= SEED DỮ LIỆU LISTENING =========
private static final List<Listening> listeningData = List.of(
    new Listening(
        "第13課 問題 1 - Mondai 1",
        "/audio/listening/mondai13-1.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: あなたは　サントスさんですか？
        2: おなまえは？
        3: なんさいですか？
        4: アメリカ人ですか？
        5: かいしゃいんですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 3 - Mondai 1",
        "/audio/listening/mondai13-2.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: お国はどちらですか？
        2: うちはどちらですか？
        3: あなたのとけいはどこのとけいですか？
        4: あなたのカメラは日本のですか？
        5: あなたのカメラはいくらですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 2 - Mondai 1",
        "/audio/listening/mondai13-3.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: これは　てちょううですか？
        2: これは　'あ'ですか　'お'ですか？
        3: これは　なんですか？
        4: これは　なんの　ざっしですか？
        5: このかばんはあなたのですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 4 - Mondai 1",
        "/audio/listening/mondai14-4.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: 今何時ですか？
        2: あなたの国の銀行は何時からなんじまですか？
        3: 毎日なんじにおきますか？
        4: きのうべんきょうしましたか？
        5: あなたのうちの電話番号は何番ですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 6 - Mondai 1",
        "/audio/listening/mondai15-5.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: あなたはたばこをすいますか？
        2: まあさ　新聞を読みますか？
        3: けさ　何を飲みましたか？
        4: あした　何をしますか？
        5: いつも　どこで　昼ごはんをたべますか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 8 - Mondai 1",
        "/audio/listening/mondai16-6.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: 家族は天気ですか？
        2: あなたの国は暑いですか？
        3: 仕事は　おもしろいですか？
        4: あなたの国はどんな国ですか？
        5: 日本語はどうですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 5 - Mondai 1",
        "/audio/listening/mondai17-7.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: 日曜日　どこへ　いきますか？
        2: 何で　スーパーへ　いきますか？
        3: だれと　スーパーへ　いきますか？
        4: きのうどこへいきましたか？
        5: 誕生日は何月何日ですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 9 - Mondai 1",
        "/audio/listening/mondai18-8.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: お母さんは　料理　が上手ですか？
        2: どんな　スポーツが好きですか？
        3: 今晩約束がありますか？
        4: かんじがわかりますか？
        5: どうして日本語を勉強しますか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 7 - Mondai 1",
        "/audio/listening/mondai19-9.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: もうばんごはんをたべましたか？
        2: なんでごはんをたべますか？
        3: 去年の誕生日にプレゼントもらいましたか？
        4: お母さんの誕生あげますか？
        5: 'Thank you' は日本語でなんですか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    ),
    new Listening(
        "第13課 問題 10 - Mondai 1",
        "/audio/listening/mondai20-10.mp3",
        "Nghe đoạn hội thoại và trả lời câu hỏi.",
        """
        1: あなたは今いきますか
        2: あなたのうちに犬がいますか
        3: あなたの部屋に時計がありますか？
        4: 日本語のじしょはどこにありますか？
        5: うちの近くに何がありますか？
        """,
        List.of("1.", "2.", "3.", "4.", "5."),
        "N5"
    )
);
 @GetMapping("/reading")
    public String readingPage(Model model) {
        model.addAttribute("readings", readingData);
        return "reading"; // file reading.html
    }

    // Mapping cho Listening
    @GetMapping("/listening")
    public String listeningPage(Model model) {
        model.addAttribute("listenings", listeningData);
        return "listening"; // file listening.html
    }

@Autowired
    private UserService userService;

    // HIỂN THỊ FORM LOGIN/REGISTER (giao diện chung login.html)
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "login"; // login.html chứa cả form đăng nhập & đăng ký
    }

    // XỬ LÝ ĐĂNG NHẬP
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        // Demo tạm hardcode admin, sau này thay bằng userService.login(...)
        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            return "redirect:/main"; // login thành công thì sang main.html
        } else {
            model.addAttribute("message", "Sai tài khoản hoặc mật khẩu!");
            model.addAttribute("user", new User());
            return "login";
        }
    }

    // HIỂN THỊ FORM ĐĂNG KÝ (cũng dùng login.html)
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "login"; // cùng trang login.html nhưng hiện form đăng ký
    }

    // XỬ LÝ ĐĂNG KÝ
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user, Model model) {
        boolean ok = userService.register(user.getUsername(), user.getPassword(), user.getEmail());
        if (ok) {
            model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
            model.addAttribute("user", new User());
            return "login";
        } else {
            model.addAttribute("message", "Tên tài khoản đã tồn tại hoặc không hợp lệ.");
            model.addAttribute("user", new User());
            return "login"; // vẫn trả về login.html nhưng hiển thị form đăng ký
        }
    }

    // XỬ LÝ RESET PASSWORD
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String newPassword, Model model) {
        // TODO: gọi userService để lưu mật khẩu mới
        model.addAttribute("message", "Mật khẩu đã được đặt lại thành công.");
        model.addAttribute("user", new User());
        return "login";
    }

    // ĐIỀU HƯỚNG TRANG CHÍNH (main.html)
    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("title", "日本語学習");
        return "main"; // main.html
    }

    // XỬ LÝ LOGOUT
    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("message", "Bạn đã đăng xuất thành công.");
        return "login";
    }
    
    @GetMapping("/level/{level}")
    public String levelPage(@PathVariable String level, Model model) {
        List<Vocabulary> levelVocab = vocabularyData.stream()
            .filter(v -> v.getLevel().equalsIgnoreCase(level))
            .collect(Collectors.toList());
        List<Kanji> levelKanji = kanjiData.stream()
            .filter(k -> k.getLevel().equalsIgnoreCase(level))
            .collect(Collectors.toList());
        List<Grammar> levelGrammar = grammarData.stream()
            .filter(g -> g.getLevel().equalsIgnoreCase(level))
            .collect(Collectors.toList());
        List<Exercise> levelExercise = exerciseData.stream()
            .filter(e -> e.getLevel().equalsIgnoreCase(level))
            .collect(Collectors.toList());

        System.out.println("Level: " + level);
        System.out.println("Vocabulary size: " + levelVocab.size());
        System.out.println("Kanji size: " + levelKanji.size());
        System.out.println("Grammar size: " + levelGrammar.size());
        System.out.println("Exercise size: " + levelExercise.size());

        model.addAttribute("title", "Cấp độ " + level.toUpperCase());
        model.addAttribute("vocabularyList", levelVocab);
        model.addAttribute("kanaList", levelKanji);
        model.addAttribute("grammarList", levelGrammar);
        model.addAttribute("exerciseList", levelExercise);
        model.addAttribute("level", level.toLowerCase());
        return level.toLowerCase(); // Giữ nguyên cách ban đầu
    }
}
