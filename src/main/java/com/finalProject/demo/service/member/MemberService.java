package com.finalProject.demo.service.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.repository.member.MemberRepository;

@Transactional
@Service
public class MemberService {
	
	@Autowired
	private MemberRepository mDao;
	
	public String leftPadding(String phone) {
		return String.format("%010d",phone);
	}
	
	public Member insert(Member member) {
		return mDao.save(member);
	}
	
	public Page<Member> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "memberId");
		Page<Member> page = mDao.findAll(pgb);
		return page;
	}
	
//	public List<Member> findAll() {
//		return mDao.findAll();
//	}
	

	
	public Member findById(Long memberId) {
		Optional<Member> optional = mDao.findById(memberId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	
//	public void deleteById(Integer id) {
//		mDao.deleteById(id);
//	}
	
	
}
