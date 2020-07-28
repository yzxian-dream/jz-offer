package main.java.com;

public class Title63 {
    public String rearrange (String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        int p1 = 0;
        int p2 = 0;
        int len = s.length();
        int i = 0;
        //char[] strArr = new char();
        //s.setLength(len);
        for(;p1<len;p1++){
            if(s.charAt(p1) == '*' ){
                s.setCharAt(p2++,s.charAt(p1));
            }else{
                s.setCharAt(p2++,s.charAt(p1));
            }
        }
        return s;
    }
}

