package com.hs.priatice.handler;


/**
 * @author Evan Huang
 */
public class OeBondBSPendingDataMigrationHandler extends PendingDataMigrationHandler {
    @Override
    public void doHandle() {
        System.out.println("生成交易所现券买卖交易数据迁移脚本");
    }
}
