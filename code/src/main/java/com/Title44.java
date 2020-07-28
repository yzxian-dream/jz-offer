package main.java.com;
/*题目描述：

          牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
        同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
        例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
        正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？*/
public class Title44 {
    public String reverseSentences(String str){
        if(str==null)
            return null;
        char[] strArr=str.toCharArray();
        reverseStr(strArr,0,strArr.length-1); //翻转整个字符串
        int begin=0;
        for(int i=0;i<strArr.length;i++){
            if(strArr[i]==' '){
                reverseStr(strArr,begin,i-1);
                begin=i+1;
            }
        }
        reverseStr(strArr,begin,strArr.length-1); //最后一个单词后没有空格
        return new String(strArr);
    }

    public void reverseStr(char[] array,int begin,int end){ //反转字符串，前后指针
        for(;begin<end;begin++,end--){
            char temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
        }
    }
}

