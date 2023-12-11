import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class aoc2 {
    static Map<String,Integer> bagMap = new HashMap<>();
    
    static int resolver1(String str){
        str = str.substring(5);
        // System.out.println(str);
        int i=0;
        String tmp = "";
        while (str.charAt(i)!=':') {
            tmp+=str.charAt(i);
            i++;
        }
        int id = Integer.valueOf(tmp);
        str = str.substring(i+1);
        // System.out.println(str);;
        String[] game = str.split(";");
        String[] balls;
        int nbBall = 0;
        for (String bag : game) {
            balls = bag.split(",");
            for (String ball : balls) {
                i = 1;
                tmp = "";
                while (ball.charAt(i)!=' ') {
                    tmp+=ball.charAt(i);
                    i++;
                }
                nbBall = Integer.valueOf(tmp);
                ball = ball.substring(i+1);
                if(bagMap.containsKey(ball)){
                    if(nbBall>bagMap.get(ball)){
                        return 0;
                    }
                }
            }
        }

        return id;
    }

    static int resolver2(String str){
        Map<String,Integer> resMap = new HashMap<>();
        resMap.put("red", 0);
        resMap.put("green",0);
        resMap.put("blue", 0);
        str = str.substring(5);
        // System.out.println(str);
        int i=0;
        String tmp = "";
        while (str.charAt(i)!=':') {
            tmp+=str.charAt(i);
            i++;
        }
        str = str.substring(i+1);
        System.out.println(str);;
        String[] game = str.split(";");
        String[] balls;
        int nbBall = 0;
        for (String bag : game) {
            balls = bag.split(",");
            for (String ball : balls) {
                i = 1;
                tmp = "";
                while (ball.charAt(i)!=' ') {
                    tmp+=ball.charAt(i);
                    i++;
                }
                nbBall = Integer.valueOf(tmp);
                ball = ball.substring(i+1);
                
                if(nbBall>resMap.get(ball)){
                    resMap.put(ball, nbBall);
                }
                
            }
        }
        
        int res= 1;
        for (Integer integer : resMap.values()) {
            res = integer * res;
        }
        return res;
    }



    public static void main(String[] args) {
        bagMap.put("red", 12);
        bagMap.put("green",13);
        bagMap.put("blue", 14);
        System.out.println();
        try {
            Scanner sc = new Scanner(new File("./res/aoc2.txt"));
            int res = 0;
            while(sc.hasNextLine()){
                res += resolver2(sc.nextLine());
                // System.out.println(res);
            }
            System.out.println(res);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
