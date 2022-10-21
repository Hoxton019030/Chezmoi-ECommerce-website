package com.finalProject.demo.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	
}
