package cn;

import org.openjdk.jmh.annotations.*;

public class TestPS {
    // 基准测试那一段代码
    @Benchmark
    // 预热，由于JVM中对于特定代码会存在优化（本地化），预热对于测试结果很重要
    // iterations 预热1次 time 预热时间 3
    @Warmup(iterations = 1, time = 3)
    // 用多少个线程去执行我们的程序
    @Fork(5)
    // 基准测试的模式
    // Throught 吞吐量
    @BenchmarkMode(Mode.Throughput)
    // 总共执行多少次测试
    // iterations 次数 time 时间
    @Measurement(iterations = 1, time = 3)
    public void testForEach() {
         Ps.foreach();
    }
}
