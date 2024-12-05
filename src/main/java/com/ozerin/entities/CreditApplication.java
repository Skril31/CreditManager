package com.ozerin.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;


import java.math.BigDecimal;

@Entity
@Table(name = "credit_application")
public class CreditApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Column(name = "employment_period")
    private String employmentPeriod;
    @Column(name = "job_position")
    private String jobPosition;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "desired_amount")
    private BigDecimal desiredAmount;
    @Column(name = "approved_amount")
    private BigDecimal approvedAmount;
    @Column(name = "status")
    private String status;
    @Column(name = "payment_term")
    private Integer paymentTerm;

    public CreditApplication() {
    }

    public CreditApplication(Client client, String employmentPeriod, String jobPosition, String organizationName, BigDecimal desiredAmount, BigDecimal approvedAmount, String status, Integer paymentTerm) {
        this.client = client;
        this.employmentPeriod = employmentPeriod;
        this.jobPosition = jobPosition;
        this.organizationName = organizationName;
        this.desiredAmount = desiredAmount;
        this.approvedAmount = approvedAmount;
        this.status = status;
        this.paymentTerm = paymentTerm;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEmploymentPeriod() {
        return employmentPeriod;
    }

    public void setEmploymentPeriod(String employmentPeriod) {
        this.employmentPeriod = employmentPeriod;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public BigDecimal getDesiredAmount() {
        return desiredAmount;
    }

    public void setDesiredAmount(BigDecimal desiredAmount) {
        this.desiredAmount = desiredAmount;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(Integer paymentTerm) {
        this.paymentTerm = paymentTerm;
    }
}
