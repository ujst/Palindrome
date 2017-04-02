package DataWork;

import Base.Text;
import Base.DataFile;
import Interfaces.InputInterface;
import Interfaces.PalindromeInterface;
import Interfaces.CreateSaveIntoFileInterface;
import Interfaces.ReadDatafromFileInterface;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Scanner;


public class TextWork implements InputInterface, CreateSaveIntoFileInterface, PalindromeInterface, ReadDatafromFileInterface {

    Text workText = new Text();
    DataFile workFile = new DataFile();

    FileWriter writeText;
    FileReader readText;

    Scanner scan = new Scanner(System.in);

    @Override
    synchronized public void createFile() throws IOException {
        //File baseFile = new File ("d:\\Palindrome.txt");
        workFile.setDataFile(new File("d:\\Palindrome.txt"));

        writeText = new FileWriter(workFile.getDataFile(), true);

        writeText.write("This is a text File.\n ");

        writeText.close();

//        BufferedReader reader = new BufferedReader(new FileReader(workFile.getDataFile()));
//
//        while (reader.readLine() != null)
//            System.out.println(reader.readLine());

    }

    @Override
    synchronized public void typeData() {
        System.out.print("Введите данные: ");
        String text = scan.nextLine();
        workText.setTextData(text);
    }

    @Override
    synchronized public void checkIfPalindrome() {

        String newText = workText.getTextData();
        StringBuffer textField = new StringBuffer(newText.subSequence(0, newText.length()));

        if (textField.equals(textField.reverse())) {
            workText.setTextData(textField.toString().toUpperCase());
            System.out.println(workText.getTextData());
        }

    }


    @Override
    synchronized public void saveData() throws IOException {

        FileWriter writeNewText = new FileWriter(workFile.getDataFile(), true);

        writeNewText.write(workText.getTextData());
        writeNewText.close();
        System.out.println(" ");

    }

    @Override
    synchronized public void readData() throws IOException {

//        readText = new FileReader(workFile.getDataFile());


        BufferedReader reader = new BufferedReader(new FileReader(workFile.getDataFile()));

//        while (reader.readLine() != null)
            System.out.println("Вывод итогового текста: " + reader.readLine());

//        System.out.println("Вывод итогового текста: " + workText.getTextData());

    }

}

