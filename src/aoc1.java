import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class aoc1 {
    static String[] integers = {"one","two","three","four","five","six","seven","eight","nine"};

    static int numberFromString(String s){
        int res =0;
        int dec =0;
        int other =0;
        char ch;
        int i =0;
        boolean verif =false;
        String subString ="";
        while(i < s.length()){
            subString+=s.charAt(i);
            verif = false;
            for (int j = 0; j < integers.length; j++) {
                if(integers[j].contains(subString)){
                    verif = true;
                }if (integers[j].equals(subString)) {
                    subString = s.charAt(i)+"";
                    if(dec==0){
                        res = j+1;
                        dec = res;
                    }
                    else {
                        
                        other = j+1;
                        
                    }
                }
            }
            if (!verif) {
                // System.out.println(subString);
                subString=s.charAt(i)+"";
            }
            ch =s.charAt(i);
            if(ch <='9' && ch >='0'){
                if(dec==0){
                    res = ch - '0';
                    dec = res;
                }
                else {
                    
                    other = ch- '0';
                    
                }
            }
            i++;
        }
            
        // System.out.println(dec*10 + other);
        if(other==0) { System.out.println(dec*10+dec);
            return dec*10+dec;}
            System.out.println(dec*10+other);
        return dec*10 + other;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./res/aoc1.txt"));
            int res = 0;
            while(sc.hasNextLine()){
                res += numberFromString(sc.nextLine());
                // System.out.println(res);
            }
            System.out.println(res);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // System.out.println(numberFromString("jjhxddmg5mqxqbgfivextlcpnvtwothreetwonerzk"));
    }
}
