package by.zhuk.bdam.analyst;

public interface Analyst<T,K> {
    T analyze(K k);
}
