package developer;

public class Main {
    public static void main(String[] args) {
        Developerin front1 = new Frontenddev();
        Developerin back1 = new Backenddev();
        Developerin fstack1 = new Fullstack();
        Frontend front2 = new Frontenddev();
        Backend back2 = new Backenddev();
        Fullstackin fstack2 = new Fullstack();
        Developerin[] team = {front1, back1, fstack1, front2, back2, fstack2};
        for (Developerin item:team) {
            if(item instanceof Frontend){
                ((Frontend) item).front();
            }
        }
    }
}
