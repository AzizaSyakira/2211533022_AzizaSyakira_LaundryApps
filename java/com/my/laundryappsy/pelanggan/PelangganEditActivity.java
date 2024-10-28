package com.my.laundryappsy.pelanggan;

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
import com.my.laundryappsy.helper.Constant;

public class PelangganEditActivity extends AppCompatActivity {

    private String id, name, email, hp;
    private EditText edPelEditNama, edPelEditEmail, edPelEditHp;
    private Button btnPelEditSimpan, btnPelEditHapus, btnPelEditBatal;
    private SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pelanggan_edit);

        id = getIntent().getStringExtra(Constant.ID);
        name = getIntent().getStringExtra(Constant.NAMA);
        email = getIntent().getStringExtra(Constant.EMAIL);
        hp = getIntent().getStringExtra(Constant.HP);

        db = new SQLiteHelper(this);
        edPelEditNama = findViewById(R.id.edPelEditNama);
        edPelEditEmail = findViewById(R.id.edPelEditEmail);
        edPelEditHp = findViewById(R.id.edPelEditHp);
        btnPelEditSimpan = findViewById(R.id.btnPelEditSimpan);
        btnPelEditHapus = findViewById(R.id.btnPelEditHapus);
        btnPelEditBatal = findViewById(R.id.btnPelEditBatal);

        // Set data pelanggan ke EditText
        edPelEditNama.setText(name);
        edPelEditEmail.setText(email);
        edPelEditHp.setText(hp);

        // Set tombol hapus untuk menghapus data pelanggan
        btnPelEditHapus.setOnClickListener(v -> {
            if (db.deletePelanggan(id)) {
                Toast.makeText(this, "Pelanggan berhasil dihapus", Toast.LENGTH_SHORT).show();
                finish(); // Kembali ke PelangganActivity setelah dihapus
            } else {
                Toast.makeText(this, "Gagal menghapus pelanggan", Toast.LENGTH_SHORT).show();
            }
        });

        // Tombol batal untuk kembali ke PelangganActivity
        btnPelEditBatal.setOnClickListener(v -> finish());
    }
}


