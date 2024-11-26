package ss.hotel;

public class Safe {
    private boolean active;
    private boolean open;

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public void open() {
        if (this.active) {
            this.open = true;
        }
    }

    public void close() {
        this.open = false;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isOpen() {
        if (this.open) {
            return true;
        }
        return false;

    }
}

