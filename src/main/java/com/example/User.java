package com.example;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "사용자 DTO")
public class User {
    @Schema(description = "사용자 ID", nullable = false, example = "user1")
    private String userId;

    @Schema(description = "사용자 이름", nullable = false, example = "홍길동")
    private String userNm;

    @Schema(description = "사용자 나이", example = "20")
    private int age;

    @Schema(description = "사용여부", defaultValue = "Y", allowableValues = {"Y", "N"})
    private String useYn;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
    
    
}
