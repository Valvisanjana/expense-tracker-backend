package com.finance.expense_tracker.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.finance.expense_tracker.dto.DashboardDTO;
import com.finance.expense_tracker.dto.RecentTransactionDTO;
import com.finance.expense_tracker.entity.Expense;
import com.finance.expense_tracker.entity.Income;
import com.finance.expense_tracker.entity.User;
import com.finance.expense_tracker.exception.UserNotFoundException;
import com.finance.expense_tracker.repository.ExpenseRepository;
import com.finance.expense_tracker.repository.IncomeRepository;
import com.finance.expense_tracker.repository.UserRepository;

@Service
public class DashboardServive {

	private final ExpenseRepository expenseRepository;
	private final IncomeRepository incomeRepository;
	private final UserRepository userRepository;

	public DashboardServive(ExpenseRepository expenseRepository, IncomeRepository incomeRepository,
			UserRepository userRepository) {
		this.expenseRepository = expenseRepository;
		this.incomeRepository = incomeRepository;
		this.userRepository = userRepository;
	}

	public DashboardDTO getDashboard(String username) {

		User user = userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundException("User not found"));
		Long userId = user.getId();

		Double totalIncome = incomeRepository.getTotalIncome(userId);
		Double totalExpense = expenseRepository.getTotalExpense(userId);
		Double saving = totalIncome - totalExpense;		
		
		List<Expense> rt = expenseRepository.findTop5ByUserIdOrderByDateDesc(userId);
		List<RecentTransactionDTO> recentTransactions = rt.stream()
				.map(expense -> new RecentTransactionDTO(expense.getTitle(), expense.getAmount(),
						expense.getCategory().getCategoryName(), expense.getDate()))
				.toList();
		return new DashboardDTO(totalIncome, totalExpense, saving, recentTransactions);

	}
}
