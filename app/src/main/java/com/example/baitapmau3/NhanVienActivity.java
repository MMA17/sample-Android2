package com.example.baitapmau3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.baitapmau3.Class.NhanVien;
import com.example.baitapmau3.DAO.NhanVienDAO;
import com.example.baitapmau3.adapter.NhanVienAdapter;

import java.util.List;

public class NhanVienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        Button btnAddNV = (Button) findViewById(R.id.btnaddNV);
        btnAddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = ((EditText) findViewById(R.id.inputTenNV)).getText().toString();
                String namsinh = ((EditText) findViewById(R.id.inputNamSinhNV)).getText().toString();
                String que = ((EditText) findViewById(R.id.inputQueNV)).getText().toString();
                String trinhdo = ((EditText) findViewById(R.id.inputTrinhDoNV)).getText().toString();
                NhanVien nv = new NhanVien();
                nv.setTen(ten);
                nv.setNamsinh(namsinh);
                nv.setQue(que);
                nv.setTrinhdo(trinhdo);
                NhanVienDAO dao = new NhanVienDAO(NhanVienActivity.this);
                dao.create();
                if (dao.addNhanVien(nv)) {
                    Toast.makeText(NhanVienActivity.this, "OKE", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(NhanVienActivity.this, "NOT OKE", Toast.LENGTH_SHORT).show();
                }
            }
        });

        NhanVienDAO dao = new NhanVienDAO(NhanVienActivity.this);
        dao.create();
        List<NhanVien> listNV = dao.getALlNhanVien();
//        System.out.println(listNV.size());
        NhanVienAdapter adapter = new NhanVienAdapter(listNV, NhanVienActivity.this);
        ListView lv = findViewById(R.id.listviewNhanVien);
        lv.setAdapter(adapter);
    }
}