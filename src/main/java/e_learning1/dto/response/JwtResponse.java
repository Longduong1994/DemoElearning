package e_learning1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {
    private Long id;
    private String fullName;
    private String email;
    private String token;
    private Set<String> roles;

}
