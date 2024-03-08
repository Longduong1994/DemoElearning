package e_learning1.service.account;

import e_learning1.dto.request.LoginRequest;
import e_learning1.dto.response.JwtResponse;
import e_learning1.dto.response.UserDetail;
import e_learning1.exception.LoginException;
import e_learning1.exception.NotFoundException;

public interface  AccountService {
    JwtResponse login(LoginRequest loginRequest) throws LoginException;
    UserDetail getDetail(Long userId) throws NotFoundException;
}
