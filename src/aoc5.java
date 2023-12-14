import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class aoc5 {
    static public void resolver1(){
        try {
            Scanner sc = new Scanner(new File("./res/aoc5.txt"));
            long res = Long.MAX_VALUE;
            String seeds = sc.nextLine();
            seeds = seeds.substring(7);
            List<Long> seedList= new ArrayList<>();
            List<Long> tmpSeedList = convertStringIntoList(seeds);
            for (int i = 0; i < tmpSeedList.size(); i+=2) {
                for (long j = tmpSeedList.get(i); j < tmpSeedList.get(i)+tmpSeedList.get(i+1); j++) {
                    seedList.add(j);
                    
                }
            }
            // System.out.println(seedList);
            boolean toAnalyse = false;
            String title ="";
            String scan = "";
            Map<String,List<Seed>> data = new HashMap<>();
            List<String> tList = new ArrayList<>();
            List<Long> tmpIntegers = new ArrayList<>();
            while(sc.hasNextLine()){
                scan=sc.nextLine();
                if(scan.equals("")){
                    toAnalyse =true;
                }
                else if(toAnalyse) {
                    title = scan;
                    toAnalyse =false;
                    data.put(scan, new ArrayList<>());
                    tList.add(title);
                }else {
                    tmpIntegers = convertStringIntoList(scan);
                    data.get(title).add(new Seed(tmpIntegers.get(0), tmpIntegers.get(1), tmpIntegers.get(2)));
                }
                // System.out.println(res);
            }
            long tmpRes = 0;
            for (int i = 0; i < tmpSeedList.size(); i+=2) {
                for (long j = tmpSeedList.get(i); j < tmpSeedList.get(i)+tmpSeedList.get(i+1); j++) {
                    seedList.add(j);
                    tmpRes = j;
                    for (String titleTmp : tList) {
                    // System.out.println(titleTmp);
                    tmpRes = seedCalcul(tmpRes, data.get(titleTmp));
                    }
                    if(tmpRes<res) res =tmpRes;
                }
            }
            // for (Long seedTmp : seedList) {
            //     tmpRes = seedTmp;
            //     for (String titleTmp : tList) {
            //         // System.out.println(titleTmp);
            //         tmpRes = seedCalcul(tmpRes, data.get(titleTmp));
            //     }
            //     if(tmpRes<res) res =tmpRes;
                
            // }
            // System.out.println(resSet);
            
            System.out.println(res);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static public List<Long> convertStringIntoList(String data){
        List<Long> res = new ArrayList<>();
        String[] dataNumStrings = data.split(" ");
        for (String string : dataNumStrings) {
            res.add(Long.valueOf(string));
        }
        
        return res;
    } 

    static public long seedCalcul(long seedInit, List<Seed> soil){
        long res =seedInit;
        for (Seed seed : soil) {
            // System.out.println(seed);
            if(seed.contains(seedInit)){
                res+=seed.getDecalage();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        resolver1();
    }
}
