package Implementation;

import DataWork.TextWork;
import java.io.IOException;
import static Base.Text.CONSTANT;

class PalindromeFile {

    public static void main(String[] args) throws IOException {
        TextWork data = new TextWork();

        data.createFile();

        for (int i = 1; i < CONSTANT; i++) {
            data.typeData();
            if(data.checkIfPalindrome())
                break;
        }

        data.saveData();
        data.readData();
    }
}