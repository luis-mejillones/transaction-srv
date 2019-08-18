package model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Access(AccessType.FIELD)
public class TransactionFee {
    public TransactionFee() {
        this.discountRate = BigDecimal.ZERO;
        this.perTransactionFee = BigDecimal.ZERO;
        this.reserve = BigDecimal.ZERO;
    }

    @Column(name="discount_rate")
    public BigDecimal discountRate;

    @Column(name="per_transaction_fee")
    public BigDecimal perTransactionFee;

    @Column(name="reserve")
    public BigDecimal reserve;
}
