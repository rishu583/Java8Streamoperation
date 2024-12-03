package java8qa.streamApi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Streamprac {

	public static void main(String[] args) {
		int[] num= {2,5,1};
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<num.length;i++) {
			map.put(i, num[i]);
		}
		
	Set<Entry<Integer,Integer>> set = map.entrySet();
	set.forEach(e->{
		System.out.println(e.getKey() +":"+e.getValue());
	});
	
	
	System.out.println("frequency of characters is ");
	String name="himalaya";
	char[] ch=name.toLowerCase().toCharArray();
	Map<Character,Integer> hm=new HashMap<Character, Integer>();
	int count=0;
	for(int i=0;i<ch.length;i++) {
		
		if(hm.containsValue(ch)) {
			hm.put(ch[i],hm.get(i)+1);
		}
		else {
			hm.put(ch[i], 1);
		}
		
	}
	
   hm.entrySet().forEach(e->{
	   
	   System.out.println(e.getKey() + " : " +e.getValue());
   });
	

	}

}
