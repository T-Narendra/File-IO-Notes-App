package IntershipTasks;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class NotesApp {
    private static final String FILE_NAME="notes.txt";
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("------Welcome to Notes App------");
        System.out.println("Enter 1 to write a new Note");
        System.out.println("Enter 2 to Read existing Note");
        System.out.println("Enter 3 to Exit");
        System.out.println("Enter your choice:");
        int choice=s.nextInt();
        s.nextLine();
        switch(choice){
            case 1:
                writeNotes(s);
                break;
            case 2:
                readNotes();
                break;
            case 3:
                System.out.println("Exting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
        s.close();
    }
    private static void writeNotes(Scanner s){
        System.out.println("Enter a note to add :");
        String note=s.nextLine();
        try(FileWriter fileWriter=new FileWriter(FILE_NAME,true)){
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            System.out.println("Writing a file at:"+ new File(FILE_NAME).getAbsolutePath());
            bufferedWriter.write(note);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Note saved successfully");
        }
        catch(IOException e){
            System.out.println("Some error occured while writing note"+e.getMessage());
        }
    }
    private static void readNotes(){
        System.out.println("--------Your Note--------");
        try(FileReader fileReader=new FileReader(FILE_NAME)){
            BufferedReader bufferedReader= new BufferedReader(fileReader);
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println("Some error occured while reading the notes"+e.getMessage());
        }
    }

}
