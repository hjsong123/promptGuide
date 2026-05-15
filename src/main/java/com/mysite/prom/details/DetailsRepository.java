package com.mysite.prom.details;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details, Integer> {
	Details findBySubject(String subject);
	Details findBySubjectAndContent(String subject, String content);
	List<Details> findBySubjectLike(String subject);
	List<Details> findByCategory(Integer category);
}
