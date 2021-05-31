

public class EverydayTest6 {
    //将一个字符串转换成一个整数，如果字符串中包含除了正负符号或者数字之外的字符则输出0，不然输出该字符串表示的数字，不允许使用字符串方法转换成整数
    public int StrToInt(String str) {
        str = str.replace("+", "");
        boolean flag = false;
        if(str.indexOf("-") == 0){
            str = str.replace("-", "");
            flag = true;
        }
        byte[] bytes = str.getBytes();
        byte b0 = '0';
        int num = 0;
        for(int i = bytes.length - 1; i >= 0; i--){
            if(bytes[i] >= b0 && bytes[i] <= b0 + 9){
                num += (bytes[i] - b0) * Math.pow(10, bytes.length - 1 - i);
            }else{
                return 0;
            }
        }
        return flag ? -num : num;
    }

}
