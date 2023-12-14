import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                    valid =false;
                }
                if(!subString.isEmpty() && !valid){
                    // a droite
                    if (i>0 && strTab[i-1].charAt(j)!='.' && !(strTab[i-1].charAt(j) <='9' && strTab[i-1].charAt(j) >='0')) {
                        valid = true;
                    }
                    if (i>0 && j>0&& strTab[i-1].charAt(j-1)!='.' && !(strTab[i-1].charAt(j-1) <='9' && strTab[i-1].charAt(j-1) >='0')) {
                        valid = true;
                    }
                    if (i>0 && j<strTab[i].length()-1&& strTab[i-1].charAt(j+1)!='.' && !(strTab[i-1].charAt(j+1) <='9' && strTab[i-1].charAt(j+1) >='0')) {
                        valid = true;
                    }
                    if (i<strTab.length-1 && j<strTab[i].length()-1&& strTab[i+1].charAt(j+1)!='.' && !(strTab[i+1].charAt(j+1) <='9' && strTab[i+1].charAt(j+1) >='0')) {
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

                }
                j++;
            }
            if(!subString.isEmpty() && valid) validNumber.add(Integer.valueOf(subString));
            i++;
        }
        int res =0;
        for (Integer integer : validNumber) {
            System.out.println(integer);
            res+=integer;
        }
        return res;
    }
   

    static int resolver2(String[] strTab){
        
        int i =0;
        int j=0;
        List<Integer> validNumber = new ArrayList<>();
        String subString ="";
        boolean valid = false;
        char ch;
        char caca;
        Coordonnes gear =null;
        Map<Coordonnes,List<Integer>> test = new HashMap<>();
        while (i<strTab.length) {
            j =0;
            subString = "";
            valid = false;
            gear = null;
            while (j<strTab[i].length()) {
                
                ch= strTab[i].charAt(j);
                if(ch <='9' && ch >='0'){
                    subString+=ch;
                }else {
                    if(valid){
                        if(!test.containsKey(gear)){
                            test.put(gear, new ArrayList<>());
                        }
                        test.get(gear).add(Integer.valueOf(subString));
                    }
                    subString="";
                    valid =false;
                    gear = null;
                }
                if(!subString.isEmpty() && !valid){
                    // a droite
                    if (i>0 && strTab[i-1].charAt(j)=='*' ) {
                        valid = true;
                        gear = new Coordonnes(i-1, j);
                        System.out.println();
                    }
                    if (i>0 && j>0&& strTab[i-1].charAt(j-1)=='*' ) {
                        valid = true;
                        gear = new Coordonnes(i-1, j-1);
                    }
                    if (i>0 && j<strTab[i].length()-1&& strTab[i-1].charAt(j+1)=='*') {
                        valid = true;
                        gear = new Coordonnes(i-1, j+1);
                    }
                    
                    if (i<strTab.length-1 && j>0 && strTab[i+1].charAt(j-1)=='*') {
                        valid = true;
                        gear = new Coordonnes(i+1, j-1);
                    }
                    if (i<strTab.length-1 && j<strTab[i].length()-1&& strTab[i+1].charAt(j+1)=='*') {
                        valid = true;
                        gear = new Coordonnes(i+1, j+1);
                    }
                    if (i<strTab.length-1 && strTab[i+1].charAt(j)=='*') {
                        valid=true;
                        gear = new Coordonnes(i+1, j);
                    }
                    if(j<strTab[i].length()-1 && strTab[i].charAt(j+1)=='*'){
                        valid = true;
                        gear = new Coordonnes(i, j+1);
                     }
                     if(j>0 && strTab[i].charAt(j-1)=='*'){
                        valid = true;
                        gear = new Coordonnes(i, j-1);
                     }

                }
                j++;
            }
            if(!subString.isEmpty() && valid) {
                if(!test.containsKey(gear)){
                    test.put(gear, new ArrayList<>());
                }
                test.get(gear).add(Integer.valueOf(subString));
            }
            i++;
        }
        int res =0;
        int count =0;
        int tmp = 0;
        for (Coordonnes gears : test.keySet()) {
            count =0;
            tmp = 1;
            for (Integer integer : test.get(gears)) {
                count++;
                tmp = tmp * integer;
            }
            if (count>1) {
                res+=tmp;
            }
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
            res = resolver2(test);
            // System.out.println(test[0]);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
