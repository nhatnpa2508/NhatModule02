import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        System.out.println("Count characters in the string.");
        String str = "Mua thu chim cu teo top.";
        System.out.println("String: "+str);
        char character = ' ';
        try{
            System.out.println("Enter character you want to count: ");
            character = (char) System.in.read();
            System.out.println("Character: " + character);
        }catch(Exception e){
            System.out.println("Wrong input!");
        }
        int lengthStr = str.length();
        int count = 0;
        for (int i = 0; i < lengthStr; i++){
            if (str.charAt(i) == character)
                count++;
        }
        System.out.println("Character '" +character+ "' in the string is: "+count);
    }
}
