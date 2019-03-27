package kr.hs.dgsw.web_326.Repository;

import kr.hs.dgsw.web_326.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
