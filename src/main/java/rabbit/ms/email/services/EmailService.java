package rabbit.ms.email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rabbit.ms.email.enums.EmailStatus;
import rabbit.ms.email.models.EmailModel;
import rabbit.ms.email.repositories.EmailRepository;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getBody());
            emailSender.send(message);

            emailModel.setSentAt(LocalDateTime.now());
            emailModel.setEmailStatus(EmailStatus.SENT);
        } catch (MailException ex) {
            System.out.println(ex.getMessage());
            emailModel.setEmailStatus(EmailStatus.ERROR);
        }
        return emailRepository.save(emailModel);
    }

}
