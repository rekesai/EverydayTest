import java.util.Scanner;

public class Test8 {

    //求a和b的最小公倍数，就是一个数字是能被他俩整除中最小的那个
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        //求最小公倍数，优化：从a*b的中间开始  再优化：从a*b的算术平方根开始
        for(int i = (int)(Math.sqrt(a*b)); i <= a*b; i++){
            if(i%a==0 && i%b==0){
                System.out.println(i);
                break;
            }
        }
    }

    //对于输入的字符串进行判断，如果按照字典排序（compareTo）则输出lexicographically，如果按照长度排则输出lengths
    //如果都遵循了输出both，如果都没有遵循输出none
    public void stringIsOrder(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++){
            strArr[i] = s.next();
        }
        boolean flagD = true;
        boolean flagL = true;
        for(int i = 0; i < n-1; i++){
            if(strArr[i].compareTo(strArr[i+1]) > 0){
                flagD = false;
            }
            if(strArr[i].length() > strArr[i+1].length()){
                flagL = false;
            }
        }
        if(flagD && flagL){
            System.out.println("both");
        }
        else if(flagD){
            System.out.println("lexicographically");
        }
        else if(flagL){
            System.out.println("lengths");
        }
        else{
            System.out.println("none");
        }
    }
    public static void main2(String[] args) {
        String str1 = "car";
        String str2 = "cats";
        System.out.println(str2.compareTo(str1));
    }
    static class A{
        protected int value;
        public A(int v){
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            try{
                value++;
                return value;
            }catch(Exception e){
                System.out.println(e.toString());
            }finally{
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A {

        public B() {
            super(5);
            setValue(getValue() - 3);
        }
        public void setValue(int value){
            super.setValue(2*value);
        }
    }

    public static void main1(String[] args){
        System.out.println(new B().getValue());
    }
}
