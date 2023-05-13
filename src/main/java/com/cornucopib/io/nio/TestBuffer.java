package com.cornucopib.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author cornucopib
 */
public class TestBuffer {

    public static void main(String args[]){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {
            fis = new FileInputStream("/Users/cornucopib/Documents/develop/java/project/base/src/main/resources/1.txt");
            fos = new FileOutputStream("/Users/cornucopib/Documents/develop/java/project/base/src/main/resources/2.txt");

            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(2);


            while (fisChannel.read(buffer) != -1){
                buffer.flip();
                fosChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fisChannel != null) {
                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fosChannel != null) {
                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
