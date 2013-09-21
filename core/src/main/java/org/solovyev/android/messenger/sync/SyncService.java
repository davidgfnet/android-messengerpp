package org.solovyev.android.messenger.sync;

import org.solovyev.android.messenger.accounts.Account;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * User: serso
 * Date: 6/8/12
 * Time: 6:14 PM
 */
public interface SyncService {

	/**
	 * Method initializes service, must be called once before any other operations with current service
	 */
	void init();

	/**
	 * Method runs all synchronization tasks over all realms registered in system
	 *
	 * @param force true if all data should be synchronized regardless to individual synchronization parameters (frequency, scheduling, etc)
	 * @throws SyncAllTaskIsAlreadyRunning if task for synchronization is already running
	 */
	void syncAll(boolean force) throws SyncAllTaskIsAlreadyRunning;

	/**
	 * Method runs all synchronization tasks for specified <var>realm</var>
	 *
	 * @param force true if all data should be synchronized regardless to individual synchronization parameters (frequency, scheduling, etc)
	 * @throws SyncAllTaskIsAlreadyRunning if task for synchronization is already running
	 */
	void syncAllForAccount(@Nonnull Account account, boolean force) throws SyncAllTaskIsAlreadyRunning;

	void sync(@Nonnull SyncTask syncTask, @Nullable Runnable afterSyncCallback) throws TaskIsAlreadyRunningException;
}
