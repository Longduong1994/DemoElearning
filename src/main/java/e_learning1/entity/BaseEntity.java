package e_learning1.entity;

import java.time.LocalDate;

public abstract class BaseEntity {
    private String createdBy;
    private String updatedBy;
    private LocalDate createAt;
    private LocalDate updateAt;
}
