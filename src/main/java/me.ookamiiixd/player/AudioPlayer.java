package me.ookamiiixd.player;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import me.ookamiiixd.main.Utils;

public class AudioPlayer extends BasePlayer {

    private enum AUDIO_TYPE {
        MP3,
        WAV
    };
    private AUDIO_TYPE audioType;
    private Clip clip;

    public AudioPlayer(File file) throws Exception {
        super(file);

        var fileExt = Utils.getFileExtension(file.getName());
        if ("mp3".equals(fileExt)) {
            audioType = AUDIO_TYPE.MP3;
        } else if ("wav".equals(fileExt)) {
            audioType = AUDIO_TYPE.WAV;
        } else {
            throw new Exception("Unsupported audio");
        }
        loadReader();
    }

    private void loadReader() throws Exception {
        var stream = AudioSystem.getAudioInputStream(file);
        if (audioType == AUDIO_TYPE.MP3) {
            AudioFormat baseFormat = stream.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false);
            stream = AudioSystem.getAudioInputStream(decodedFormat, stream);
        }
        clip = AudioSystem.getClip();
        clip.open(stream);
        clip.addLineListener(this::onLineEvent);
    }

    private void onLineEvent(LineEvent e) {
        if (e.getType() == LineEvent.Type.STOP && status != STATUS.PAUSE) {
            setFinished(true);
            setStatus(STATUS.IDLE);
        }
    }

    @Override
    public void play() {
        if (getStatus() == STATUS.PLAY) {
            return;
        }
        new Thread(() -> {
            setStatus(STATUS.PLAY);
            clip.start();
        }).start();
    }

    public void play(long position) {
        if (getStatus() == STATUS.PLAY) {
            clip.stop();
        }
        new Thread(() -> {
            setStatus(STATUS.PLAY);
            clip.setMicrosecondPosition(position);
            clip.start();
        }).start();
    }

    @Override
    public void pause() {
        if (getStatus() == STATUS.PAUSE) {
            return;
        }
        setFinished(false);
        setStatus(STATUS.PAUSE);
        clip.stop();
    }

    @Override
    public void resume() {
        if (getStatus() == STATUS.PLAY) {
            return;
        }
        new Thread(() -> {
            setStatus(STATUS.PLAY);
            clip.setMicrosecondPosition(getPosition());
            clip.start();
        }).start();
    }

    @Override
    public void stop() {
        if (getStatus() == STATUS.STOP) {
            return;
        }
        setFinished(false);
        setStatus(STATUS.STOP);
        clip.stop();
        clip.setMicrosecondPosition(0);
    }

    @Override
    public void dispose() {
        if (getStatus() == STATUS.IDLE) {
            return;
        }
        setStatus(STATUS.IDLE);
        clip.stop();
        clip.close();
    }

    public long getPosition() {
        if (clip == null) {
            return 0;
        }
        return clip.getMicrosecondPosition();
    }

    public long getLength() {
        if (clip == null) {
            return 0;
        }
        return clip.getMicrosecondLength();
    }
}
