package com.example.demo.domain.surl.surl.entity;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.global.jpa.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Entity
@Builder
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Surl extends BaseTime {
    @ManyToOne
    private Member author;
    private String body;
    private String url;
    @Setter(AccessLevel.NONE)
    private long count;

    public void increaseCount(){
        count++;
    }

}
