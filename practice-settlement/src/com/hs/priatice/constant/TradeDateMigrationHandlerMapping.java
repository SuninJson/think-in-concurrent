package com.hs.priatice.constant;

import com.hs.priatice.handler.*;

/**
 * @author Evan Huang
 */
public enum TradeDateMigrationHandlerMapping {
    /**
     * 交易所现券买卖交易
     */
    OE_BOND_BS_TRADE(new OeBondBSPendingDataMigrationHandler()),
    /**
     * 交易所回购交易
     */
    OE_REPO(new OeRepoPendingDataMigrationHandler()),
    /**
     * 银行间现券买卖
     */
    IB_BOND_BS(new IbBondBSPendingDataMigrationHandler()),
    /**
     * 银行间回购
     */
    IB_REPO(new IbRepoPendingDataMigrationHandler());

    TradeDateMigrationHandlerMapping(PendingDataMigrationHandler handler) {
        this.handler = handler;
    }

    private PendingDataMigrationHandler handler;

    public PendingDataMigrationHandler getHandler() {
        return handler;
    }
}
