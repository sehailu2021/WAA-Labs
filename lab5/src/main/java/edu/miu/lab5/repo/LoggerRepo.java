package edu.miu.lab5.repo;

import edu.miu.lab5.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
