package by.zhuk.bdam.analyst.spark.phase;

public interface PhaseProblemAnalyst<T> {
    boolean isPhaseHasProblem(T t);
}
