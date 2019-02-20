package by.zhuk.bdam.infodumper;

import by.zhuk.bdam.exception.JobDumpException;

public interface AppInfoDumper<T, K> {
    T dump(String appId, K config) throws JobDumpException;
}
