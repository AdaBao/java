package cn.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List myList1=new LinkedList<Integer>();
		List myList2=new ArrayList<Integer>();
		
		for(int i=0; i<10; i++)
		{
			myList1.add(i);
			myList2.add(i);
		}
		
		Iterator iterator1=myList1.iterator();
		Iterator iterator2=myList2.iterator();
		
		/*��������ڱ������ļ��Ͻ��нṹ�ϵĸı�(���Ըü���ʹ��add��remove��clear����),��ô�������Ͳ��ٺϷ�
		 * �������ʹ�õ������Լ���remove����,��ô�������������Ȼ�ǺϷ���
		 * */
		
		//myList1.remove(3);  
		//iterator1.next();
		//iterator1.remove();
		/*while(iterator1.hasNext())
		{
			System.out.println(iterator1.next());
		}*/
		
		//myList2.remove(3);
		//myList2.add(10);
		//iterator2.next();
		//iterator2.remove();
		/*while(iterator2.hasNext())
		{
			System.out.println(iterator2.next());
		}*/

	}

}
