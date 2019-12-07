package com.example.mastermind.viewmodel;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.mastermind.validation.Email;
import com.example.mastermind.validation.Iban;
import com.example.mastermind.validation.StrongPassword;
import com.example.mastermind.validation.TcKimlikNo;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
public class LogonViewModel {
	@Size(min = 5, message = "{validation.knickname}")
	private String nickname;
	@Email
	@Pattern(regexp = "^\\+?[a-z0-9](([-+.]|[_]+)?[a-z0-9]+)*@([a-z0-9]+(\\.|\\-))+[a-z]{2,6}$", message = "{validation.email}")	
	private String email;
	@StrongPassword
	private String password;
	@Iban(message = "{validation.iban}")
	private String iban;
	@TcKimlikNo
	private String identityNo;
	private int level;

	public LogonViewModel() {
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

}
