package model;

//import businessLogic.vantiv.EMAFFile.ParseEMAFFile;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.sdl.odata.api.edm.annotations.EdmEntity;
//import com.sdl.odata.api.edm.annotations.EdmEntitySet;
//import com.sdl.odata.api.edm.annotations.EdmNavigationProperty;
//import com.sdl.odata.api.edm.annotations.EdmProperty;
//import currency.CurrencyCode;
//import io.swagger.annotations.ApiModelProperty;
//import models.bss.batch.common.BillingTransactionType;
//import models.bss.batch.common.TransactionPricing;
//import models.bss.batch.funding.Batch;
//import models.bss.batch.preFunding.DailyFundingBatch;
//import models.bss.emaf.CreditAuth;
//import models.bss.emaf.CreditReconciliation;
//import models.bss.emaf.DebitAuth;
//import models.bss.emaf.DebitReconciliation;
//import models.bss.emaf.EMAFRecord;
//import models.bss.emaf.EMAFRecordStatus;
//import models.bss.transaction.CardNetwork;
//import models.bss.transaction.CardType;
//import models.bss.transaction.FundingAgent;
//import models.bss.transaction.PaymentMethod;
//import models.bss.transaction.RelatedPartyRef;
//import models.bss.transaction.ResponseCode;
//import models.bss.transaction.TransactionComment;
//import models.bss.transaction.TransactionFee;
//import models.bss.transaction.TransactionProcessor;
//import models.bss.transaction.TransactionStatusHistory;
//import models.bss.transaction.TransactionStatuses;
//import models.bss.transaction.TransactionSubStatus;
//import models.bss.transaction.TransactionType;
//import models.bss.transaction.emaf.EMAFData;
//import models.bss.transaction.emaf.TransactionEmafRecords;
//import models.bss.transaction.funding.FundingData;
//import models.bss.transaction.funding.FundingInstruction;
//import models.bss.transaction.log.TransactionLog;
//import models.bss.transaction.log.TransactionMethod;
//import models.bss.transaction.log.TransactionStatusDetail;
//import models.bss.transaction.log.TransactionStatusStatus;
//import models.bss.transaction.status.TransactionStatus;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
//import util.BigDecimalFactory;
//import utils.Constants;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import static util.FieldFormatConstants.DATE_FORMAT;
//import static util.ODataConstants.ODATA_GENERIC_KEY;
//import static util.ODataConstants.ODATA_NAMESPACE;

@Entity
@Table(name = "transaction_", schema = "boss@cassandra_pu")
public class Transaction {
    public Transaction() {
//        this.transactionStatus = TransactionStatuses.GATEWAY_LOG;
//        this.transactionSubStatus = TransactionStatuses.GATEWAY_LOG.CREATED;
//        this.relatedParties = new ArrayList<>();
//        this.comments = new ArrayList<>();
//        this.statusHistory = new ArrayList<>();
//        this.transactionEmafRecords = new TransactionEmafRecords();
//        this.transactionFees = new TransactionFee();
//        this.fundingData = new FundingData();
//        this.isHeld = false;
//        this.isPended = false;
    }

    @Id
    @Column(name="id")
    public String id;

    @Column(name="href")
    public String href;

    @Column(name="veea_merchant_id")
    public String veeaMerchantId;

    @Column(name="merchant_name")
    public String merchantName;

    @Column(name="vantiv_mid")
    public String vantivMID;

    @Column(name="amount")
    public BigDecimal amount;

//    @Column(name="total_charges")
//    public BigDecimal totalCharges;

//    @Column(name="is_authorized")
//    public Boolean isAuthorized;

//    @Column(name="authorized_date")
//    @JsonFormat(pattern=DATE_FORMAT, timezone="UTC")
//    public ZonedDateTime authorizedDate;
//
//    @Column(name="settlement_date")
//    @JsonFormat(pattern=DATE_FORMAT, timezone="UTC")
//    public ZonedDateTime settlementDate;

    @Embedded
    @Column(name="transaction_fees")
    public TransactionFee transactionFees;

//    @Column(name="interchange")
//    public Double interchange;
//
//    @Column(name="surcharge")
//    public Double surcharge;
//
//    @Column(name="card_network_name")
//    public CardNetwork cardNetworkName;
//
//    @Column(name="currency_code")
//    public CurrencyCode currencyCode;
//
//    @Column(name="payment_method")
//    public PaymentMethod paymentMethod;
//
//    @Column(name="date_")
//    public ZonedDateTime date;
//
//    @Column(name="funding_date")
//    public ZonedDateTime fundingDate;
//
//
//    @Column(name="transaction_status")
//    public TransactionStatus transactionStatus;
//
//    @Column(name="transaction_sub_status")
//    public TransactionSubStatus transactionSubStatus;
//
//    @Column(name="card_type")
//    public CardType cardType;
//
//    @Column(name="transaction_type")
//    public TransactionType transactionType;
//
//    @Column(name="response_code")
//    public ResponseCode responseCode;
//
//    @Column(name="processor")
//    public TransactionProcessor processor;
//
//    @Column(name="funding_agent")
//    public FundingAgent fundingAgent;
//
//    @Column(name="transaction_log")
//    public TransactionLog transactionLog;
//
//    @Column(name="")
//    public TransactionEmafRecords transactionEmafRecords;
//
//    @Column(name="funding_data")
//    public FundingData fundingData;
//
//    @Column(name="related_party")
//    public List<RelatedPartyRef> relatedParties;
//
//    @Column(name="comments")
//    public List<TransactionComment> comments;
//
//    @Column(name="status_history")
//    public List<TransactionStatusHistory> statusHistory;
//
//    @Column(name="transaction_method")
//    public TransactionMethod transactionMethod;
//
//    @Column(name="is_held")
//    protected Boolean isHeld;

    @Column(name="is_pended")
    public Boolean isPended;

//    public boolean getIsHeld() {
//        return this.isHeld;
//    }

//    public void hold(String userName, TransactionComment comment) {
//        if(this.isHeld) {
//            throw new IllegalStateException("already hold");
//        } else if(TransactionStatuses.FUNDED_STATUSES.contains(this.transactionStatus)) {
//            throw new IllegalStateException("already funded");
//        }
//
//        this.isHeld = true;
//        this.comments.add(comment);
//        TransactionStatusHistory held = new TransactionStatusHistory(
//            TransactionStatuses.HELD,
//            null,
//            userName);
//        this.statusHistory.add(held);
//        this.unlinkDailyFundingBatch();
//    }

//    public void release(String userName, TransactionComment comment) {
//        if(!this.getIsHeld()) {
//            throw new IllegalStateException("already released");
//        }
//
//        this.isHeld = false;
//        this.comments.add(comment);
//        TransactionStatusHistory release = new TransactionStatusHistory(
//            TransactionStatuses.RELEASED,
//            null,
//            userName);
//        this.statusHistory.add(release);
//    }

//    @JsonIgnore
//    public BigDecimal getFundingAmount() {
//        BigDecimal amount = this.amount;
//        if(TransactionType.REFUND.equals(this.transactionType)) {
//            amount = amount.negate();
//        }
//
//        return amount
//            .subtract(this.getVeeaPayFee(), BigDecimalFactory.getMathContext())
//            .subtract(this.getReserveAmount(), BigDecimalFactory.getMathContext());
//    }

//    @JsonIgnore
//    public BigDecimal getRefundAmount() {
//        if(!TransactionType.REFUND.equals(this.transactionType)) {
//            return BigDecimalFactory.get("0");
//        }
//
//        return this.amount;
//    }

//    @JsonIgnore
//    public BigDecimal getVeeaPayFee() {
//        return this.transactionFees.getVeeaPayFee();
//    }

//    @JsonIgnore
//    public BigDecimal getReserveAmount() {
//        if(TransactionType.REFUND.equals(this.transactionType)) {
//            return BigDecimalFactory.get("0");
//        }
//
//        return this.transactionFees.reserve;
//    }

//    @JsonIgnore
//    public Optional<RelatedPartyRef> getMerchantRelatedParty() {
//        return this.getRelatedPartyByRole(Constants.RelatedPartyRole.MERCHANT);
//    }

//    @JsonIgnore
//    public Optional<RelatedPartyRef> getPricingRelatedParty() {
//        return this.getRelatedPartyByRole(Constants.RelatedPartyRole.BILLING_PRICING);
//    }

//    @JsonIgnore
//    public Optional<RelatedPartyRef> getReservePricingRelatedParty() {
//        return this.getRelatedPartyByRole(Constants.RelatedPartyRole.RESERVE_PRICING);
//    }

//    @JsonIgnore
//    public Optional<RelatedPartyRef> getRelatedPartyByRole(String role) {
//        if (this.relatedParties == null) {
//            return Optional.empty();
//        }
//
//        return this.relatedParties.stream().filter(rp -> rp.role.equals(role)).findFirst();
//    }

//    @JsonIgnore
//    public Optional<RelatedPartyRef> getDailyFundingBatchRelatedParty() {
//        return this.getRelatedPartyByRole(Constants.RelatedPartyRole.DAILY_FUNDING_BATCH);
//    }

//    @JsonIgnore
//    public BigDecimal getPendedAmount() {
//        if(!this.isPended) {
//            return BigDecimalFactory.get("0");
//        }
//        return this.amount;
//    }

//    public boolean hasMerchantRelatedParty() {
//        return this.getRelatedPartyByRole(Constants.RelatedPartyRole.MERCHANT).isPresent();
//    }

//    public void link(DailyFundingBatch batch) {
//        RelatedPartyRef dailyBatchRelatedParty = new RelatedPartyRef(
//            batch.id,
//            batch.getHref(),
//            Constants.RelatedPartyRole.DAILY_FUNDING_BATCH,
//            null);
//
//        this.relatedParties.add(dailyBatchRelatedParty);
//    }

//    public void unlinkDailyFundingBatch() {
//        Optional<RelatedPartyRef> daily = this.getRelatedPartyByRole(Constants.RelatedPartyRole.DAILY_FUNDING_BATCH);
//        daily.ifPresent(relatedPartyRef -> this.relatedParties.remove(relatedPartyRef));
//    }

//    public void linkToSubmerchantCredit(Batch batch) {
//        if(this.fundingData.subMerchantCredit == null) {
//            this.fundingData.subMerchantCredit = new FundingInstruction();
//        }
//
//        this.fundingData.subMerchantCredit.batchId  = batch.id;
//    }

//    public void linkToSubmerchantDebit(Batch batch) {
//        if(this.fundingData.subMerchantDebit == null) {
//            this.fundingData.subMerchantDebit= new FundingInstruction();
//        }
//
//        this.fundingData.subMerchantDebit.batchId  = batch.id;
//    }

//    public void linkToReserveCredit(Batch batch) {
//        if(this.fundingData.reserveCredit == null) {
//            this.fundingData.reserveCredit = new FundingInstruction();
//        }
//
//        this.fundingData.reserveCredit.batchId  = batch.id;
//    }

//    public void linkToPayFacCredit(Batch batch) {
//        if(this.fundingData.payFacCredit == null) {
//            this.fundingData.payFacCredit = new FundingInstruction();
//        }
//
//        this.fundingData.payFacCredit.batchId  = batch.id;
//    }

//    public void addTransactionEmafRecord(Object paymentRecord, String emafS3Url) {
//        if (CreditAuth.class.isAssignableFrom(paymentRecord.getClass())) {
//            CreditAuth creditAuth = (CreditAuth) paymentRecord;
//            this.transactionEmafRecords.authDetailRecord1 = creditAuth.creditAuthDetailRecord1.rawEmafRecord;
//            this.transactionEmafRecords.authDetailRecord2 = creditAuth.creditAuthDetailRecord2.rawEmafRecord;
//            this.transactionEmafRecords.authEmafS3Url = emafS3Url;
//            this.transactionEmafRecords.cardType = CardType.CREDIT;
//        } else if (CreditReconciliation.class.isAssignableFrom(paymentRecord.getClass())) {
//            CreditReconciliation creditReconciliation = (CreditReconciliation) paymentRecord;
//            this.transactionEmafRecords.reconciliationDetailRecord1 = creditReconciliation.creditReconciliationDetailRecord1.rawEmafRecord;
//            this.transactionEmafRecords.reconciliationDetailRecord2 = creditReconciliation.creditReconciliationDetailRecord2.rawEmafRecord;
//            this.transactionEmafRecords.reconciliationDetailRecord3 = creditReconciliation.creditReconciliationDetailRecord3.rawEmafRecord;
//            this.transactionEmafRecords.reconciliationDetailRecord4 = creditReconciliation.creditReconciliationDetailRecord4.rawEmafRecord;
//            this.transactionEmafRecords.reconciliationEmafS3Url = emafS3Url;
//            this.transactionEmafRecords.cardType = CardType.CREDIT;
//        } else if (DebitAuth.class.isAssignableFrom(paymentRecord.getClass())) {
//            DebitAuth debitAuth = (DebitAuth) paymentRecord;
//            this.transactionEmafRecords.authDetailRecord1 = debitAuth.debitAuthDetailRecord1.rawEmafRecord;
//            this.transactionEmafRecords.authDetailRecord2 = debitAuth.debitAuthDetailRecord2.rawEmafRecord;
//            this.transactionEmafRecords.authEmafS3Url = emafS3Url;
//            this.transactionEmafRecords.cardType = CardType.DEBIT;
//        } else if (DebitReconciliation.class.isAssignableFrom(paymentRecord.getClass())) {
//            DebitReconciliation debitReconciliation = (DebitReconciliation) paymentRecord;
//            this.transactionEmafRecords.reconciliationDetailRecord1 = debitReconciliation.debitReconciliationDetailRecord1.rawEmafRecord;
//            this.transactionEmafRecords.reconciliationDetailRecord2 = debitReconciliation.debitReconciliationDetailRecord2.rawEmafRecord;
//            this.transactionEmafRecords.reconciliationEmafS3Url = emafS3Url;
//            this.transactionEmafRecords.cardType = CardType.DEBIT;
//        }
//    }

//    /**
//     * add a new transaction status
//     *
//     * @param emafRecord emaf record with the information to use in the update
//     * @param emafS3Url  emaf url on S3
//     */
//    public void addStatusDetails(EMAFRecord emafRecord, String emafS3Url) {
//        EMAFRecordStatus emafRecordStatus = emafRecord.retrieveEMAFRecordStatus();
//
//        if(emafRecordStatus.transactionStatusStatus.equals(TransactionStatusStatus.SETTLED)){
//            TransactionStatusDetail statusDetail = new TransactionStatusDetail();
//            statusDetail.transactionStatusType = emafRecordStatus.transactionStatusType;
//            statusDetail.transactionStatusStatus = emafRecordStatus.transactionStatusStatus;
//            statusDetail.emafS3Url = emafS3Url;
//            statusDetail.timestamp = Instant.now().getEpochSecond();
//            this.transactionLog.statusDetails.add(statusDetail);
//        }
//    }

//    public void addInterchangeAndSurcharge(Object paymentRecord) {
//
//        if (CreditReconciliation.class.isAssignableFrom(paymentRecord.getClass())) {
//            CreditReconciliation creditReconciliation =  (CreditReconciliation) paymentRecord;
//            this.interchange = creditReconciliation.getInterchangeAmount();
//            this.surcharge = creditReconciliation.getSurchargeAmount();
//        } else if (DebitReconciliation.class.isAssignableFrom(paymentRecord.getClass())) {
//            DebitReconciliation debitReconciliation = (DebitReconciliation) paymentRecord;
//            this.interchange = debitReconciliation.getInterchangeAmount();
//        }
//    }

//    public void updateTransactionFees(TransactionPricing pricing) {
//        this.updateDiscountRate(pricing);
//        this.updatePerTransactionFee(pricing);
//        this.totalCharges = this.transactionFees.perTransactionFee.add(this.transactionFees.discountRate);
//        this.updateReserveFee(pricing);
//        this.updatePricingRelatedParties(pricing);
//
//        this.fundingData = new FundingData();
//        if(TransactionType.REFUND.equals(this.transactionType)) {
//            this.fundingData.subMerchantDebit.amount = this.getFundingAmount().negate();
//        } else {
//            this.fundingData.subMerchantCredit.amount = this.getFundingAmount();
//        }
//
//        this.fundingData.reserveCredit.amount = this.getReserveAmount();
//        this.fundingData.payFacCredit.amount = this.getVeeaPayFee();
//    }

//    public void markAsPended(String userName, TransactionComment comment) {
//        if (this.isPended) {
//            throw new IllegalStateException("Already pended");
//        }
//
//        this.isPended = true;
//        this.comments.add(comment);
//        TransactionStatusHistory pended = new TransactionStatusHistory(
//                TransactionStatuses.PENDED,
//                null,
//                userName
//        );
//        this.statusHistory.add(pended);
//    }

//    public void unMarkAsPended(String userName, TransactionComment comment) {
//        if (!this.isPended) {
//            throw new IllegalStateException("Already removed pended condition");
//        }
//
//        this.isPended = false;
//        this.comments.add(comment);
//        TransactionStatusHistory releasePended = new TransactionStatusHistory(
//                TransactionStatuses.RELEASE_PENDED,
//                null,
//                userName
//        );
//        this.statusHistory.add(releasePended);
//    }

//    private void updateDiscountRate(TransactionPricing pricing) {
//        if(this.transactionType == TransactionType.REFUND) { //Refunds don't have a discountRate
//            this.transactionFees.discountRate = BigDecimalFactory.get("0");
//        } else {
//            this.transactionFees.discountRate = (this.amount.multiply(pricing.discountRate, BigDecimalFactory.getMathContext()))
//                .divide(BigDecimalFactory.get("100"), BigDecimalFactory.getMathContext());
//        }
//    }

//    private void updatePerTransactionFee(TransactionPricing pricing) {
//
//        if(TransactionType.REFUND.equals(this.transactionType)) {
//           return;
//        }
//
//        this.transactionFees.perTransactionFee = pricing.perTransactionFee;
//    }

//    private void updateReserveFee(TransactionPricing pricing) {
//
//        if(TransactionType.REFUND.equals(this.transactionType)) {
//            return;
//        }
//
//        if(pricing.reserve == null) {
//            this.transactionFees.reserve = BigDecimalFactory.get("0");
//            return;
//        }
//
//        BigDecimal reserveAmount = BigDecimalFactory.get("0");
//        if(pricing.reserve.isPercentage) {
//            reserveAmount = (this.amount.multiply(pricing.reserve.reserveValue, BigDecimalFactory.getMathContext()))
//                .divide(BigDecimalFactory.get("100"), BigDecimalFactory.getMathContext());
//        } else {
//            reserveAmount = pricing.reserve.reserveValue;
//        }
//
//        this.transactionFees.reserve = reserveAmount;
//    }

//    private void updatePricingRelatedParties(TransactionPricing pricing) {
//        this.removeRelatedPartyIfPresent(Constants.RelatedPartyRole.BILLING_PRICING);
//        this.relatedParties.add(new RelatedPartyRef(pricing.billingId, "", Constants.RelatedPartyRole.BILLING_PRICING, pricing.version));
//        this.removeRelatedPartyIfPresent(Constants.RelatedPartyRole.RESERVE_PRICING);
//        if(pricing.reserve != null) {
//            this.relatedParties.add(new RelatedPartyRef(pricing.reserve.billingId, "", Constants.RelatedPartyRole.RESERVE_PRICING, pricing.reserve.version));
//        }
//    }

//    public void removeRelatedPartyIfPresent(String role) {
//        Optional<RelatedPartyRef> toRemove = this.getRelatedPartyByRole(role);
//        toRemove.ifPresent(relatedPartyRef -> this.relatedParties.remove(relatedPartyRef));
//    }

//    public Optional<TransactionPricing> selectPricing(List<TransactionPricing> transactionPrices) {
//        if(this.transactionType.equals(TransactionType.PRE_AUTH)) {
//            return transactionPrices.stream()
//                .filter(tp -> tp.type.equals(BillingTransactionType.PRE_AUTH))
//                .filter(tp -> tp.cardBrand.equals(this.cardNetworkName))
//                .findFirst();
//        }
//
//        Optional<TransactionMethod> transactionMethodOptional = this.transactionLog.getTransactionMethod();
//        if(!transactionMethodOptional.isPresent()) {
//            return Optional.empty();
//        }
//
//        TransactionMethod transactionMethod = transactionMethodOptional.get();
//        for(TransactionPricing pricing : transactionPrices) {
//            if(!this.cardNetworkName.equals(pricing.cardBrand)) {
//                continue;
//            }
//
//            if((transactionMethod.equals(TransactionMethod.CONTACT) ||
//                transactionMethod.equals(TransactionMethod.CONTACTLESS)) &&
//                pricing.type.equals(BillingTransactionType.CP)) {
//                return Optional.of(pricing);
//            }
//
//            if(transactionMethod.equals(TransactionMethod.CARD_NOT_PRESENT) && pricing.type.equals(BillingTransactionType.CNP)) {
//                return Optional.of(pricing);
//            }
//
//            if(transactionMethod.equals(TransactionMethod.MANUAL_ENTRY) && pricing.type.equals(BillingTransactionType.KEYIN)) {
//                return Optional.of(pricing);
//            }
//        }
//
//        return Optional.empty();
//    }

//    @JsonIgnore
//    public EMAFData getEMAFData() {
//        if(this.emafData == null) {
//            this.emafData = ParseEMAFFile.parseToEmafData(this.transactionEmafRecords);
//        }
//        return this.emafData;
//    }

}
