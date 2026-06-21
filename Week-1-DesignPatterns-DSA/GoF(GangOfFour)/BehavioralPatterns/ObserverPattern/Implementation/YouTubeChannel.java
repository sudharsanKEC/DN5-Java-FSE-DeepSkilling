import java.util.*;
public class YouTubeChannel implements Subject{

    private List<Observer> observers = new ArrayList<>();
    private String latestVideo;

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update("New video uploaded: "+latestVideo);
        }
    }

    public void uploadVideo(String videoTitle){
        this.latestVideo = videoTitle;
        System.out.println("Channel uploaded: "+videoTitle);
        notifyObservers();
    }
}
