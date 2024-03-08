package e_learning1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseParticipating {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private Long percent;
}
