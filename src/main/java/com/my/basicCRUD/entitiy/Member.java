package com.my.basicCRUD.entitiy;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="member")
@Data
public class Member {
    @Id
    @Column(name="memberId", length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(name = "member_name", length = 100, nullable = false)
    private String name;
    private int age;
    private String address;
}
