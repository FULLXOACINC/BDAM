package by.zhuk.bdam.domain.spark;

import by.zhuk.bdam.domain.core.StageMetric;
import by.zhuk.bdam.util.TableGenerator;

import java.util.ArrayList;
import java.util.List;

public class SparkStageMetric extends StageMetric {
    private List<String> executorDeserializeTime;
    private List<String> executorDeserializeCpuTime;
    private List<String> executorRunTime;
    private List<String> executorCpuTime;
    private List<String> resultSize;
    private List<String> jvmGcTime;
    private List<String> resultSerializationTime;
    private List<String> gettingResultTime;
    private List<String> schedulerDelay;
    private List<String> peakExecutionMemory;
    private List<String> memoryBytesSpilled;
    private List<String> diskBytesSpilled;

    private List<String> inputMetricsBytesRead;
    private List<String> inputMetricsRecordsRead;

    private List<String> outputMetricsBytesWritten;
    private List<String> outputMetricsRecordsWritten;

    private List<String> shuffleReadMetricsReadBytes;
    private List<String> shuffleReadMetricsReadRecords;
    private List<String> shuffleReadMetricsRemoteBlocksFetched;
    private List<String> shuffleReadMetricsLocalBlocksFetched;
    private List<String> shuffleReadMetricsFetchWaitTime;
    private List<String> shuffleReadMetricsRemoteBytesRead;
    private List<String> shuffleReadMetricsRemoteBytesReadToDisk;
    private List<String> shuffleReadMetricsTotalBlocksFetched;

    private List<String> shuffleWriteMetricsWriteBytes;
    private List<String> shuffleWriteMetricsWriteRecords;
    private List<String> shuffleWriteMetricsWriteTime;


    public SparkStageMetric() {
        executorDeserializeTime = new ArrayList<>();
        executorDeserializeCpuTime = new ArrayList<>();
        executorRunTime = new ArrayList<>();
        executorCpuTime = new ArrayList<>();
        resultSize = new ArrayList<>();
        jvmGcTime = new ArrayList<>();
        resultSerializationTime = new ArrayList<>();
        gettingResultTime = new ArrayList<>();
        schedulerDelay = new ArrayList<>();
        peakExecutionMemory = new ArrayList<>();
        memoryBytesSpilled = new ArrayList<>();
        diskBytesSpilled = new ArrayList<>();
        inputMetricsBytesRead = new ArrayList<>();
        inputMetricsRecordsRead = new ArrayList<>();
        outputMetricsBytesWritten = new ArrayList<>();
        outputMetricsRecordsWritten = new ArrayList<>();
        shuffleReadMetricsReadBytes = new ArrayList<>();
        shuffleReadMetricsReadRecords = new ArrayList<>();
        shuffleReadMetricsRemoteBlocksFetched = new ArrayList<>();
        shuffleReadMetricsLocalBlocksFetched = new ArrayList<>();
        shuffleReadMetricsFetchWaitTime = new ArrayList<>();
        shuffleReadMetricsRemoteBytesRead = new ArrayList<>();
        shuffleReadMetricsRemoteBytesReadToDisk = new ArrayList<>();
        shuffleReadMetricsTotalBlocksFetched = new ArrayList<>();
        shuffleWriteMetricsWriteBytes = new ArrayList<>();
        shuffleWriteMetricsWriteRecords = new ArrayList<>();
        shuffleWriteMetricsWriteTime = new ArrayList<>();
    }

    public List<String> getExecutorDeserializeTime() {
        return executorDeserializeTime;
    }

    public void setExecutorDeserializeTime(List<String> executorDeserializeTime) {
        this.executorDeserializeTime = executorDeserializeTime;
    }

    public List<String> getExecutorDeserializeCpuTime() {
        return executorDeserializeCpuTime;
    }

    public void setExecutorDeserializeCpuTime(List<String> executorDeserializeCpuTime) {
        this.executorDeserializeCpuTime = executorDeserializeCpuTime;
    }

    public List<String> getExecutorRunTime() {
        return executorRunTime;
    }

    public void setExecutorRunTime(List<String> executorRunTime) {
        this.executorRunTime = executorRunTime;
    }

    public List<String> getExecutorCpuTime() {
        return executorCpuTime;
    }

    public void setExecutorCpuTime(List<String> executorCpuTime) {
        this.executorCpuTime = executorCpuTime;
    }

    public List<String> getResultSize() {
        return resultSize;
    }

    public void setResultSize(List<String> resultSize) {
        this.resultSize = resultSize;
    }

    public List<String> getJvmGcTime() {
        return jvmGcTime;
    }

    public void setJvmGcTime(List<String> jvmGcTime) {
        this.jvmGcTime = jvmGcTime;
    }

    public List<String> getResultSerializationTime() {
        return resultSerializationTime;
    }

    public void setResultSerializationTime(List<String> resultSerializationTime) {
        this.resultSerializationTime = resultSerializationTime;
    }

    public List<String> getGettingResultTime() {
        return gettingResultTime;
    }

    public void setGettingResultTime(List<String> gettingResultTime) {
        this.gettingResultTime = gettingResultTime;
    }

    public List<String> getSchedulerDelay() {
        return schedulerDelay;
    }

    public void setSchedulerDelay(List<String> schedulerDelay) {
        this.schedulerDelay = schedulerDelay;
    }

    public List<String> getPeakExecutionMemory() {
        return peakExecutionMemory;
    }

    public void setPeakExecutionMemory(List<String> peakExecutionMemory) {
        this.peakExecutionMemory = peakExecutionMemory;
    }

    public List<String> getMemoryBytesSpilled() {
        return memoryBytesSpilled;
    }

    public void setMemoryBytesSpilled(List<String> memoryBytesSpilled) {
        this.memoryBytesSpilled = memoryBytesSpilled;
    }

    public List<String> getDiskBytesSpilled() {
        return diskBytesSpilled;
    }

    public void setDiskBytesSpilled(List<String> diskBytesSpilled) {
        this.diskBytesSpilled = diskBytesSpilled;
    }

    public List<String> getInputMetricsBytesRead() {
        return inputMetricsBytesRead;
    }

    public void setInputMetricsBytesRead(List<String> inputMetricsBytesRead) {
        this.inputMetricsBytesRead = inputMetricsBytesRead;
    }

    public List<String> getInputMetricsRecordsRead() {
        return inputMetricsRecordsRead;
    }

    public void setInputMetricsRecordsRead(List<String> inputMetricsRecordsRead) {
        this.inputMetricsRecordsRead = inputMetricsRecordsRead;
    }

    public List<String> getOutputMetricsBytesWritten() {
        return outputMetricsBytesWritten;
    }

    public void setOutputMetricsBytesWritten(List<String> outputMetricsBytesWritten) {
        this.outputMetricsBytesWritten = outputMetricsBytesWritten;
    }

    public List<String> getOutputMetricsRecordsWritten() {
        return outputMetricsRecordsWritten;
    }

    public void setOutputMetricsRecordsWritten(List<String> outputMetricsRecordsWritten) {
        this.outputMetricsRecordsWritten = outputMetricsRecordsWritten;
    }

    public List<String> getShuffleReadMetricsReadBytes() {
        return shuffleReadMetricsReadBytes;
    }

    public void setShuffleReadMetricsReadBytes(List<String> shuffleReadMetricsReadBytes) {
        this.shuffleReadMetricsReadBytes = shuffleReadMetricsReadBytes;
    }

    public List<String> getShuffleReadMetricsReadRecords() {
        return shuffleReadMetricsReadRecords;
    }

    public void setShuffleReadMetricsReadRecords(List<String> shuffleReadMetricsReadRecords) {
        this.shuffleReadMetricsReadRecords = shuffleReadMetricsReadRecords;
    }

    public List<String> getShuffleReadMetricsRemoteBlocksFetched() {
        return shuffleReadMetricsRemoteBlocksFetched;
    }

    public void setShuffleReadMetricsRemoteBlocksFetched(List<String> shuffleReadMetricsRemoteBlocksFetched) {
        this.shuffleReadMetricsRemoteBlocksFetched = shuffleReadMetricsRemoteBlocksFetched;
    }

    public List<String> getShuffleReadMetricsLocalBlocksFetched() {
        return shuffleReadMetricsLocalBlocksFetched;
    }

    public void setShuffleReadMetricsLocalBlocksFetched(List<String> shuffleReadMetricsLocalBlocksFetched) {
        this.shuffleReadMetricsLocalBlocksFetched = shuffleReadMetricsLocalBlocksFetched;
    }

    public List<String> getShuffleReadMetricsFetchWaitTime() {
        return shuffleReadMetricsFetchWaitTime;
    }

    public void setShuffleReadMetricsFetchWaitTime(List<String> shuffleReadMetricsFetchWaitTime) {
        this.shuffleReadMetricsFetchWaitTime = shuffleReadMetricsFetchWaitTime;
    }

    public List<String> getShuffleReadMetricsRemoteBytesRead() {
        return shuffleReadMetricsRemoteBytesRead;
    }

    public void setShuffleReadMetricsRemoteBytesRead(List<String> shuffleReadMetricsRemoteBytesRead) {
        this.shuffleReadMetricsRemoteBytesRead = shuffleReadMetricsRemoteBytesRead;
    }

    public List<String> getShuffleReadMetricsRemoteBytesReadToDisk() {
        return shuffleReadMetricsRemoteBytesReadToDisk;
    }

    public void setShuffleReadMetricsRemoteBytesReadToDisk(List<String> shuffleReadMetricsRemoteBytesReadToDisk) {
        this.shuffleReadMetricsRemoteBytesReadToDisk = shuffleReadMetricsRemoteBytesReadToDisk;
    }

    public List<String> getShuffleReadMetricsTotalBlocksFetched() {
        return shuffleReadMetricsTotalBlocksFetched;
    }

    public void setShuffleReadMetricsTotalBlocksFetched(List<String> shuffleReadMetricsTotalBlocksFetched) {
        this.shuffleReadMetricsTotalBlocksFetched = shuffleReadMetricsTotalBlocksFetched;
    }

    public List<String> getShuffleWriteMetricsWriteBytes() {
        return shuffleWriteMetricsWriteBytes;
    }

    public void setShuffleWriteMetricsWriteBytes(List<String> shuffleWriteMetricsWriteBytes) {
        this.shuffleWriteMetricsWriteBytes = shuffleWriteMetricsWriteBytes;
    }

    public List<String> getShuffleWriteMetricsWriteRecords() {
        return shuffleWriteMetricsWriteRecords;
    }

    public void setShuffleWriteMetricsWriteRecords(List<String> shuffleWriteMetricsWriteRecords) {
        this.shuffleWriteMetricsWriteRecords = shuffleWriteMetricsWriteRecords;
    }

    public List<String> getShuffleWriteMetricsWriteTime() {
        return shuffleWriteMetricsWriteTime;
    }

    public void setShuffleWriteMetricsWriteTime(List<String> shuffleWriteMetricsWriteTime) {
        this.shuffleWriteMetricsWriteTime = shuffleWriteMetricsWriteTime;
    }

    public String toReadableString() {
        StringBuilder buffer = new StringBuilder();
        List<List<String>> rowList = new ArrayList<>();

        List<String> executorDeserializeTimeString = new ArrayList<>();
        List<String> executorDeserializeCpuTimeString = new ArrayList<>();
        List<String> executorRunTimeString = new ArrayList<>();
        List<String> executorCpuTimeString = new ArrayList<>();
        List<String> resultSizeString = new ArrayList<>();
        List<String> jvmGcTimeString = new ArrayList<>();
        List<String> resultSerializationTimeString = new ArrayList<>();
        List<String> gettingResultTimeString = new ArrayList<>();
        List<String> schedulerDelayString = new ArrayList<>();
        List<String> peakExecutionMemoryString = new ArrayList<>();
        List<String> memoryBytesSpilledString = new ArrayList<>();
        List<String> diskBytesSpilledString = new ArrayList<>();
        List<String> inputMetricsBytesReadString = new ArrayList<>();
        List<String> inputMetricsRecordsReadString = new ArrayList<>();
        List<String> outputMetricsBytesWrittenString = new ArrayList<>();
        List<String> outputMetricsRecordsWrittenString = new ArrayList<>();
        List<String> shuffleReadMetricsReadBytesString = new ArrayList<>();
        List<String> shuffleReadMetricsReadRecordsString = new ArrayList<>();
        List<String> shuffleReadMetricsRemoteBlocksFetchedString = new ArrayList<>();
        List<String> shuffleReadMetricsLocalBlocksFetchedString = new ArrayList<>();
        List<String> shuffleReadMetricsFetchWaitTimeString = new ArrayList<>();
        List<String> shuffleReadMetricsRemoteBytesReadString = new ArrayList<>();
        List<String> shuffleReadMetricsRemoteBytesReadToDiskString = new ArrayList<>();
        List<String> shuffleReadMetricsTotalBlocksFetchedString = new ArrayList<>();
        List<String> shuffleWriteMetricsWriteBytesString = new ArrayList<>();
        List<String> shuffleWriteMetricsWriteRecordsString = new ArrayList<>();
        List<String> shuffleWriteMetricsWriteTimeString = new ArrayList<>();


        executorDeserializeTimeString.add("executorDeserializeTime");
        executorDeserializeCpuTimeString.add("executorDeserializeCpuTime");
        executorRunTimeString.add("executorRunTime");
        executorCpuTimeString.add("executorCpuTime");
        resultSizeString.add("resultSize");
        jvmGcTimeString.add("jvmGcTime");
        resultSerializationTimeString.add("resultSerializationTime");
        gettingResultTimeString.add("gettingResultTime");
        schedulerDelayString.add("schedulerDelay");
        peakExecutionMemoryString.add("peakExecutionMemory");
        memoryBytesSpilledString.add("memoryBytesSpilled");
        diskBytesSpilledString.add("diskBytesSpilled");
        inputMetricsBytesReadString.add("inputMetricsBytesRead");
        inputMetricsRecordsReadString.add("inputMetricsRecordsRead");
        outputMetricsBytesWrittenString.add("outputMetricsBytesWritten");
        outputMetricsRecordsWrittenString.add("outputMetricsRecordsWritten");
        shuffleReadMetricsReadBytesString.add("shuffleReadMetricsReadBytes");
        shuffleReadMetricsReadRecordsString.add("shuffleReadMetricsReadRecords");
        shuffleReadMetricsRemoteBlocksFetchedString.add("shuffleReadMetricsRemoteBlocksFetched");
        shuffleReadMetricsLocalBlocksFetchedString.add("shuffleReadMetricsLocalBlocksFetched");
        shuffleReadMetricsFetchWaitTimeString.add("shuffleReadMetricsFetchWaitTime");
        shuffleReadMetricsRemoteBytesReadString.add("shuffleReadMetricsRemoteBytesRead");
        shuffleReadMetricsRemoteBytesReadToDiskString.add("shuffleReadMetricsRemoteBytesReadToDisk");
        shuffleReadMetricsTotalBlocksFetchedString.add("shuffleReadMetricsTotalBlocksFetched");
        shuffleWriteMetricsWriteBytesString.add("shuffleWriteMetricsWriteBytes");
        shuffleWriteMetricsWriteRecordsString.add("shuffleWriteMetricsWriteRecords");
        shuffleWriteMetricsWriteTimeString.add("shuffleWriteMetricsWriteTime");

        executorDeserializeTimeString .addAll(executorDeserializeTime);
        executorDeserializeCpuTimeString .addAll(executorDeserializeCpuTime);
        executorRunTimeString .addAll(executorRunTime);
        executorCpuTimeString .addAll(executorCpuTime);
        resultSizeString .addAll(resultSize);
        jvmGcTimeString .addAll(jvmGcTime);
        resultSerializationTimeString .addAll(resultSerializationTime);
        gettingResultTimeString .addAll(gettingResultTime);
        schedulerDelayString .addAll(schedulerDelay);
        peakExecutionMemoryString .addAll(peakExecutionMemory);
        memoryBytesSpilledString .addAll(memoryBytesSpilled);
        diskBytesSpilledString .addAll(diskBytesSpilled);
        inputMetricsBytesReadString .addAll(inputMetricsBytesRead);
        inputMetricsRecordsReadString .addAll(inputMetricsRecordsRead);
        outputMetricsBytesWrittenString .addAll(outputMetricsBytesWritten);
        outputMetricsRecordsWrittenString .addAll(outputMetricsRecordsWritten);
        shuffleReadMetricsReadBytesString .addAll(shuffleReadMetricsReadBytes);
        shuffleReadMetricsReadRecordsString .addAll(shuffleReadMetricsReadRecords);
        shuffleReadMetricsRemoteBlocksFetchedString .addAll(shuffleReadMetricsRemoteBlocksFetched);
        shuffleReadMetricsLocalBlocksFetchedString .addAll(shuffleReadMetricsLocalBlocksFetched);
        shuffleReadMetricsFetchWaitTimeString .addAll(shuffleReadMetricsFetchWaitTime);
        shuffleReadMetricsRemoteBytesReadString .addAll(shuffleReadMetricsRemoteBytesRead);
        shuffleReadMetricsRemoteBytesReadToDiskString.addAll(shuffleReadMetricsRemoteBytesReadToDisk);
        shuffleReadMetricsTotalBlocksFetchedString .addAll(shuffleReadMetricsTotalBlocksFetched);
        shuffleWriteMetricsWriteBytesString .addAll(shuffleWriteMetricsWriteBytes);
        shuffleWriteMetricsWriteRecordsString .addAll(shuffleWriteMetricsWriteRecords);
        shuffleWriteMetricsWriteTimeString .addAll(shuffleWriteMetricsWriteTime);
        rowList.add(executorDeserializeTimeString);
        rowList.add(executorDeserializeCpuTimeString);
        rowList.add(executorRunTimeString);
        rowList.add(executorCpuTimeString);
        rowList.add(resultSizeString);
        rowList.add(jvmGcTimeString);
        rowList.add(resultSerializationTimeString);
        rowList.add(gettingResultTimeString);
        rowList.add(schedulerDelayString);
        rowList.add(peakExecutionMemoryString);
        rowList.add(memoryBytesSpilledString);
        rowList.add(diskBytesSpilledString);
        rowList.add(inputMetricsBytesReadString);
        rowList.add(inputMetricsRecordsReadString);
        rowList.add(outputMetricsBytesWrittenString);
        rowList.add(outputMetricsRecordsWrittenString);
        rowList.add(shuffleReadMetricsReadBytesString);
        rowList.add(shuffleReadMetricsReadRecordsString);
        rowList.add(shuffleReadMetricsRemoteBlocksFetchedString);
        rowList.add(shuffleReadMetricsLocalBlocksFetchedString);
        rowList.add(shuffleReadMetricsFetchWaitTimeString);
        rowList.add(shuffleReadMetricsRemoteBytesReadString);
        rowList.add(shuffleReadMetricsRemoteBytesReadToDiskString);
        rowList.add(shuffleReadMetricsTotalBlocksFetchedString);
        rowList.add(shuffleWriteMetricsWriteBytesString);
        rowList.add(shuffleWriteMetricsWriteRecordsString);
        rowList.add(shuffleWriteMetricsWriteTimeString);

        TableGenerator generator = new TableGenerator();
        ArrayList<String> header = new ArrayList<>();
        header.add("Metrics");
        header.add("Min");
        header.add("Mean");
        header.add("Max");
        buffer.append(generator.generateTable(header,rowList));
        return buffer.toString();
    }
}
