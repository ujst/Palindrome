package Implementation; /**
 * Created by VV on 18.12.2016.
 */

import Interfaces.InputInterface;
import DataWork.TextWork;

import java.io.IOException;

class PalindromeFile {
    public static void main(String[] args) throws IOException {
        TextWork data = new TextWork();
        data.createFile();
        data.typeData();
        data.checkIfPalindrome();
        data.saveData();
        data.readData();

    }

}