package rabbit.ms.email.models;

import jakarta.persistence.*;
import lombok.Data;
import rabbit.ms.email.dtos.EmailRequestDTO;
import rabbit.ms.email.enums.EmailStatus;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class EmailModel {

    public EmailModel(EmailRequestDTO emailRequestDTO){
        this.ownerRef = emailRequestDTO.getOwnerRef();
        this.emailFrom = emailRequestDTO.getEmailFrom();
        this.emailTo = emailRequestDTO.getEmailTo();
        this.subject = emailRequestDTO.getSubject();
        this.body = emailRequestDTO.getBody();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime sentAt;
    private EmailStatus emailStatus;
}