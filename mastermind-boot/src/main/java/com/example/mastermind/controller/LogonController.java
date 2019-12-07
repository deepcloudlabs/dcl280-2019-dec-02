package com.example.mastermind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mastermind.model.Game;
import com.example.mastermind.model.Player;
import com.example.mastermind.service.AuthenticationService;
import com.example.mastermind.viewmodel.LogonViewModel;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com.tr)
 *
 */
@Controller
@Scope("request")
@RequestMapping("/logon")
public class LogonController {
	@Autowired
	private AuthenticationService authenticationService;
	private Player player;
	private Game game;

	@ModelAttribute("player")
	public Player getPlayer() {
		return player;
	}

	@ModelAttribute("game")
	public Game getGame() {
		return game;
	}

	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Autowired
	public void setGame(Game game) {
		this.game = game;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String logon() {
		return "logon";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String logon(@Validated LogonViewModel logonViewModel,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			return "logon";
		}
		String username = logonViewModel.getEmail();
		String password = logonViewModel.getPassword();
		if (authenticationService.authenticate(username, password)) {
			game.setLevel(logonViewModel.getLevel());
			player.setNickname(logonViewModel.getNickname());
			player.setEmail(logonViewModel.getEmail());
			player.setPassword(logonViewModel.getPassword());
			game.init();
			return "redirect:/game/play";
		}
		model.addAttribute("errorMessage", "Wrong username/password!");		
		return "logon";
	}
}
