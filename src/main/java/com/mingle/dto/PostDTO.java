package com.mingle.dto;

import java.time.Instant;
import java.util.Set;

import com.mingle.domain.entites.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PostDTO {
	
	// 공통 요소
	private Long id;
//	private String memberId;
	private String title;
	private String content;
	private Instant writeDate;
	private Long viewCount;
	private Boolean isNotice;
	private Boolean isFix;
	private Long reviewGrade;
	private Set<Reply> replies;
	private MemberDTO member;
	
//	@Builder
//	public PostDTO(Long id, String memberId, String title, String contents, Instant writeDate, Long viewCount,
//			Boolean isNotice, Boolean isFix, Long reviewGrade, Set<Reply> replies) {
//		super();
//		this.id = id;
//		this.memberId = memberId;
//		this.title = title;
//		this.contents = contents;
//		this.writeDate = writeDate;
//		this.viewCount = viewCount;
//		this.isNotice = isNotice;
//		this.isFix = isFix;
//		this.reviewGrade = reviewGrade;
//		this.replies = replies;
//	}
	
	@Builder
	public PostDTO(Long id, String title, String content, Instant writeDate, Long viewCount, Boolean isNotice,
			Boolean isFix, Long reviewGrade, Set<Reply> replies, MemberDTO member) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
		this.isNotice = isNotice;
		this.isFix = isFix;
		this.reviewGrade = reviewGrade;
		this.replies = replies;
		this.member = member;
	}
	
	
	
	
	
	
	

	
}
