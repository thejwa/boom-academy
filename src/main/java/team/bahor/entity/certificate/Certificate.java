package team.bahor.entity.certificate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Certificate extends Auditable {
    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Double percentage;

}
