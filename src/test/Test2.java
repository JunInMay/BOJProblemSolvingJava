package test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
interface Test2{
    static void main(String[] a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String regex = "^(c|j|n|m|t|s|l|d|qu)(')[aeiouh]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String[] arr = str.split("[\\s-]");
        int cnt = arr.length;
        for(String val : arr) {
            matcher = pattern.matcher(val);
            while(matcher.find()) {
                cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
    }
}