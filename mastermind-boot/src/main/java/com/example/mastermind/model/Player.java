package com.example.mastermind.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
@SuppressWarnings("serial")
@Component
@Scope("session")
public class Player implements Serializable {
	private String nickname; // setter+getter
	private String email; // setter+getter
	private String password; // setter+getter

	public Player() {
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}