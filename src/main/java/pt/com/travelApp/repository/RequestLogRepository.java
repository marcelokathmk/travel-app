package pt.com.travelApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.com.travelApp.entity.RequestLog;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Long>{

}
