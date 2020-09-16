package com.hs.priatice.handler;


/**
 * @author Evan Huang
 */
public class IbRepoPendingDataMigrationHandler extends PendingDataMigrationHandler {
    @Override
    public void doHandle() {
        System.out.println("生成银行间回购交易数据迁移脚本");
    }
}
