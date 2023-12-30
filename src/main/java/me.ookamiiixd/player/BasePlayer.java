package me.ookamiiixd.player;

import java.io.File;

public abstract class BasePlayer implements Player {

    public enum STATUS {
        IDLE,
        PLAY,
        PAUSE,
        STOP
    };
    protected File file;
    protected STATUS status = STATUS.IDLE;
    protected boolean finished = false;

    public BasePlayer(File f) {
        file = f;
    }

    public synchronized STATUS getStatus() {
        return status;
    }

    public synchronized void setStatus(STATUS s) {
        status = s;
    }

    public synchronized boolean isFinished() {
        return finished;
    }

    protected synchronized void setFinished(boolean f) {
        finished = f;
    }
}
