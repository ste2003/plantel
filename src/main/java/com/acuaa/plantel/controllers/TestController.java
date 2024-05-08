package com.acuaa.plantel.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acuaa.plantel.models.SwimStyle;
import com.acuaa.plantel.models.Time;
import com.acuaa.plantel.models.User;
import com.acuaa.plantel.payload.request.LoginRequest;
import com.acuaa.plantel.payload.request.TimeRequest;
import com.acuaa.plantel.payload.response.MessageResponse;
import com.acuaa.plantel.repository.TimeRepository;
import com.acuaa.plantel.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TimeRepository timeRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess(@AuthenticationPrincipal final Principal principal) {
		if (userRepository.existsByUsername(principal.getName())) {
			// username = ((UserDetails) principal).getUsername();
			System.out.println("funciona!");
			return "algo";
		}

		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Inform Board.";
	}
	
	@PostMapping("/time")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> setTime(@RequestBody TimeRequest timeRequest) {
		//public ResponseEntity<?> setTime(@RequestBody TimeRequest timeRequest) {
		   // return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		User user = user = userRepository.findById(timeRequest.getUserId())
				.orElseThrow(() -> new EntityNotFoundException());
		
		//Integer id, Date date, String swimmingpool, Integer distance, SwimStyle swimStyle, Integer minutes,
		//Integer seconds, Integer miliseconds
		Time time = new Time();
		time.setDate(timeRequest.getDate());
		time.setDistance(timeRequest.getDistance());
		time.setMiliseconds(timeRequest.getMiliseconds());
		time.setMinutes(timeRequest.getMinutes());
		time.setSeconds(timeRequest.getSeconds());
		time.setSwimmingpool(timeRequest.getSwimmingpool());
		time.setSwimStyle(timeRequest.getSwimStyle());		
		time.setUser(user);
		
		
		System.out.println(time);
		timeRepository.save(time);
		    
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@RequestMapping(value = "/times/{id}", method = RequestMethod.GET)	
	public Optional<Time> getTime(@PathVariable("id") Long id) {
		return timeRepository.findById(id);

	}
	
	@RequestMapping(value = "/times", method = RequestMethod.GET)
	public List<Time> getTime(){
		return timeRepository.findAll();
	}
	
	@RequestMapping(value = "/times/{id}", method = RequestMethod.DELETE)
	public void deleteTime(@PathVariable("id") Long id) {
		timeRepository.deleteById(id);		
	}
	@RequestMapping(value = "/times/{id}", method = RequestMethod.PUT)
	public Time updateCoupon(@RequestBody Time c) {
		return timeRepository.save(c);
		
		
	}
		

	
}
