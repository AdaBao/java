package cn.com;

import java.util.Comparator;

//�Ƚ�����ΪTreeSet���캯���Ĳ�������,��TreeSet�Ĺ��캯���л����TreeMap�Ĺ��캯��,Ȼ���ô���ıȽ�����TreeMap�ĳ�Ա������ֵ
//����������ʱ,put��������ñȽ����еĺ���ȥ�Ƚϴ�С
public class PersonCompare implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		if(o1.getAge()>o2.getAge())
			return 1;
		else if(o1.getAge()==o2.getAge())
			return 0;
		else
			return -1;
		
	}

}
