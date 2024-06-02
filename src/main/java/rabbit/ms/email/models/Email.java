package rabbit.ms.email.models;

import jakarta.persistence.*;
import lombok.Data;
import rabbit.ms.email.enums.EmailStatus;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class Email{
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