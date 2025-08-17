public class Kanji {
    private String kanji;
    private String onyomi;
    private String kunyomi;
    private String meaning;
    private String example;
    private String level; // hoặc field gì đó bạn muốn thêm

    public Kanji(String kanji, String onyomi, String kunyomi, String meaning, String example) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.example = example;
    }

    //  Constructor 6 tham số
    public Kanji(String kanji, String onyomi, String kunyomi, String meaning, String example, String level) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.example = example;
        this.level = level;
    }

}
