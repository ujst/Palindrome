package Base;

public class Text {
    public static final int CONSTANT = 1000;

    public static final String SEPARATOR = "\r\n";

    private String textData;

    public String getTextData() {
        return textData;
    }

    public void setTextData(String words) {
        this.textData = words;
    }

    private String textPalindrome;


    public String getTextPalindrome() {
        return textPalindrome;
    }

    public void setTextPalindrome(String textPalindrome) {
        this.textPalindrome = textPalindrome;
    }
}
