package br.com.guilhermea23.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private InterfaceUserRepository userRepository;
    
    @PostMapping("/")
    public ResponseEntity create(@RequestBody User user){
        var userData = this.userRepository.findByUsername(user.getUsername());

        if (userData !=null){
            System.out.println("esse username nao ta pra jogo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe.");
        }


        var passwordHashred = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());

        user.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
