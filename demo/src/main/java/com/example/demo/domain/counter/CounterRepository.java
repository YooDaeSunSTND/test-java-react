package com.example.demo.domain.counter;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CounterRepository extends JpaRepository<Counter, Long> {

    Optional<Counter> findCounterByUsername(String username);


    @Modifying
    @Query("update Counter c set c.counterNum = ?1 where c.id = ?2")
    void setCounterById(Integer counterNum, Integer counterId);

}
