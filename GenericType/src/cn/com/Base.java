package cn.com;

import java.util.List;

public class Base <E> implements Comparable<Base> {

	@Override
	public int compareTo(Base o) {
		// TODO Auto-generated method stub
		return 0;
	}

	//public <T super E> void max(List<T> list){}//�������,java��֧�������﷨
	public void max(List<? super E> list){}//����ͨ��
}
