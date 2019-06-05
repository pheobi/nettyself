package com.cn;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        int id = 101;
        int age = 21;

        //使用nio的byteBuffer序列化
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(id);
        buffer.putInt(age);
        //buffer.putLong(); 方法便捷 但不可扩容 此时用long 会抛异常
        byte[] array = buffer.array();
        System.out.println(Arrays.toString(buffer.array()));
        //========================================
        //反序列化
        ByteBuffer buffer2 = ByteBuffer.wrap(array);
        System.out.println("id："+buffer2.getInt());
        System.out.println("age："+buffer2.getInt());
    }
}
