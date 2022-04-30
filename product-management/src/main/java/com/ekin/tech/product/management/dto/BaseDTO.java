package com.ekin.tech.product.management.dto;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public class BaseDTO {

    @NotNull
    private Long id;

    @NotNull
    private int objectVersion = 0;

    @NotNull
    private OffsetDateTime createdDate;

    private OffsetDateTime updatedDate;

    private String createdBy = "unknown";

    private String updatedBy;

    public BaseDTO() {
    }

    public BaseDTO(Long id) {
        this.id = id;
    }

    public BaseDTO(Long id, int objectVersion, OffsetDateTime createdDate, OffsetDateTime updatedDate, String createdBy, String updatedBy) {
        this.id = id;
        this.objectVersion = objectVersion;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(int objectVersion) {
        this.objectVersion = objectVersion;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public OffsetDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(OffsetDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
