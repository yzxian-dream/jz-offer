package 表示数值的字符串;
class Solution {
    public boolean isNumber(String s) {
         s = s.trim();
        if (s.length() <= 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        
        s.replace('E', 'e');
        int index = s.indexOf('e');
        if (index >= 0) {
             String l = s.substring(0,index);
             String r = s.substring(index+1);
             if (r.length() > 0) {
                if (r.charAt(0) == '+' || r.charAt(0) == '-') {
                    r = r.substring(1);
                }
             }
             return validNum(l) && validPureNum(r);
        }else{
            return validNum(s);
        }
       
    }

    private boolean validNum(String s) {
        int index = s.indexOf('.');
        if (index >= 0) {
            String l = s.substring(0, index);
            String r = s.substring(index+1);
            if (l.length() > 0 && r.length() > 0) {
                return validPureNum(l) && validPureNum(r);
            }else if (r.length() > 0) {
                return validPureNum(r);
            }else{
                return validPureNum(l);
            }
        }else{
            return validPureNum(s);
        }
    }

    private boolean validPureNum(String s) {
        if (s.length() <= 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i) < '0' || s.charAt(i) > '9'){
            return false;
           }
        }
        return true;
    }
}