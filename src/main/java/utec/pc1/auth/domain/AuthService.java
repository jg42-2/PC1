package utec.pc1.auth.domain;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import utec.pc1.auth.DTO.LoginRequestDTO;
import utec.pc1.auth.DTO.LoginResponseDTO;
import utec.pc1.auth.DTO.RegisterResponseDTO;
import utec.pc1.auth.components.JwtService;
import utec.pc1.exceptions.InvalidCredentialsException;
import utec.pc1.exceptions.UserAlreadyExistsException;
import utec.pc1.user.domain.User;
import utec.pc1.user.infrastructure.UserRepository;
import utec.pc1.auth.DTO.RegisterRequestDTO;

import javax.naming.AuthenticationException;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager, JwtService jwtService,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public RegisterResponseDTO register(RegisterRequestDTO request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("El username ya está registrado: " + request.getUsername());
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("El email ya está registrado: " + request.getEmail());
        }


        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = userRepository.save(user);
        return modelMapper.map(saved, RegisterResponseDTO.class);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Credenciales inválidas"));

        String token = jwtService.generateToken(user);
        return new LoginResponseDTO(token, (int) jwtService.getExpirationInSeconds());
    }
}