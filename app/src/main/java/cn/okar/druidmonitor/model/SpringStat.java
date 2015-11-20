package cn.okar.druidmonitor.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wangfengchen on 15/11/20.
 */
public class SpringStat {
    @SerializedName(value = "Class")
    private String className;
    @SerializedName(value = "Method")
    private String method;
    @SerializedName(value = "RunningCount")
    private int runningCount;
    @SerializedName(value = "ConcurrentMax")
    private int concurrentMax;
    @SerializedName(value = "ExecuteCount")
    private int executeCount;
    @SerializedName(value = "ExecuteErrorCount")
    private int executeErrorCount;
    @SerializedName(value = "ExecuteTimeMillis")
    private int executeTimeMillis;
    @SerializedName(value = "JdbcCommitCount")
    private int jdbcCommitCount;
    @SerializedName(value = "JdbcRollbackCount")
    private int jdbcRollbackCount;
    @SerializedName(value = "JdbcPoolConnectionOpenCount")
    private int jdbcPoolConnectionOpenCount;
    @SerializedName(value = "JdbcPoolConnectionCloseCount")
    private int jdbcPoolConnectionCloseCount;
    @SerializedName(value = "JdbcResultSetOpenCount")
    private int jdbcResultSetOpenCount;
    @SerializedName(value = "JdbcResultSetCloseCount")
    private int jdbcResultSetCloseCount;
    @SerializedName(value = "JdbcExecuteCount")
    private int jdbcExecuteCount;
    @SerializedName(value = "JdbcExecuteErrorCount")
    private int jdbcExecuteErrorCount;
    @SerializedName(value = "JdbcExecuteTimeMillis")
    private int jdbcExecuteTimeMillis;
    @SerializedName(value = "JdbcFetchRowCount")
    private int jdbcFetchRowCount;
    @SerializedName(value = "JdbcUpdateCount")
    private int jdbcUpdateCount;
    @SerializedName(value = "LastError")
    private String lastError;
    @SerializedName(value = "LastErrorTime")
    private String lastErrorTime;
    @SerializedName(value = "Histogram")
    private List<Integer> histogram;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getRunningCount() {
        return runningCount;
    }

    public void setRunningCount(int runningCount) {
        this.runningCount = runningCount;
    }

    public int getConcurrentMax() {
        return concurrentMax;
    }

    public void setConcurrentMax(int concurrentMax) {
        this.concurrentMax = concurrentMax;
    }

    public int getExecuteCount() {
        return executeCount;
    }

    public void setExecuteCount(int executeCount) {
        this.executeCount = executeCount;
    }

    public int getExecuteErrorCount() {
        return executeErrorCount;
    }

    public void setExecuteErrorCount(int executeErrorCount) {
        this.executeErrorCount = executeErrorCount;
    }

    public int getExecuteTimeMillis() {
        return executeTimeMillis;
    }

    public void setExecuteTimeMillis(int executeTimeMillis) {
        this.executeTimeMillis = executeTimeMillis;
    }

    public int getJdbcCommitCount() {
        return jdbcCommitCount;
    }

    public void setJdbcCommitCount(int jdbcCommitCount) {
        this.jdbcCommitCount = jdbcCommitCount;
    }

    public int getJdbcRollbackCount() {
        return jdbcRollbackCount;
    }

    public void setJdbcRollbackCount(int jdbcRollbackCount) {
        this.jdbcRollbackCount = jdbcRollbackCount;
    }

    public int getJdbcPoolConnectionOpenCount() {
        return jdbcPoolConnectionOpenCount;
    }

    public void setJdbcPoolConnectionOpenCount(int jdbcPoolConnectionOpenCount) {
        this.jdbcPoolConnectionOpenCount = jdbcPoolConnectionOpenCount;
    }

    public int getJdbcPoolConnectionCloseCount() {
        return jdbcPoolConnectionCloseCount;
    }

    public void setJdbcPoolConnectionCloseCount(int jdbcPoolConnectionCloseCount) {
        this.jdbcPoolConnectionCloseCount = jdbcPoolConnectionCloseCount;
    }

    public int getJdbcResultSetOpenCount() {
        return jdbcResultSetOpenCount;
    }

    public void setJdbcResultSetOpenCount(int jdbcResultSetOpenCount) {
        this.jdbcResultSetOpenCount = jdbcResultSetOpenCount;
    }

    public int getJdbcResultSetCloseCount() {
        return jdbcResultSetCloseCount;
    }

    public void setJdbcResultSetCloseCount(int jdbcResultSetCloseCount) {
        this.jdbcResultSetCloseCount = jdbcResultSetCloseCount;
    }

    public int getJdbcExecuteCount() {
        return jdbcExecuteCount;
    }

    public void setJdbcExecuteCount(int jdbcExecuteCount) {
        this.jdbcExecuteCount = jdbcExecuteCount;
    }

    public int getJdbcExecuteErrorCount() {
        return jdbcExecuteErrorCount;
    }

    public void setJdbcExecuteErrorCount(int jdbcExecuteErrorCount) {
        this.jdbcExecuteErrorCount = jdbcExecuteErrorCount;
    }

    public int getJdbcExecuteTimeMillis() {
        return jdbcExecuteTimeMillis;
    }

    public void setJdbcExecuteTimeMillis(int jdbcExecuteTimeMillis) {
        this.jdbcExecuteTimeMillis = jdbcExecuteTimeMillis;
    }

    public int getJdbcFetchRowCount() {
        return jdbcFetchRowCount;
    }

    public void setJdbcFetchRowCount(int jdbcFetchRowCount) {
        this.jdbcFetchRowCount = jdbcFetchRowCount;
    }

    public int getJdbcUpdateCount() {
        return jdbcUpdateCount;
    }

    public void setJdbcUpdateCount(int jdbcUpdateCount) {
        this.jdbcUpdateCount = jdbcUpdateCount;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public String getLastErrorTime() {
        return lastErrorTime;
    }

    public void setLastErrorTime(String lastErrorTime) {
        this.lastErrorTime = lastErrorTime;
    }

    public List<Integer> getHistogram() {
        return histogram;
    }

    public void setHistogram(List<Integer> histogram) {
        this.histogram = histogram;
    }
}
