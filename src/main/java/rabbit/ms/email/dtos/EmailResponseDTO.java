package rabbit.ms.email.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import rabbit.ms.email.enums.EmailStatus;
import rabbit.ms.email.models.EmailModel;

import java.time.LocalDateTime;

@Data
public class EmailResponseDTO {

    public EmailResponseDTO(EmailModel email) {
        this.emailId = email.getEmailId();
        this.ownerRef = email.getOwnerRef();
        this.emailFrom = email.getEmailFrom();
        this.emailTo = email.getEmailTo();
        this.subject = email.getSubject();
        this.body = email.getBody();
        this.sentAt = email.getSentAt();
        this.emailStatus = email.getEmailStatus();
    }

    @NotBlank
    private String emailId;
    @NotBlank
    private String ownerRef;
    @Email
    @NotBlank
    private String emailFrom;
    @NotBlank
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String body;

    private LocalDateTime sentAt;

    private EmailStatus emailStatus;
}
