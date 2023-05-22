package aop2;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Board {
	public ArrayList<String> getList(){
		System.out.println("getList 호출");
		ArrayList<String> list = new ArrayList();
		list.add("게시물1");
		list.add("게시물2");
		list.add("게시물3");
		list.add("게시물4");
		list.add("게시물5");
		return list;
	}
	
	public void insert(int seq) {
		System.out.println(seq + " 번째 게시물을 저장합니다.");
	}
}
