package a2.tabs.gui.model.util;

import a2.tabs.gui.model.User;

public interface Message {

    public User getUser();

    public String getMessage();

    public long getTimestamp();

    public boolean getIsFromAdmin();

    public String getSender();
}