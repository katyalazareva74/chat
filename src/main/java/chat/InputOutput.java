package chat;

import javax.swing.*;

public interface InputOutput {
    void savechat(String text);
    StringBuilder loadchat();
}
