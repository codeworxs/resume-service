package com.codeworxs.resume.app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResumeMasterRepository extends JpaRepository<ResumeMaster, Long> {
 
	Optional<List<ResumeMaster>> findByUserId(Long userId);
}
