package utec.pc1.auth.application;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utec.pc1.auth.DTO.LoginRequestDTO;
import utec.pc1.auth.DTO.LoginResponseDTO;
import utec.pc1.auth.DTO.RegisterRequestDTO;
import utec.pc1.auth.DTO.RegisterResponseDTO;
import utec.pc1.auth.domain.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestParam RegisterRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestParam LoginRequestDTO request){
        return ResponseEntity.ok(authService.login(request));
    }


}
