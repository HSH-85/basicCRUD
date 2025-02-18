package com.my.basicCRUD.DTO;

import com.my.basicCRUD.entitiy.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;
    @Size(min = 2, message = "이름은 2자 이상으로 입력해야 합니다.")
    private String name;
    @Range(min = 0, max = 120, message = "나이는 0세부터 120세까지입니다.")
    private int age;

    @NotBlank(message = "주소는 꼭 입력해야 합니다.")
    private String address;

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
