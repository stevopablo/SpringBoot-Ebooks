package com.bookCulture.ebooks.controller;

import com.bookCulture.ebooks.model.LivroModel;
import com.bookCulture.ebooks.model.UserModel;
import com.bookCulture.ebooks.repository.iLivroRepository;
import com.bookCulture.ebooks.repository.iUserRepository;
import com.bookCulture.ebooks.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private iUserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private iLivroRepository livroRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user){
        if(userRepository.findByName(user.getName()) != null){
            return ResponseEntity.badRequest().body("user allready exist");
        } else if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email já cadastrado!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("usuario criado " + user.getName());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserModel user){
        UserModel existUser = userRepository.findByName(user.getName());
        if (existUser == null || !passwordEncoder.matches(user.getPassword(), existUser.getPassword())){
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
        String token = jwtUtil.generateToken(user.getName());
        System.out.println("token gerado "+ token);
        return ResponseEntity.ok("Bearer "+ token);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        List<UserModel> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{userId}/cart/{bookId}")
    public ResponseEntity<?> addToCart(@PathVariable String userId, @PathVariable String bookId){
        Optional<UserModel> userOpt = userRepository.findById(userId);
        Optional<LivroModel> bookOpt = livroRepository.findById(bookId);
        if (userOpt.isPresent() && bookOpt.isPresent()){
            UserModel user = userOpt.get();
            user.getCart().add(bookId);
            userRepository.save(user);
            return ResponseEntity.ok("Livro adicionado");
        }
        return ResponseEntity.status(404).body("erro ao adicionar livro");
    }

    @GetMapping("/{userId}/cart")
    public ResponseEntity<?> getCart(@PathVariable String userId){
        Optional<UserModel> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()){
            List<String> cart = userOpt.get().getCart();
            return ResponseEntity.ok(cart);
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }

    @DeleteMapping("/{userId}/{bookId}")
    public ResponseEntity<?> removeFromCart(@PathVariable String userId, @PathVariable String bookId ){
        Optional<UserModel> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()){
            UserModel user = userOpt.get();
            user.getCart().remove(bookId);
            userRepository.save(user);
                return ResponseEntity.ok("Livro removido com sucesso");
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }
}
