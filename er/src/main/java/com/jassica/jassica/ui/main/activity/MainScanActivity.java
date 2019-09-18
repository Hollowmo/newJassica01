package com.jassica.jassica.ui.main.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jassica.jassica.R;
import com.jassica.jassica.utils.ToastUtil;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import io.reactivex.annotations.NonNull;
/*
* 扫一扫
* */
public class MainScanActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private ZXingView mQRCodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scan);
        mQRCodeView = findViewById(R.id.scan);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        } else {
            mQRCodeView.startSpot();
            mQRCodeView.setDelegate(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //打开后置摄像头预览,但并没有开始扫描
        mQRCodeView.startCamera();
        //开启扫描框
        mQRCodeView.showScanRect();
        mQRCodeView.startSpot();
    }


    @Override

    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }


    @Override

    public void onScanQRCodeSuccess(String result) {
        ToastUtil.showLong(result);
    }



    @Override
    public void onScanQRCodeOpenCameraError() {
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //打开后置摄像头预览,但并没有开始扫描
                mQRCodeView.startCamera();
                //开启扫描框
                mQRCodeView.showScanRect();
                mQRCodeView.startSpot();
                return;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
