package com.dreamjournal.Dream_journal_api.repository;

import com.dreamjournal.Dream_journal_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User ,Long>{
}
