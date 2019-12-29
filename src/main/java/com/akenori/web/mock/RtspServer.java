package com.akenori.web.mock;

import org.springframework.stereotype.Component;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;

import javax.annotation.PostConstruct;

@Component
public class RtspServer {

    @PostConstruct
    public void init(){


        String media = RtspServer.class.getResource("/video.mp4").getPath();
        String options = formatRtspStream("127.0.0.1", 8554, "");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        MediaPlayer mediaPlayer = mediaPlayerFactory.mediaPlayers().newMediaPlayer();
        mediaPlayer.controls().setRepeat(true);
        mediaPlayer.media().play(media,
                options,
                ":no-sout-rtp-sap",
                ":no-sout-standard-sap",
                ":sout-all",
                ":sout-keep");
    }

    private static String formatRtspStream(String serverAddress, int serverPort, String id) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#rtp{sdp=rtsp://@");
        sb.append(serverAddress);
        sb.append(':');
        sb.append(serverPort);
        sb.append('/');
        sb.append(id);
        sb.append("}");
        return sb.toString();
    }
}
