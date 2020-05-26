package com.example.library_0526;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.library_0526.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//인터넷에 있는 이미지 불러오기 => 인터넷 연결 권한 필요
        Glide.with(mContext).load("https://lh3.googleusercontent.com/proxy/YjKxcyO51y75l7D3RaxpybqWaHe3NM_J7vwqKZp_iXtU42vdYbvIG66g-nTyrSwxhXVgvyOaCU06YqIgBmwLfsFciazJByI9vzFRAOujd7OayRaECBiqsToJxaBAxpwXV7-IJ1-FuNxPlq9-qLzaAPZ4eLYAgH3arHzLjtZOg-ku8Q").into(binding.profileId);

    }
}
