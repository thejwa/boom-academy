package team.bahor.repositories.finance;

import org.springframework.stereotype.Repository;
import team.bahor.entity.finance.Coupon;
import team.bahor.repositories.base.AbstractRepository;
import team.bahor.repositories.base.BaseGenericRepository;

@Repository
public interface CouponRepository extends AbstractRepository<Coupon, String> {
}
