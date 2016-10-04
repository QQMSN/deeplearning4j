package org.deeplearning4j.ui.stats.storage;

import java.io.Serializable;

/**
 * A listener interface, so that classes can be notified of changes to a {@link org.deeplearning4j.ui.storage.StatsStorage}
 * implementation
 *
 * @author Alex Black
 */
public interface StatsStorageListener {

    /**
     * Notify the listener when a new session has been added
     *
     * @param sessionID New session ID
     */
    void notifyNewSession(String sessionID);

    /**
     * Notify the listener that a new worker ID has been added, for the given session ID
     *
     * @param sessionID Session ID associated with new worker ID
     * @param workerID  New worker ID
     */
    void notifyNewWorkerID(String sessionID, String workerID);

    /**
     * Notify the listener that new static info is available, for the given session and worker ID.
     * i.e., this will be called after {@link org.deeplearning4j.ui.storage.StatsStorage#putStaticInfo(String, String, byte[])}
     * has been called
     *
     * @param sessionID Session ID for the new static info record
     * @param workerID  Worker ID for the new static info record
     */
    void notifyStaticInfo(String sessionID, String workerID);

    /**
     * Notify the listener that a new update has been made available; i.e., that
     * {@link org.deeplearning4j.ui.storage.StatsStorage#putUpdate(String, String, long, byte[])} has been called
     *
     * @param sessionID Session ID for the new update
     * @param workerID  Worker ID for the new update
     * @param timestamp Timestamp for the new update
     */
    void notifyStatusUpdate(String sessionID, String workerID, long timestamp);

    /**
     * Notify the listener that session metadata has been posted; i.e., that
     * {@link org.deeplearning4j.ui.storage.StatsStorage#putSessionMetaData(String, String, String, Serializable)} has
     * been called
     *
     * @param sessionID Session ID for the new metadata
     */
    void notifySessionMetaData(String sessionID);

}