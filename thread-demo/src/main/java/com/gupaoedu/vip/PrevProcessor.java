package com.gupaoedu.vip;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class PrevProcessor extends Thread implements IRequestProcessor {
    //阻塞队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public PrevProcessor() {
    }

    public PrevProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    /**
     * 非当前线程通过
     * PrevProcessor p = new PrevProcessor();
     * p.interrupt();
     * 来中断PrevProcessor
     */
//    public void shutdown() { //对外提供关闭的方法
//        isFinish = true;
//    }
    @Override
    public void run() {
        new PrevProcessor().interrupt();

        new PrevProcessor().interrupt();
//        while(!isFinish){ //不建议这么写
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Request request = requests.take();//阻塞式获取数据
                //真正的处理逻辑
                System.out.println("prevProcessor:" + request);
                //交给下一个责任链
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void process(Request request) {
        //TODO 根据实际需求去做一些处理
        requests.add(request);
    }
}
