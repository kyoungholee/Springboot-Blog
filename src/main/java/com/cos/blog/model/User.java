package com.cos.blog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Timestamp;

 @DynamicInsert //insert시에 null인 필드를 제외시켜준다.
@Entity //User 클래스가 Mysql에 테이블이 생성된다.
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id //PK키를 알려준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 프로젝트에서 연결괸 DB의 넘버링 전략을 따라간ㄷ.
    private int id; // auto_increment

    @Column(nullable = false, length = 30, unique = true)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password;


    @Column(nullable = false, length = 50)
    private String email;


    //@ColumnDefault("'user'")
    //DB는 RoleType이 없다.
    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum을 쓰는게 좋다. //ADMIN, USER manager

    @CreationTimestamp // 시간이 자동으로 입력
    private Timestamp createDate;


}
