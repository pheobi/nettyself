package com.cn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws IOException {
        int id = 101;
        int age = 21;

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        //不能用write(int b) 因其直接将 int数据 4位 转成byte 1位 会导致数据截断
        //要使用 write(byte[] b) 需现将int转成byte数组
        //arrayOutputStream.write();
        arrayOutputStream.write(int2bytes(id));
        arrayOutputStream.write(int2bytes(age));

        byte[] byteArray = arrayOutputStream.toByteArray();

        System.out.println(Arrays.toString(byteArray));

        //=====================================================
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        byte[] idBytes = new byte[4];
        arrayInputStream.read(idBytes);
        System.out.println("id:"+bytes2int(idBytes));

        byte[] ageBytes = new byte[4];
        arrayInputStream.read(ageBytes);
        System.out.println("age:"+bytes2int(ageBytes));

    }

    /**
     *大端字节序列（先写高位，再写低位）----小端序列（先写低位，再写高位）
    *@Author:YahuiLi
    *@Description:
    *@param
    *@Date:15:55 2019/6/3
    */
    public static byte[] int2bytes(int i){
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (i >> 3 * 8);//获取int的高位 向右移动三位 3*8个字节
        bytes[1] = (byte)(i>>2*8);
        bytes[2] = (byte)(i>>1*8);
        bytes[3] = (byte)(i>>0*8);
        return bytes;
    }
    /**
     * 大端
    *@Author:YahuiLi
    *@Description:
    *@param
    *@Date:16:34 2019/6/3
    */
    public static int bytes2int(byte[] bytes){
        return (bytes[0]<<3*8)|(bytes[1]<<2*8)|(bytes[2]<<1*8)|(bytes[3]<<0*8);
    }
}

