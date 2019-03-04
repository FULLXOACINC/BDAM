package by.zhuk.bdam.reconfiger;

public interface Reconfiguer<T, K> {
    void reconfigure(K solution, T config);
}
