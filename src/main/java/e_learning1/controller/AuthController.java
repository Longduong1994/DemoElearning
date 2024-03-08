package e_learning1.controller;

import e_learning1.dto.request.LoginRequest;
import e_learning1.exception.LoginException;
import e_learning1.exception.NotFoundException;
import e_learning1.service.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class AuthController {
    private  final AccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws LoginException {
        return new ResponseEntity<>(accountService.login(loginRequest), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProfile(@PathVariable("id") String id) throws NotFoundException {
        Long userId = Long.parseLong(id);
        return new ResponseEntity<>(accountService.getDetail(userId), HttpStatus.OK);
    }
}
