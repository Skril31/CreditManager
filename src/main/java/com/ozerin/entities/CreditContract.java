package com.ozerin.entities;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "credit_contracts")
public class CreditContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "credit_application_id", nullable = false)
    private CreditApplication creditApplication;
    @Column(name = "sign_date")
    private LocalDate signDate;
    @Column(name = "signature_status")
    private String signatureStatus;

    public CreditContract() {
    }

    public CreditContract(CreditApplication creditApplication, LocalDate signDate, String signatureStatus) {
        this.creditApplication = creditApplication;
        this.signDate = signDate;
        this.signatureStatus = signatureStatus;
    }

    public CreditApplication getCreditApplication() {
        return creditApplication;
    }

    public void setCreditApplication(CreditApplication creditApplication) {
        this.creditApplication = creditApplication;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public String getSignatureStatus() {
        return signatureStatus;
    }

    public void setSignatureStatus(String signatureStatus) {
        this.signatureStatus = signatureStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
