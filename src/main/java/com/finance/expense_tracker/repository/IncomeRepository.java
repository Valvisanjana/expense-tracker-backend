package com.finance.expense_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finance.expense_tracker.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

	@Query("select coalesce(sum(i.amount), 0) from Income i where i.user.id = :userId")
	Double getTotalIncome(@Param("userId")Long userId);
	
	List<Income> findByUserId(Long userId);
	
	Double findIncomeByDate(Long userId, int monthValue, int year);
 
}
