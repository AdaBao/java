package cn.com;

public class People <T extends Human>{
	private String province;
	private T[] human;
	//private static T instance;//����ʧ��,��Ϊ�����Ǿ�̬�������Ǿ�̬������������class,��������ĳ������
	public People(T[] human,String province){
		this.human=human;
		this.province=province;
		
		//���������䶼���ܱ���ͨ��,��Ϊͨ�����Ͳ�����������������,�������Ͳ���,ֻ�ܴ���Object���͵Ķ���
		//T t=new T();
		//T[] arr=new T[10];
	}
	
	public void printAll(){
		System.out.println(this.province+":");
		for(int i=0; i<this.human.length; i++){
			System.out.println(human[i].getName()+" "+human[i].getYear()+" "+human[i].getWeight()+" "+human[i].getNationality());
		}
	}
	
	//���ȷʵ����ʹ�����Ͳ�����������,����ʹ�����з���
	public <E> E create(Class<E> type){
		try {
			return type.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		} 
		
	}
	
	//����ʧ��,ԭ��������ľ�̬��������˵
	/*public static T getInstance(){
		return null;
	}*/
	
}
