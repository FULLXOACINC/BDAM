package by.zhuk.bdam.analyst.core;

public interface Analyst<T, K> {
    T analyze(K k);
}
