package team.bahor.dto.finance;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import team.bahor.dto.BaseGenericDto;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class CouponCreateDto implements BaseGenericDto {

    private String courseId;

    @Size(max = 12, min = 12)
    private String code;

    @Range(min = 1)
    private int limitSize;

    @Range(min = 0)
    private double discountAmount;

    @Range(min = 0, max = 100)
    private double discountPercentage;

    private LocalDate dueDate;

}
