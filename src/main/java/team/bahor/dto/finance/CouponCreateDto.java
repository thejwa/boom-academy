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

    @Size(max = 6, min = 6)
    private String code;

    @Range(min = 1)
    private int limitSize;

    private double discountAmount;

    private double discountPercentage;

    private LocalDate dueDate;

}
