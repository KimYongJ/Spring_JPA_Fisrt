package step02.entity;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jpa.basic.enumtype.MemberType;
import lombok.Data;
@Data
@javax.persistence.Entity
public class Member2 {
	@Id//프라이머리키로 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // db에서 알아서 값을 생성해주라는 뜻이 담겨 있음. IDENTITY 는 autoIncreament라 생각하면됨 MySQL 에서 많이 씀
	private Long id;
	@Column(columnDefinition = "varchar(100) default 'AAA", nullable = false)
	private String name;
	private Integer age;
	// 날짜를 시간까지 알려받기 위해서는 LocalDateTime을 쓴다.
	@Column(name="reg_time", updatable = false)
	
	private LocalDateTime registrationTime;
	
//	// 날짜를 시간까지 알려받기 위해서는Date에 Temporal 설정을 한다
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date registrationTime;
	
//	private String memberType;// VIP, NORMAL, VVIP, ..
	@Column(name="member_type")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
}
