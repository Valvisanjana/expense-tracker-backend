package com.finance.expense_tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.finance.expense_tracker.dto.IncomeRequestDTO;
import com.finance.expense_tracker.dto.IncomeResponseDTO;
import com.finance.expense_tracker.entity.Income;
import com.finance.expense_tracker.entity.User;
import com.finance.expense_tracker.exception.UserNotFoundException;
import com.finance.expense_tracker.repository.IncomeRepository;
import com.finance.expense_tracker.repository.UserRepository;

@Service
public class IncomeServiceImpl implements IncomeService {

	private final IncomeRepository incomeRepo;
	private final UserRepository userRepo;

	public IncomeServiceImpl(IncomeRepository incomeRepo, UserRepository userRepo) {
		this.incomeRepo = incomeRepo;
		this.userRepo = userRepo;
	}

	@Override
	public IncomeResponseDTO addIncome(IncomeRequestDTO req, String email) {
		User user = userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("user Not Found"));

		Income income = new Income();
		income.setAmount(req.getAmount());
		income.setAmount(req.getAmount());
		income.setIncomeName(req.getIncomeName());
		income.setDate(req.getDate());
		income.setUser(user);

		Income savedIncome = incomeRepo.save(income);
		return new IncomeResponseDTO(savedIncome.getIncomeId(), savedIncome.getAmount(), savedIncome.getIncomeName(),
				savedIncome.getDate());
	}

	@Override
	public void deleteIncomeById(Long incomeId) {
		if (!incomeRepo.existsById(incomeId)) {
			throw new RuntimeException("Income not found");
		}
		incomeRepo.deleteById(incomeId);
	}

	@Override
	public List<IncomeResponseDTO> getAllIncomes(String email) {
		User user = userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("user Not Found"));

		List<Income> incomes = incomeRepo.findByUserId(user.getId());

		return incomes.stream().map(income -> new IncomeResponseDTO(income.getIncomeId(), income.getAmount(),
				income.getIncomeName(), income.getDate())).collect(Collectors.toList());
	}

}
