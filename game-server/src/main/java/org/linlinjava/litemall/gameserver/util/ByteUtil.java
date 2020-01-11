package org.linlinjava.litemall.gameserver.util;


import io.netty.buffer.ByteBuf;
import lombok.extern.log4j.Log4j2;

import java.io.UnsupportedEncodingException;

@Log4j2
public class ByteUtil {

    public ByteUtil() {
    }

    public static byte[] getBooleanArray(byte b) {
        byte[] array = new byte[8];

        for (int i = 7; i >= 0; --i) {
            array[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }

        return array;
    }

    public static String byteToBit(byte b) {
        return "" + (byte) (b >> 7 & 1) + (byte) (b >> 6 & 1) + (byte) (b >> 5 & 1) + (byte) (b >> 4 & 1) + (byte) (b >> 3 & 1) + (byte) (b >> 2 & 1) + (byte) (b >> 1 & 1) + (byte) (b >> 0 & 1);
    }

    public static String bytesToBit(byte[] bytes) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bytes.length; ++i) {
            str.append(byteToBit(bytes[i]));
        }

        return str.toString();
    }

    public static byte[] int2byteWithBigEnd(int res) {
        byte[] targets = new byte[]{(byte) (res & 255), (byte) (res >> 8 & 255), (byte) (res >> 16 & 255), (byte) (res >>> 24)};
        return targets;
    }

    public static byte[] int2byteWithSmallEnd(int res) {
        byte[] targets = new byte[]{(byte) (res >>> 24), (byte) (res >> 16 & 255), (byte) (res >> 8 & 255), (byte) (res & 255)};
        return targets;
    }

    public static String byteToBit(byte b, int start, int length) {
        StringBuilder bitStr = new StringBuilder();

        for (int i = length + start - 1; i >= start; --i) {
            bitStr.append((byte) (b >> i & 1));
        }

        return bitStr.toString();
    }

    public static Integer bytesToInt(byte[] bytes, int start, int length) {
        String bitstr = bytesToBit(bytes);
        String subStr = bitstr.substring(start, start + length);
        return Integer.parseInt(subStr, 2);
    }

    public static Integer byteToInt(byte b, int start, int length) {
        String bitstr = byteToBit(b);
        String subStr = bitstr.substring(start, start + length);
        return Integer.parseInt(subStr, 2);
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for (int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v).toUpperCase();
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static byte[] shortToByteArray(short s) {
        byte[] shortBuf = new byte[2];

        for (int i = 0; i < 2; ++i) {
            int offset = (shortBuf.length - 1 - i) * 8;
            shortBuf[i] = (byte) (s >>> offset & 255);
        }

        return shortBuf;
    }

    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);

        for (int i = 0; i < bytes.length; ++i) {
            temp.append((byte) ((bytes[i] & 240) >>> 4));
            temp.append((byte) (bytes[i] & 15));
        }

        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
    }

    public static byte[] str2Bcd(String str) {
        int len = str.length();
        int mod = len % 2;
        if (mod != 0) {
            str = "0" + str;
            len = str.length();
        }

        byte[] abt = new byte[len];
        if (len >= 2) {
            len /= 2;
        }

        byte[] bbt = new byte[len];
        abt = str.getBytes();

        for (int p = 0; p < str.length() / 2; ++p) {
            int j;
            if (abt[2 * p] >= 48 && abt[2 * p] <= 57) {
                j = abt[2 * p] - 48;
            } else if (abt[2 * p] >= 97 && abt[2 * p] <= 122) {
                j = abt[2 * p] - 97 + 10;
            } else {
                j = abt[2 * p] - 65 + 10;
            }

            int k;
            if (abt[2 * p + 1] >= 48 && abt[2 * p + 1] <= 57) {
                k = abt[2 * p + 1] - 48;
            } else if (abt[2 * p + 1] >= 97 && abt[2 * p + 1] <= 122) {
                k = abt[2 * p + 1] - 97 + 10;
            } else {
                k = abt[2 * p + 1] - 65 + 10;
            }

            int a = (j << 4) + k;
            byte b = (byte) a;
            bbt[p] = b;
        }

        return bbt;
    }

    public static byte[] short2Byte(short a) {
        byte[] b = new byte[]{(byte) (a >> 8), (byte) a};
        return b;
    }

    public static short byte2Short(byte[] b) {
        return (short) ((b[0] & 255) << 8 | b[1] & 255);
    }

    public static byte verification(byte[] msg) {
        byte sum = 0;

        for (int i = 0; i < msg.length; ++i) {
            sum ^= (byte) (msg[i] & 255);
        }

        return sum;
    }

    public static String checkSum(byte[] msg) {
        byte sum = 0;

        for (int i = 0; i < msg.length; ++i) {
            sum ^= (byte) (msg[i] & 255);
        }

        String verifs = Integer.toHexString(sum & 255);

        for (int k = 0; k < 2 - verifs.length(); ++k) {
            verifs = "0" + verifs;
        }

        return verifs;
    }

    public static int byte2UShort(byte[] b) {
        return byte2Short(b) & '\uffff';
    }

    public static byte[] hex2Byte(String hex) {
        StringBuffer strbuf = new StringBuffer();

        for (int i = 0; i < hex.length(); i += 2) {
            strbuf.append(hex.charAt(i));
            strbuf.append(hex.charAt(i + 1));
            strbuf.append(" ");
        }

        String s = strbuf.toString();
        String[] sliStrings = s.split(" ");
        byte[] sbyte = new byte[sliStrings.length];

        for (int i = 0; i < sbyte.length; ++i) {
            if (sliStrings[i] != null && sliStrings[i] != "") {
                sbyte[i] = (byte) (Integer.parseInt(sliStrings[i], 16) & 255);
            }
        }

        return sbyte;
    }

    public static byte[] getZeros(int num) {
        byte[] bytes = new byte[num];

        for (int i = 0; i < num; ++i) {
            bytes[i] = 0;
        }

        return bytes;
    }

    public static byte[] stringToByteArray(String s, int len) {
        byte[] resultByte = null;

        try {
            byte[] data = s.getBytes("gb2312");
            if (data.length > len) {
            } else {
                resultByte = new byte[len];
                System.arraycopy(data, 0, resultByte, 0, data.length);
                int srcLen = data.length;
                if (srcLen < len) {
                    byte[] zeros = getZeros(len - srcLen);
                    System.arraycopy(zeros, 0, resultByte, data.length, zeros.length);
                }
            }
        } catch (UnsupportedEncodingException var6) {
        }

        return resultByte;
    }

    public static byte[] getvbyte(String s) {
        String[] sliStrings = s.split(" ");
        byte[] sbyte = new byte[sliStrings.length];

        for (int i = 0; i < sbyte.length; ++i) {
            if (sliStrings[i] != null && sliStrings[i] != "") {
                sbyte[i] = (byte) (Integer.parseInt(sliStrings[i], 16) & 255);
            }
        }

        return sbyte;
    }

    public static String addSymbol(String buf) {
        StringBuffer strbuf = new StringBuffer();

        for (int i = 0; i < buf.length(); i += 2) {
            strbuf.append(buf.charAt(i));
            strbuf.append(buf.charAt(i + 1));
            strbuf.append(" ");
        }

        return strbuf.toString();
    }

    public static String strToHexAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            sbu.append(Integer.toHexString(chars[i]));
        }

        return sbu.toString();
    }

    public static char asciiToHexChar(String value) {
        return (char) Integer.parseInt(value, 16);
    }

    public static String asciiToHexStr(String value) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < value.length(); i += 2) {
            sb.append((char) Integer.parseInt(value.substring(i, i + 2), 16));
        }

        return sb.toString();
    }


    /**
     * int到byte[]
     *
     * @param i
     * @return
     */
    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        // 由高位到低位
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    /**
     * byte[]转int
     *
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (bytes[i] & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }


    public static void cony(ByteBuf buf)  {
        try {
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String bodyU = new String(req, "UTF-8");
            String bodyG = new String(req, "GBK");
            log.info("UTF-8------------------------->\n" + bodyU);
            log.info("GBK------------------------->\n" + bodyG);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
