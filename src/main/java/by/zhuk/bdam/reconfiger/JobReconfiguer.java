package by.zhuk.bdam.reconfiger;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;

import java.util.Map;

public interface JobReconfiguer extends Reconfiguer<Map<String, JobProblemSolution>, JobConfig> {
}
