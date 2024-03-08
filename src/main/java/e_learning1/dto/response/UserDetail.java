package e_learning1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetail {
    private Long id;
    private String email;
    private String fullName;
    private String password;
    private Boolean isLogin;
    private Boolean isBlock;
}
