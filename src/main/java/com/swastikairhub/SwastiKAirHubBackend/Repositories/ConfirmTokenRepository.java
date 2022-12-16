package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.User.Registration.RegistrationToken.ConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
@Repository
public interface ConfirmTokenRepository extends CrudRepository<ConfirmationToken,Long> {
    @Query("SELECT ct FROM ConfirmationToken ct WHERE ct.token=?1")
    Optional<ConfirmationToken> findByToken(String token);
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
