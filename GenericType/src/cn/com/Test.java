package cn.com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�������ַ��͵�ʵ������ʽ����
		Pair pair=new Pair("hello","world");
		Pair pair1=new Pair<>("hello","world");
		Pair pair2=new Pair<String>("hello","world");
		Pair<String> pair3=new Pair("hello","world");
		Pair<String> pair4=new Pair<>("hello","world");
		Pair<String> pair5=new Pair<String>("hello","world");
		System.out.println(pair.getFirst());
		System.out.println(pair1.getFirst());
		System.out.println(pair2.getFirst());
		System.out.println(pair3.getFirst());
		System.out.println(pair4.getFirst());
		System.out.println(pair5.getFirst());
//-----------------------------------------------------------------
		//���͵����Ͳ��������ж��
		org.bth.Pair p=new org.bth.Pair<Integer,String>(10,"hello");
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
		
//-----------------------------------------------------------------		
		//�������͵���
		sayHello("xiaoming");
		
//-----------------------------------------------------------------
		//�ӿڷ���
		Rectangle rectangle=new Rectangle(2,3);
		System.out.println(rectangle.calcGirth());
		System.out.println(rectangle.calcArea());
		
		Triangle triangle=new Triangle(3.0,4.0,5.0);
		System.out.println(triangle.calcGirth());
		System.out.println(triangle.calcArea());
//-----------------------------------------------------------------
		//���Ͳ������޶�
		//����Ϊĳ��������
		Calculator calc=new Calculator<Double>();
		System.out.println(calc.sum(3, 4));
		
		//�Ͻ�Ϊ�ӿ�
		Chinese chinese1=new Chinese("zhao",20,100);
		Chinese chinese2=new Chinese("qian",21,120);
		Chinese chinese3=new Chinese("sun",18,90);
		Chinese[] chinese={chinese1,chinese2,chinese3};
		People people=new People<Chinese>(chinese,"peking");
		people.printAll();
		
		Circle circle1=new Circle(4.0);
		Circle circle2=new Circle(5.0);
		Circle circle3=new Circle(6.0);
		Circle[] circles={circle1,circle2,circle3};
		Circle maxCircle=max(circles);
		System.out.println(maxCircle.calcArea());
		
		//�Ͻ�Ϊ�������Ͳ���,����Ҫ֪��List<Integer>������List<Number>������,��
		//School���addAll������,T������Ҫ�̳��Ի�����E����,������ʾ,Integer���ͼ̳���Number
		List<Number> students1=new ArrayList<Number>();
		School<Number> school1=new School<Number>("bit","peking",students1);
		List<Integer> students2=new ArrayList<Integer>();
		School<Integer> school2=new School<Integer>("bit","peking",students2);
		school1.addAll(school2);//������ȷ
		//school2.addAll(school1);//����ʧ��
//-----------------------------------------------------------------
		//����ͨ���
		List<Double> doubleList=new LinkedList<Double>();
		doubleList.add(1.0);
		doubleList.add(2.0);
		doubleList.add(3.0);
		printAll(doubleList);
		System.out.println();
		List<Number> numberList=new LinkedList();
		numberList.add(1.0);
		printAll(numberList);
		System.out.println();
		//List<String> strList=new LinkedList();
		//printAll(strList); //�������
		_swap(doubleList);
//-----------------------------------------------------------------
		//������ͨ���,max����ʹ����ͨ�����super,T��Child,Base(?) super Child,Child�̳���Comparable<Base>
		List<Child> childList=new LinkedList<Child>();
		max(childList);
		//max1(childList);//�������,��ȻChild�̳���Base,���Ƕ��ڱ�������˵Child�ƺ���δʵ��Comparable�ӿ�
//-----------------------------------------------------------------
		//ʹ�÷�����  �����ͽӿ�
		//ÿ���඼��һ��������Ϣ,�������Ͷ���
		Class<?> cls="Hello".getClass();
		System.out.println(cls);
		System.out.println(String.class=="Hello".getClass());
		//System.out.println(List<Integer>.class);//����ʧ��,java��֧������д��
		System.out.println(new LinkedList<Integer>().getClass()==LinkedList.class);//һ�����Ͷ����getClass�����ķ���ֵ��ԭʼ���Ͷ�������ͬ��
		//if(new LinkedList<Integer> instanceof LinkedList<Integer>){}//ͬ������ʧ��,java��֧������д��
		if(new LinkedList<Integer>() instanceof LinkedList<?>){}//java֧�ִ�д��
		//List<Integer>[] listArr={new LinkedList<Integer>()};//����ʧ��,java���ܴ�����������
		LinkedList[] listArr={new LinkedList<Integer>(),new LinkedList<String>()};//����ͨ��
		
		//����������ͨ������,����Integer[]������Number[]��������,�������ʹ�ò���Ҳ�ǲ���ȫ��
		Integer[] ints=new Integer[10];
		Number[] numbers=ints;
		Object[] objs=ints;
		//objs[0]="hello";//������ͨ��,��������ʱ�����쳣
		
		//���д���������ʱ�ᱨ��,����ͨ������������������
		try{
			Object [] oArr=new Object[10];
			Integer[] iArr={0,1,2,3,4,5,6,7,8,9};
			System.arraycopy(iArr, 0, oArr, 0, 10);
			Integer [] iArr1=(Integer[])oArr;
		}
		catch(Exception e){
			System.out.println("Exception");
		}
		
		try{
			Object  oArr=Array.newInstance(Integer.class, 10);
			Integer[] iArr={0,1,2,3,4,5,6,7,8,9};
			System.arraycopy(iArr, 0, oArr, 0, 10);
			Integer [] iArr1=(Integer[])oArr;
			System.out.println("no exception");
		}
		catch(Exception e){
			System.out.println("Exception");
		}
		
		
		
		
		
	
		
		
	}
	
	//��������
	private static <T> void sayHello(T t){
		System.out.println(t+" hello");
	}
	
	//�Ͻ�Ϊ�ӿ�
	//������<T extends Comparable<T>>? Tʵ����Comparable�ӿ�,ͬʱComparable�ӿ�Ҳ�Ƿ���,Comparable�ӿ���ҪT�����Ͳ���,����ͨ���鿴Circle�������
	private static <T extends Comparable<T>> T max(T[] arr){
		if(arr==null||arr.length==0)
			return null;
		T max=arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i].compareTo(max)==1)
				max=arr[i];
		}
		
		return max;
	}
	
	//ͨ����ڷ����е�ʹ��
	private static  void printAll(List<? extends Number> list){
		if(list==null||list.size()==0)
			return;
		//list.add(new Object());//�������,ͨ���ֻ��д���ܶ�
		Iterator iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
	}
	//ͨ����ڷ����е�ʹ��,��������ڱ����ʱ��ᱨ��,�����е�ͨ�����һ���ص����ֻ��д���ܶ�
	/*private static void swap(List<?> list){
		Object tmp=list.get(0);
		list.set(0, list.get(1));
		list.set(1, tmp);
	}*/
	
	//ͨ����ڷ����е�ʹ��,����������������ʵ�ֽ���,������溯�������ֵ�����
	private static <T> void swap(List<T> list){
		System.out.println("����ǰ:"+list.get(0)+" "+list.get(1));
		T tmp=list.get(0);
		list.set(0, list.get(1));
		list.set(1, tmp);
		System.out.println("������:"+list.get(0)+" "+list.get(1));
	}
	private static void _swap(List<?> list){
		swap(list);
	}
	
	//������ͨ���,super��ʾĳ��������
	private static <T extends Comparable<? super T>>  T max(List<T> list){
		return null;
	}
	
	private static <T extends Comparable<T>>  T max1(List<T> list){
		return null;
	}
	
	

}
