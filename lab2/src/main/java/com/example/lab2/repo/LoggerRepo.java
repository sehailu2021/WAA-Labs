package com.example.lab2.repo;

import com.example.lab2.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
