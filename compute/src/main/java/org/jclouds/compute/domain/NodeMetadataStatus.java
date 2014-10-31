package org.jclouds.compute.domain;

public enum NodeMetadataStatus {
	/**
	 * The node is in transition
	 */
	PENDING,
	/**
	 * The node is visible, and in the process of being deleted.
	 */
	TERMINATED,
	/**
	 * The node is deployed, but suspended or stopped.
	 */
	SUSPENDED,
	/**
	 * The node is available for requests
	 */
	RUNNING,
	/**
	 * There is an error on the node
	 */
	ERROR,
	/**
	 * The state of the node is unrecognized.
	 */
	UNRECOGNIZED;

}