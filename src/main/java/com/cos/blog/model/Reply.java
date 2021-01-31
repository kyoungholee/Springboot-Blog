package com.cos.blog.model;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Reply {
//Reply 게시글에 대한 답변

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id; //mysql = auto_increment

    @Column(nullable = false, length = 200)
    private String content;


    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;


}