package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

public class MemberDataLoaderListener implements ApplicationListener  {
	@Override
	public void startApplication(Map<String, Object> context) {
		System.out.println("애플리케이션이 시작될 떄 준비 작업을 수행한다.");
		
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("member3.data")))) {
			
			context.put("memberList", in.readObject());
			
		} catch (Exception e) {
			System.out.println("회원 데이터를 읽는 중 오류 발생:" + e.toString());
			context.put("memberList", new LinkedList<Member>());
		}
	}
	

	@Override
	public void endApplicaiton(Map<String, Object> context) {
		System.out.println("애플리케이션이 종료될 떄 마무리 작업을 수행한다.");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("member3.data")))) {
			
			out.writeObject(context.get("memberList"));
			
		} catch (Exception e) {
			System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
		}
		
	}
}
		
		
	