package com.dcs.exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DanCiJieLong {
    class Pain{
        String vale;
        boolean isBule = false;
        boolean isRed = false;
        List<Pain> nextPains = new ArrayList<>();
        public Pain(String vale){
            this.vale = vale;
        }
    }
    public static boolean isNext(Pain a,Pain b){
        boolean re = true;
        String x = a.vale;
        String y = b.vale;
        if (x == y) return false;
        int count = 0;
        for (int i = 0;i <x.length();i++){
            if(x.charAt(i) != y.charAt(i)){
                count++;
                if (count > 1) return false;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String begin = scanner.nextLine();
        String end = new StringBuffer(begin).reverse().toString();
//        String end = "cog";
        String zi = scanner.nextLine();
        int res = 0;
        boolean hasRes = false;
        String[] strings = zi.split(" ");
        List<Pain> pains = new ArrayList<>();
//        pains.add(new Pain(begin));
//        pains.add(new Pain(end));
        for (int i = 0;i < strings.length;i++ ){
//            pains.add(new Pain(strings[i]));
        }
        for (int i = 0;i < pains.size();i++){
            for (int j = 0;j < pains.size();j++){
                Pain a = pains.get(i);
                Pain b = pains.get(j);
                if (isNext(a,b)){
                    a.nextPains.add(b);
                }
            }
        }

        List<Pain> nextPains = new ArrayList<>();
        List<Pain> retPains = new ArrayList<>();
        nextPains.add(pains.get(0));
        while (!nextPains.isEmpty()){
            res++;
            for (int i = 0;i < nextPains.size();i++){
                Pain a = nextPains.get(i);
                if (a.isRed) continue;
                if (a.vale.equals(end)) {
                    nextPains.clear();
                    retPains.clear();
                    hasRes = true;
                    if (begin == end) {
                        System.out.println(0);
                        break;
                    }
                    System.out.println(res);
                    break;
                }
                a.isRed = true;
                for (int j = 0;j < a.nextPains.size();j++){
                    Pain b = a.nextPains.get(j);
                    if (b.isRed || b.isBule) continue;
                    retPains.add(b);
                    b.isBule = true;
                }
            }
            nextPains = new ArrayList<>(retPains);
            retPains.clear();
        }
        if (!hasRes) System.out.println(99);
    }

}
