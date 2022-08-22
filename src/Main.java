import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        File directoryPath = new File(".");
        File filesList[] = directoryPath.listFiles();
        for(File file : filesList)
        {
            if(file.getName().contains(".txt"))
            {
                try
                {
                    File myObj = new File(file.getAbsolutePath());
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine())
                    {
                        String data = myReader.nextLine();
                        String numberString = data.replaceAll("[^0-9]"," ");
                        numberString=numberString.trim();
                        numberString = numberString.replaceAll(" + ", " ");
                        String[] numbers=numberString.split(" ");

                        for(String number : numbers)
                        {
                            if(Integer.parseInt(number)>=10)
                            {
                                System.out.println(data);
                                break;
                            }
                        }
                    }
                    myReader.close();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }
}