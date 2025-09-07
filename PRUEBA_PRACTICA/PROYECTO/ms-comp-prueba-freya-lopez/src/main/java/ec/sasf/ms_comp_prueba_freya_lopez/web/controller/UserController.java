package ec.sasf.ms_comp_prueba_freya_lopez.web.controller;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.UserEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.UserRepository;
import ec.sasf.ms_comp_prueba_freya_lopez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public UserEntity crearUsuario(@RequestBody UserEntity user) {
        return userService.crearUsuario(user);
    }

    @GetMapping
    public List<UserEntity> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PutMapping("/{id}")
    public UserEntity actualizarUsuario(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.actualizarUsuario(id, user);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        userService.eliminarUsuario(id);
        return "Usuario eliminado correctamente";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        UserEntity user = userRepository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }

        Map<String, String> response = new HashMap<>();
        response.put("email", user.getEmail());
        response.put("role", user.getRole());
        return response;
    }

}
