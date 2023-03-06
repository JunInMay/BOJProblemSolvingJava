package problems.from.number05500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5555 {

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String target = br.readLine();
    	int ringCount = Integer.parseInt(br.readLine());
    	int result = 0;
    	while (ringCount-- > 0) {
    		String ring = br.readLine();
    		for (int i=0; i<ring.length(); i++) {
    			boolean flag = true;
    			for (int j=0; j<target.length(); j++) {
    				int now = (i + j) % ring.length();
    				if (ring.charAt(now) != target.charAt(j)) {
    					flag = false;
    					break;
    				}
    			}
    			if (flag) {
    				result++;
    				break;
    			}
    		}
    	}
    	System.out.println(result);
	}

}
