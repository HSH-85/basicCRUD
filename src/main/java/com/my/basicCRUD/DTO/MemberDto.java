package com.my.basicCRUD.DTO;

import com.my.basicCRUD.entitiy.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private int age;
    private String address;

    public MemberDto(Long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    // Entity -> DTO로 변환
    public static MemberDto fromEntity(Member entity) {
        return new MemberDto(
                entity.getMemberId(),
                entity.getName(),
                entity.getAge(),
                entity.getAddress()
        );
    }

    //DTO -> Entity
    public static Member fromDto(MemberDto dto) {
        Member member = new Member();
        member.setMemberId(dto.getId());
        member.setAge(dto.getAge());
        member.setName(dto.getName());
        member.setAddress(dto.getAddress());
        return member;
    }
}
