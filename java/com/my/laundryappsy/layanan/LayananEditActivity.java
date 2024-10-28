package com.my.laundryappsy.layanan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.my.laundryappsy.R;
import com.my.laundryappsy.database.SQLiteHelper;
import com.my.laundryappsy.database.SQLiteHelper2;
import com.my.laundryappsy.helper.Constant;

public class LayananEditActivity extends AppCompatActivity {

        private String id, tipe, harga;
        private EditText edLayEditLayanan, edLayEditHarga;
        private Button btnLayEditSimpan, btnLayEditHapus, btnLayEditBatal;
        private SQLiteHelper2 db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_layanan_edit);

            id = getIntent().getStringExtra(Constant.ID);
            tipe= getIntent().getStringExtra(Constant.TIPE);
            harga = getIntent().getStringExtra(Constant.HARGA);

            db = new SQLiteHelper2(this);
            edLayEditLayanan = findViewById(R.id.edLayEditLayanan);
            edLayEditHarga = findViewById(R.id.edLayEditHarga);
            btnLayEditSimpan = findViewById(R.id.btnLayEditSimpan);
            btnLayEditHapus = findViewById(R.id.btnLayEditHapus);
            btnLayEditBatal = findViewById(R.id.btnLayEditBatal);

            // Set data layanan ke EditText
            edLayEditLayanan.setText(tipe);
            edLayEditHarga.setText(harga);

            // Set tombol hapus untuk menghapus data layanan
            btnLayEditHapus.setOnClickListener(v -> {
                if (db.deleteLayanan(id)) {
                    Toast.makeText(this, "Layanan berhasil dihapus", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(this, "Layanan menghapus pelanggan", Toast.LENGTH_SHORT).show();
                }
            });

            // Tombol batal untuk kembali ke layananactivity
            btnLayEditBatal.setOnClickListener(v -> finish());
        }
    }