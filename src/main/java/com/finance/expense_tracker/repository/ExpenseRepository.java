package com.finance.expense_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finance.expense_tracker.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

	@Query("select sum(e.amount) from Expense e where e.user.id = :userId")
	Double getTotalExpense(Long userId);

	@Query("select e from Expense e where e.user.id = :userId order by e.date desc limit 5")
	List<Expense> findTop5ByUserIdOrderByDateDesc(Long userId);


}
