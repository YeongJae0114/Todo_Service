package com.example.demo.domain.member.member.entity;

import com.example.demo.global.jpa.BaseTime;
import jakarta.persistence.*;

import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Member extends BaseTime {
    private String username;
    private String password;
    private String nickname;
}
