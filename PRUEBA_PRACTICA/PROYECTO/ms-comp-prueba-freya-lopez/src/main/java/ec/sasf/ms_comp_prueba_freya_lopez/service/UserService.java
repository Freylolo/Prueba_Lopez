package ec.sasf.ms_comp_prueba_freya_lopez.service;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.UserEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity crearUsuario(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserEntity> listarUsuarios() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> obtenerPorId(Long id) {
        return userRepository.findById(id);
    }

    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity actualizarUsuario(Long id, UserEntity userActualizado) {
        return userRepository.findById(id).map(user -> {
            user.setName(userActualizado.getName());
            user.setEmail(userActualizado.getEmail());
            if (userActualizado.getPassword() != null && !userActualizado.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userActualizado.getPassword()));
            }
            user.setRole(userActualizado.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public boolean login(String email, String password) {
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
    public Optional<UserEntity> obtenerPorEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

}
