package chat;

public class ServerLog implements ServerListener {
    private boolean isServerWorking;
    Listener listener;
    ServerLog(Listener listener){
        this.isServerWorking=false;
        this.listener=listener;
    }
    public  void start(){
        if(!isServerWorking){
            isServerWorking=true;
            listener.messageReceive("Статус сервера: "+isServerWorking);
        } else{
            listener.messageReceive("Сервер уже запущен");
        }
    }
    public  void stop(){
        if(isServerWorking){
            isServerWorking=false;
            listener.messageReceive("Статус сервера: "+isServerWorking);
        } else{
            listener.messageReceive("Сервер уже остановлен");
        }
    }
}
