package lb.com.wallpaperpicker.sample;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lb.wallpaper_picker_library.WallpaperPickerActivity;

import lb.com.wallpaperpicker.R;

public class MainActivity extends AppCompatActivity
  {

  @Override
  protected void onCreate(Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
    pickWallpaper.setComponent(new ComponentName(getPackageName(), WallpaperPickerActivity.class.getName()));
    startActivityForResult(pickWallpaper, 1);

    }


  }
