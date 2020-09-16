package com.hs.priatice.dispatcher;

import com.hs.priatice.constant.TradeDateMigrationHandlerMapping;
import com.hs.priatice.handler.PendingDataMigrationHandler;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Evan Huang
 */
public class DataMigrationTaskDispatcher {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    protected static final List<TradeDateMigrationHandlerMapping> handlerMappings = new ArrayList<>();
    private CountDownLatch countDownLatch;

    static {
        //添加迁移数据相关的业务类型
        handlerMappings.add(TradeDateMigrationHandlerMapping.OE_BOND_BS_TRADE);
        handlerMappings.add(TradeDateMigrationHandlerMapping.OE_REPO);
        handlerMappings.add(TradeDateMigrationHandlerMapping.IB_BOND_BS);
        handlerMappings.add(TradeDateMigrationHandlerMapping.IB_REPO);
    }

    public DataMigrationTaskDispatcher() {
        countDownLatch = new CountDownLatch(handlerMappings.size());
    }

    public void doDispatch() {
        try {
            for (TradeDateMigrationHandlerMapping handlerMapping : handlerMappings) {
                executorService.execute(() -> {
                            try {
                                PendingDataMigrationHandler handler = handlerMapping.getHandler();
                                handler.doHandle();
                            } finally {
                                countDownLatch.countDown();
                            }
                        }
                );
            }
            countDownLatch.await();
            System.out.println("交易数据迁移任务已全部完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataMigrationTaskDispatcher().doDispatch();
    }
}
