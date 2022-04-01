package team.bahor.services.finance;

import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.finance.CouponDto;
import team.bahor.dto.finance.CouponUpdateDto;
import team.bahor.services.base.GenericCrudService;

public interface CouponService extends GenericCrudService<
        CouponDto,
        CouponCreateDto,
        CouponUpdateDto,
        String> {
}