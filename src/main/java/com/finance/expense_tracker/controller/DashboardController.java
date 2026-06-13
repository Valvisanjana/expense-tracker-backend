package com.finance.expense_tracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.expense_tracker.dto.DashboardDTO;
import com.finance.expense_tracker.service.DashboardServive;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

	private final DashboardServive dashboardService;

	public DashboardController(DashboardServive dashboardService) {
		this.dashboardService = dashboardService;
	}
	
	@GetMapping("/dashboard")
	public DashboardDTO getDashboard(@AuthenticationPrincipal UserDetails userDetails) {
	    return dashboardService.getDashboard(userDetails.getUsername());
	}
	
	
}
