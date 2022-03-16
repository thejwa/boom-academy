package team.bahor.entity.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;
import team.bahor.enums.Currency;
import team.bahor.enums.types.PaymentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PaymentHistory extends Auditable {
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentType type;
}
