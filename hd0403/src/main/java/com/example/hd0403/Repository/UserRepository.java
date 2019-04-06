package com.example.hd0403.Repository;

import com.example.hd0403.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
