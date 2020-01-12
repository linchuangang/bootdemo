package com.lin.bootdemo.enumcode;

/**
 * @Author: wubo
 * @Date: 2019/11/18 17:36
 * @Description:
 */
public enum TableNameEnum {
    PRODUCTIONSCHEDULING("排产结果", "scheduleWaitingList"),
    TRANSACTIONMODEASSESS("交易模式", "transaction_mode_assess"),
    FILINGAPPLY("备案申请表", "filing_apply"),
    CHARGEOFF("核销申请单", "charge_off"),
    OUTWARD_PROCESSING_GOODS_CARRY_REPORT("备案管理_外发加工货物运回清单", "outwardProcessingGoodsCarryReport"),
    OFFCUT_UN_CARRY_REPORT("备案管理_边角料不运回报告", "offcutUnCarryReport"),
    EXECUTIVE_REPORT("备案管理_执行情况报告", "executiveReport"),
    CHARGE_OFF_RECEIVED("备案管理_核销实际收货", "chargeOffReceived"),
    CHARGE_OFF_DELIVER("备案管理_核销实际发货", "chargeOffDeliver"),
    CHARGE_OFF_COLLECT("备案管理_核销收发货汇总", "chargeOffCollect"),
    QP_RECEIVING_SHIPMENT("备案管理_QP实际收发货表", "qpReceivingShipment"),
    MATERIAL_CARRY_DOWN("余料结转明细", "materialCarryDown");
    public String value;
    public String tableName;


    TableNameEnum(String tableName, String value) {
        this.value = value;
        this.tableName = tableName;
    }
}
