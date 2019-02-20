package by.zhuk.bdam.parser;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.exception.ParseConfigException;

public interface ConfigParser {
    JobConfig parse(String confFile) throws ParseConfigException;
}
