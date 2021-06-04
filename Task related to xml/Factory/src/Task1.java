class Task1_LazyInitializedSingleton {

    public static Task1_LazyInitializedSingleton instance;

    public static Task1_LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new Task1_LazyInitializedSingleton();
        }
        return instance;
    }
}

class Task1_ThreadSafeSingleton {

    private static Task1_ThreadSafeSingleton object;

    public static synchronized Task1_ThreadSafeSingleton getInstance() {
        if (object == null) {
            object = new Task1_ThreadSafeSingleton();
        }
        return object;
    }
}

public class Task1 {
    Task1_LazyInitializedSingleton T = new Task1_LazyInitializedSingleton();
    Task1_ThreadSafeSingleton T1 = new Task1_ThreadSafeSingleton();

}
