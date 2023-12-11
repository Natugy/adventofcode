import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class aoc4 {
    static int resolver1(String str){
        String[] splitTitle = str.split(":");
        String[] sides = splitTitle[1].split("\\|");
        String[] winNumbersString = sides[0].split(" ");
        String[] otherNumbersString = sides[1].split(" ");
        // System.out.println(winNumbersString[1]);
        ArrayList<Integer> winNumber = new ArrayList<>();
        for (int i = 1; i < winNumbersString.length; i++) {
            // System.out.println(winNumbersString[i]);
            if(!winNumbersString[i].equals("")) winNumber.add(Integer.valueOf(winNumbersString[i]));
        }
        ArrayList<Integer> otherNumber = new ArrayList<>();
        for (int i = 1; i < otherNumbersString.length; i++) {
            if(!otherNumbersString[i].equals("")){
                // System.out.println(otherNumbersString[i]);
                otherNumber.add(Integer.valueOf(otherNumbersString[i]));
                
            }
        }
        int res = 0;
        for (Integer integer : otherNumber) {
            if(winNumber.contains(integer)){
                if(res==0){
                    res =1;
                }
                else{
                    res = res *2;
                }
            }
        }
        // System.out.println(winNumbersString[2]);
        return res;
    }
    static int resolver2(String str){
        String[] splitTitle = str.split(":");
        String[] sides = splitTitle[1].split("\\|");
        String[] winNumbersString = sides[0].split(" ");
        String[] otherNumbersString = sides[1].split(" ");
        // System.out.println(winNumbersString[1]);
        ArrayList<Integer> winNumber = new ArrayList<>();
        for (int i = 1; i < winNumbersString.length; i++) {
            // System.out.println(winNumbersString[i]);
            if(!winNumbersString[i].equals("")) winNumber.add(Integer.valueOf(winNumbersString[i]));
        }
        ArrayList<Integer> otherNumber = new ArrayList<>();
        for (int i = 1; i < otherNumbersString.length; i++) {
            if(!otherNumbersString[i].equals("")){
                // System.out.println(otherNumbersString[i]);
                otherNumber.add(Integer.valueOf(otherNumbersString[i]));
                
            }
        }
        int res = 0;
        for (Integer integer : otherNumber) {
            if(winNumber.contains(integer)){
                res++;
            }
        }
        // System.out.println(winNumbersString[2]);
        return res;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./res/aoc4.txt"));
            int res = 0;
            int i =1;
            int tmp;
            Map<Integer,Integer> nbCard = new HashMap<>();
            nbCard.put(1, 1);
            while (sc.hasNextLine()) {
                tmp = resolver2(sc.nextLine());
                if(!nbCard.containsKey(i)) nbCard.put(i,1);
                for (int j = i+1; j < i+tmp+1; j++) {
                    if(!nbCard.containsKey(j)) nbCard.put(j,1);
                    nbCard.put(j,nbCard.get(j)+nbCard.get(i));
                }
                i++;
            }
            for (Integer value : nbCard.values()) {
                res+=value;
            }
            System.out.println(i);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}