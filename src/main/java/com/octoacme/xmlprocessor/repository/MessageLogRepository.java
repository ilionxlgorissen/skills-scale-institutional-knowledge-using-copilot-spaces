package com.octoacme.xmlprocessor.repository;

import com.octoacme.xmlprocessor.entity.MessageLog;
import com.octoacme.xmlprocessor.model.ResponseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for {@link MessageLog} audit records.
 */
@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {

    Optional<MessageLog> findByMessageId(String messageId);

    List<MessageLog> findByStatus(ResponseStatus status);
}
