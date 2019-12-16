//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.util;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {
    public DesUtil() {
    }

    public static String byteArr2HexStr(byte[] paramArrayOfByte) throws Exception {
        int i = 0;
        int k = paramArrayOfByte.length;

        StringBuffer localStringBuffer;
        for(localStringBuffer = new StringBuffer(k * 2); i < k; ++i) {
            int j;
            for(j = paramArrayOfByte[i]; j < 0; j += 256) {
            }

            if (j < 16) {
                localStringBuffer.append("0");
            }

            localStringBuffer.append(Integer.toString(j, 16));
        }

        return localStringBuffer.toString();
    }

    public static String decrypt(String paramString1, String paramString2) {
        Key key = getKey(paramString2.getBytes());

        try {
            paramString1 = new String(decrypt(hexStr2ByteArr(paramString1), key));
            return paramString1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] paramArrayOfByte, Key paramKey) throws Exception {
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(2, paramKey);
        return localCipher.doFinal(paramArrayOfByte);
    }

    public static String encrypt(String paramString1, String paramString2) {
        Key key = getKey(paramString2.getBytes());

        try {
            paramString1 = byteArr2HexStr(encrypt(paramString1.getBytes(), key));
            return paramString1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(byte[] paramArrayOfByte, Key paramKey) throws Exception {
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(1, paramKey);
        return localCipher.doFinal(paramArrayOfByte);
    }

    private static Key getKey(byte[] paramArrayOfByte) {
        byte[] arrayOfByte = new byte[8];

        for(int i = 0; i < paramArrayOfByte.length && i < arrayOfByte.length; ++i) {
            arrayOfByte[i] = paramArrayOfByte[i];
        }

        return new SecretKeySpec(arrayOfByte, "DES");
    }

    public static byte[] hexStr2ByteArr(String paramString) throws Exception {
        byte[] bytes = paramString.getBytes();
        int i = 0;
        int j = bytes.length;

        byte[] arrayOfByte;
        for(arrayOfByte = new byte[j / 2]; i < j; i += 2) {
            String str = new String(bytes, i, 2);
            arrayOfByte[i / 2] = (byte)Integer.parseInt(str, 16);
        }

        return arrayOfByte;
    }
}
