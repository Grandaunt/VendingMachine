package com.example.sjs.vendingmachine;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sjs.vendingmachine.SerialUtil.SerialPortActivity;

public class OpenDoorActivity extends SerialPortActivity implements View.OnClickListener {

    private  static  String TAG = "MainActivity";
    //    private EditText mEditTextEmission;
    private Button open_one,open_two,open_three,open_four,open_five,open_six,open_seven;
//    public static int[] open_numarr ={

//              [0x00,0x00],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x01,0xD0,0x97],#1#柜门
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x02,0xE0,0xF4],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x03,0xF0,0xD5],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x04,0x80,0x32],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x05,0x90,0x13],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x06,0xA0,0x70],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x07,0xB0,0x51],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x08,0x41,0xBE],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x09,0x51,0x9F],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x0A,0x61,0xFC],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x0B,0x71,0xDD],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x0C,0x01,0x3A],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x0D,0x11,0x1B],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x0E,0x21,0x78],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x0F,0x31,0x59],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x10,0xD2,0x87],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x11,0xC2,0xA6],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x12,0xF2,0xC5],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x13,0xE2,0xE4],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x14,0x92,0x03],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x15,0x82,0x22],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x16,0xB2,0x41],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x17,0xA2,0x60],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x18,0x53,0x8F],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x19,0x43,0xAE],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x1A,0x73,0xCD],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x1B,0x63,0xEC],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x1C,0x13,0x0B],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x1D,0x03,0x2A],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x1E,0x33,0x49],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x1F,0x23,0x68],
//            [0xC7,0x07,0x00,0x52,0x00,0x05,0x20,0xE4,0xD4]#32#
//    };
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
    public String[] open_numarr = {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_door);
//        mEditTextEmission = (EditText) findViewById(R.id.editTextEmission);
        open_one = (Button)findViewById(R.id.open_one);
        open_two = (Button)findViewById(R.id.open_two);
        open_three = (Button)findViewById(R.id.open_three);
        open_four = (Button)findViewById(R.id.open_four);
        open_five = (Button)findViewById(R.id.open_five);
        open_six = (Button)findViewById(R.id.open_six);
        open_seven = (Button)findViewById(R.id.open_seven);
        open_one.setOnClickListener(this);
        open_two.setOnClickListener(this);
        open_three.setOnClickListener(this);
        open_four.setOnClickListener(this);
        open_five.setOnClickListener(this);
        open_six.setOnClickListener(this);
        open_seven.setOnClickListener(this);


    }

    public void send(int open_num) {

//        String text = mEditTextEmission.getText().toString();
//        if (TextUtils.isEmpty(open_num)) {
//            return;
//        }
        Log.i(TAG,open_num+"send已发送open_num");
        byte [] HxStr =hex2byte(open_numarr[open_num]);
        Message message = Message.obtain();
//        message.obj = open_num.getBytes();
        message.obj =  HxStr;
        Log.i(TAG,HxStr+"send已发送");
        sendingHandler.sendMessage(message);


    }

    @Override
    protected void onDataReceived(final byte[] buffer, final int size) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(mApplication, "收到消息：" + new String(buffer) + "  size = " + size, Toast.LENGTH_SHORT).show();
                Log.i(TAG,"收到消息：buffer" + buffer + "  size = " + size);
                Log.i(TAG,"收到消息：buffer" + new String(buffer) + "  size = " + size);
                String returnStr = bytesToHexString(buffer);
                Log.i(TAG,"收到消息：数组转换成十六进制字符串" + returnStr + "  size = " + size);
                String returnStr2 = bytes2HexString(buffer);
                Log.i(TAG,"收到消息：bytes2HexString" + returnStr2 + "  size = " + size);

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.open_one:
                Log.i(TAG,"发送"+open_numarr[0]);
                send(0);
                break;
            case R.id.open_two:
                Log.i(TAG,"发送"+open_numarr[1]);
                send(1);
                break;
            case R.id.open_three:
                Log.i(TAG,"发送"+open_numarr[2]);
                send(2);
                break;
            case R.id.open_four:
                Log.i(TAG,"发送"+open_numarr[3]);
                send(3);
                break;
            case R.id.open_five:
                Log.i(TAG,"发送"+open_numarr[4]);
                send(4);
                break;
            case R.id.open_six:
                Log.i(TAG,"发送"+open_numarr[5]);
                send(5);
                break;
            case R.id.open_seven:
                Log.i(TAG,"发送"+open_numarr[6]);
                send(6);
                break;
            default:
                break;
        }

    }
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


