package e_learning1.service.account;

import e_learning1.dto.request.LoginRequest;
import e_learning1.dto.response.JwtResponse;
import e_learning1.dto.response.UserDetail;
import e_learning1.entity.Account;
import e_learning1.exception.LoginException;
import e_learning1.exception.NotFoundException;
import e_learning1.repository.AccountRepository;
import e_learning1.security.account_principle.AccountPrinciple;
import e_learning1.security.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    private final AuthenticationProvider authenticationProvider;
    private final JwtProvider jwtProvider;
    @Override
    public JwtResponse login(LoginRequest loginRequest) throws LoginException {
        Authentication authentication;
        try {
            authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (AuthenticationException ex) {
            throw new LoginException("Tài khoản hoặc mật khẩu không đúng.");
        }
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        if (!accountPrinciple.getAccount().getIsBlock()) {
            throw new LoginException("Tài khoản đã bị khóa.");
        }
        String token = jwtProvider.generateToken(accountPrinciple);
        return JwtResponse.builder()
                .fullName(accountPrinciple.getAccount().getFullName())
                .token(token)
                .email(accountPrinciple.getAccount().getEmail())
                .roles(accountPrinciple.getAccount().getRoles().stream().map(item -> item.getRoleName().name()).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public UserDetail getDetail(Long userId) throws NotFoundException {
        Optional<Account> account = accountRepository.findById(userId);
        if (!account.isPresent()) {
            throw new NotFoundException("Không tìm thấy user");
        }
        return UserDetail.builder()
                .id(account.get().getId())
                .email(account.get().getEmail())
                .fullName(account.get().getFullName())
                .image(account.get().getImage())
                .email(account.get().getEmail()).build();
    }
}
