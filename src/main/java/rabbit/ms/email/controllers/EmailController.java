package rabbit.ms.email.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rabbit.ms.email.dtos.EmailRequestDTO;
import rabbit.ms.email.dtos.EmailResponseDTO;
import rabbit.ms.email.models.EmailModel;
import rabbit.ms.email.services.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<EmailResponseDTO> sendEmail(@RequestBody @Valid EmailRequestDTO emailRequestDTO) {
        EmailModel emailModel = new EmailModel(emailRequestDTO);
        EmailResponseDTO emailResponseDTO = new EmailResponseDTO(emailService.sendEmail(emailModel));
        return ResponseEntity.ok(emailResponseDTO);
    }
}
