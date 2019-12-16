//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.charset.Charset;

public class GameReadTool {
    public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

    public GameReadTool() {
    }

    public static String readString(ByteBuf cb) throws IndexOutOfBoundsException {
        int lenght = readUnsignedByte(cb);
        if (lenght == 0) {
            return "";
        } else if (lenght > 0 && lenght <= cb.readableBytes()) {
            byte[] strByte = new byte[lenght];
            cb.readBytes(strByte);
            return readString(strByte);
        } else {
            throw new IndexOutOfBoundsException("字符串长度不够 ! ");
        }
    }

    public static String readString2(ByteBuf cb) throws IndexOutOfBoundsException {
        int lenght = cb.readUnsignedShort();
        if (lenght == 0) {
            return "";
        } else if (lenght > 0 && lenght <= cb.readableBytes()) {
            byte[] strByte = new byte[lenght];
            cb.readBytes(strByte);
            return readString(strByte);
        } else {
            throw new IndexOutOfBoundsException("字符串长度不够 ! ");
        }
    }

    public static String readString(byte[] bytes) {
        return new String(bytes, DEFAULT_CHARSET);
    }

    public static String readString(byte[] bytes, int length) {
        return new String(bytes, 0, length, DEFAULT_CHARSET);
    }

    public static int readUnsignedByte(ByteBuf cb) {
        return cb.readUnsignedByte();
    }

    public static int readInt(ByteBuf cb) {
        return cb.readInt();
    }

    public static int readByte(ByteBuf cb) {
        return cb.readUnsignedByte();
    }

    public static int readShort(ByteBuf cb) {
        return cb.readUnsignedShort();
    }

    public static ByteBuf readLenBuffer2(ByteBuf cb) {
        int len = cb.readUnsignedShort();
        ByteBuf byteBuf = Unpooled.buffer(len);
        cb.readBytes(byteBuf);
        return byteBuf;
    }
}
