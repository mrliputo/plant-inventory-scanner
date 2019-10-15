package id.ac.unja.si.siitscanner.common;

import android.app.Activity;

import com.google.zxing.integration.android.IntentIntegrator;

public class QRCode {
    private Activity activity;

    public QRCode(Activity activity) {
        this.activity = activity;
    }

    public void integrator() {
        IntentIntegrator integrator = new IntentIntegrator(this.activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan QR code yang ada pada tanaman");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.setCaptureActivity(ZXingOrientation.class);
        integrator.initiateScan();
    }
}
