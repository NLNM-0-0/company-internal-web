package com.ciw.backend.repository;

import com.ciw.backend.entity.ResourceCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ResourceCalendarRepository extends JpaRepository<ResourceCalendar, Long>, JpaSpecificationExecutor<ResourceCalendar> {
	boolean existsByResourceIdAndDateAfter(Long resourceId, Date date);

	void deleteByResourceId(Long resourceId);

	List<ResourceCalendar> getByDate(Date date);

	@Query("SELECT rc FROM ResourceCalendar rc WHERE rc.date BETWEEN :from AND :to")
	List<ResourceCalendar> getByDateBetween(Date from, Date to);
}
