import java.util.Scanner;

public class Test25 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            long n = s.nextLong();
            while(n/10 != 0){
                long sum = 0;
                while(n/10 != 0){
                    sum += n%10;
                    n = n/10;
                }
                n = sum;
            }
            System.out.println(n);
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        long[] fib = new long[10000];
        fib[0] = 1;
        fib[1] = 2;
        for(int i = 2; i < 10000; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        for(int i = 0; i < 10000; i++){
            fib[i] = fib[i]%10000;
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int tmp = sc.nextInt();
                String str = fib[tmp-1]+"";
                if(str.length() < 4){
                    for(int j = 0; j < 4-str.length(); j++){
                        System.out.print(0);
                    }
                }
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
