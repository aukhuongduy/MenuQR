package gallery.duyakse04298.fpt.edu.com.project;

import android.Manifest;
import android.animation.Animator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import gallery.duyakse04298.fpt.edu.com.project.databinding.ActivityScanBinding;

public class ScanActivity extends AppCompatActivity {
    private static final int PICTURE_SIZE_MAX_WIDTH = 1280;
    private static final int PREVIEW_SIZE_MAX_WIDTH = 640;

    ActivityScanBinding binding;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    SurfaceHolder surfaceHolder;
    Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan);
        binding.cameraView.setZOrderMediaOverlay(true);
        surfaceHolder = binding.cameraView.getHolder();
        barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build();
        createRatioSurface();
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        if (!barcodeDetector.isOperational()) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (ContextCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 200);
        }

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedFps(24)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(1366,1024).build();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    cameraSource.start(binding.cameraView.getHolder());
                } catch (IOException ie) {
                    Log.e("CAMERA SOURCE", ie.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });
                barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() > 0) {
                    barcodeDetector.release();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.ivCheckSuccess.setVisibility(View.VISIBLE);
                            binding.ivCheckSuccess.startAnimation(fadeIn);
                        }
                    });
                    Intent itent = new Intent(ScanActivity.this, DetailActivity.class);
                    itent.putExtra("barcode",barcodes.valueAt(0));
                    startActivity(itent);
                    finish();
                }
            }
        });
    }
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//
//        // Get the preview size
//        int previewWidth = binding.cameraView.getMeasuredWidth(),
//                previewHeight = binding.cameraView.getMeasuredHeight();
//        RelativeLayout.LayoutParams overlayParamsBottom = (RelativeLayout.LayoutParams) binding.overlayBottom.getLayoutParams();
//        overlayParamsBottom.height = previewHeight - previewWidth;
//        binding.overlayBottom.setLayoutParams(overlayParamsBottom);
//    }

    private void createRatioSurface() {

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int height = 0;
        int width = 0;

        if(metrics.widthPixels < metrics.heightPixels){
            width = metrics.widthPixels;
            height= (metrics.widthPixels/3) * 4 ;
        } else {
            height= metrics.heightPixels;
            width= (metrics.heightPixels/3) * 4 ;
        }

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        binding.cameraView.setLayoutParams(layoutParams);
    }
}
