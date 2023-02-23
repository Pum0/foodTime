package com.example.foodtime;


import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.example.foodtime.listView.ListData;
import com.example.foodtime.listView.MyAdapter;
import com.naver.maps.map.NaverMapSdk;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private long pressedTime = 0; //'뒤로가기' 버튼 클릭했을 때의 시간
    SlidingUpPanelLayout slidingUpPanelLayout;
    ArrayList<ListData> foodDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NaverMapFragment naverFragment = new NaverMapFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, naverFragment).commit();

        slidingUpPanelLayout = findViewById(R.id.main_panel);

        this.InitializeMovieData();

        ListView listView = (ListView) findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,foodDataList);

        listView.setAdapter(myAdapter);
    }

    public void InitializeMovieData()
    {
        foodDataList = new ArrayList<ListData>();

        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "미션임파서블","15세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "아저씨","19세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "어벤져스","12세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "미션임파서블","15세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "아저씨","19세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "어벤져스","12세 이상관람가"));foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "미션임파서블","15세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "아저씨","19세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "어벤져스","12세 이상관람가"));foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "미션임파서블","15세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "아저씨","19세 이상관람가"));
        foodDataList.add(new ListData(R.drawable.ic_launcher_foreground, "어벤져스","12세 이상관람가"));
    }

    @Override
    public void onBackPressed() {
        // 판넬이 올라가 있을 경우 닫기
        if (slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED)
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

        else {
            //마지막으로 누른 '뒤로가기' 버튼 클릭 시간이 이전의 '뒤로가기' 버튼 클릭 시간과의 차이가 2초보다 크면
            if (System.currentTimeMillis() > pressedTime + 2000) {
                //현재 시간을 pressedTime 에 저장
                pressedTime = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(), "한번 더 누르면 종료", Toast.LENGTH_SHORT).show();
            }

            //마지막 '뒤로가기' 버튼 클릭시간이 이전의 '뒤로가기' 버튼 클릭 시간과의 차이가 2초보다 작으면
            else {
                Toast.makeText(getApplicationContext(), "종료 완료", Toast.LENGTH_SHORT).show();
                // 앱 종료
                exitProgram();
            }
        }
    }


    private void exitProgram() {
        // 종료

        // 태스크를 백그라운드로 이동
        // moveTaskToBack(true);

        if (Build.VERSION.SDK_INT >= 21) {
            // 액티비티 종료 + 태스크 리스트에서 지우기
            finishAndRemoveTask();
        } else {
            // 액티비티 종료
            finish();
        }

        System.exit(0);
    }

}


//        NaverMapSdk.getInstance(this).setClient(
//                new NaverMapSdk.NaverCloudPlatformClient("vherh2ll56"));