package com.example.sjs.vendingmachine.Manager;

/**
 * Created by SJS on 2017/2/9.
 */

public class openDoorManager {

    /***  示例
     *    C7 07 00 52 00 05 04 80 32
     *    C8 06 81 62 00 05 70 D5
     *    1.起始标记（1）PC->门控板 0xC7
     *    2.消息长度（1）开是07
     *    3.柜子地址（1）从00开始
     *    4.消息type（1）0x51（查询状态），0x52（打开格子），0x53（加热开/关），0x54（心跳，心跳命令不需要支持），0x55（制冷开/关），0x56（整机照明开/关）
     *    5.柜子地址（1）从00开始
     *    6.无意义（1）固定填05
     *    7.自定义数据 格子的地址
     *    8.9.CRC6（2）校验位
     */
    public static String[] open_numarr = {
            "C7 07 00 52 00 05 01 D0 97",
            "C7 07 00 52 00 05 02 E0 F4",
            "C7 07 00 52 00 05 03 F0 D5",
            "C7 07 00 52 00 05 04 80 32",
            "C7 07 00 52 00 05 05 90 13",
            "C7 07 00 52 00 05 06 A0 70",
            "C7 07 00 52 00 05 07 B0 51",
            "C7 07 00 52 00 05 08 41 BE",
            "C7 07 00 52 00 05 09 51 9F",
            "C7 07 00 52 00 05 0A 61 FC",

            "C7 07 00 52 00 05 0B 71 DD",
            "C7 07 00 52 00 05 0C 01 3A",
            "C7 07 00 52 00 05 0D 11 1B",
            "C7 07 00 52 00 05 0E 21 78",
            "C7 07 00 52 00 05 0F 31 59",
            "C7 07 00 52 00 05 10 D2 87",
            "C7 07 00 52 00 05 11 C2 A6",
            "C7 07 00 52 00 05 12 F2 C5",
            "C7 07 00 52 00 05 13 E2 E4",
            "C7 07 00 52 00 05 14 92 03",

            "C7 07 00 52 00 05 15 82 22",
            "C7 07 00 52 00 05 16 B2 41",
            "C7 07 00 52 00 05 17 A2 60",
            "C7 07 00 52 00 05 18 53 8F",
            "C7 07 00 52 00 05 19 43 AE",
            "C7 07 00 52 00 05 1A 73 CD",
            "C7 07 00 52 00 05 1B 63 EC",
            "C7 07 00 52 00 05 1C 13 0B",
            "C7 07 00 52 00 05 1D 03 2A",
            "C7 07 00 52 00 05 1E 33 49",

            "C7 07 00 52 00 05 1F 23 68",
            "C7 07 00 52 00 05 20 E4 D4"//32
    };






    /**
     * @Title:hex2byte
     * @Description:字符串转16进制
     * @param hex
     *           字符串
     * @return 16进制字符串
     * @throws
     */
    public static byte[] hex2byte(String hex) {
        String digital = "0123456789ABCDEF";
        String hex1 = hex.replace(" ", "");
        char[] hex2char = hex1.toCharArray();
        byte[] bytes = new byte[hex1.length()/2];
        byte temp;
        for (int p = 0; p < bytes.length; p++) {
            temp = (byte) (digital.indexOf(hex2char[2 * p]) * 16);
            temp += digital.indexOf(hex2char[2 * p + 1]);
            bytes[p] = (byte) (temp & 0xff);
        }
        return bytes;
    }

    /**
     * 数组转换成十六进制字符串
     *
     * @return HexString
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
    /**
     * @Title:bytes2HexString
     * @Description:字节数组转16进制字符串
     * @param b
     *            字节数组
     * @return 16进制字符串
     * @throws
     */
    public static String bytes2HexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        String hex;
        for (int i = 0; i < b.length; i++) {
            hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            result.append(hex.toUpperCase());
        }
        return result.toString();
    }
}
