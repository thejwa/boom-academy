package team.bahor.validators.finance;

import org.springframework.stereotype.Component;
import team.bahor.exeptions.NotAllowedException;
import team.bahor.validators.base.BaseGenericValidator;

import java.time.LocalDate;

@Component
public class CouponValidator implements BaseGenericValidator {

    public  void thenAfter(LocalDate localDate) {

        if (localDate.isAfter(LocalDate.now())) {

            throw new NotAllowedException("please enter the next time");

        }

    }
}
