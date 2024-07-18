package com.example.demo.domain.surl.surl.repository;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.domain.surl.surl.entity.Surl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SurlRepository extends JpaRepository<Surl, Long> {
}
