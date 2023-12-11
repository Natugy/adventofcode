import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aoc3 {
    static int resolver1(String[] strTab){
        
        int i =0;
        int j=0;
        List<Integer> validNumber = new ArrayList<>();
        String subString ="";
        boolean valid = false;
        char ch;
        char caca;
        while (i<strTab.length) {
            j =0;
            subString = "";
            valid = false;
            while (j<strTab[i].length()) {
                ch= strTab[i].charAt(j);
                if(ch <='9' && ch >='0'){
                    subString+=ch;
                }else {
                    if(valid) validNumber.add(Integer.valueOf(subString));
                    subString="";
                }
                if(!subString.isEmpty() && !valid){
                    if (i>0 && strTab[i-1].charAt(j)!='.' && !(strTab[i-1].charAt(j) <='9' && strTab[i-1].charAt(j) >='0')) {
                        valid = true;
                    }
                    if (i>0 && j<0&& strTab[i-1].charAt(j-1)!='.' && !(strTab[i-1].charAt(j-1) <='9' && strTab[i-1].charAt(j-1) >='0')) {
                        valid = true;
                    }
                    if (i>0 && j<strTab[i].length()-1&& strTab[i-1].charAt(j+1)!='.' && !(strTab[i-1].charAt(j+1) <='9' && strTab[i-1].charAt(j+1) >='0')) {
                        valid = true;
                    }
                    
                    if (i<strTab.length-1 && j>0 && strTab[i+1].charAt(j-1)!='.' && !(strTab[i+1].charAt(j-1) <='9' && strTab[i+1].charAt(j-1) >='0')) {
                        valid = true;
                    }
                    if (i<strTab.length-1 && j<strTab[i].length()-1&& strTab[i+1].charAt(j+1)!='.' && !(strTab[i+1].charAt(j+1) <='9' && strTab[i+1].charAt(j+1) >='0')) {
                        valid = true;
                    }
                    if (i<strTab.length-1 && strTab[i+1].charAt(j)!='.' && !(strTab[i+1].charAt(j) <='9' && strTab[i+1].charAt(j) >='0')) {
                        valid=true;
                    }
                    if(j<strTab[i].length()-1 && strTab[i].charAt(j+1)!='.' && !(strTab[i].charAt(j+1) <='9' && strTab[i].charAt(j+1) >='0')){
                        valid = true;
                     }
                     if(j>0 && strTab[i].charAt(j-1)!='.' && !(strTab[i].charAt(j-1) <='9' && strTab[i].charAt(j-1) >='0')){
                        valid = true;
                     }
                     
                }else{
                    valid =false;
                }
                j++;
            }
            i++;
        }
        int res =0;
        for (Integer integer : validNumber) {
            // System.out.println(integer);
            res+=integer;
        }
        return res;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./res/aoc3.txt"));
            int res = 0;
            List<String> engine = new ArrayList<>();
            int i=0;
            while(sc.hasNextLine()){
                // System.out.println(res);
                engine.add(sc.nextLine());
            }
            String[] test= new String[engine.size()];
            for (int j = 0; j < test.length; j++) {
                test[j] = engine.get(j);
            }
            res = resolver1(test);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
