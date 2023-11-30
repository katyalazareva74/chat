package chat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveLoad implements InputOutput {
    public void savechat(String str){
        try(FileWriter fw = new FileWriter("data.txt", true)){
            fw.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public StringBuilder loadchat(){
        try(FileReader fr = new FileReader("data.txt"); Scanner sc = new Scanner(fr)) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()){
                sb.append(sc.nextLine()+"\n");
            }
            return sb;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
