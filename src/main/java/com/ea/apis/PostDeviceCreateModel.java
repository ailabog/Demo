package com.ea.apis;

public class PostDeviceCreateModel {
    private String name;
    private String hostName;
    private String serialNumber;
    private String partnerAddress;
    private String partnerContName;
    private String partnerContEmail;
    private String partnerType;
    private String isStrategicPartner;
    private String partnerStartDate;
    private String partnerEndDate;
    private String eaDevContactName;
    private String eaDevContactEmail;
    private String eaDevRequestedBy;
    private String eaDevContactTeam;
    private String partnerAddInformation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPartnerAddress() {
        return partnerAddress;
    }

    public void setPartnerAddress(String partnerAddress) {
        this.partnerAddress = partnerAddress;
    }

    public String getPartnerContName() {
        return partnerContName;
    }

    public void setPartnerContName(String partnerContName) {
        this.partnerContName = partnerContName;
    }

    public String getPartnerContEmail() {
        return partnerContEmail;
    }

    public void setPartnerContEmail(String partnerContEmail) {
        this.partnerContEmail = partnerContEmail;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    public String getIsStrategicPartner() {
        return isStrategicPartner;
    }

    public void setIsStrategicPartner(String isStrategicPartner) {
        this.isStrategicPartner = isStrategicPartner;
    }

    public String getPartnerStartDate() {
        return partnerStartDate;
    }

    public void setPartnerStartDate(String partnerStartDate) {
        this.partnerStartDate = partnerStartDate;
    }

    public String getPartnerEndDate() {
        return partnerEndDate;
    }

    public void setPartnerEndDate(String partnerEndDate) {
        this.partnerEndDate = partnerEndDate;
    }

    public String getEADevContactName() {
        return eaDevContactName;
    }

    public void setEADevContactName(String eaDevContactName) {
        this.eaDevContactName = eaDevContactName;
    }

    public String getEADevContactEmail() {
        return eaDevContactEmail;
    }

    public void setEADevContactEmail(String eaDevContactEmail) {
        this.eaDevContactEmail = eaDevContactEmail;
    }

    public String getEADevRequestedBy() {
        return eaDevRequestedBy;
    }

    public void setEADevRequestedBy(String eaDevRequestedBy) {
        this.eaDevRequestedBy = eaDevRequestedBy;
    }

    public String getEADevContactTeam() {
        return eaDevContactTeam;
    }

    public void setEADevContactTeam(String eaDevContactTeam) {
        this.eaDevContactTeam = eaDevContactTeam;
    }

    public String getPartnerAddInformation() {
        return partnerAddInformation;
    }

    public void setPartnerAddInformation(String partnerAddInformation) {
        this.partnerAddInformation = partnerAddInformation;
    }

    @Override
    public String toString()
    {
        return "DeviceDetails{" +
                "name=" + name +
                ", hostName='" + hostName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", partnerAddress='" + partnerAddress + '\'' +
                ", partnerContName='" + partnerContName + '\'' +
                ", partnerContEmail='" + partnerContEmail + '\'' +
                ", partnerType='" + partnerType + '\'' +
                ", isStrategicPartner='" + isStrategicPartner + '\'' +
                ", partnerStartDate='" + partnerStartDate + '\'' +
                ", partnerEndDate='" + partnerEndDate + '\'' +
                ", eaDevContactName='" + eaDevContactName + '\'' +
                ", eaDevRequestedBy='" + eaDevRequestedBy + '\'' +
                ", eaDevContactTeam='" + eaDevContactTeam + '\'' +
                ", partnerAddInformation='" + partnerAddInformation + '\'' +
                '}';
    }
}

