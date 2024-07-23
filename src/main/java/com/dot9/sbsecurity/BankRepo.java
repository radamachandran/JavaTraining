package com.dot9.sbsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<BankUser, Long> {
          
 public	BankUser findByUsername(String username);
}
