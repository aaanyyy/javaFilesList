import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter a path to a directory");
        Scanner s=new Scanner(System.in);
        String path=s.nextLine();
        File file = new File(path);
        if (!file.exists())
        {System.out.println("no such directory");
            return;}

        if(file.isFile())
        {System.out.println("it is a file, not directory");
            return;}

        printList(path);
    }

    static void printList(String fileName) {

        File file=new File(fileName);
        Arrays.stream(file.listFiles()).filter(f -> f.isDirectory()).forEach(f -> {


            printList(f.getAbsolutePath());

        });
        Arrays.stream(file.listFiles()).filter(f->f.isFile()).filter(f->{
            String []arr=f.getName().split("\\.");

            if(arr.length>0&&arr[arr.length-1].contentEquals("java")) return true;
            else return false;
        }).forEach(f->{
            System.out.println(f.getAbsolutePath().replace("\\.\\","\\"));

        });
    }
}
