package cn;

import org.openjdk.jmh.annotations.*;

public class TestPS {
    // ��׼������һ�δ���
    @Benchmark
    // Ԥ�ȣ�����JVM�ж����ض����������Ż������ػ�����Ԥ�ȶ��ڲ��Խ������Ҫ
    // iterations Ԥ��1�� time Ԥ��ʱ�� 3
    @Warmup(iterations = 1, time = 3)
    // �ö��ٸ��߳�ȥִ�����ǵĳ���
    @Fork(5)
    // ��׼���Ե�ģʽ
    // Throught ������
    @BenchmarkMode(Mode.Throughput)
    // �ܹ�ִ�ж��ٴβ���
    // iterations ���� time ʱ��
    @Measurement(iterations = 1, time = 3)
    public void testForEach() {
         Ps.foreach();
    }
}
