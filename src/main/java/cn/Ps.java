package cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ps {
    public static List<Integer> nums = new ArrayList<>();
    static {
        Random r = new Random();
        for(int i=0; i<1000; i++) nums.add(1000000 + r.nextInt(1000000));

    }
    public static void foreach() {
        nums.forEach(v->isPrime(v));
    }
    static void parallel() {
        nums.parallelStream().forEach(Ps::isPrime);
    }
    public static void main(String[] args) {


        //System.out.println(nums);

        long start = System.currentTimeMillis();
        nums.forEach(i->isPrime(i));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        //使用parallel stream api

        start = System.currentTimeMillis();
        //并行流
        nums.parallelStream().forEach(Ps::isPrime);
        end = System.currentTimeMillis();

        System.out.println(end - start);
    }


    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
