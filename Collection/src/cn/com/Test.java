package cn.com;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s=new TreeSet<>();
		s.add(1);
		s.add(4);
		s.add(-1);
		s.add(-2);
		//TreeSet�ڲ�ʹ�õ���ƽ�������,���������������
		System.out.println(s);
		System.out.println("-------------");
		System.out.println(s.contains(1));
		System.out.println("-------------");
		Person p=new Person("xiaoming",20);
		Set<Person> s1=new TreeSet<>();
		//���Personû��ʵ�ֱȽ���,���򼯺�������µĶ���ʱ,�ͻ����쳣�׳�
		s1.add(p);
		Person p1=new Person("xiaoli",30);
		s1.add(p1);
		for(Person person:s1){
			System.out.println(person.getAge());
		}
		
		System.out.println("-------------");
		Set<Person> s2=new TreeSet<>(new PersonCompare());
		s2.add(new Person("xiaozhao",10));
		s2.add(new Person("xiaowang",11));
		for(Person person:s2){
			System.out.println(person.getAge());
		}
		System.out.println("-------------");
		
		//�������Э���ԣ�Ҳ��˵��ļ̳�����������Ҳ�������������ݲ���ǿ������ת�����ͣ�����˵��Object[]תPerson[]��ֻ��һ����ȡ����֮����ת��
		Object[] oArr=s2.toArray();
		
		for(int i=0; i<oArr.length; i++)
			{
			  Person temp=(Person)oArr[i];
		      System.out.println(temp.getAge());
		 }
		System.out.println("-------------");
		
		Iterator iterator=s2.iterator();
		while(iterator.hasNext())
		{
			Person person=(Person)iterator.next();
			System.out.println(person.getAge());
		}
		
		System.out.println("-------------");
	

	}

}
