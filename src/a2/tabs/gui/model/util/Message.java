package a2.tabs.gui.model.util;

import a2.tabs.gui.model.User;

public interface Message {

    User getUser();

    String getMessage();

    long getTimestamp();

    boolean getIsFromAdmin();

    String getSender();
}