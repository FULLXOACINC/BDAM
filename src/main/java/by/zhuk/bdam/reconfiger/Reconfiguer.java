package by.zhuk.bdam.reconfiger;

public interface Reconfiguer<T, K> {
    void reconfigure(T solution, K config);
}
