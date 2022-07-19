package com.dams.java.nio;

import java.nio.ByteBuffer;

public class RelativeBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("Init Position = " + byteBuffer.position());
        System.out.println("Init Limit = " + byteBuffer.limit());
        System.out.println("Init Capacity = " + byteBuffer.capacity());

        byteBuffer.mark();
        byteBuffer.put((byte)10).put((byte) 11).put((byte) 12);
        byteBuffer.reset();

        System.out.println("value1= " + byteBuffer.get() + ", byteBuffer.position1() = " + byteBuffer.position());
        System.out.println("value2= " + byteBuffer.get() + ", byteBuffer.position2() = " + byteBuffer.position());
        System.out.println("value3= " + byteBuffer.get() + ", byteBuffer.position3() = " + byteBuffer.position());
        System.out.println("value4= " + byteBuffer.get() + ", byteBuffer.position4() = " + byteBuffer.position());
    }

}
