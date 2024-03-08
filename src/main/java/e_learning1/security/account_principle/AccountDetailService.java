package e_learning1.security.account_principle;

import e_learning1.entity.Account;
import e_learning1.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class AccountDetailService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByEmail(email);
        if (account.isPresent()) {
            return  AccountPrinciple.builder()
                    .account(account.get())
                    .authorities(account.get().getRoles().stream().map(item -> new SimpleGrantedAuthority(item.getRoleName().name())).collect(Collectors.toSet()))
                    .build();
        } else {
            throw new UsernameNotFoundException(email + " not found");
        }
    }
}
