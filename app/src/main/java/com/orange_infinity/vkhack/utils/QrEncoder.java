package com.orange_infinity.vkhack.utils;

import android.graphics.Bitmap;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QrEncoder {

    public static Bitmap convertStringToQr(String text, int width) {
        QRGEncoder qrgEncoder = new QRGEncoder(text, null, QRGContents.Type.TEXT, width);
        try {
            return qrgEncoder.encodeAsBitmap();
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
