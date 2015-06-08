package lb.com.wallpaperpicker.sample;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.lb.wallpaper_picker_library.WallpaperPickerActivity;

import lb.com.wallpaperpicker.R;

public class MainActivity extends AppCompatActivity
  {

  @Override
  protected void onCreate(Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.button).setOnClickListener(new OnClickListener()
    {
    @Override
    public void onClick(final View v)
      {
      final Intent pickWallpaper=new Intent(Intent.ACTION_SET_WALLPAPER);
      pickWallpaper.setComponent(new ComponentName(getPackageName(),WallpaperPickerActivity.class.getName()));
      startActivityForResult(pickWallpaper,1);
      }
    });
    }

  @Override
  protected void onActivityResult(final int requestCode,final int resultCode,final Intent data)
    {
    super.onActivityResult(requestCode,resultCode,data);
    if(requestCode==1)
      Toast.makeText(this,resultCode==RESULT_OK?"wallpaper set":"action cancelled",Toast.LENGTH_LONG).show();
    }
  @Override
  public boolean onCreateOptionsMenu(final Menu menu)
    {
    getMenuInflater().inflate(R.menu.main,menu);
    return true;
    }
  @Override
  public boolean onOptionsItemSelected(final MenuItem item)
    {
    String url=null;
    switch(item.getItemId())
      {
      case R.id.menuItem_all_my_apps:
        url="https://play.google.com/store/apps/developer?id=AndroidDeveloperLB";
        break;
      case R.id.menuItem_all_my_repositories:
        url="https://github.com/AndroidDeveloperLB";
        break;
      case R.id.menuItem_current_repository_website:
        url="https://github.com/AndroidDeveloperLB/WallpaperPicker";
        break;
      }
    if(url==null)
      return true;
    final Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
    startActivity(intent);
    return true;
    }
  }
