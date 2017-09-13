package things.useful.sp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    public VideoView myVideoView;
    SurfaceHolder _videoHolder;
    public String path0 = "android.resource://things.useful.sp/" + R.raw.rek0;
    public String path1 = "android.resource://things.useful.sp/" + R.raw.rek1;
    public String path2 = "android.resource://things.useful.sp/" + R.raw.rek2;
    public String path3 = "android.resource://things.useful.sp/" + R.raw.rek3;
    //public String s = "file://" +Environment.getExternalStorageDirectory().getAbsolutePath() + "/REKLAM/rek.MP4";

    public boolean mNavVisible = false;


    public int VideoI = 0;


    public ArrayList<String> videoNames = new ArrayList<String>();


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);





//----------------------------------------------------------------------


        videoNames.add(path1);
        videoNames.add(path2);
        videoNames.add(path3);



        //snimak 1
        myVideoView = (VideoView) findViewById(R.id.videoView);

        //textView.setText(s);

        myVideoView.setVideoURI(Uri.parse(path0));
        myVideoView.start();







        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {


                myVideoView.setVideoURI(Uri.parse(videoNames.get(VideoI)));

                myVideoView.start();

                if (VideoI == videoNames.size() - 1) {
                    VideoI = 0;
                } else {
                    VideoI++;
                }
            }
        });


//  Ovaj kod sluzi da se ubasi jos 2 reklame koje ce da idu zaredom betonjara

        /*myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp)
            {

                myVideoView.setVideoURI(Uri.parse(path2));
                myVideoView.start();

                myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {

                        myVideoView.setVideoURI(Uri.parse(path3));
                        myVideoView.start();


                        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {


                                myVideoView.stopPlayback();



                            }
                        });



                    }
                });


            }
        });*/


// Ovaj kod sluzi za replay

       /* myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });*/

    }/*
    private void showCameraAlert2() {
        new AlertDialog.Builder(this)
                .setTitle("Error: Unsuported device!")
                .setMessage("Camera flashlight not available in Android device with os lower then Marshmallow!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }*/
}

