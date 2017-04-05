package DataWork;

import Base.Text;
import Base.DataFile;
import Interfaces.InputInterface;
import Interfaces.PalindromeInterface;
import Interfaces.CreateSaveIntoFileInterface;
import Interfaces.ReadDatafromFileInterface;

import java.io.*;
import java.util.Scanner;

import static Base.Text.SEPARATOR;


public class TextWork implements InputInterface, CreateSaveIntoFileInterface, PalindromeInterface, ReadDatafromFileInterface {

    Text workText = new Text();
    DataFile workFile = new DataFile();

    FileWriter writeText;

    Scanner scan = new Scanner(System.in);

    @Override
    public void createFile() throws IOException {

        workFile.setDataFile(new File("d:\\Palindrome.txt"));

        writeText = new FileWriter(workFile.getDataFile(), true);
        writeText.write("This is a text File.\n ");
        writeText.close();

    }

    @Override
    public void typeData() {
        System.out.print("Введите данные: ");
        String text = scan.nextLine();
        workText.setTextData(text);
    }

    @Override
    public Boolean checkIfPalindrome() {

        Boolean result = false;

        String newText = workText.getTextData();
        StringBuffer textField = new StringBuffer(newText.subSequence(0, newText.length()));

        String a = textField.toString();
        String b = textField.reverse().toString();

        if (a.compareTo(b) == 0) {
            workText.setTextPalindrome(textField.toString().toUpperCase());
            System.out.println("Сохраняем в файл палиндром: " + workText.getTextPalindrome());
            result = true;
        } else {
            System.out.println("Введенное слово - не палиндром. ");
        }

        return result;
    }


    @Override
    public void saveData() throws IOException {

        FileWriter writeNewText = new FileWriter(workFile.getDataFile(), true);

        writeNewText.write(SEPARATOR + workText.getTextPalindrome() + ". ");
        writeNewText.close();

        System.out.println(" ");

    }

    @Override
    public void readData() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(workFile.getDataFile()));

        System.out.println("Вывод текста с файла " + workFile.getDataFile() + " : ");
        while (reader.ready())
            System.out.println(reader.readLine());

        reader.close();

    }

}

