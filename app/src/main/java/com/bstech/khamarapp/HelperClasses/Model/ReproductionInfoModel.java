package com.bstech.khamarapp.HelperClasses.Model;

public class ReproductionInfoModel {
    private String ID;
    private CowModel cow;
    private String NoOfchield;
    private String LastDeliveryDate;
    private String HeatDate;
    private String AIDate;
    private String BullID;
    private String BullType;
    private String SemeanDate;
    private String PragDate;
    private String NextDeliveryDate;
    private String EDT;
    private String BachurWeight;
    private String BachurGender;
    private String Others;

    public ReproductionInfoModel(String ID, CowModel cow, String noOfchield, String lastDeliveryDate, String heatDate, String AIDate, String bullID, String bullType, String semeanDate, String pragDate, String nextDeliveryDate, String EDT, String bachurWeight, String bachurGender, String others) {
        this.ID = ID;
        this.cow = cow;
        NoOfchield = noOfchield;
        LastDeliveryDate = lastDeliveryDate;
        HeatDate = heatDate;
        this.AIDate = AIDate;
        BullID = bullID;
        BullType = bullType;
        SemeanDate = semeanDate;
        PragDate = pragDate;
        NextDeliveryDate = nextDeliveryDate;
        this.EDT = EDT;
        BachurWeight = bachurWeight;
        BachurGender = bachurGender;
        Others = others;
    }

    public String getID() {
        return ID;
    }

    public CowModel getCow() {
        return cow;
    }

    public String getNoOfchield() {
        return NoOfchield;
    }

    public String getLastDeliveryDate() {
        return LastDeliveryDate;
    }

    public String getHeatDate() {
        return HeatDate;
    }

    public String getAIDate() {
        return AIDate;
    }

    public String getBullID() {
        return BullID;
    }

    public String getBullType() {
        return BullType;
    }

    public String getSemeanDate() {
        return SemeanDate;
    }

    public String getPragDate() {
        return PragDate;
    }

    public String getNextDeliveryDate() {
        return NextDeliveryDate;
    }

    public String getEDT() {
        return EDT;
    }

    public String getBachurWeight() {
        return BachurWeight;
    }

    public String getBachurGender() {
        return BachurGender;
    }

    public String getOthers() {
        return Others;
    }
}
