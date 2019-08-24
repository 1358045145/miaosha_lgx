package com.lgx.miaosha.test;

public class StringReplace {

    public String replace(StringBuilder sb){
        int firstLength = sb.length();
        for (int i = 0 ; i <= firstLength - 1 ; i ++){
            if (sb.charAt(i) == ' '){
                sb.append("   ");
            }
        }

        int first = firstLength - 1;
        int last = sb.length() - 1;

        while (first < last && first >= 0) {
            char c = sb.charAt(first--);
            if (c != ' '){
                sb.setCharAt(last--,c);
            }else {
                sb.setCharAt(last--,'0');
                sb.setCharAt(last--,'2');
                sb.setCharAt(last--,'%');
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('A');
        stringBuilder.append('B');
        stringBuilder.append(' ');
        stringBuilder.append('C');
        String replace = new StringReplace().replace(stringBuilder);
        System.out.println(replace);
    }
}
