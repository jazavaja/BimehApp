package com.javad.mrbimeh.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aliakhgar.xplayerservice.MusicService;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.halilibo.bettervideoplayer.BetterVideoPlayer;
import com.javad.mrbimeh.MyTextView.NumTextView;
import com.javad.mrbimeh.R;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class LearnFragment extends Fragment {
    Context context;
    String linkMusic;
    String linkPic;
    String linkVideo;
    String text;
    ImageView pause;
    SeekBar seekBar;
    TextView timeNow, totalTime;
    long timeElapsed = 0, finalTime = 0;

    MusicService musicService;
    MediaPlayer mediaPlayer;

    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;

    /* renamed from: com.javad.mrbimeh.fragments.LearnFragment$2 */
    class C03702 implements OnCompletionListener {

        public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(LearnFragment.this.getContext(), "ویدیو شروع شد", Toast.LENGTH_SHORT).show();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_fragment1, container, false);
        pause = (ImageView) view.findViewById(R.id.pause);
        seekBar = (SeekBar) view.findViewById(R.id.seekbar);
        timeNow = (TextView) view.findViewById(R.id.timeNow);
        totalTime = (TextView) view.findViewById(R.id.totalTime);
        exoPlayerView = (SimpleExoPlayerView) view.findViewById(R.id.exo_player_view);
        AppCompatSeekBar seekBar = (AppCompatSeekBar) view.findViewById(R.id.seekbar);
        ImageView pic = (ImageView) view.findViewById(R.id.image);
        NumTextView textLearn = (NumTextView) view.findViewById(R.id.textLearn);
        Log.e("BODYlearn", getArguments().getString("body"));
        this.linkPic = getArguments().getString("pic");
        this.linkMusic = getArguments().getString("voice");
        this.linkVideo = getArguments().getString("video");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.linkPic);
        stringBuilder.append(" ");
        stringBuilder.append(this.linkMusic);
        stringBuilder.append(" ");
        stringBuilder.append(this.linkVideo);

        Log.e("LEARN", stringBuilder.toString());

        playVideo(exoPlayerView, setHttpString(this.linkVideo));

        linkMusic = "http://www.wikiwook.ir/blog/files/Your-Goals-for-the-New-Year_wikiwook.ir_.mp3";
        pause.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LearnFragment.this.playMusic(setHttpString(linkMusic), pause);
            }
        });
        Picasso.with(this.context).load(setHttpString(this.linkPic)).fit().into(pic);
        textLearn.setText(getArguments().getString("body"));
        return view;
    }

    private void setHttpARRAYurl(String[] ll) {
        for (int i = 0; i < ll.length; i++) {
            if (!ll[i].contains("http://")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(ll[i]);
                ll[i] = stringBuilder.toString();
            }
        }
    }

    private String setHttpString(String ll) {
        if (ll.contains("http://")) {
            return ll;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(ll);
        return stringBuilder.toString();
    }

    private void playVideo(final SimpleExoPlayerView exoPlayerView, String linkVideo) {
//        linkVideo = "https://as2.cdn.asset.aparat.com/aparat-video/746d61d891ed1e03ae2e3ed604394de09934263-360p__71994.mp4";
//        linkVideo = "http://jafari.xyz/pirazad/555.mp4";
//        linkVideo = "https://teamtext.ir/mrbime/edu/video/5840film.mp4";
//
        try {

            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector);

            Uri videoURI = Uri.parse(linkVideo);

            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);

            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(true);

        }catch (Exception e){
            Log.e("MainAcvtivity"," exoplayer error "+ e.toString());
        }
    }

    boolean play = true;

    private void playMusic(final String urll, final ImageView view) {

        musicService.setpreInfo(urll);
        if (play){
            musicService.playSong();
            play = false;
            Log.e("play" , "play shode");
            view.setImageResource(R.drawable.ic_pause);

        }else {
            Log.e("play" , "play nashode");
            if (musicService.isPlaying()) {

                musicService.playPause();
                view.setImageResource(R.drawable.ic_play);

            } else {

                musicService.start();
                view.setImageResource(R.drawable.ic_pause);

            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        musicService.pause();

        try {
            exoPlayer.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        try {
            exoPlayer.release();
            musicService.stop();
            musicService.release();
            musicService.onDestroy();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("DefaultLocale")
    private void updator(){

        mediaPlayer = musicService.getMediaPlayer();

//        set seekbar progress
        seekBar.setProgress((int) timeElapsed);

        musicService.setUpdateListner(new MusicService.progressUpdaing() {
            @Override
            public void publishUpdate(boolean b, int i) {

            seekBar.setProgress(i);
//                timeNow.setText(i + "");

            Log.e("final time", milliSecondToTimer(finalTime));
            Log.e("time Elapsed", String.valueOf(timeElapsed));

            //get current position
            timeElapsed = mediaPlayer.getCurrentPosition();

            finalTime = mediaPlayer.getDuration();

            timeNow.setText(milliSecondToTimer(timeElapsed));
            totalTime.setText(milliSecondToTimer(finalTime));

            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                musicService.setProgress(seekBar.getProgress());
            }
        });
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder)iBinder;
            musicService = binder.getService();
            updator();
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onStart() {

        try {

            Intent playIntent = new Intent(getActivity(), MusicService.class);
            playIntent.setAction("Run");
            getActivity().bindService(playIntent, serviceConnection, Context.BIND_AUTO_CREATE);
            getActivity().startService(playIntent);
            super.onStart();

        }catch (Exception e){

        }

    }

    private String milliSecondToTimer(long milliseconds){

        String finalTimerString = "";
        String secondsString;

        // convert total duration to timer
        int hours = (int)( milliseconds / (1000 * 60 * 60));
        int minutes = (int)(milliseconds % (1000 * 60 * 60 )) / (1000 * 60);
        int seconds = (int)((milliseconds % (1000 * 60 * 60 )) % (1000 * 60) / 1000);

        // Adds hour if there
        if (hours > 0){
            finalTimerString = hours + ":";
        }

        // prepending 0 to seconds if it is one digit
        if (seconds < 10){

            secondsString = "0" + seconds;

        }else {

            secondsString = "" +seconds;

        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        return finalTimerString;


    }
}
