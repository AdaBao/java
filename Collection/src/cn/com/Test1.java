package cn.com;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeMap����ݹؼ��ֱ��������״̬,����ڶ��л��׳��쳣,��ΪPeople���ܱȽ�,People��Ҫʵ��Comparable�ӿ�
		//Map map=new TreeMap<People,String>();
		//map.put(new People(), "");
		
		//containsKey���������compareTo�������бȽ�,���������p1��p2����Ϊ��ֵ����ͬ��,��������ĵڶ���put����
		//������Ӽ�ֵ��,���ǻ����value
		Map map=new TreeMap<Person,String>();
		Person p1=new Person("sam",12);
		map.put(p1, "sam");
		System.out.println(map.containsKey(p1));
		System.out.println("-------------");
		Person p2=new Person("sam1",12);
		System.out.println(map.containsKey(p2));
		map.put(p2, "sam2");
		System.out.println("-------------");
		System.out.println(map.size());
		
		
		map.put(new Person("amy",13), "amy");
		map.put(new Person("lingling",14), "lingling");
		//�������ֱ�����ʽ�ᱨ��,��Ϊmap.entrySet()�õ��ļ����е�ÿһ��Ԫ����Object����,Object�����޷�ת��ΪMap.Entry<Person,String>����
		//for(Map.Entry<Person, String> entry : map.entrySet()){
		//}
		
		Set<Map.Entry<Person, String>> s=map.entrySet();
		Iterator iterator=s.iterator();
		while(iterator.hasNext()){
			Map.Entry<Person, String> entry=(Map.Entry<Person, String>)iterator.next();
			System.out.println(entry.getKey().getName()+" "+entry.getValue());
		}

	}

}
