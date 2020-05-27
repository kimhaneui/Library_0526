package com.example.library_0526;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.library_0526.databinding.ActivityMainBinding;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

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

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PermissionListener pl = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

//                        실제전화걸기
                        //                실제 전화걸기 => 권한 허가가 X 앱이 강제종료 => tedpermmision 권한 획득후
                        String phoneNum = binding.phoneNum.getText().toString();
                        Uri myuri = Uri.parse(String.format("tel:%s",phoneNum));
                        Intent myintent  = new Intent(Intent.ACTION_CALL,myuri);
                        startActivity(myintent);

                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {

                        Toast.makeText(mContext,"권한이 거부되어 통화가 불가능합니다",Toast.LENGTH_SHORT).show();

                    }
                };
//                권한 X=>얼럿으로 허용할지?
//                권한 이전 허용 => 곧바로 Grant 사용
                TedPermission
                        .with(mContext)
                        .setPermissionListener(pl).
                        setDeniedMessage("거부하면 통화가 불가능함.")
                        .setPermissions(Manifest.permission.CALL_PHONE).check();
            }
        });
        binding.profileId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,PhotoActivity.class);
                intent.putExtra("imgUrl", "https://i.pinimg.com/736x/0b/2f/8a/0b2f8a51314ab1ebe0505aee843a33b1.jpg");
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {


        String url = getIntent().getStringExtra("imgUrl");
        Glide.with(mContext).load(url).into(binding.profileId);
//인터넷에 있는 이미지 불러오기 => 인터넷 연결 권한 필요
        Glide.with(mContext).load("https://lh3.googleusercontent.com/proxy/YjKxcyO51y75l7D3RaxpybqWaHe3NM_J7vwqKZp_iXtU42vdYbvIG66g-nTyrSwxhXVgvyOaCU06YqIgBmwLfsFciazJByI9vzFRAOujd7OayRaECBiqsToJxaBAxpwXV7-IJ1-FuNxPlq9-qLzaAPZ4eLYAgH3arHzLjtZOg-ku8Q").into(binding.profileId);

    }
}
