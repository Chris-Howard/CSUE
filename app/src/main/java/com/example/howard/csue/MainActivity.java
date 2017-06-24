package com.example.howard.csue;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCsuButtonClick(View view){

        String packageName = "com.chinacreator.msc.mobilechinacreator";
        if(isAppInstalled(this,packageName)){
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            startActivity(intent);
        }
        else{
            String str = "http://app.its.csu.edu.cn/app/csu.apk?time=145124";
            Uri uri = Uri.parse(str);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
    }

    /*
 * check the app is installed
 */
    private boolean isAppInstalled(Context context, String packagename)
    {
        PackageInfo packageInfo;

        try
        {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        }
        catch (Exception e)
        {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null)
        {
            //System.out.println("没有安装");
            return false;
        }
        else
        {
            //System.out.println("已经安装");
            return true;
        }
    }

}
