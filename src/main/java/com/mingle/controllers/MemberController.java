package com.mingle.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingle.domain.entites.Member;
import com.mingle.dto.MemberDTO;
import com.mingle.services.MemberService;

@Controller
@RestController
@RequestMapping("/api/member")
public class MemberController {
	@Autowired
	private MemberService mServ;

	// 사용자 기본정보 불러오기 - 아이디, 닉네임
	@GetMapping("/userBasicInfo")
	public ResponseEntity<Map<String, String>> selectUserNickName(Authentication authentication) {
		Map<String, String> userInfo = new HashMap<>();

		// 사용자 아이디 가져오기
		if (authentication != null) {
			String username = authentication.getName();
			// 로그인한 사용자 nickName 불러오기
			String userNick = mServ.selectUserNickName(username);
			// 아이디랑 닉네임 맵으로 생성
			userInfo.put("loginID", username);
			userInfo.put("loginNick", userNick);
		}

		return ResponseEntity.ok(userInfo);
	}

	// 아이디 중복검사
	@PostMapping("/idDuplicateCheck")
	public ResponseEntity<Boolean> idDuplicateCheck(@RequestBody String id) {
		boolean result = mServ.idDuplicateCheck(id);
		return ResponseEntity.ok(result);
	}

	// 이메일 중복검사
	@PostMapping("/emailDuplicateCheck")
	public ResponseEntity<Boolean> emailDuplicateCheck(String email) {
		boolean result = mServ.emailDuplicateCheck(email);
		return ResponseEntity.ok(result);
	}

	// 전화번호 중복검사
	@PostMapping("/phoneDuplicateCheck")
	public ResponseEntity<Boolean> phoneDuplicateCheck(@RequestBody String phone) {
		boolean result = mServ.phoneDuplicateCheck(phone);
		return ResponseEntity.ok(result);
	}
	
	// 닉네임 랜덤 생성
	@GetMapping("/createNickName")
	public ResponseEntity<String> createNickName(){
		String result = mServ.createNickName();
		return ResponseEntity.ok(result);
	}
	
	// 회원가입
	@PostMapping("/insertMember")
	public ResponseEntity<Integer> insertMember(@RequestBody MemberDTO dto){
		System.out.println(dto.getBirth());
		Member insertResult = mServ.insertMember(dto);
		int result = insertResult!=null?1:0;
		return ResponseEntity.ok(result);
	}
}
