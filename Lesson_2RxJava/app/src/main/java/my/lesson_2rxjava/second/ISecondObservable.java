package my.lesson_2rxjava.second;

public interface ISecondObservable {

    void registerSub(ISecondObserver customer);
    void unregisterSub(ISecondObserver customer);
    void sendSpam();

}
