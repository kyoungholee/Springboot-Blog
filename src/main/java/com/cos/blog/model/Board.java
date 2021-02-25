package com.cos.blog.model;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리 <html>태그가 섰여서 디자인이 된다.
    //내용


    private int count; // 조회수

    //EAGER user를 가져올게
    @ManyToOne(fetch = FetchType.EAGER) //Many = Board(게시글) , User = One
    @JoinColumn(name = "userId")
    private User user; //DB는 오브젝트를 저장 할 수 없다. <FK키 사용>
    //자바는 오브젝트를 저장할 수 있다.


    @OneToMany(mappedBy = "board" ,fetch = FetchType.EAGER)//mappedBy 연관관계의 주인이 아니고, (난 FK가 아니에요)
    // DB에 칼럼을 만들지 마세요
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
