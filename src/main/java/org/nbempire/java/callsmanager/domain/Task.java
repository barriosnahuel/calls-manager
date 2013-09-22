package org.nbempire.java.callsmanager.domain;

/**
 * @author Barrios, Nahuel.
 * @version 1.0
 * @since Mar 19, 2010, 12:57:01 PM
 */
public class Task {

    private Integer taskNumber;

    private String shortDescript;

    private String longDescript;

    public Task(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Task number: ").append(taskNumber).append("\n\t").append("Short descript: ").append(shortDescript).append("\n\t")
          .append("Long descript: ").append(longDescript);

        return sb.toString();
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getShortDescript() {
        return shortDescript;
    }

    public void setShortDescript(String shortDescript) {
        this.shortDescript = shortDescript;
    }

    public String getLongDescript() {
        return longDescript;
    }

    public void setLongDescript(String longDescript) {
        this.longDescript = longDescript;
    }
}
