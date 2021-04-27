package fr.fscript98.zapette

import BddRepository.Singleton.motDePasseBdd
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.journeyapps.barcodescanner.BarcodeEncoder

class QrCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code)
        val intent= Intent(this,EtudiantRepondre::class.java)
        val imageCode2 = findViewById<ImageView>(R.id.imageQrCodeEleve2)
        val qrCode = QRCodeWriter()
        val barcodeEncoder = BarcodeEncoder()
        val bitMtx = qrCode.encode(
            motDePasseBdd ,
            BarcodeFormat.QR_CODE ,
            2000,
            2000

        )
        val bitMap2 = barcodeEncoder.createBitmap(bitMtx)
        imageCode2.setImageBitmap(bitMap2)

        imageCode2.setOnClickListener{
            startActivity(intent)
            finish()
        }
    }
}