package practice.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeautyOfString {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        StringBuffer s=new StringBuffer();
        for(int i=0;i<str.length();i++)s.append(str.charAt(i)-96);
        int num= Integer.parseInt(s.toString());
        char[] temp= new char[s.length()];
        Arrays.fill(temp,'1');
        int lim=Integer.parseInt(new String(temp));
        int count=0;
        for(int i=lim;i<num;i++){
           String st= String.valueOf(i);
           if(st.contains("7") ||st.contains("8") ||st.contains("9"))continue;;
           if(canFormPalindrome(st)) count++;
        }
        System.out.println(count);
        br.close();
    }

    static int NO_OF_CHARS = 256;
    static boolean canFormPalindrome(String str) {
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;
            if (odd > 1)
                return false;
        }
        return true;
    }

    public static int beautyOFString(int n, String str){
        StringBuffer s=new StringBuffer();
        for(int i=0;i<str.length();i++)s.append(str.charAt(i)-96);
        int num= Integer.parseInt(s.toString());
        char[] temp= new char[s.length()];
        Arrays.fill(temp,'1');
        int lim=Integer.parseInt(new String(temp));
        int count=0;
        for(int i=lim;i<num;i++){
            String st= String.valueOf(i);
            if(st.contains("7") ||st.contains("8") ||st.contains("9"))continue;;
            if(canFormPalindrome(st)) count++;
        }
        return count;
    }
}
