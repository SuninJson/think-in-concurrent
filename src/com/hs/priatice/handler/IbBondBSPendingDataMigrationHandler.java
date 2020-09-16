package com.hs.priatice.handler;


/**
 * @author Evan Huang
 * @date 2019/5/10
 */
public class IbBondBSPendingDataMigrationHandler extends PendingDataMigrationHandler {
    @Override
    public void doHandle() {
        System.out.println("生成银行间现券买卖交易数据迁移脚本");
    }
}
