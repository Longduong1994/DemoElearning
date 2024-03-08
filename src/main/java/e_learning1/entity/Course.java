package e_learning1.entity;

import e_learning1.dto.response.CourseResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public CourseResponse toResponse(){
        return CourseResponse.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .image(this.image).build();
    }
}
