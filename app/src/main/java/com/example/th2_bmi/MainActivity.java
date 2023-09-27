package com.example.th2_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtChieuCao, edtCanNang;
    Button btnTinhBMI;
    TextView txtChiSoBMI, txtDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtChieuCao = (EditText) findViewById(R.id.editTextChieuCao);
        edtCanNang = (EditText) findViewById(R.id.editTextCanNang);
        btnTinhBMI = (Button) findViewById(R.id.buttonTinhBMI);
        txtChiSoBMI = (EditText) findViewById(R.id.editTextChiSoBMI);
        txtDanhGia = (EditText) findViewById(R.id.editTextĐanhGia);

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị chiều cao và cân nặng từ EditText
                String chieuCaoStr = edtChieuCao.getText().toString();
                String canNangStr = edtCanNang.getText().toString();

                // Chuyển đổi giá trị sang kiểu số
                double chieuCao = Double.parseDouble(chieuCaoStr) / 100;
                double canNang = Double.parseDouble(canNangStr);

                // Tính chỉ số BMI
                double bmi = canNang / (chieuCao * chieuCao);

                // Hiển thị kết quả vào EditText
                txtChiSoBMI.setText(String.format("%.2f", bmi));

                // Đánh giá chỉ số BMI
                if (bmi < 18.5) {
                    txtDanhGia.setText("Thiếu cân");
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    txtDanhGia.setText("Bình thường");
                } else if (bmi >= 25 && bmi < 29.9) {
                    txtDanhGia.setText("Thừa cân");
                } else {
                    txtDanhGia.setText("Béo phì");
                }
            }
        });
    }
}