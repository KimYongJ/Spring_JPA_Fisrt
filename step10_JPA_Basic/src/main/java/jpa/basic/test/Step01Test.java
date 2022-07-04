package jpa.basic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;

public class Step01Test {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("step01_JPA_Basic");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		// MySQL의 scott 디비에 바로 접근이 가능하다. 이하 CRUD코드 
		///////////////////////// DB 생성 ////////////////////////////////////
//		tx.begin(); 
//		Member member1 = new Member();// insert를 위해 Member 객체 생성
//		member1.setId("id1");
//		member1.setAge(32);
//		member1.setUserName("jpa1");
//		// 실제 db에 적용하기 위한 코드 , manager 객체 em을 이용해 삽입 가능
//		em.persist(member1); // member1객체를 db에 적용하기 위한 코드 
//		tx.commit(); //커밋을 통해 트랜젝션자체가 db에 완벽하게 반영된다.
//		
////		tx.begin();
//		Member member2 = new Member();
//		member2.setId("id2");
//		member2.setAge(33);
//		member2.setUserName("jpa2");
//		//실제 db에 적용하기 위한 코드 , manager 객체 em을 이용해 삽입 가능
//		em.persist(member2); // member1객체를 db에 적용하기 위한 코드 
//		tx.commit(); //커밋을 통해 트랜젝션자체가 db에 완벽하게 반영된다.
		
		
		///////////////////////// DB 조회 ////////////////////////////////////
		// select하는 코드 
//		Member member1 =  em.find(Member.class, "id1");
//		System.out.println("member1");
//		Member member01 = em.find(Member.class, "id1"); 
//		System.out.println("member01");
//		System.out.println(member1==member01); // true출력, 같은 객체
//		
//		// select all 하는 코드 JPQL 예시 : Entity 객체를 대상으로 검색하는 객체지향적 쿼리 
//		List<Member> allMembers = em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println(allMembers);
//		
//		// 반환타입이 명확할 경우 TypeQuery사용, 불명확할 경우 Query 사용
//		
//		// 멤버 하나만 들고오는 함수
//		em.createQuery("select m from Member m",Member.class).getSingleResult();
		
		///////////////////////// DB 수정 ////////////////////////////////////
		// 흐름 : id값(프라이머리키)으로 해당 값을 찾고 수정한다. 객체 자체를 set을 통해 값을 변경만하면 자동 적용됨 , 
		// 업데이트 대상에서 지정되지 않은 멤버변수 데이터는 기존대로 유지함.
		tx.begin(); 
		Member member1 =  em.find(Member.class, "id1");
		member1.setAge(47);
		tx.commit();
		///////////////////// DB 수정 관련 실험, em.clear를 하면 em.find로 찾은 객체가 사라지므로 setAge가 안된다. /////////////////////////////////
//		tx.begin();
//		Member member1 =  em.find(Member.class, "id1");
//		em.clear();
//		member1.setAge(32);
//		tx.commit();
		///////////////////////// DB 삭제 //////////////////////////////
		// 흐름 : id값(프라이머리키)으로 해당 값을 찾고  EntityManager 객체를 통해 삭제한다.
//		tx.begin();
//		Member member1 =  em.find(Member.class, "id1");
//		em.remove(member1);
//		tx.commit();
	}
}