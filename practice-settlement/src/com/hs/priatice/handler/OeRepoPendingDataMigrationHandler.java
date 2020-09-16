package com.hs.priatice.handler;


/**
 * @author Evan Huang
 */
public class OeRepoPendingDataMigrationHandler extends PendingDataMigrationHandler {
    @Override
    public void doHandle() {
        System.out.println("生成交易所回购交易数据迁移脚本");
    }
}
