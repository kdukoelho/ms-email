package rabbit.ms.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rabbit.ms.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, String> {
}
